package com.tutorial.players;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PlayersController {
    @Autowired
    private PlayerService playerService;
    @GetMapping("/players")
    public List<Player> getAllPlayers(){
        return playerService.getAllPlayers();
    }

    @GetMapping("/players/{id}")
    public Player getPlayer(@PathVariable int id){
        return playerService.getPlayer(id);
    }

    @PostMapping("/players")
    public void addPlayer(@RequestBody Player p){
        playerService.addPlayer(p);
    }

    @RequestMapping(value="/players/{id}", method=RequestMethod.PUT)
    public void updatePlayer(@PathVariable int id, @RequestBody Player p){
        playerService.updatePlayer(id,p);
    }

    @RequestMapping(value="/players/{id}", method=RequestMethod.DELETE)
    public void deletePlayer(@PathVariable int id){
        playerService.deletePlayer(id);
    }
}
