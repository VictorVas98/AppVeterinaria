package com.example.AppVeterinaria.Entidades;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Persona")
public class Persona {

    @Id
    @Column(name = "CodigoPersona")
    private int codigoPersona;

    @Column(name = "PrimerNombre")
    private String primerNombre;

    @Column(name = "SegundoNombre")
    private String segundoNombre;

    @Column(name = "TercerNombre")
    private String tercerNombre;

    @Column(name = "PrimerApellido")
    private String primerApellido;

    @Column(name = "SegundoApellido")
    private String segundoApellido;

    @Column(name = "TercerApellido")
    private String tercerApellido;

    @Column(name = "TipoPersona")
    private String tipoPersona;

    @Column(name = "RazonSocial")
    private String razonSocial;

    @Column(name = "FechaNacimiento")
    private Date fechaNacimiento;

    @Column(name = "Genero")
    private String genero;

    public Persona() {
    }

    public int getCodigoPersona() {
        return codigoPersona;
    }

    public void setCodigoPersona(int codigoPersona) {
    this.codigoPersona = codigoPersona;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getTercerNombre() {
        return tercerNombre;
    }

    public void setTercerNombre(String tercerNombre) {
        this.tercerNombre = tercerNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getTercerApellido() {
        return tercerApellido;
    }

    public void setTercerApellido(String tercerApellido) {
        this.tercerApellido = tercerApellido;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}