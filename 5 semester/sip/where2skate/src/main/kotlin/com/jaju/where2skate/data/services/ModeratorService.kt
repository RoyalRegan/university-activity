package com.jaju.where2skate.data.services

import com.jaju.where2skate.data.dao.user.admin.complain.Request
import com.jaju.where2skate.data.mappers.user.admin.RequestMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Service
import java.sql.Types

@Service
class ModeratorService @Autowired constructor(private val jdbcTemplate: NamedParameterJdbcTemplate) {

    fun getComplains(): List<Request> {
        val sql = "select * from request"
        return jdbcTemplate.query(sql, RequestMapper())
    }

    fun releaseRinkUpdate(requestId: Int, userId: String) {
        val sql = "call rink_update_release(v_request_id:= :v_request_id," +
                "v_user_id:= :v_user_id)"
        val bindingParams = MapSqlParameterSource().apply {
            addValue("v_request_id", requestId, Types.INTEGER)
            addValue("v_user_id", userId, Types.VARCHAR)
        }
        jdbcTemplate.execute(sql, bindingParams) { preparedStatement -> preparedStatement.execute() }
    }

    fun releaseRinkInsert(requestId: Int, userId: String) {
        val sql = "call rink_insert_release(v_request_id:= :v_request_id," +
                "v_user_id:= :v_user_id)"
        val bindingParams = MapSqlParameterSource().apply {
            addValue("v_request_id", requestId, Types.INTEGER)
            addValue("v_user_id", userId, Types.VARCHAR)
        }
        jdbcTemplate.execute(sql, bindingParams) { preparedStatement -> preparedStatement.execute() }
    }
}