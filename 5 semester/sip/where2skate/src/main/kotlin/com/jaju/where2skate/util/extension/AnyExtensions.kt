package com.jaju.where2skate.util.extension

fun <T : Any> T?.notNull(action: (it: T) -> Unit) {
    if (this != null) {
        action(this)
    }
}