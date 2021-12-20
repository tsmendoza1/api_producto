package com.tommy.tienda.service

import com.tommy.tienda.repository.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service


@Service
class AppUserDetailsService: UserDetailsService {
    @Autowired
    lateinit var UsersRepository: UsersRepository

    override fun loadUserByUsername(username: String?): UserDetails {
        val response = UsersRepository.findByUsername(username)
        return User(response?.username,"{noop}admin"+response?.password, ArrayList())
    }//GymUserDetailsService
}