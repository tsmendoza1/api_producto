package com.tommy.tienda.repository

import com.tommy.tienda.model.Cliente
import org.springframework.data.jpa.repository.JpaRepository

interface ClienteRepository: JpaRepository<Cliente, Long> {
    //interface WorkoutRepository:JpaRepository<Producto, Long> {}
   // fun findById(id:Long):Cliente?
}