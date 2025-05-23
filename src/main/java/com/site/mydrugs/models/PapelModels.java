package com.site.mydrugs.models;

import jakarta.persistence.*;

@Entity
@Table(name = "papel")
public class PapelModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPapel;

    @Column(name = "papel")
    private String papel;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente", insertable = false, updatable = false)
    private ClienteModels cliente;

    @Column(name = "id_cliente")
    private int idCliente;

    public PapelModels() {
    }

    public PapelModels(String papel) {
        this.papel = papel;
    }

    public PapelModels(PapelModels papelModels) {
    }

    public int getIdPapel() {
        return idPapel;
    }

    public void setId(int idPapel) {
        this.idPapel = idPapel;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    @Override
    public String toString() {
        return "PapelModels{" +
                "idPapel=" + idPapel +
                '}';
    }

//    public ClienteModels getCliente() {
//        return cliente;
//    }

    public void setCliente(ClienteModels cliente) {
        this.cliente = cliente;
    }

    public void setIdPapel(int idPapel) {
        this.idPapel = idPapel;
    }

//    public int getIdCliente() {
//        return idCliente;
//    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}
