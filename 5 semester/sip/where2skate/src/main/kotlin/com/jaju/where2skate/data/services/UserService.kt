package com.jaju.where2skate.data.services

import com.google.firebase.auth.UserRecord
import com.jaju.where2skate.data.dao.rink.RinkComment
import com.jaju.where2skate.data.dao.user.User
import com.jaju.where2skate.data.dao.user.admin.complain.Request
import com.jaju.where2skate.data.mappers.rink.RinkCommentMapper
import com.jaju.where2skate.data.mappers.user.UserMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Component
import java.sql.Types

@Component
class UserService @Autowired constructor(private val jdbcTemplate: NamedParameterJdbcTemplate) {

    fun getUserByUuid(uuid: String): User? {
        val sql = """select * from "user" where uuid = :uuid """
        val bindingParams = MapSqlParameterSource().apply {
            addValue("uuid", uuid, Types.VARCHAR)
        }
        return try {
            jdbcTemplate.queryForObject(sql, bindingParams, UserMapper())
        } catch (e: EmptyResultDataAccessException) {
            null
        }
    }

    //TODO: user api
    fun addUser(userRecord: UserRecord): User? {
        userRecord.run {
            val sql = """insert into "user" (uuid, nickname, image_url) values ('${userRecord.uid}','${userRecord.displayName}','${userRecord.photoUrl}') returning uuid,nickname,image_url"""
            return jdbcTemplate.query(sql, UserMapper())[0]
        }
    }

    fun addRequest(request: Request, uuid: String) {
        request.run {
            val sql = "call request_insert(v_user_id:= :v_user_id," +
                    "v_object_type:= :v_object_type," +
                    "v_object_id:= :v_object_id," +
                    "v_info:= :v_info)"
            val bindingParams = MapSqlParameterSource().apply {
                addValue("v_user_id", uuid, Types.VARCHAR)
                addValue("v_object_type", objectType.toString(), Types.OTHER)
                addValue("v_object_id", objectId, Types.VARCHAR)
                addValue("v_info", info, Types.VARCHAR)
            }
            jdbcTemplate.execute(sql, bindingParams) { preparedStatement -> preparedStatement.execute() }
        }
    }

    fun getUserComments(limit: Int, page: Int, uuid: String):List<RinkComment> {
        val offset = if (page == 0 || page == 1) {
            0
        } else {
            (page - 1) * limit
        }
        val sql = """select c.*,u.nickname,ur.rate
                       from comment c
                       inner join "user" u on c.user_id = u.uuid
                       left join user_rate ur on c.id = ur.comment_id
                         where c.user_id = :uuid and deleted = 0
                         order by date desc
                     limit :limit offset :offset"""
        val bindingParams = MapSqlParameterSource().apply {
            addValue("limit", limit, Types.INTEGER)
            addValue("offset", offset, Types.INTEGER)
            addValue("uuid", uuid, Types.VARCHAR)
        }
        return jdbcTemplate.query(sql, bindingParams, RinkCommentMapper())
    }
}