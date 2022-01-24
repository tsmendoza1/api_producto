package com.tommy.tienda.service

import com.tommy.tienda.model.Cliente
import com.tommy.tienda.model.Distribuidor
import com.tommy.tienda.repository.ClienteRepository
import com.tommy.tienda.repository.DistribuidorRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest

class DistribuidorServiceTest {

    @InjectMocks
    lateinit var distribuidorService: DistribuidorService

    @Mock
    lateinit var distribuidorRepository: DistribuidorRepository

    val returnObject: Distribuidor = Distribuidor().apply {
        id= 1
        nombre="Sana"
    }
    val newObject: Distribuidor = Distribuidor().apply {
        id= 1
        nombre="Sana"
    }

    @Test
    fun saveIsCorrect(){
        Mockito.`when`(distribuidorRepository.save(Mockito.any(Distribuidor::class.java))).thenReturn(returnObject)
        val response = distribuidorService.save(newObject)
        Assertions.assertEquals(response.id, newObject.id)
        Assertions.assertEquals(response.nombre, newObject.nombre)
    }

    @Test
    fun updateIsCorrect(){
        Mockito.`when`(distribuidorRepository.save(Mockito.any(Distribuidor::class.java))).thenReturn(returnObject)
        val response = distribuidorService.update(newObject)
        Assertions.assertEquals(response.id, newObject.id)
        Assertions.assertEquals(response.nombre, newObject.nombre)
    }
}