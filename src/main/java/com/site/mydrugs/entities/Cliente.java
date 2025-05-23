package com.site.mydrugs.entities;

import com.site.mydrugs.models.ClienteModels;
import com.site.mydrugs.models.EnderecoClienteModels;
import com.site.mydrugs.models.PapelModels;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cliente {

    private Integer idCliente;
    private String nome;
    private String email;
    private String telefone;
    private String senha;
    private List<String> papeis;
    private boolean enabled = true;
    private EnderecoClienteModels endereco;
    private Integer idEnderecoCliente;

    public Cliente() {
    }

    public Cliente(String nome, String email, List<String> papeis, String telefone, String senha, boolean enabled,
            EnderecoClienteModels endereco, Integer idEnderecoCliente) {
        this.nome = nome;
        this.email = email;
        this.papeis = papeis;
        this.telefone = telefone;
        this.senha = senha;
        this.enabled = enabled;
        this.endereco = endereco;
        this.idEnderecoCliente = idEnderecoCliente;
    }

    public static Cliente toCliente(ClienteModels clienteModels){
        Cliente cliente = new Cliente();

        cliente.setIdCliente(clienteModels.getIdCliente());
        cliente.setNome(clienteModels.getNome());
        cliente.setEmail(clienteModels.getEmail());
        cliente.setTelefone(clienteModels.getTelefone());
        cliente.setIdEnderecoCliente(clienteModels.getIdEnderecoCliente());
        cliente.setEndereco(clienteModels.getEndereco());
        cliente.setSenha(clienteModels.getSenha());

        // Protegendo contra null
        if (clienteModels.getPapeis() != null) {
            cliente.setPapeis(
                    clienteModels.getPapeis()
                            .stream()
                            .map(PapelModels::getPapel)
                            .collect(Collectors.toList())
            );
        } else {
            cliente.setPapeis(new ArrayList<>());
        }

        return cliente;
    }

    public void verificaEmail() {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email não pode ser nulo ou vazio");
        }
        if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new IllegalArgumentException("Email inválido");
        }
    }

    public void verificaTelefone() {
        if (telefone == null || telefone.trim().isEmpty()) {
            throw new IllegalArgumentException("O campo 'telefone' é obrigatório e não pode estar vazio.");
        }
        if (telefone.length() != 11) {
            throw new IllegalArgumentException("O telefone deve ter 11 digitos. Formato (XX)XXXXX-XXXX.");
        }
    }

    public void validar() {
        verificaEmail();
        verificaTelefone();
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<String> getPapeis() {
        return papeis;
    }

    public void setPapeis(List<String> papeis) {
        this.papeis = papeis;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public EnderecoClienteModels getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoClienteModels endereco) {
        this.endereco = endereco;
    }

    public Integer getIdEnderecoCliente() {
        return idEnderecoCliente;
    }

    public void setIdEnderecoCliente(Integer idEnderecoCliente) {
        this.idEnderecoCliente = idEnderecoCliente;
    }

}
