package com.tommy.tienda.service

import com.tommy.tienda.model.Cliente
import com.tommy.tienda.model.Producto
import com.tommy.tienda.repository.ClienteRepository
import com.tommy.tienda.repository.ProductoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody

@Service
class ClienteService {
    @Autowired
    lateinit var ClienteRepository: ClienteRepository 

    fun list(): List<Cliente> {
        return ClienteRepository.findAll()
    }

    fun update (cliente: Cliente):Cliente{
        return ClienteRepository.save(cliente)
    }

   // fun updateDescription (cliente: Cliente):Cliente {
     //   val response = ClienteRepository.findById(cliente.id) ?: throw Exception()
       // response.apply {
         //   this.description = cliente.description
        //}
        //return ClienteRepository.save(cliente)
   // }

    fun delete (id:Long): Boolean {
        ClienteRepository.deleteById(id)
        return true
    }

    fun save(cliente:Cliente):Cliente {
        return ClienteRepository.save(cliente)
    }
}