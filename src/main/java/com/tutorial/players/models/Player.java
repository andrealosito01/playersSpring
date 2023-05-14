package com.tutorial.players.models;

import jakarta.persistence.*;

@Entity
@Table(name="player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String nome;
    private String cognome;
    private String squadra;

    public Player(){}

    public Player(Long ID, String nome, String cognome, String squadra){
        this.ID = ID;
        this.nome = nome;
        this.cognome = cognome;
        this.squadra = squadra;
    }

    public long getID(){
        return ID;
    }

    public void setID(Long ID){
        this.ID = ID;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCognome(){
        return cognome;
    }

    public void setCognome(String cognome){
        this.cognome = cognome;
    }

    public String getSquadra(){
        return squadra;
    }

    public void setSquadra(String squadra){
        this.squadra = squadra;
    }

}
