package com.tommy.tienda.repository

import com.tommy.tienda.model.Distribuidor
import org.springframework.data.jpa.repository.JpaRepository

interface DistribuidorRepository: JpaRepository<Distribuidor, Long> {
    //interface WorkoutRepository:JpaRepository<Producto, Long> {}
}