package com.jaju.where2skate.data.mappers.user

import com.jaju.where2skate.data.dao.user.User
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class UserMapper : RowMapper<User> {

    override fun mapRow(rs: ResultSet, rowNum: Int): User {
        return User(
                uuid = rs.getString("uuid"),
                nickname = rs.getString("nickname"),
                imageUrl = rs.getString("image_url"),
                moderator = rs.getInt("moderator")
        )
    }
}
