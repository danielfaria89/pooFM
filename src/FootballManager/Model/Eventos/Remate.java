package FootballManager.Model.Eventos;

import FootballManager.Model.Jogadores.GuardaRedes;
import FootballManager.Model.Jogadores.Jogador;

import java.util.Random;

public class Remate extends Ataque{
    private Jogador marcador;

    public Remate(){
        super();
    }

    public Remate(Jogador marcador){
        super();
        this.marcador=marcador.clone();
    }

    public void setMarcador(Jogador marcador){
        this.marcador=marcador.clone();
    }

    public String marcadorNome(){
        return marcador.getNome();
    }

    public boolean golo(GuardaRedes gk){
        Random r= new Random();
        double chanceGolo=0.05+((marcador.getRemate()-gk.calculaRatingTotal())/500.0);
        return r.nextDouble() < chanceGolo*r.nextGaussian();
    }
}
