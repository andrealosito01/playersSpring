package com.tutorial.players;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PlayerService {

    private List<Player> players = new ArrayList<>(Arrays.asList(new Player(1,"Andrea","Losito","Inter"),
            new Player(2,"Mattia","Rango","Juventus"),
            new Player(3,"Gaetano","Marchianò","Milan")));

    public List<Player> getAllPlayers(){
        return players;
    }

    public Player getPlayer(int ID){
        for (Player p:players) {
            if(p.getID() == ID)
                return p;
        }
        return null;
    }

    public void addPlayer(Player p){
        players.add(p);
    }

    public void updatePlayer(int id, Player p){
        for (Player pl:players) {
            if(pl.getID() == id)
                pl = p;
        }
    }

    public void deletePlayer(int id){
        players.removeIf(p -> p.getID() == id);
    }
}
