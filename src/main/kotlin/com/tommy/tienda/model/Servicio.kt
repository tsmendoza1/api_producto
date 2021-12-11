package com.tommy.tienda.model

import javax.persistence.*

@Entity
@Table(name = "servicio")
class Servicio {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    var descripcion: String? = null

    var details: String? = null

}