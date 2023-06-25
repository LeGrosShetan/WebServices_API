package com.epul.permispiste.dto;

import com.epul.permispiste.domains.ActionEntity;
import com.epul.permispiste.domains.JeuEntity;
import com.epul.permispiste.domains.MissionEntity;

import java.util.HashMap;
import java.util.Objects;

public class JeuDto {
    private int numJeu;
    private String libelleJeu;
    private HashMap<Integer, String> actions;
    private HashMap<Integer, String> missions;

    public int getNumJeu() {
        return numJeu;
    }

    public void setNumJeu(int numJeu) {
        this.numJeu = numJeu;
    }

    public String getLibelleJeu() {
        return libelleJeu;
    }

    public void setLibelleJeu(String libelleJeu) {
        this.libelleJeu = libelleJeu;
    }

    public HashMap<Integer, String> getActions() {
        return actions;
    }

    public void setActions(HashMap<Integer, String> actions) {
        this.actions = actions;
    }

    public HashMap<Integer, String> getMissions() {
        return missions;
    }

    public void setMissions(HashMap<Integer, String> missions) {
        this.missions = missions;
    }

    public JeuDto(int numJeu, String libelleJeu, HashMap<Integer, String> actions, HashMap<Integer, String> missions) {
        this.numJeu = numJeu;
        this.libelleJeu = libelleJeu;
        this.actions = actions;
        this.missions = missions;
    }

    public JeuDto(JeuEntity jeuEntity){
        this.numJeu = jeuEntity.getNumjeu();
        this.libelleJeu = jeuEntity.getLibellejeu();
        this.actions = new HashMap<>();
        this.missions = new HashMap<>();

        for(ActionEntity action : jeuEntity.getActions()){
            this.actions.put(action.getNumaction(), action.getLibaction());
        }

        for(MissionEntity mission : jeuEntity.getMissions()){
            this.missions.put(mission.getNummission(), mission.getLibellemission());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JeuDto)) return false;
        JeuDto jeuDto = (JeuDto) o;
        return numJeu == jeuDto.numJeu && libelleJeu.equals(jeuDto.libelleJeu) && actions.equals(jeuDto.actions) && missions.equals(jeuDto.missions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numJeu, libelleJeu, actions, missions);
    }
}
