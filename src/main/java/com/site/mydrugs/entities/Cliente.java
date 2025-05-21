package com.site.mydrugs.entities;

import com.site.mydrugs.models.ClienteModels;
import com.site.mydrugs.models.EnderecoClienteModels;

public class Cliente {

    private Integer idCliente;
    private String nome;
    private String email;
    private String telefone;
    private String senha;
    private String status = "ativo";
    private EnderecoClienteModels endereco;
    private Integer idEnderecoCliente;

    public Cliente() {
    }

    public Cliente(String nome, String email, String telefone, String senha, String status,
            EnderecoClienteModels endereco, Integer idEnderecoCliente) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.status = status;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
