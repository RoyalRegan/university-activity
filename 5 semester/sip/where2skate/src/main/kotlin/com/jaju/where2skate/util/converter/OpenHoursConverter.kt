package com.jaju.where2skate.util.converter

import com.jaju.where2skate.data.dao.rink.params.OpenHours
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class OpenHoursConverter : Converter<String, OpenHours> {

    override fun convert(source: String): OpenHours? {
        return try {
            OpenHours.valueOf(source.toUpperCase())
        } catch (e: EnumConstantNotPresentException) {
            null
        }
    }
}

