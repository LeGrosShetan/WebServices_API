package com.epul.permispiste.controller;

import com.epul.permispiste.domains.MissionEntity;
import com.epul.permispiste.dto.MissionDto;
import com.epul.permispiste.service.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RequestMapping("/mission")
@RestController
@CrossOrigin
public class ControllerMission {

    @Autowired
    private MissionService uneMissionService;

    /**
     * Liste tous les jeux et renvoie à la vue de liste des jeux.
     * @return Un appel à la vue qui liste les jeux.
     */
    @GetMapping(value = "/getMissions")
    public Set<MissionDto> getMissions() {
        Set<MissionEntity> mesMissions = new HashSet<>();
        Set<MissionDto> mesMissionsDto = new HashSet<>();

        mesMissions = uneMissionService.getToutesLesMissions();
        for(MissionEntity mission : mesMissions){
            mesMissionsDto.add(new MissionDto(mission));
        }

        return mesMissionsDto;
    }

//    /**
//     * Récupère une liste de tous les jeux auquel est inscrit l'apprenant de numéro numApprenant.
//     * @param numJeu Le numéro de l'apprenant dont on cherche les jeux.
//     * @return L'action correspondant au numéro d'action.
//     */
//    @GetMapping(value = "/getMissions/{numJeu}")
//    public ModelAndView getMissionsByJeu(HttpServletRequest request, HttpServletResponse response, @PathVariable(value = "numJeu") int numJeu) {
//        Set<MissionEntity> mesMissions = null;
//        JeuEntity monJeu = null;
//        String destinationPage = "";
//        try {
//            mesMissions = monJeu.getMissions();
//            request.setAttribute("mesMissions", mesMissions);
//            destinationPage = "vues/missions/listerMissions";
//        } catch (MonException e) {
//            request.setAttribute("MesErreurs", e.getMessage());
//            destinationPage = "/vues/Erreur";
//        } catch (Exception e) {
//            request.setAttribute("MesErreurs", e.getMessage());
//            destinationPage = "vues/Erreur";
//        }
//        return new ModelAndView(destinationPage);
//    }

    /**
     * Récupère un jeu via son numéro de jeu.
     * @param numMission Le numéro du jeu à chercher.
     * @return Le jeu correspondant au numéro de jeu.
     */
    @GetMapping(value = "/getUneMission/{numMission}")
    public MissionDto getMissionByNum(@PathVariable(value = "numMission") int numMission) {
        MissionEntity uneMission;
        uneMission = uneMissionService.getUneMissionNum(numMission);
        return new MissionDto(uneMission);
    }
}
