package com.site.mydrugs.entities;

import com.site.mydrugs.models.EnderecoClienteModels;

public class EnderecoCliente {
    private Integer idEnderecoCliente;
    private String logradouro;
    private String numero;
    private String cidade;
    private String estado;
    private String cep;

    public EnderecoCliente(String logradouro, String numero, String cidade, String estado, String cep) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public EnderecoCliente() {
    }

    public static EnderecoCliente toCliente(EnderecoClienteModels enderecoModels){
        EnderecoCliente endereco = new EnderecoCliente();

        endereco.setIdEnderecoCliente(enderecoModels.getIdEnderecoCliente());
        endereco.setLogradouro(enderecoModels.getLogradouro());
        endereco.setCep(enderecoModels.getCep());
        endereco.setNumero(enderecoModels.getNumero());
        endereco.setCidade(enderecoModels.getCidade());
        endereco.setEstado(enderecoModels.getEstado());
        return endereco;
    }

    public void validar(){
        logradouroIsInvalid();
        numeroIsInvalid();
        cidadeIsInvalid();
        estadoIsInvalid();
        cepIsInvalid();
    }

    public void logradouroIsInvalid() {
        if (logradouro == null || logradouro.trim().isEmpty() || logradouro.length() < 3 || logradouro.length() > 255) {
            throw new IllegalArgumentException("O logradouro deve ter entre 3 e 255 caracteres.");
        }
    }

    public void numeroIsInvalid() {
        if (numero == null || numero.trim().isEmpty()) {
            throw new IllegalArgumentException("O número do endereço é obrigatório.");
        }
    }

    public void cidadeIsInvalid() {
        if (cidade == null || cidade.trim().isEmpty() || cidade.length() < 2 || cidade.length() > 100) {
            throw new IllegalArgumentException("A cidade deve ter entre 2 e 100 caracteres.");
        }
    }

    public void estadoIsInvalid() {
        if (estado == null || estado.trim().isEmpty() || estado.length() != 2) {
            throw new IllegalArgumentException("O estado deve ser uma sigla válida de 2 caracteres.");
        }
    }

    public void cepIsInvalid() {
        String cepRegex = "^\\d{8}$";
        if (cep == null || !cep.matches(cepRegex)) {
            throw new IllegalArgumentException("O CEP deve conter exatamente 8 dígitos numérico");
        }
    }

    public Integer getIdEnderecoCliente() {
        return idEnderecoCliente;
    }
    
    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getCep() {
        return cep;
    }

    public void setIdEnderecoCliente(Integer idEnderecoCliente) {
        this.idEnderecoCliente = idEnderecoCliente;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    
}
