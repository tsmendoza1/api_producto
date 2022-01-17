package com.tommy.tienda.security

import com.tommy.tienda.security.filter.JwtFilterRequest
import com.tommy.tienda.service.AppUserDetailsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter


@EnableWebSecurity
class SecurityConfig: WebSecurityConfigurerAdapter() {
    @Autowired
    lateinit var AppUserDetailsService: AppUserDetailsService

    @Autowired
    lateinit var jwtFilterRequest: JwtFilterRequest

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth?.userDetailsService(AppUserDetailsService)
    }

    override fun configure(http: HttpSecurity) {
        http.csrf()?.disable()
                ?.authorizeRequests()?.antMatchers("/**/auth")
                ?.permitAll()?.anyRequest()?.authenticated()
                ?.and()?.sessionManagement()
                ?.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        http.addFilterBefore(jwtFilterRequest, UsernamePasswordAuthenticationFilter::class.java)
    }
    @Bean
    override fun authenticationManagerBean(): AuthenticationManager {
        return super.authenticationManagerBean()
    }
}