package com.example.demo;

public class Paziente {

    private int id;
    private String CF;
    private String Nome;
    private String Cognome;
    private String Sesso;
    private String Birthday;
    private String Residenza;
    private String Telefono;
    private int Altezza;
    private int Peso;


    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id; }

    public String getCF() {
        return CF;
    }

    public void setCF(String CF) {
        this.CF = CF;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCognome() {
        return Cognome;
    }

    public void setCognome(String cognome) {
        Cognome = cognome;
    }

    public String getSesso() {
        return Sesso;
    }

    public void setSesso(String sesso) {
        Sesso = sesso;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

    public String getResidenza() {
        return Residenza;
    }

    public void setResidenza(String residenza) {
        Residenza = residenza;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public int getAltezza() {
        return Altezza;
    }

    public void setAltezza(int altezza) {
        Altezza = altezza;
    }

    public int getPeso() {
        return Peso;
    }

    public void setPeso(int peso) { Peso = peso; }

}