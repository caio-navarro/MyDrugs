package com.site.mydrugs.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // Query para buscar usuário - deve retornar: username, password, enabled
        // Remove o prefixo {bcrypt} da senha para o Spring Security processar corretamente
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "SELECT email, REPLACE(senha, '{bcrypt}', '') as senha, enabled FROM clientes WHERE email = ?"
        );

        // Query para buscar autoridades/papéis - deve retornar: username, authority
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "SELECT c.email, p.papel FROM clientes c " +
                        "INNER JOIN papel p ON c.id_cliente = p.id_cliente " +
                        "WHERE c.email = ?"
        );

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(configurer -> {
            configurer
                    // Rotas públicas (não precisam de autenticação)
                    .requestMatchers("/cliente/cadastrar").permitAll()
                    .requestMatchers("/cliente/listar").permitAll()

                    // Rotas que precisam de papel específico
                    .requestMatchers("/droga/cadastrar").hasRole("USUARIO")
                    .requestMatchers("droga/listar").hasRole("USUARIO")

                    // Qualquer outra requisição precisa estar autenticada
                    .anyRequest().authenticated();
        });

        httpSecurity.httpBasic(Customizer.withDefaults());

        httpSecurity.csrf(csrf -> csrf.disable());

        return httpSecurity.build();
    }
}