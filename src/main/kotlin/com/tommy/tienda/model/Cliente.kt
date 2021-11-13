package com.tommy.tienda.model

import javax.persistence.*

@Entity
@Table(name = "cliente")
class Cliente {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    var Nombre: String? = null

    var Fecha: String? = null
}