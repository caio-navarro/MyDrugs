package com.site.mydrugs.entities;

import com.site.mydrugs.models.CarrinhoModels;
import com.site.mydrugs.models.DrogaModels;
import com.site.mydrugs.models.ItemCarrinhoModels;

public class ItemCarrinho {

    private int idItensCarrinho;
    private int quantidade;
    private DrogaModels droga;
    private int idDroga;
    private CarrinhoModels carrinho;
    private int idCarrinho;
    
    public ItemCarrinho() {
    }

    public ItemCarrinho(int quantidade, DrogaModels droga, int idDroga, CarrinhoModels carrinho, int idCarrinho) {
        this.quantidade = quantidade;
        this.droga = droga;
        this.idDroga = idDroga;
        this.carrinho = carrinho;
        this.idCarrinho = idCarrinho;
    }

    public static ItemCarrinho toItem(ItemCarrinhoModels itemCarrinhoModels){
        ItemCarrinho itemCarrinho = new ItemCarrinho();

        itemCarrinho.setIdItensCarrinho(itemCarrinhoModels.getIdItensCarrinho());
        itemCarrinho.setQuantidade(itemCarrinhoModels.getQuantidade());
        itemCarrinho.setDroga(itemCarrinhoModels.getDroga());
        itemCarrinho.setIdDroga(itemCarrinhoModels.getIdDroga());
        itemCarrinho.setCarrinho(itemCarrinhoModels.getCarrinho());
        itemCarrinho.setIdCarrinho(itemCarrinhoModels.getIdCarrinho());

        return itemCarrinho;
    }

    public int getIdItensCarrinho() {
        return idItensCarrinho;
    }

    public void setIdItensCarrinho(int idItensCarrinho) {
        this.idItensCarrinho = idItensCarrinho;
    }
    
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public DrogaModels getDroga() {
        return droga;
    }

    public void setDroga(DrogaModels droga) {
        this.droga = droga;
    }

    public int getIdDroga() {
        return idDroga;
    }

    public void setIdDroga(int idDroga) {
        this.idDroga = idDroga;
    }

    public CarrinhoModels getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(CarrinhoModels carrinho) {
        this.carrinho = carrinho;
    }

    public int getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(int idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

}