package com.tommy.tienda.service

<<<<<<< HEAD
import com.tommy.tienda.repository.UsersRepository
=======
>>>>>>> origin/main
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service


@Service
class AppUserDetailsService: UserDetailsService {
    @Autowired
<<<<<<< HEAD
    lateinit var UsersRepository: UsersRepository

    override fun loadUserByUsername(username: String?): UserDetails {
        val response = UsersRepository.findByUsername(username)
=======
    lateinit var usersService: UsersService

    override fun loadUserByUsername(username: String?): UserDetails {
        val response = usersService.getUser(username)
>>>>>>> origin/main
        return User(response?.username,"{noop}admin"+response?.password, ArrayList())
    }//GymUserDetailsService
}