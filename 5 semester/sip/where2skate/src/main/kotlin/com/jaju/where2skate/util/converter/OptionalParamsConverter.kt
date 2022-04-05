package com.jaju.where2skate.util.converter

import com.jaju.where2skate.data.dao.rink.params.OptionalParam
import com.jaju.where2skate.util.parser.parseOptionalParam
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class OptionalParamsConverter : Converter<String, OptionalParam> {

    override fun convert(source: String): OptionalParam? {
        return parseOptionalParam(source)
    }
}