package com.jaju.where2skate.data.mappers.user.admin

import com.jaju.where2skate.data.dao.user.admin.complain.Request
import com.jaju.where2skate.data.dao.user.admin.complain.RequestTypes
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class RequestMapper : RowMapper<Request> {

    override fun mapRow(rs: ResultSet, rowNum: Int): Request {
        return Request(
                id = rs.getInt("id"),
                userId = rs.getString("user_id"),
                reasonType = rs.getInt("reason_type"),
                objectType = RequestTypes.valueOf(rs.getString("object_type").toUpperCase()),
                objectId = rs.getString("object_id"),
                requestDate = rs.getDate("request_date"),
                statusId = rs.getInt("status_id"),
                info = rs.getString("info"),
                lastUpdate = rs.getDate("last_update")
        )
    }
}
