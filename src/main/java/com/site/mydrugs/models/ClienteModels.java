package com.site.mydrugs.models;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

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

    @Column(name = "enabled")
    private boolean enabled = true;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco_cliente", insertable = false, updatable = false)
    private EnderecoClienteModels endereco;

    @Column(name = "id_endereco_cliente")
    private Integer idEnderecoCliente;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<PapelModels> papeis = new ArrayList<>();

    public ClienteModels() {
    }

    public ClienteModels(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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

    public List<PapelModels> getPapeis() {
        return papeis;
    }

    public void setPapeis(List<PapelModels> papeis) {
        this.papeis = papeis;
    }
}
