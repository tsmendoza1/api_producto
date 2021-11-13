package com.tommy.tienda.controllers

import com.tommy.tienda.model.Cliente
import com.tommy.tienda.model.Producto
import com.tommy.tienda.service.ClienteService
import com.tommy.tienda.service.ProductoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.web.bind.annotation.*

    @RestController
    @RequestMapping("/cliente")
    @CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

    class ClienteController {
        @Autowired
        lateinit var ClienteService: ClienteService

        @GetMapping
        fun list(): List<Cliente>{
            return ClienteService.list()
        }

        @PostMapping
        fun update (@RequestBody cliente:Cliente): Cliente {
            return ClienteService.update(cliente)
        }

       @DeleteMapping("/delete/{id}")
        fun delete (@PathVariable("id") id:Long ):Boolean {
            return ClienteService.delete(id)
        }
  }
