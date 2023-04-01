package com.tutorial.players.services;

import com.tutorial.players.models.Player;

import java.util.List;

public interface PlayerService {
    public List<Player> getAllPlayers();

    public Player getPlayer(Long id);

    public void addPlayer(Player player);

    public void updatePlayer(Long id, Player player);

    public void deletePlayer(Long id);
}
