package com.tommy.tienda.repository

import com.tommy.tienda.model.servicio
import org.springframework.data.jpa.repository.JpaRepository

interface ProductoRepository: JpaRepository <servicio, Long> {
    //interface WorkoutRepository:JpaRepository<Producto, Long> {}
}