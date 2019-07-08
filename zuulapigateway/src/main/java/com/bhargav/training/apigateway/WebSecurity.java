package com.bhargav.training.apigateway;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();
        httpSecurity.authorizeRequests()
                .antMatchers(HttpMethod.POST,"/createusers/users").permitAll()
                .antMatchers(HttpMethod.POST, "/createusers/login").permitAll()
                .antMatchers("h2-console/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(new JWTFilter(this.authenticationManager()));

        httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);


    }
}
