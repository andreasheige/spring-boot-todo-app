package com.pabe.springboottodoapp.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
//@EnableWebSecurity
public class TodoSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws  Exception {
        auth
                .inMemoryAuthentication()
                .withUser("boss").password("{noop}1234").authorities("USER")
                .and()
                .withUser("boss").password("{noop}1234").authorities("USER", "ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/todos").hasAuthority("USER")
                .antMatchers("/todoDelete/*").hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "/todos*").hasAnyAuthority("ADMIN")
                .and()
                .formLogin()
                .and()
                .rememberMe();    
    
    }

}