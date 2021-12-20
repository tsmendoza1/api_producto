package com.tommy.tienda.model

import javax.persistence.*

class Users(val username: String, val password: Any?) {
    @Entity
    @Table(name = "users")
    class Users{
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        @Column(updatable = false)
        var id: Long? = null
        var username: String? = null
        var password: String? = null
    }
}