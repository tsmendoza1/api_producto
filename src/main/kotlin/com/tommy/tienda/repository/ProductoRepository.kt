package com.tommy.tienda.repository

import com.tommy.tienda.model.Producto
import org.springframework.data.jpa.repository.JpaRepository

interface ProductoRepository: JpaRepository <Producto, Long> {
    //interface WorkoutRepository:JpaRepository<Producto, Long> {}
}