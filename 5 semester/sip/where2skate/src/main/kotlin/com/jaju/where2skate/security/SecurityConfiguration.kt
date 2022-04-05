package com.jaju.where2skate.security

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.auth.FirebaseAuth
import com.jaju.where2skate.security.exception.SecurityExceptionHandler
import com.jaju.where2skate.security.filter.AuthFilter
import com.jaju.where2skate.security.firebase.FirebaseUserDetailsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.core.io.ClassPathResource
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
class SecurityConfiguration @Autowired constructor(private val firebaseUserDetailsService: FirebaseUserDetailsService) : WebSecurityConfigurerAdapter() {

    @Autowired
    private lateinit var authFilter: AuthFilter

    @Autowired
    private lateinit var exceptionHandler: SecurityExceptionHandler

    @Bean
    fun firebaseAuth(): FirebaseAuth {
        val serviceAccount = ClassPathResource("static/firebase.json").inputStream

        val options = FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://where2skate-254414.firebaseio.com")
                .build()

        FirebaseApp.initializeApp(options)

        return FirebaseAuth.getInstance()
    }

    override fun configure(web: WebSecurity) {
        web.ignoring().antMatchers(HttpMethod.GET, "/api/rinks", "/api/rink*", "/api/rink/*", "/api/rink/*/*")
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(firebaseUserDetailsService)
    }

    override fun configure(http: HttpSecurity) {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/**")
                .authenticated()
                .and()
                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter::class.java)
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().exceptionHandling().
                        authenticationEntryPoint(exceptionHandler).
                        accessDeniedHandler(exceptionHandler)
    }
}