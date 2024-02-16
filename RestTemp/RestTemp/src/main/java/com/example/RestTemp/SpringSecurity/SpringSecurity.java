package com.example.RestTemp.SpringSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SpringSecurity {
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user= User.withDefaultPasswordEncoder().username("shashank").password("12345").build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.cors(c->c.disable());
        httpSecurity.cors(c-> c.disable());
        httpSecurity.sessionManagement(s->s.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        httpSecurity

                .authorizeHttpRequests(authRequst-> {
                    authRequst
                            .requestMatchers("/**","/employes").authenticated();

                });
        httpSecurity.formLogin(Customizer.withDefaults());
        httpSecurity.httpBasic(Customizer.withDefaults());

        return httpSecurity.build();
    }
}
