package com.prueba.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "HU_EMPLS")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "NUM_EMP")
    private Integer numEmp;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "NUM_CIA", referencedColumnName = "NUM_CIA")
    private Moneda catMoneda;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "APELLIDO_PATERNO")
    private String apellidoPaterno;

    @Column(name = "APELLIDO_MATERNO")
    private String apellidoMaterno;

    @Column(name = "PUESTO")
    private String puesto;

    public Integer getNumEmp() {
        return numEmp;
    }

    public void setNumEmp(Integer numEmp) {
        this.numEmp = numEmp;
    }

    public Moneda getCatMoneda() {
        return catMoneda;
    }

    public void setCatMoneda(Moneda catMoneda) {
        this.catMoneda = catMoneda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
}
