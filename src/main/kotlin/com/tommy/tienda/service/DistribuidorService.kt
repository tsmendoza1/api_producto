package com.tommy.tienda.service

import com.tommy.tienda.model.Cliente
import com.tommy.tienda.model.Distribuidor
import com.tommy.tienda.repository.ClienteRepository
import com.tommy.tienda.repository.DistribuidorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@Service
class DistribuidorService {
    @Autowired
    lateinit var distribuidorRepository: DistribuidorRepository

    fun list(): List<Distribuidor> {
        return distribuidorRepository.findAll()
    }

    fun save (distribuidor: Distribuidor): Distribuidor {
        //validacion cliente vacio
        if (distribuidor.nombre.equals("")){

        }
        return distribuidorRepository.save(distribuidor)
    }

    fun update (distribuidor: Distribuidor): Distribuidor {
        //validacion nombre vacio
        try {
            if (distribuidor.nombre.equals("")) {
                throw Exception()
            } else {
                return distribuidorRepository.save(distribuidor)
            }
        }catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_ACCEPTABLE, "No se aceptan nombres vacios", ex)
        }
    }

    fun delete (id:Long): Boolean {
        distribuidorRepository.deleteById(id)
        return true
    }



   }