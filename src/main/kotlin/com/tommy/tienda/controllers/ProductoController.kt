package com.tommy.tienda.controllers

import com.tommy.tienda.model.Servicio
import com.tommy.tienda.service.ProductoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/servicio")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class ProductoController {
    @Autowired
    lateinit var productoService: ProductoService

    @GetMapping
    fun list(): List<Servicio>{
        return productoService.list()
    }

    @PostMapping
    fun update (@RequestBody servicio: Servicio): Servicio {
        return productoService.update(servicio)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id:Long ):Boolean {
        return productoService.delete(id)
    }

    @GetMapping
    fun save(@RequestBody servicio: Servicio): Servicio {
        return productoService.save(servicio)
    }

}