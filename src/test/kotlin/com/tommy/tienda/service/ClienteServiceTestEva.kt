package com.tommy.tienda.service

import com.google.gson.Gson
import com.tommy.tienda.model.Cliente
import com.tommy.tienda.repository.ClienteRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import java.io.File

@SpringBootTest

class ClienteServiceTestEva {

    @InjectMocks
    lateinit var clienteService: ClienteService

    @Mock
    lateinit var clienteRepository: ClienteRepository

    val jsonString = File("./src/test/resources/Cliente/CrearCliente.json").readText(Charsets.UTF_8)
    val clienteMock = Gson().fromJson(jsonString, Cliente::class.java)

    @Test
    fun updateIsCorrect(){
        Mockito.`when`(clienteRepository.save(Mockito.any(Cliente::class.java))).thenReturn(clienteMock)
        val response = clienteService.update(clienteMock)
        Assertions.assertEquals(response.id, clienteMock.id)
        Assertions.assertEquals(response.Nombre, clienteMock.Nombre)
    }

    @Test
    fun updateIsInCorrect(){
       // Mockito.`when`(clienteRepository.save(Mockito.any(Cliente::class.java))).thenReturn(clienteMock)
        val response = clienteService.update(clienteMock)
        Assertions.assertEquals(response.id, clienteMock.id)
        Assertions.assertEquals(response.Nombre, clienteMock.Nombre)
    }

    @Test
    fun validateDescriptionIsCorrect(){
        val response = clienteService.verifyNombre()
        Assertions.assertEquals(true, response)
    }

    @Test
    fun validateDescriptionIsIncorrect(){
        val response = clienteService.verifyNombre()
        Assertions.assertEquals(false, response)
    }

}