package com.tommy.tienda.service

import com.tommy.tienda.model.servicio
import com.tommy.tienda.repository.DistribuidorRepository
import com.tommy.tienda.repository.ProductoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*

@Service
class DistribuidorService {
    @Autowired
    lateinit var DistribuidorRepository:DistribuidorRepository


    fun list(): List<servicio> {

        return ProductoRepository.findAll()
    }

    fun update (producto: servicio): servicio {
        //validacion descripcion vacia
        if (producto.description.equals("")) {
            throw Exception()
        } else {
            return ProductoRepository.save(producto)
        }
    }

    fun delete (id:Long): Boolean {
        ProductoRepository.deleteById(id)
        return true
    }

    fun save (producto: servicio): servicio {
        return ProductoRepository.save(producto)
    }
}