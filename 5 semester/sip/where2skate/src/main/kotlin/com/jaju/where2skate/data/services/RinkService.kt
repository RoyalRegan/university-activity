package com.jaju.where2skate.data.services

import com.jaju.where2skate.data.dao.rink.RinkComment
import com.jaju.where2skate.data.dao.rink.params.OpenHours
import com.jaju.where2skate.data.dao.rink.params.OptionalParam
import com.jaju.where2skate.data.dao.rink.Rink
import com.jaju.where2skate.data.dao.rink.RinkPhoto
import com.jaju.where2skate.data.dao.rink.RinkSimple
import com.jaju.where2skate.data.dao.rink.RinkType
import com.jaju.where2skate.data.dao.user.UserRate
import com.jaju.where2skate.data.mappers.rink.*
import com.jaju.where2skate.data.mappers.user.UserMapper
import com.jaju.where2skate.util.extension.notNull
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.PreparedStatementCallback
import org.springframework.jdbc.core.SqlParameter
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Service
import java.sql.Types

@Service
class RinkService @Autowired constructor(private val jdbcTemplateNamed: NamedParameterJdbcTemplate) {

    //TODO: Think about it
    fun getRinks(latitude: Double, longitude: Double,
                 radius: Double, type: Array<String>?,
                 optional: Set<OptionalParam>?, rating: Double?,
                 open: Set<OpenHours>?): List<RinkSimple> {
        var sql = "select * from rink r inner join rink_types rt on r.type = rt.prefix " +
                "where harversine(latitude,longitude,cast('$latitude' as double precision),cast('$longitude' as double precision)) <= $radius "
        type.notNull {
            sql += "and prefix in (${it.joinToString(separator = ",") { s -> "'$s'" }}) "
        }
        rating.notNull {
            sql += "and rating >= $it "
        }
        open.notNull {
            sql += "and open_hours ~ ('${it.joinToString(separator = "||")}') "
        }
        optional.notNull {
            it.forEach { param: OptionalParam -> sql += "and ${param.paramType.name} = ${param.value}" }
        }
        println(sql)
        return jdbcTemplateNamed.query(sql, RinkSimpleMapper())
    }

    fun getRinkDetails(rinkId: Int): Rink? {
        val sql = "select * from rink r inner join rink_types rt on r.type = rt.prefix where r.id = :id"
        val bindingParams = MapSqlParameterSource().apply {
            addValue("id", rinkId, Types.INTEGER)
        }
        return try {
            jdbcTemplateNamed.queryForObject(sql, bindingParams, RinkMapper())
        } catch (e: EmptyResultDataAccessException) {
            null
        }
    }

    fun getRinkTypes(): List<RinkType> {
        val sql = "select * from rink_types"
        return jdbcTemplateNamed.query(sql, RinkTypeMapper())
    }

    fun getRinkPhotos(rinkId: Int): List<RinkPhoto> {
        val sql = "select * from rink_photos where rink_id = :id"
        val bindingParams = MapSqlParameterSource().apply {
            addValue("id", rinkId, Types.INTEGER)
        }
        return jdbcTemplateNamed.query(sql, bindingParams, RinkPhotoMapper())
    }

    fun getRinkComments(rinkId: Int, limit: Int, page: Int, uuid: String?): List<RinkComment> {
        val offset = if (page == 0 || page == 1) {
            0
        } else {
            (page - 1) * limit
        }
        val sql = """select c.*, u.nickname, ur.rate
                       from comment c
                       inner join "user" u on c.user_id = u.uuid
                       left join user_rate ur on (c.id = ur.comment_id and ur.user_id = :uuid)
                      where rink_id = :id and deleted = 0
                      order by case when c.user_id = :uuid then 0 else 1 end ,date desc
                     limit :limit offset :offset"""
        val bindingParams = MapSqlParameterSource().apply {
            addValue("id", rinkId, Types.INTEGER)
            addValue("limit", limit, Types.INTEGER)
            addValue("offset", offset, Types.INTEGER)
            addValue("uuid", uuid, Types.VARCHAR)
        }
        return jdbcTemplateNamed.query(sql, bindingParams, RinkCommentMapper())
    }

    fun addRink(rink: Rink, uuid: String, force:Int) {
        rink.run {
            val sql = "call rink_insert_prepare(v_name:= :v_name," +
                    "v_type:= :v_type," +
                    "v_latitude:= :v_latitude," +
                    "v_longitude:= :v_longitude," +
                    "v_open_hours:= :v_open_hours," +
                    "v_user_id:= :v_user_id," +
                    "v_free:= :v_free," +
                    "v_warm_room:= :v_warm_room," +
                    "v_parking:= :v_parking," +
                    "v_skates_rentals:= :v_skates_rentals," +
                    "v_skates_sharpening:= :v_skates_sharpening," +
                    "v_website_url:= :v_website_url," +
                    "v_phone_number:= :v_phone_number," +
                    "v_force:= :v_force)"
            val bindingParams = MapSqlParameterSource().apply {
                addValue("v_name", name, Types.VARCHAR)
                addValue("v_type", type, Types.VARCHAR)
                addValue("v_latitude", latitude!!, Types.DOUBLE)
                addValue("v_longitude", longitude!!, Types.DOUBLE)
                addValue("v_open_hours", openHours?.joinToString(separator = ","), Types.VARCHAR)
                addValue("v_user_id", uuid, Types.VARCHAR)
                addValue("v_free", free!!, Types.INTEGER)
                addValue("v_warm_room", warmRoom, Types.INTEGER)
                addValue("v_parking", parking, Types.INTEGER)
                addValue("v_skates_rentals", skatesRentals, Types.INTEGER)
                addValue("v_skates_sharpening", skatesSharpening, Types.INTEGER)
                addValue("v_website_url", websiteUrl, Types.VARCHAR)
                addValue("v_phone_number", phoneNumber, Types.VARCHAR)
                addValue("v_force",force,Types.INTEGER)

            }
            jdbcTemplateNamed.execute(sql, bindingParams) { preparedStatement -> preparedStatement.execute() }
        }
    }

    fun addComment(rinkComment: RinkComment, uuid: String) {
        rinkComment.run {
            val sql = "call comment_insert(v_user_id:= :v_user_id," +
                    "v_rink_id:= :v_rink_id," +
                    "v_text:= :v_text," +
                    "v_score:= :v_score)"
            val bindingParams = MapSqlParameterSource().apply {
                addValue("v_user_id", uuid, Types.VARCHAR)
                addValue("v_rink_id", rinkId, Types.INTEGER)
                addValue("v_text", text, Types.VARCHAR)
                addValue("v_score", score ?: 0, Types.DOUBLE)
            }
            jdbcTemplateNamed.execute(sql, bindingParams) { preparedStatement -> preparedStatement.execute() }
        }
    }

    fun addUserRate(userRate: UserRate, uuid: String) {
        userRate.run {
            val sql = "call user_rate_merge(v_user_id:= :v_user_id," +
                    "v_comment_id:= :v_comment_id," +
                    "v_rate:= :v_rate)"
            val bindingParams = MapSqlParameterSource().apply {
                addValue("v_user_id", uuid, Types.VARCHAR)
                addValue("v_comment_id", commentId, Types.INTEGER)
                addValue("v_rate", rate, Types.INTEGER)
            }
            jdbcTemplateNamed.execute(sql, bindingParams) { preparedStatement -> preparedStatement.execute() }
        }
    }

    fun updateRink(rink: Rink, uuid: String, v_parent_rink_id: Int, force: Int) {
        rink.run {
            val sql = "call rink_update_prepare(v_name:= :v_name," +
                    "v_parent_rink_id:= :v_parent_rink_id," +
                    "v_type:= :v_type," +
                    "v_latitude:= :v_latitude," +
                    "v_longitude:= :v_longitude," +
                    "v_open_hours:= :v_open_hours," +
                    "v_user_id:= :v_user_id," +
                    "v_free:= :v_free," +
                    "v_warm_room:= :v_warm_room," +
                    "v_parking:= :v_parking," +
                    "v_skates_rentals:= :v_skates_rentals," +
                    "v_skates_sharpening:= :v_skates_sharpening," +
                    "v_website_url:= :v_website_url," +
                    "v_phone_number:= :v_phone_number," +
                    "v_force:= :v_force)"
            val bindingParams = MapSqlParameterSource().apply {
                addValue("v_parent_rink_id", v_parent_rink_id, Types.INTEGER)
                addValue("v_name", name, Types.VARCHAR)
                addValue("v_type", type, Types.VARCHAR)
                addValue("v_latitude", latitude, Types.DOUBLE)
                addValue("v_longitude", longitude, Types.DOUBLE)
                addValue("v_open_hours", openHours?.joinToString(separator = ","), Types.VARCHAR)
                addValue("v_user_id", uuid, Types.VARCHAR)
                addValue("v_free", free, Types.INTEGER)
                addValue("v_warm_room", warmRoom, Types.INTEGER)
                addValue("v_parking", parking, Types.INTEGER)
                addValue("v_skates_rentals", skatesRentals, Types.INTEGER)
                addValue("v_skates_sharpening", skatesSharpening, Types.INTEGER)
                addValue("v_website_url", websiteUrl, Types.VARCHAR)
                addValue("v_phone_number", phoneNumber, Types.VARCHAR)
                addValue("v_force",force,Types.INTEGER)
            }
            jdbcTemplateNamed.execute(sql, bindingParams) { preparedStatement -> preparedStatement.execute() }
        }
    }

    fun updateComment(rinkComment: RinkComment, uuid: String, id: Int) {
        rinkComment.run {
            val sql = "call comment_update(v_user_id:= :v_user_id," +
                    "v_comment_id:= :v_comment_id," +
                    "v_text:= :v_text," +
                    "v_score:= :v_score)"
            val bindingParams = MapSqlParameterSource().apply {
                addValue("v_user_id", uuid, Types.VARCHAR)
                addValue("v_comment_id", id, Types.INTEGER)
                addValue("v_text", text, Types.VARCHAR)
                addValue("v_score", score, Types.DOUBLE)
            }
            jdbcTemplateNamed.execute(sql, bindingParams) { preparedStatement -> preparedStatement.execute() }
        }
    }
}

