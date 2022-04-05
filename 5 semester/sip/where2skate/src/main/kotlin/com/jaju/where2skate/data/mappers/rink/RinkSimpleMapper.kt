package com.jaju.where2skate.data.mappers.rink

import com.jaju.where2skate.data.dao.rink.RinkSimple
import com.jaju.where2skate.data.dao.rink.params.OpenHours
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet
import java.util.stream.Collectors

class RinkSimpleMapper : RowMapper<RinkSimple> {

    override fun mapRow(rs: ResultSet, rowNum: Int): RinkSimple? {
        return RinkSimple(
                id = rs.getInt("ID"),
                latitude = rs.getDouble("LATITUDE"),
                longitude = rs.getDouble("LONGITUDE"),
                name = rs.getString("NAME"),
                openHours = rs.getString("OPEN_HOURS").split(",").stream().map { OpenHours.valueOf(it.toUpperCase()) }.collect(Collectors.toList()),
                type = rs.getString("TYPE"),
                free = rs.getInt("FREE"),
                rating = rs.getDouble("RATING")
        )
    }
}