package com.tommy.tienda.service

import com.tommy.tienda.model.Servicio
import com.tommy.tienda.repository.ProductoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ProductoService {
    @Autowired
    lateinit var ProductoRepository: ProductoRepository


    fun list(): List<Servicio> {

        return ProductoRepository.findAll()
    }

    fun update (servicio: Servicio): Servicio {
        try {
            //validacion descripcion vacia
            if (servicio.descripcion.equals("")) {
                throw Exception()
            } else {
                return ProductoRepository.save(servicio)
            }
        } catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_ACCEPTABLE, "No se aceptan campos vacios", ex)
        }
    }
    fun delete (id:Long): Boolean {
        ProductoRepository.deleteById(id)
        return true
    }

    fun save (servicio:Servicio): Servicio {
        return ProductoRepository.save(servicio)
    }
}