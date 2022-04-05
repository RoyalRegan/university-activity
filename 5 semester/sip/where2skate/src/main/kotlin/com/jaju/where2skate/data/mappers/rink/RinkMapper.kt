package com.jaju.where2skate.data.mappers.rink

import com.jaju.where2skate.data.dao.rink.Rink
import com.jaju.where2skate.data.dao.rink.params.OpenHours
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet
import java.util.stream.Collector
import java.util.stream.Collectors

class RinkMapper : RowMapper<Rink> {

    override fun mapRow(rs: ResultSet, rowNum: Int): Rink {
        return Rink(
                id = rs.getInt("ID"),
                latitude = rs.getDouble("LATITUDE"),
                longitude = rs.getDouble("LONGITUDE"),
                name = rs.getString("NAME"),
                openHours = rs.getString("OPEN_HOURS").split(",").stream().map { OpenHours.valueOf(it.toUpperCase()) }.collect(Collectors.toList()),
                parking = rs.let {val v = it.getInt("PARKING"); if (it.wasNull()) null else v },
                phoneNumber = rs.getString("PHONE_NUMBER"),
                free = rs.getInt("FREE"),
                rating = rs.getDouble("RATING"),
                skatesRentals = rs.let { val v = it.getInt("SKATES_RENTALS"); if (it.wasNull()) null else v },
                skatesSharpening = rs.let { val v = it.getInt("SKATES_SHARPENING");  if (it.wasNull()) null else v },
                type = rs.getString("PREFIX"),
                warmRoom = rs.let { val v = it.getInt("WARM_ROOM");  if (it.wasNull()) null else v },
                websiteUrl =rs.getString("WEBSITE_URL")
        )
    }
}