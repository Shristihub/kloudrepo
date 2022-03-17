package com.shristi.autowiring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Football implements Sports{
    List<String> players;

    public List<String> getPlayers() {
        return players;
    }

    @Value("#{'${tennis.players}'.split(',')}")
    public void setPlayers(List<String> players) {
        this.players = players;
    }

    @Override
    public List<String> showPlayers() {
        return getPlayers();
    }
}
