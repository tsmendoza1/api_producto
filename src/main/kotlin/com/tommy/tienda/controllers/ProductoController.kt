package com.tommy.tienda.controllers

import com.tommy.tienda.model.Producto
import com.tommy.tienda.service.ProductoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/producto")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class ProductoController {
    @Autowired
    lateinit var ProductoService: ProductoService

    @GetMapping
    fun list(): List<Producto>{
        return ProductoService.list()
    }

}