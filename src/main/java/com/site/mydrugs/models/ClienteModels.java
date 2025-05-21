package com.site.mydrugs.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class ClienteModels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer idCliente;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "senha")
    private String senha;

    @Column(name = "status")
    private String status = "ativo";

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco_cliente", insertable = false, updatable = false)
    private EnderecoClienteModels endereco;

    @Column(name = "id_endereco_cliente")
    private Integer idEnderecoCliente;

    private String roles;

    public ClienteModels() {
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    
    
}
