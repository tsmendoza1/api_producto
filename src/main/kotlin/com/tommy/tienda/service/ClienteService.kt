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
    lateinit var clienteRepository: ClienteRepository

    fun list(): List<Cliente> {
        return clienteRepository.findAll()
    }

    fun save (cliente:Cliente):Cliente {
        return clienteRepository.save(cliente)
    }

    fun update(cliente: Cliente): Cliente {
        if (verifyDescription("libre")) {
            return clienteRepository.save(cliente)
        }
        return clienteRepository.save(cliente)
    }

    fun updateNombre (cliente: Cliente):Cliente {
        //validacion nombre vacio
        try {
            cliente.Nombre?.trim()?.isEmpty()
                    ?: throw java.lang.Exception("El nombre no puede estar vacio")

            if (cliente.Nombre.equals("")) {
                throw Exception()
            } else {
                return clienteRepository.save(cliente)
            }

        }catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_ACCEPTABLE, "No se aceptan nombres vacios", ex)
        }
    }



    fun delete (id:Long): Boolean {
        clienteRepository.deleteById(id)
        return true
    }



    fun verifyWord(description: String?):Boolean{
        if (description?.length!!<3){
            return false
        }
        return true
    }

    fun verifyDescription(description: String?):Boolean{
        fun verifyDescription(description: String?):Boolean{

            for (i in 0..String().length){
                val lista= listOf<String>("ocupado","libre")
            }
            return true
        }
        return false
    }
}