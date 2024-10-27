package br.edu.fateczl.projetoandroid08_1.model;

public class Ingresso {

    private String id;
    private float valor;

    public Ingresso(float valor) {
        this.valor = valor;
    }

    public float valorFinal(float valorTaxa){
        return valor +valorTaxa;
    }







}
