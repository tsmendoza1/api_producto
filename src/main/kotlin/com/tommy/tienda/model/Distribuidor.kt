package com.tommy.tienda.model

import javax.persistence.*

@Entity
@Table(name = "distribuidor")
class Distribuidor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    var nombre: String? = null

    var descripcion: String? = null
}