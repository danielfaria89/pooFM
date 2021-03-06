package FootballManager.Model.Jogadores;

import FootballManager.Model.Exceptions.JogadorInvalidoException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Jogador implements Serializable {
    private String nome;
    private int velocidade;
    private int resistencia;
    private int destreza;
    private int impulsao;
    private int cabeca;
    private int remate;
    private int passe;
    private int numero;
    private List<String> equipas;

    //Construtores e afins

    public Jogador(){
        this.nome="";
        this.velocidade=0;
        this.resistencia=0;
        this.destreza=0;
        this.impulsao=0;
        this.cabeca=0;
        this.remate=0;
        this.passe=0;
        this.numero=0;
        this.equipas= new ArrayList<>();
    }

    public Jogador(String nome,int numero,int velocidade,int resistencia,int destreza,int impulsao,int cabeca,int remate,int passe,ArrayList<String> equipas) throws JogadorInvalidoException {
            this.setNome(nome);
            this.setVelocidade(velocidade);
            this.setResistencia(resistencia);
            this.setDestreza(destreza);
            this.setImpulsao(impulsao);
            this.setCabeca(cabeca);
            this.setRemate(remate);
            this.setPasse(passe);
            this.setEquipas(equipas);
            this.setNumero(numero);
    }

    public Jogador(Jogador j){
        this.setNome(j.getNome());
        this.velocidade=(j.getVelocidade());
        this.resistencia=(j.getResistencia());
        this.destreza=(j.getDestreza());
        this.impulsao=(j.getImpulsao());
        this.cabeca=(j.getCabeca());
        this.remate=(j.getRemate());
        this.passe=(j.getPasse());
        this.equipas=(j.getEquipas());
        this.numero=(j.getNumero());
    }

    public abstract Jogador clone();

    public boolean equals(Object jogador){
        if(jogador==null)return false;
        if(jogador==this)return true;
        if(jogador.getClass()!=this.getClass())return false;
        Jogador novo = (Jogador) jogador;
        return (novo.getCabeca()==this.getCabeca()) &&
                (novo.getDestreza()==this.getDestreza()) &&
                (novo.getResistencia())==this.getResistencia() &&
                (novo.getImpulsao()==this.getImpulsao()) &&
                (novo.getPasse()==this.getPasse()) &&
                (novo.getRemate()==this.getRemate()) &&
                (novo.getVelocidade()==this.getVelocidade()) &&
                (novo.getNome().equals(this.getNome()));
    }

    public String prettyString(){
        StringBuilder sb= new StringBuilder();
        if(this instanceof Medios)sb.append("MED:");
        else if(this instanceof Defesas)sb.append("DEF:");
        else if(this instanceof Avancados)sb.append("AVA:");
        else if(this instanceof Laterais)sb.append("LAT:");
        else if(this instanceof GuardaRedes)sb.append("G-R:");
        sb.append(this.getNome()).append(" ".repeat(Math.max(0,40-this.getNome().length()))).append("|");
        sb.append(String.format("%02d",this.getNumero())).append("| OVR:|");
        sb.append(String.format("%02d",this.calculaRatingTotal())).append("|  VEL:|");
        sb.append(String.format("%02d",this.getVelocidade())).append("| RES:|");
        sb.append(String.format("%02d",this.getResistencia())).append("| DEX:|");
        sb.append(String.format("%02d",this.getDestreza())).append("| IMP:|");
        sb.append(String.format("%02d",this.getImpulsao())).append("| CAB:|");
        sb.append(String.format("%02d",this.getCabeca())).append("| REM:|");
        sb.append(String.format("%02d",this.getRemate())).append("| PAS:|");
        sb.append(String.format("%02d",this.getPasse()));
        if(this instanceof Laterais) sb.append("| CRU:|").append(String.format("%02d",((Laterais) this).getCruzamento()));
        else if(this instanceof GuardaRedes) sb.append("| ELA:|").append(String.format("%02d",((GuardaRedes) this).getElasticidade()));
        else if(this instanceof Medios) sb.append("| REC:|").append(String.format("%02d",((Medios) this).getRecuperacao()));
        else if(this instanceof Defesas) sb.append("| COR:|").append(String.format("%02d",((Defesas) this).getCorpo()));
        else if(this instanceof Avancados) sb.append("| DES:|").append(String.format("%02d",((Avancados) this).getDesmarcacao()));
        sb.append("|");
        return sb.toString();
    }

    public String toString(){
        StringBuilder sb= new StringBuilder();
        if(this instanceof Medios)sb.append("Medio:");
        else if(this instanceof Defesas)sb.append("Defesa:");
        else if(this instanceof Avancados)sb.append("Avancado:");
        else if(this instanceof Laterais)sb.append("Lateral:");
        else if(this instanceof GuardaRedes)sb.append("Guarda-Redes:");
        sb.append(this.getNome()).append(",");
        sb.append(this.getNumero()).append(",");
        sb.append(this.getVelocidade()).append(",");
        sb.append(this.getResistencia()).append(",");
        sb.append(this.getDestreza()).append(",");
        sb.append(this.getImpulsao()).append(",");
        sb.append(this.getCabeca()).append(",");
        sb.append(this.getRemate()).append(",");
        sb.append(this.getPasse());
        if(this instanceof Laterais) sb.append(",").append(((Laterais) this).getCruzamento());
        else if(this instanceof GuardaRedes) sb.append(",").append(((GuardaRedes) this).getElasticidade());
        else if(this instanceof Medios) sb.append(",").append(((Medios) this).getRecuperacao());
        else if(this instanceof Defesas) sb.append(",").append(((Defesas) this).getCorpo());
        else if(this instanceof Avancados) sb.append(",").append(((Avancados) this).getDesmarcacao());
        return sb.toString();
    }

    //Gets e Sets

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) throws JogadorInvalidoException {
        if(velocidade>100||velocidade<0)throw new JogadorInvalidoException(nome);
        else this.velocidade = velocidade;
    }

    public int getResistencia() {
        return this.resistencia;
    }

    public void setResistencia(int resistencia) throws JogadorInvalidoException {
        if(resistencia>100||resistencia<0)throw new JogadorInvalidoException(nome);
        else this.resistencia = resistencia;    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) throws JogadorInvalidoException {
        if(destreza>100||destreza<0)throw new JogadorInvalidoException(nome);
        else this.destreza = destreza;    }

    public int getImpulsao() {
        return impulsao;
    }

    public void setImpulsao(int impulsao) throws JogadorInvalidoException {
        if(impulsao>100||impulsao<0)throw new JogadorInvalidoException(nome);
        else this.impulsao = impulsao;
    }

    public int getCabeca() {
        return cabeca;
    }

    public void setCabeca(int cabeca) throws JogadorInvalidoException {
        if(cabeca>100||cabeca<0)throw new JogadorInvalidoException(nome);
        else this.cabeca = cabeca;    }

    public int getRemate() {
        return remate;
    }

    public void setRemate(int remate) throws JogadorInvalidoException {
        if(remate>100||remate<0)throw new JogadorInvalidoException(nome);
        else this.remate = remate;
    }

    public int getPasse() {
        return passe;
    }

    public void setPasse(int passe) throws JogadorInvalidoException {
        if(passe>100||passe<0)throw new JogadorInvalidoException(nome);
        else this.passe = passe;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getEquipas(){
        return new ArrayList<>(this.equipas);
    }

    public void setEquipas(List<String> equipas){
        this.equipas = new ArrayList<>(equipas);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) throws JogadorInvalidoException {
        if(numero>99||numero<0)throw new JogadorInvalidoException("Numero invalido:"+nome);
        else this.numero=numero;
    }

    public void addEquipa(String equipa){
        this.equipas.add(equipa);
    }

    public abstract int calculaRatingTotal();

    public boolean isCentral(){
        if(this instanceof Laterais)return false;
        else if(this instanceof Defesas)return true;
        else if(this instanceof GuardaRedes)return true;
        else if(this instanceof Avancados)return ((Avancados)this).getDesmarcacao()>velocidade-10;
        else if(this instanceof Medios)return ((Medios) this).getRecuperacao()>velocidade-10;
        else return false;
    }

    public boolean isLado(){
        if(this instanceof Laterais)return true;
        else if(this instanceof Defesas)return false;
        else if(this instanceof GuardaRedes)return true;
        else if(this instanceof Avancados)return velocidade>remate-10;
        else if(this instanceof Medios)return velocidade>((Medios) this).getRecuperacao()-10;
        else return false;
    }
}