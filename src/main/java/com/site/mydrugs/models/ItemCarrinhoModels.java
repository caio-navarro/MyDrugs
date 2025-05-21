package com.site.mydrugs.models;

import jakarta.persistence.*;

@Entity
@Table(name = "itens_carrinhos")
public class ItemCarrinhoModels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_itens_carrinho")
    private int idItensCarriho;

    @Column(name = "quantidade")
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "id_droga", insertable = false, updatable = false)
    private DrogaModels droga;

    @Column(name = "id_droga")
    private int idDroga;

    @ManyToOne
    @JoinColumn(name = "id_carrinho", insertable = false, updatable = false)
    private CarrinhoModels carrinho;

    @Column(name = "id_carrinho")
    private int idCarrinho;

    public ItemCarrinhoModels() {
    }

    public ItemCarrinhoModels(int quantidade, DrogaModels droga, int idDroga, CarrinhoModels carrinho, int idCarrinho) {
        this.quantidade = quantidade;
        this.droga = droga;
        this.idDroga = idDroga;
        this.carrinho = carrinho;
        this.idCarrinho = idCarrinho;
    }

    public int getIdItensCarrinho() {
        return idItensCarriho;
    }

    public void setIdItensCarrinho(int idItensCarriho) {
        this.idItensCarriho = idItensCarriho;
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
