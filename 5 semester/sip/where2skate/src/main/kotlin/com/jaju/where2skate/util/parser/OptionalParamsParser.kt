package com.jaju.where2skate.util.parser

import com.jaju.where2skate.data.dao.rink.params.OptionalParam
import com.jaju.where2skate.data.dao.rink.params.OptionalParams

fun parseOptionalParam(param: String): OptionalParam? {
    val value = if (param[0] == ('!')) 0 else 1
    param.replace("!", "").let {
        return try {
            OptionalParam(OptionalParams.valueOf(it.toUpperCase()), value)
        } catch (e: EnumConstantNotPresentException) {
            null
        }
    }
}