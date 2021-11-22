package com.tommy.tienda.controllers

import com.tommy.tienda.model.Cliente
import com.tommy.tienda.model.servicio
import com.tommy.tienda.service.ProductoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/servicio")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class ProductoController {
    @Autowired
    lateinit var ProductoService: ProductoService

    @GetMapping
    fun list(): List<servicio>{
        return ProductoService.list()
    }

    @PostMapping
    fun update (@RequestBody producto: servicio): servicio {
        return ProductoService.update(producto)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id:Long ):Boolean {
        return ProductoService.delete(id)
    }

}