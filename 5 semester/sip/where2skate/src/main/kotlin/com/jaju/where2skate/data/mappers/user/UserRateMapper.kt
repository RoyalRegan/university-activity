package com.jaju.where2skate.data.mappers.user

import com.jaju.where2skate.data.dao.user.UserRate
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class UserRateMapper : RowMapper<UserRate> {

    override fun mapRow(rs: ResultSet, rowNum: Int): UserRate {
        return UserRate(
                id = rs.getInt("ID"),
                userId = rs.getString("USER_ID"),
                commentId = rs.getInt("COMMENT_ID"),
                rate = rs.getInt("RATE")
        )
    }
}