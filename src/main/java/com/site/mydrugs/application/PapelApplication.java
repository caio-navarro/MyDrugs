package com.site.mydrugs.application;

import com.site.mydrugs.models.ClienteModels;
import com.site.mydrugs.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PapelApplication {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void cadastrar(ClienteModels cliente) {
        // Codificar a senha SEM o prefixo {bcrypt}
        cliente.setSenha(passwordEncoder.encode(cliente.getSenha()));

        this.clienteRepository.save(cliente);
    }
}