package br.edu.fateczl.projetoandroid08_1.model;

public class IngressoVip extends Ingresso {
    /*
     *@author:<Rodrigo Fortunato Martins Neves>
     */
    private String funcao;

    public IngressoVip(float valor) {
        super(valor);

    }

    @Override
    public float valorFinal(float valorTaxa) {
        return (super.valorFinal(valorTaxa) * 1.18f);
    }
}
