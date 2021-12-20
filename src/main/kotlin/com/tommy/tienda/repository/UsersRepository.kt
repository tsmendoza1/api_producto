package com.tommy.tienda.repository

import com.tommy.tienda.model.Users
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface UsersRepository : JpaRepository<Users, Long> {
    fun findById(id:Long?):Users?
    @Query(value = "SELECT FROM u WHERE u.username = :username", nativeQuery = true)
    fun findByUsername(username:String?):Users?
}//interfaz nueva
