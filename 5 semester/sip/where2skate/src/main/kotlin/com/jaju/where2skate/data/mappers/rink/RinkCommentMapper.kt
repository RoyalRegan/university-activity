package com.jaju.where2skate.data.mappers.rink

import com.jaju.where2skate.data.dao.rink.RinkComment
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class RinkCommentMapper : RowMapper<RinkComment> {

    override fun mapRow(rs: ResultSet, rowNum: Int): RinkComment? {
        return RinkComment(
                id = rs.getInt("ID"),
                userName = rs.getString("NICKNAME"),
                rinkId = rs.getInt("RINK_ID"),
                text = rs.getString("TEXT"),
                karma = rs.getInt("KARMA"),
                deleted = rs.getInt("DELETED"),
                score = rs.getDouble("SCORE"),
                date = rs.getDate("DATE"),
                userRate = rs.getInt("RATE")
        )
    }
}