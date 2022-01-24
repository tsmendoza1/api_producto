package com.tommy.tienda.service

import com.tommy.tienda.service.UsersService.UsersService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest

class UserServiceTest {

    @Autowired
    lateinit var usersService: UsersService

    @Test
    fun calMultiplicationTest(){
        //    val response = usersService.calcMultiplication(2, 2)
        //   Assertions.assertEquals(4, response)
    }

    @Test
    fun restNine (){
        //numero mayor a 10 restar 9 si no devolver el mismo
        //    val response = usersService.restNine(1)
        //   Assertions.assertEquals(1, response)
    }

    @Test
    fun subtactFromNextTen (){
        //  val response = usersService.subtactFromNextTen(7)
        //  Assertions.assertEquals(1, response)
    }

    @Test
    fun verificarCedula (){
        //  val response = usersService.verificarCedula("0987654321")
        // Assertions.assertEquals(false, response)
    }

}