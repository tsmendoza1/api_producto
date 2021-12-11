package com.tommy.tienda.repository

import com.tommy.tienda.model.Servicio
import org.springframework.data.jpa.repository.JpaRepository

interface ProductoRepository: JpaRepository <Servicio, Long> {
    //interface WorkoutRepository:JpaRepository<Producto, Long> {}
}