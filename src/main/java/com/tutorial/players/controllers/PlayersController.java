package com.tutorial.players.controllers;

import com.tutorial.players.models.Player;
import com.tutorial.players.services.PlayerServiceDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayersController {
    @Autowired
    private PlayerServiceDB playerService;
    @GetMapping("/players")
    //@PreAuthorize("hasAuthority('base')")
    public List<Player> getAllPlayers(){
        return playerService.getAllPlayers();
    }

    @GetMapping("/players/{id}")
    @PreAuthorize("hasAuthority('base')")
    public Player getPlayer(@PathVariable Long id){
        return playerService.getPlayer(id);
    }

    @PostMapping("/players")
    @PreAuthorize("hasAuthority('moderatore')")
    public void addPlayer(@RequestBody Player p){
        playerService.addPlayer(p);
    }

    @RequestMapping(value="/players/{id}", method=RequestMethod.PUT)
    @PreAuthorize("hasAuthority('moderatore')")
    public void updatePlayer(@PathVariable Long id, @RequestBody Player p){
        playerService.updatePlayer(id,p);
    }

    @RequestMapping(value="/players/{id}", method=RequestMethod.DELETE)
    @PreAuthorize("hasAuthority('amministratore')")
    public void deletePlayer(@PathVariable Long id){
        playerService.deletePlayer(id);
    }
}
