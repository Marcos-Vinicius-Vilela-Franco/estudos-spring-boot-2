package br.com.tarefas.to_do_list.configs.security;

import javax.print.DocFlavor.READER;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig{
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
       http
        .csrf(csrf->csrf.disable())   
        .authorizeHttpRequests(
            authorizeConfig ->{
                authorizeConfig.requestMatchers("/api/create").permitAll();
                authorizeConfig.anyRequest().authenticated();
                
            }
        );
        return http.build();
    }
   
}
