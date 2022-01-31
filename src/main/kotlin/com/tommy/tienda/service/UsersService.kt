package com.tommy.tienda.service

import com.tommy.tienda.model.Users
import com.tommy.tienda.repository.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class UsersService {
    @Autowired
    lateinit var usersRepository: UsersRepository


    fun list(): List<Users> {
        return usersRepository.findAll()
    }

    fun getUser(username: String?): Users?{
        try {
            val response = usersRepository.findByUsername(username)
                    ?: throw Exception("No existe el usuario")
            return response
        } catch (ex:Exception){
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, "User not found", ex)
        }
    }

    fun update(user: Users): Users {
        return usersRepository.save(user)
    }

    fun delete (id:Long): Boolean{
        usersRepository.deleteById(id)
        return true
    }

}

