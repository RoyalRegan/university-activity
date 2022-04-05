package com.jaju.kursach_core.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
@EnableWebSecurity
class SecurityConfig @Autowired constructor(val customUserDetailsService: CustomUserDetailsService) : WebSecurityConfigurerAdapter() {
    @Bean
    fun bCryptPasswordEncoder() = BCryptPasswordEncoder();

    override fun configure(web: WebSecurity) {
        web.ignoring().antMatchers(HttpMethod.GET, "/api/list/**")
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(customUserDetailsService)
    }

    override fun configure(http: HttpSecurity) {
        http.csrf().disable()
                .authorizeRequests().antMatchers("/api/client/**","/api/list/**").authenticated()
                .and()
                .httpBasic().and()
                .cors()
    }
}