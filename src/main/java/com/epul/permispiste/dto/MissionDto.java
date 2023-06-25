package com.epul.permispiste.dto;

import com.epul.permispiste.domains.MissionEntity;
import com.epul.permispiste.domains.ObjectifEntity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;

public class MissionDto {
    private int numMission;
    private String libMission;
    private HashMap<Integer, String> objectifs;
    private HashMap<Integer, String> jeu;

    public int getNumMission() {
        return numMission;
    }

    public void setNumMission(int numMission) {
        this.numMission = numMission;
    }

    public String getLibMission() {
        return libMission;
    }

    public void setLibMission(String libMission) {
        this.libMission = libMission;
    }

    public HashMap<Integer, String> getObjectifs() {
        return objectifs;
    }

    public void setObjectifs(HashMap<Integer, String> objectifs) {
        this.objectifs = objectifs;
    }

    public HashMap<Integer, String> getJeu() {
        return jeu;
    }

    public void setJeu(HashMap<Integer, String> jeu) {
        this.jeu = jeu;
    }

    public MissionDto(int numMission, String libMission, HashMap<Integer, String> objectifs, HashMap<Integer, String> jeu) {
        this.numMission = numMission;
        this.libMission = libMission;
        this.objectifs = objectifs;
        this.jeu = jeu;
    }

    public MissionDto(MissionEntity missionEntity){
        this.numMission = missionEntity.getNummission();
        this.libMission = missionEntity.getLibellemission();
        this.objectifs = new HashMap<>();
        this.jeu = new HashMap<>(1);

        for (ObjectifEntity objectif : missionEntity.getObjectifs()){
            this.objectifs.put(objectif.getNumobjectif(), objectif.getLibobjectif());
        }

        this.jeu.put(missionEntity.getJeu().getNumjeu(), missionEntity.getJeu().getLibellejeu());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MissionDto)) return false;
        MissionDto that = (MissionDto) o;
        return numMission == that.numMission && libMission.equals(that.libMission) && objectifs.equals(that.objectifs) && jeu.equals(that.jeu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numMission, libMission, objectifs, jeu);
    }
}
