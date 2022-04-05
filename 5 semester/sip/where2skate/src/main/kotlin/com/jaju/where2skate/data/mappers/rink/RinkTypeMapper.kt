package com.jaju.where2skate.data.mappers.rink

import com.jaju.where2skate.data.dao.rink.RinkType
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class RinkTypeMapper : RowMapper<RinkType> {

    override fun mapRow(rs: ResultSet, rowNum: Int): RinkType {
        return RinkType(
                name = rs.getString("NAME"),
                prefix = rs.getString("PREFIX"),
                description = rs.getString("DESCRIPTION")
        )
    }
}