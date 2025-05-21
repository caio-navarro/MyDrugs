package com.site.mydrugs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.site.mydrugs.models.ClienteModels;
import com.site.mydrugs.repositories.ClienteRepository;

@Service
public class UsuarioDetailsService implements UserDetailsService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public UsuarioDetailsService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        ClienteModels cliente = clienteRepository.findByEmail(username)
            .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        return User.builder()
                .username(cliente.getEmail())          // login
                .password(cliente.getSenha())          // senha já em BCrypt
                .roles(cliente.getRoles())
                .build();
    }
}