package com.tutorial.players.services;

import com.tutorial.players.models.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PlayerServiceMock implements PlayerService{

    private List<Player> players = new ArrayList<>(Arrays.asList(new Player(1L,"Andrea","Losito","Inter"),
            new Player(2L,"Mattia","Rango","Juventus"),
            new Player(3L,"Gaetano","Marchianò","Milan")));

    public List<Player> getAllPlayers(){
        return players;
    }

    public Player getPlayer(Long ID){
        for (Player p:players) {
            if(p.getID() == ID)
                return p;
        }
        return null;
    }

    public void addPlayer(Player p){
        players.add(p);
    }

    public void updatePlayer(Long id, Player p){
        for(int i=0; i< players.size(); i++){
            Player player = players.get(i);
            if(player.getID() == p.getID()) {
                players.set(i, p);
                return;
            }
        }
    }

    public void deletePlayer(Long id){
        players.removeIf(p -> p.getID() == id);
    }
}
