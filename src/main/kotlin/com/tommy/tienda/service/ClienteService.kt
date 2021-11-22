package com.tommy.tienda.service

import com.tommy.tienda.model.Cliente
import com.tommy.tienda.repository.ClienteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ClienteService {
    @Autowired
    lateinit var ClienteRepository: ClienteRepository 

    fun list(): List<Cliente> {
        return ClienteRepository.findAll()
    }

    fun update (cliente: Cliente):Cliente {
        //validacion nombre vacio
        if (cliente.Nombre.equals("")) {
            throw Exception()
        } else {
            return ClienteRepository.save(cliente)
        }
    }

    fun delete (id:Long): Boolean {
        ClienteRepository.deleteById(id)
        return true
    }

    fun save (cliente:Cliente):Cliente {
        //validacion cliente vacio
        if (cliente.Nombre.equals("")){

        }
        return ClienteRepository.save(cliente)
    }
}