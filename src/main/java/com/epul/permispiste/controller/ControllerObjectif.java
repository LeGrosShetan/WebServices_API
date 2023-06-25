package com.epul.permispiste.controller;

import com.epul.permispiste.domains.MissionEntity;
import com.epul.permispiste.domains.ObjectifEntity;
import com.epul.permispiste.dto.ObjectifDto;
import com.epul.permispiste.service.MissionService;
import com.epul.permispiste.service.ObjectifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RequestMapping("/objectif")
@RestController
@CrossOrigin
public class ControllerObjectif {

    @Autowired
    private ObjectifService unObjectifService;

    @Autowired
    private MissionService uneMissionService;

    /**
     * Liste tous les jeux et renvoie à la vue de liste des jeux.
     * @return Un appel à la vue qui liste les jeux.
     */
    @GetMapping(value = "/getObjectifs")
    public Set<ObjectifDto> getObjectifs() {
        Set<ObjectifEntity> mesObjectifs = new HashSet<>();
        Set<ObjectifDto> mesObjectifsDto = new HashSet<>();

        mesObjectifs = unObjectifService.getTousLesObjectifs();
        for(ObjectifEntity objectif : mesObjectifs){
            mesObjectifsDto.add(new ObjectifDto(objectif));
        }

        return mesObjectifsDto;
    }

    /**
     * Récupère une liste de tous les jeux auquel est inscrit l'apprenant de numéro numApprenant.
     * @param numMission Le numéro de l'apprenant dont on cherche les jeux.
     * @return L'action correspondant au numéro d'action.
     */
    @GetMapping(value = "/getObjectifs/{numMission}")
    public Set<ObjectifDto> getObjectifsByMission(@PathVariable(value = "numMission") int numMission) {
        Set<ObjectifEntity> mesObjectifs = new HashSet<>();
        Set<ObjectifDto> mesObjectifsDto = new HashSet<>();
        MissionEntity maMission;

        maMission = uneMissionService.getUneMissionNum(numMission);
        mesObjectifs = maMission.getObjectifs();
        for(ObjectifEntity objectif : mesObjectifs){
            mesObjectifsDto.add(new ObjectifDto(objectif));
        }

        return mesObjectifsDto;
    }

    /**
     * Récupère un jeu via son numéro de jeu.
     * @param numObjectif Le numéro du jeu à chercher.
     * @return Le jeu correspondant au numéro de jeu.
     */
    @GetMapping(value = "/getUnObjectif/{numObjectif}")
    public ObjectifDto getObjectifByNum(@PathVariable(value = "numObjectif") int numObjectif) {
        ObjectifEntity unObjectif;
        unObjectif = unObjectifService.getUnObjectifNum(numObjectif);
        return new ObjectifDto(unObjectif);
    }
}
