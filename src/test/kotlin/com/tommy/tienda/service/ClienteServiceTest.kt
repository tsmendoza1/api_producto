package com.tommy.tienda.service

import com.tommy.tienda.model.Cliente
import com.tommy.tienda.repository.ClienteRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest

class ClienteServiceTest {

    @InjectMocks
    lateinit var clienteService: ClienteService

    @Mock
    lateinit var clienteRepository: ClienteRepository



    val returnObject: Cliente = Cliente().apply {
        id= 1
        Nombre="Sana"
    }
    val newObject: Cliente = Cliente().apply {
        id= 1
        Nombre="Sana"
    }

    @Test
    fun saveIsCorrect(){
        Mockito.`when`(clienteRepository.save(Mockito.any(Cliente::class.java))).thenReturn(returnObject)
        val response = clienteService.save(newObject)
        Assertions.assertEquals(response.id, newObject.id)
        Assertions.assertEquals(response.Nombre, newObject.Nombre)
    }

    @Test
    fun updateIsCorrect(){
        Mockito.`when`(clienteRepository.save(Mockito.any(Cliente::class.java))).thenReturn(returnObject)
        val response = clienteService.update(newObject)
        Assertions.assertEquals(response.id, newObject.id)
        Assertions.assertEquals(response.Nombre, newObject.Nombre)
    }

}