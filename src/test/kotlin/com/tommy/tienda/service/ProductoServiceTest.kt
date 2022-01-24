package com.tommy.tienda.service

import com.tommy.tienda.model.Distribuidor
import com.tommy.tienda.model.Servicio
import com.tommy.tienda.repository.DistribuidorRepository
import com.tommy.tienda.repository.ProductoRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest

class ProductoServiceTest {

    @InjectMocks
    lateinit var productoService: ProductoService

    @Mock
    lateinit var productoRepository: ProductoRepository

    val returnObject: Servicio = Servicio().apply {
        id= 1
        descripcion="Sana"
    }
    val newObject: Servicio = Servicio().apply {
        id= 1
        descripcion="Sana"
    }

    @Test
    fun saveIsCorrect(){
        Mockito.`when`(productoRepository.save(Mockito.any(Servicio::class.java))).thenReturn(returnObject)
        val response = productoService.save(newObject)
        Assertions.assertEquals(response.id, newObject.id)
        Assertions.assertEquals(response.descripcion, newObject.descripcion)
    }

    @Test
    fun updateIsCorrect(){
        Mockito.`when`(productoRepository.save(Mockito.any(Servicio::class.java))).thenReturn(returnObject)
        val response = productoService.update(newObject)
        Assertions.assertEquals(response.id, newObject.id)
        Assertions.assertEquals(response.descripcion, newObject.descripcion)
    }
}