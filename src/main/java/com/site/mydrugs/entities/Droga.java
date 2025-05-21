package com.site.mydrugs.entities;

import com.site.mydrugs.models.DrogaModels;

public class Droga {

    private Integer idDroga;
    private String nome;
    private String descricao;
    private Double valor;
    private Integer estoque;
    private String imagemUrl;
    
    public Droga() {
    }

    public Droga(String nome, String descricao, Double valor, Integer estoque, String imagemUrl) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.estoque = estoque;
        this.imagemUrl = imagemUrl;
    }

    public static Droga toDroga(DrogaModels drogaModels){
        Droga droga = new Droga();

        droga.setIdDroga(drogaModels.getIdDroga());
        droga.setNome(drogaModels.getNome());
        droga.setDescricao(drogaModels.getDescricao());
        droga.setValor(drogaModels.getValor());
        droga.setEstoque(drogaModels.getEstoque());
        droga.setImagemUrl(drogaModels.getImagemUrl());

        return droga;
    }

    public void validar(){
        validaNome();
        validaDescricao();
        validaEstoque();
        validaValor();
    }

    public void validaNome(){
        if(nome.isEmpty()){
            throw new IllegalArgumentException("Nome não pode estar vazio.");
        }if(nome.length() < 2){
            throw new IllegalArgumentException("Nome muito pequeno.");
        }
    }

    public void validaDescricao(){
        if(descricao.isEmpty()){
            throw new IllegalArgumentException("Descrição não pode estar vazio.");
        }if(descricao.length() < 5){
            throw new IllegalArgumentException("Descrição muito pequena.");
        }
    }

    public void validaEstoque(){
        if(estoque == null || estoque < 0){
            throw new IllegalArgumentException("Estoque não pode ser nulo ou menor que 0.");
        } 
    }

    public void validaValor(){
        if(valor == null || valor < 0){
            throw new IllegalArgumentException("Valor não pode ser nulo ou menor que 0.");
        } 
    }

    public Integer getIdDroga() {
        return idDroga;
    }

    public void setIdDroga(Integer idDroga) {
        this.idDroga = idDroga;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    
    
}
