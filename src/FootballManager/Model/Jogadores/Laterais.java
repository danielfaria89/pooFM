package FootballManager.Model.Jogadores;

import FootballManager.Model.Exceptions.JogadorInvalidoException;

import java.util.ArrayList;

public class Laterais extends Jogador{
    private int cruzamento;

    public Laterais(){
        super();
    }

    public Laterais(String nome,int numero,int velocidade,int resistencia,int destreza,int impulsao,int cabeca,int remate,int passe,int cruzamento,ArrayList<String>equipas) throws JogadorInvalidoException {
        super(nome,numero,velocidade,resistencia,destreza,impulsao,cabeca,remate,passe,equipas);
        this.cruzamento=cruzamento;
    }

    public Laterais(Laterais lateral){
        super(lateral);
        this.cruzamento=lateral.getCruzamento();
    }

    public Laterais(Jogador jogador){
        super(jogador);
        this.cruzamento=(int)Math.round((jogador.getPasse()+ jogador.getDestreza())/2.0);
    }

    public Laterais clone(){
        return new Laterais(this);
    }

    public int getCruzamento(){
        return this.cruzamento;
    }

    public void setCruzamento(int cruzamento){
        this.cruzamento=cruzamento;
    }

    public int calculaRatingTotal(){
        double valor = this.getVelocidade() *0.25;
        valor += this.getResistencia() *0.20;
        valor += this.getDestreza() *0.15;
        valor += this.getImpulsao() *0.02;
        valor += this.getCabeca() *0.01;
        valor += this.getRemate() *0.02;
        valor += this.getPasse() *0.10;
        valor += this.getCruzamento() *0.25;
        return (int)Math.round(valor);
    }
}