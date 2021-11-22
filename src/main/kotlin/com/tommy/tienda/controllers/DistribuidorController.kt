package com.tommy.tienda.controllers

import com.tommy.tienda.model.Cliente
import com.tommy.tienda.model.distribuidor
import com.tommy.tienda.service.DistribuidorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/distribuidor")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class DsittribuidorController {
    @Autowired
    lateinit var DistribuidorService: DistribuidorService

    @GetMapping
    fun list(): List<distribuidor>{
        return DistribuidorService.list()
    }

    @GetMapping
    fun save(@RequestBody distribuidor: distribuidor): distribuidor {
        return DistribuidorService.save(distribuidor)
    }

    @PostMapping
    fun update (@RequestBody distribuidor: distribuidor): distribuidor {
        return DistribuidorService.update(distribuidor)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id:Long ):Boolean {
        return DistribuidorService.delete(id)
    }

}