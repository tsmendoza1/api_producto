package com.tommy.tienda.service.UsersService

import com.tommy.tienda.model.Users
import com.tommy.tienda.repository.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException
import java.lang.Integer.parseInt

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

    fun verificarCedula (cedula:String){
        var cedula = "0931811087";

        //Preguntamos si la cedula consta de 10 digitos
        if(cedula.length == 10){

            //Obtenemos el digito de la region que sonlos dos primeros digitos
            var digito_region = cedula.substring(0,2);

            //Pregunto si la region existe ecuador se divide en 24 regiones
            if( digito_region >= "1" && digito_region <="24" ){

                // Extraigo el ultimo digito
                var ultimo_digito   = cedula.substring(9,10);

                //Agrupo todos los pares y los sumo
                var pares = parseInt(cedula.substring(1,2)) + parseInt(cedula.substring(3,4)) + parseInt(cedula.substring(5,6)) + parseInt(cedula.substring(7,8));

                //Agrupo los impares, los multiplico por un factor de 2, si la resultante es > que 9 le resta el 9 a la resultante
                var numero1a = cedula.substring(0,1);
                var numero1 = (numero1a*2);
                if( numero1 > 9 ){ var numero1 = (numero1 - 9); }

                var numero3a = cedula.substring(2,3);
                var numero3 = (numero3a * 2);
                if( numero3 > 9 ){ var numero3 = (numero3 - 9); }

                var numero5a = cedula.substring(4,5);
                var numero5 = (numero5a * 2);
                if( numero5 > 9 ){ var numero5 = (numero5 - 9); }

                var numero7a = cedula.substring(6,7);
                var numero7 = (numero7a * 2);
                if( numero7 > 9 ){ var numero7 = (numero7 - 9); }

                var numero9a = cedula.substring(8,9);
                var numero9 = (numero9a * 2);
                if( numero9 > 9 ){ var numero9 = (numero9 - 9); }

                var impares = numero1 + numero3 + numero5 + numero7 + numero9;

                //Suma total
                var suma_total = (pares + impares);

                //extraer el primero digito
                var primer_digito_suma = String(suma_total).substring(0,1);

                //Obtener la decena inmediata
                var decena = (parseInt(primer_digito_suma) + 1)  * 10;

                //Obtener la resta de la decena inmediata - la suma_total esto da el digito validador
                var digito_validador = decena - suma_total;

                //Si el digito validador es = a 10 toma el valor de 0
                if(digito_validador == 10)
                var digito_validador = 0

                //Validar que el digito validador sea igual al de la cedula
                if(digito_validador == ultimo_digito){
                    println("la cedula:" + cedula + " es correcta");
                }else{
                    println("la cedula:" + cedula + "es incorrecta")
                }

            }else{

                println("Esta cedula no pertenece a ninguna region");
            }
        }else{

            println("Esta cedula tiene menos de 10 Digitos");
        }

    }

} //service

