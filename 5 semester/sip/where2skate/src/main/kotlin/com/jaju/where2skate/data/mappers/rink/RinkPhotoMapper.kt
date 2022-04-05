package com.jaju.where2skate.data.mappers.rink

import com.jaju.where2skate.data.dao.rink.RinkPhoto
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class RinkPhotoMapper : RowMapper<RinkPhoto> {

    override fun mapRow(rs: ResultSet, rowNumber: Int): RinkPhoto? {
        return RinkPhoto(
                id = rs.getInt("ID"),
                rinkId = rs.getInt("RINK_ID"),
                url = rs.getString("URL")
        )
    }
}