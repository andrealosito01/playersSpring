package com.tutorial.players.controllers;

import com.tutorial.players.models.Player;
import com.tutorial.players.services.PlayerServiceDB;
import com.tutorial.players.services.PlayerServiceMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayersController {
    @Autowired
    private PlayerServiceMock playerService;
    @GetMapping("/players")
    public List<Player> getAllPlayers(){
        return playerService.getAllPlayers();
    }

    @GetMapping("/players/{id}")
    public Player getPlayer(@PathVariable Long id){
        return playerService.getPlayer(id);
    }

    @PostMapping("/players")
    public void addPlayer(@RequestBody Player p){
        playerService.addPlayer(p);
    }

    @RequestMapping(value="/players/{id}", method=RequestMethod.PUT)
    public void updatePlayer(@PathVariable Long id, @RequestBody Player p){
        playerService.updatePlayer(id,p);
    }

    @RequestMapping(value="/players/{id}", method=RequestMethod.DELETE)
    public void deletePlayer(@PathVariable Long id){
        playerService.deletePlayer(id);
    }
}
