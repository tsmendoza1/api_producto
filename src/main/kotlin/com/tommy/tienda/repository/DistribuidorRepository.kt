package com.tommy.tienda.repository

import com.tommy.tienda.model.distribuidor
import org.springframework.data.jpa.repository.JpaRepository

interface DistribuidorRepository: JpaRepository<distribuidor, Long> {
    //interface WorkoutRepository:JpaRepository<Producto, Long> {}
}