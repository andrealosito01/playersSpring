package com.tutorial.players.services;

import com.tutorial.players.models.Player;
import com.tutorial.players.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceDB implements PlayerService{
    @Autowired
    private PlayerRepository playerRepository;
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayer(Long id) {
        Optional<Player> player = playerRepository.findById(id);
        if(player.isPresent())
            return player.get();
        else
            return null;
    }

    public void addPlayer(Player player) {
        playerRepository.saveAndFlush(player);
    }

    public void updatePlayer(Long id, Player player) {
        playerRepository.saveAndFlush(player);
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}
