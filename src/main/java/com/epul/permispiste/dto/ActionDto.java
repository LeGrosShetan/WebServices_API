package com.epul.permispiste.dto;

import com.epul.permispiste.domains.ActionEntity;
import com.epul.permispiste.domains.JeuEntity;
import com.epul.permispiste.domains.ObjectifEntity;
import com.epul.permispiste.domains.RegleEntity;

import java.util.HashMap;
import java.util.Objects;

public class ActionDto {
    private int numAction;
    private String libAction;
    private HashMap<Integer, String> objectifs;
    private HashMap<Integer, String> regles;
    private HashMap<Integer, String> jeux;

    public int getNumAction() {
        return numAction;
    }

    public void setNumAction(int numAction) {
        this.numAction = numAction;
    }

    public String getLibAction() {
        return libAction;
    }

    public void setLibAction(String libAction) {
        this.libAction = libAction;
    }

    public HashMap<Integer, String> getObjectifs() {
        return objectifs;
    }

    public void setObjectifs(HashMap<Integer, String> objectifs) {
        this.objectifs = objectifs;
    }

    public HashMap<Integer, String> getRegles() {
        return regles;
    }

    public void setRegles(HashMap<Integer, String> regles) {
        this.regles = regles;
    }

    public HashMap<Integer, String> getJeux() {
        return jeux;
    }

    public void setJeux(HashMap<Integer, String> jeux) {
        this.jeux = jeux;
    }

    public ActionDto(int numAction, String libAction, HashMap<Integer, String> objectifs, HashMap<Integer, String> regles, HashMap<Integer, String> jeux) {
        this.numAction = numAction;
        this.libAction = libAction;
        this.objectifs = objectifs;
        this.regles = regles;
        this.jeux = jeux;
    }

    public ActionDto(ActionEntity actionEntity){
        this.numAction = actionEntity.getNumaction();
        this.libAction = actionEntity.getLibaction();
        this.objectifs = new HashMap<>();
        this.regles = new HashMap<>();
        this.jeux = new HashMap<>();

        for(ObjectifEntity objectif : actionEntity.getObjectifs()){
            this.objectifs.put(objectif.getNumobjectif(), objectif.getLibobjectif());
        }

        for(RegleEntity regle : actionEntity.getRegles()){
            this.regles.put(regle.getNumregle(), regle.getLibregle());
        }

        for(JeuEntity jeu : actionEntity.getJeux()){
            this.jeux.put(jeu.getNumjeu(), jeu.getLibellejeu());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ActionDto)) return false;
        ActionDto actionDto = (ActionDto) o;
        return numAction == actionDto.numAction && libAction.equals(actionDto.libAction) && objectifs.equals(actionDto.objectifs) && regles.equals(actionDto.regles) && jeux.equals(actionDto.jeux);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numAction, libAction, objectifs, regles, jeux);
    }
}
