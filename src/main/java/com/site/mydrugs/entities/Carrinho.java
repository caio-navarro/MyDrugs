package com.site.mydrugs.entities;

import java.util.List;
import com.site.mydrugs.models.CarrinhoModels;
import com.site.mydrugs.models.ItemCarrinhoModels;

public class Carrinho {

    private Integer idCarrinho;
    private double valorTotal;
    private List<ItemCarrinhoModels> itensCarrinho;

    public Carrinho() {
    }

    public Carrinho(double valorTotal, List<ItemCarrinhoModels> itensCarrinho) {
        this.valorTotal = valorTotal;
        this.itensCarrinho = itensCarrinho;
    }

    public Carrinho toCarrinho(CarrinhoModels carrinhoModels) {
        Carrinho carrinho = new Carrinho();

        carrinho.setIdCarrinho(carrinhoModels.getIdCarrinho());
        carrinho.setValorTotal(carrinhoModels.getValorTotal());
        carrinho.setItensCarrinho(carrinhoModels.getItensCarrinho());
        return carrinho;
    }

    public Integer getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(Integer idCarrinho) {
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
