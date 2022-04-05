package com.jaju.kursach_core.security

import java.lang.RuntimeException

class DuplicateLoginException : RuntimeException("Данный login уже используется")