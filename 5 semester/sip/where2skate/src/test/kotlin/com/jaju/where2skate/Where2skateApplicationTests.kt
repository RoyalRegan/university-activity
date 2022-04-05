package com.jaju.where2skate

import com.jaju.where2skate.data.services.RinkService
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class Where2skateApplicationTests {

    @Autowired
    private lateinit var rinkService: RinkService

    @Test
    fun contextLoads() {
    }

}
