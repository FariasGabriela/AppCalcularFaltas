package com.example.gabriela.dispositivosmoveisacch.entidades;

public class Materia {

    private String nome;
    private String horarios;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }

    public Materia(String nome, String horarios) {
        this.nome = nome;
        this.horarios = horarios;
    }
}
