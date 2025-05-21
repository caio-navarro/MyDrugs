package com.site.mydrugs.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "carrinhos")
public class CarrinhoModels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrinho")
    private int idCarrinho;

    @Column(name = "valor_total")
    private double valorTotal;

    @OneToMany(mappedBy = "carrinho") 
    private List<ItemCarrinhoModels> itensCarrinho;

    public CarrinhoModels() {
    }

    public CarrinhoModels(double valorTotal, List<ItemCarrinhoModels> itensCarrinho) {
        this.valorTotal = valorTotal;
        this.itensCarrinho = itensCarrinho;
    }

    public Integer getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(Integer idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public void setIdCarrinho(int idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<ItemCarrinhoModels> getItensCarrinho() {
        return itensCarrinho;
    }

    public void setItensCarrinho(List<ItemCarrinhoModels> itensCarrinho) {
        this.itensCarrinho = itensCarrinho;
    }

}
