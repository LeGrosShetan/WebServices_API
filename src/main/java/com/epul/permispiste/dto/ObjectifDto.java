package com.epul.permispiste.dto;

import com.epul.permispiste.domains.ActionEntity;
import com.epul.permispiste.domains.MissionEntity;
import com.epul.permispiste.domains.ObjectifEntity;

import java.util.HashMap;
import java.util.Objects;

public class ObjectifDto {
    private int numObjectif;
    private String libObjectif;
    private HashMap<Integer, String> actions;
    private HashMap<Integer, String> missions;

    public int getNumObjectif() {
        return numObjectif;
    }

    public void setNumObjectif(int numObjectif) {
        this.numObjectif = numObjectif;
    }

    public String getLibObjectif() {
        return libObjectif;
    }

    public void setLibObjectif(String libObjectif) {
        this.libObjectif = libObjectif;
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

    public ObjectifDto(int numObjectif, String libObjectif, HashMap<Integer, String> actions, HashMap<Integer, String> missions) {
        this.numObjectif = numObjectif;
        this.libObjectif = libObjectif;
        this.actions = actions;
        this.missions = missions;
    }

    public ObjectifDto(ObjectifEntity objectifEntity){
        this.numObjectif = objectifEntity.getNumobjectif();
        this.libObjectif = objectifEntity.getLibobjectif();
        this.actions = new HashMap<>();
        this.missions = new HashMap<>();

        for(ActionEntity action : objectifEntity.getActions()){
            this.actions.put(action.getNumaction(), action.getLibaction());
        }

        for(MissionEntity mission : objectifEntity.getMissions()){
            this.missions.put(mission.getNummission(), mission.getLibellemission());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ObjectifDto)) return false;
        ObjectifDto that = (ObjectifDto) o;
        return numObjectif == that.numObjectif && libObjectif.equals(that.libObjectif) && actions.equals(that.actions) && missions.equals(that.missions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numObjectif, libObjectif, actions, missions);
    }
}
