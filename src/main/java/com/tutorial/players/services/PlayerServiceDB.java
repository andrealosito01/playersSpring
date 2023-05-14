package com.tutorial.players.services;

import com.tutorial.players.models.Player;
import com.tutorial.players.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceDB implements PlayerService{
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    @Cacheable("players")
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    @Cacheable("players")
    public Player getPlayer(Long id) {
        Optional<Player> player = playerRepository.findById(id);
        if(player.isPresent())
            return player.get();
        else
            return null;
    }

    @Override
    @Cacheable("players")
    public void addPlayer(Player player) {
        playerRepository.save(player);
    }

    @Override
    @CachePut(value="players", key="#player.id")
    public void updatePlayer(Long id, Player player) {
        playerRepository.save(player);
    }

    @Override
    @CacheEvict(value="players", key="#id")
    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}
