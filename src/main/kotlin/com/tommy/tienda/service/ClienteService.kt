package com.tommy.tienda.service

import com.tommy.tienda.model.Cliente
import com.tommy.tienda.repository.ClienteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ClienteService {
    @Autowired
    lateinit var ClienteRepository: ClienteRepository 

    fun list(): List<Cliente> {
        return ClienteRepository.findAll()
    }

    fun update (cliente: Cliente):Cliente {
        //validacion nombre vacio
        try {
            cliente.Nombre?.trim()?.isEmpty()
                    ?: throw java.lang.Exception("El nombre no puede estar vacio")

            if (cliente.Nombre.equals("")) {
                throw Exception()
            } else {
                return ClienteRepository.save(cliente)
            }

        }catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_ACCEPTABLE, "No se aceptan nombres vacios", ex)
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

    fun verifyWord(description: String?):Boolean{
        if (description?.length!!<3){
            return false
        }
        return true
    }
}