package com.example.AppVeterinaria.Entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "FichaMascota")
public class FichaMascota {

    @Id
    @Column(name = "NumeroFicha")
    private int numeroFicha;

    @Column(name = "CodigoEspecie")
    private int codigoEspecie;

    @Column(name = "CodigoRaza")
    private int codigoRaza;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "FechaNacimiento")
    private String fechaNacimiento; // Se puede cambiar a LocalDate si es necesario

    @Column(name = "Talla")
    private String talla;

    @Column(name = "Genero")
    private String genero;

    public FichaMascota() {
    }

    public int getNumeroFicha() {
        return numeroFicha;
    }

    public void setNumeroFicha(int numeroFicha) {
        this.numeroFicha = numeroFicha;
    }

    public int getCodigoEspecie() {
        return codigoEspecie;
    }

    public void setCodigoEspecie(int codigoEspecie) {
        this.codigoEspecie = codigoEspecie;
    }

    public int getCodigoRaza() {
        return codigoRaza;
    }

    public void setCodigoRaza(int codigoRaza) {
        this.codigoRaza = codigoRaza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
