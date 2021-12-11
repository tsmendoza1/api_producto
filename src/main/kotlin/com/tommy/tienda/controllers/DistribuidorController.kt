package com.tommy.tienda.controllers

import com.tommy.tienda.model.Distribuidor
import com.tommy.tienda.service.DistribuidorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/distribuidor")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class DistribuidorController {
    @Autowired
    lateinit var DistribuidorService: DistribuidorService

    @GetMapping
    fun list(): List<Distribuidor>{
        return DistribuidorService.list()
    }

    @GetMapping
    fun save(@RequestBody distribuidor: Distribuidor): Distribuidor {
        return DistribuidorService.save(distribuidor)
    }

    @PostMapping
    fun update (@RequestBody distribuidor: Distribuidor): Distribuidor {
        return DistribuidorService.update(distribuidor)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id:Long ):Boolean {
        return DistribuidorService.delete(id)
    }

}