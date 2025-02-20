package com.prueba.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "HU_CAT_MONEDA")
public class Moneda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NUM_CIA")
    private Integer numCia;

    @Column(name = "CLAVE_MONEDA")
    private String claveMoneda;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "SIMBOLO")
    private String simbolo;

    @Column(name = "ESTATUS")
    private String estatus;

    public Integer getNumCia() {
        return numCia;
    }

    public void setNumCia(Integer numCia) {
        this.numCia = numCia;
    }

    public String getClaveMoneda() {
        return claveMoneda;
    }

    public void setClaveMoneda(String claveMoneda) {
        this.claveMoneda = claveMoneda;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
