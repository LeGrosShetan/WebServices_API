package com.epul.permispiste.controller;

import com.epul.permispiste.dto.ApprenantDto;
import com.epul.permispiste.mesExceptions.MonException;
import com.epul.permispiste.domains.ApprenantEntity;
import com.epul.permispiste.service.ApprenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RequestMapping("/apprenant")
@RestController
@CrossOrigin
public class ControllerApprenant {

    @Autowired
    private ApprenantService unApprenantService;

    /**
     * Liste tous les apprenants et renvoie à la vue de liste des apprenants.
     * @return Un appel à la vue qui liste les apprenants.
     */
    @GetMapping(value = "/getApprenants")
    public Set<ApprenantDto> getApprenants() {
        Set<ApprenantEntity> mesApprenants = new HashSet<>();
        Set<ApprenantDto> mesApprenantsDto = new HashSet<>();

        mesApprenants = unApprenantService.getTousLesApprenants();

        for(ApprenantEntity apprenant : mesApprenants){
            mesApprenantsDto.add(new ApprenantDto(apprenant));
        }

        return mesApprenantsDto;
    }

    /**
     * Récupère un apprenant via son numéro d'apprenant.
     * @param numApprenant Le numéro de l'apprenant à chercher.
     * @return L'apprenant correspondant au numéro d'apprenant.
     */
    @GetMapping(value = "/getUnApprenant/{numApprenant}")
    public ApprenantDto getApprenantByNum(@PathVariable(value = "numApprenant") int numApprenant) {
        ApprenantEntity unApprenant;
        unApprenant = unApprenantService.getUnApprenantNum(numApprenant);
        return new ApprenantDto(unApprenant);
    }

    /**
     * Insert un apprenant et renvoie à la vue index.
     * @return Appel à la vue index.
     * @throws Exception La potentielle exception levée.
     */
    @PostMapping(value = "/saveApprenant")
    public ApprenantDto insererApprenant(@RequestBody ApprenantEntity apprenant) throws Exception {
        ApprenantEntity unApprenant = new ApprenantEntity();
        try {
            if(apprenant.getNumapprenant() == null){
                throw new MonException("Apprenant", "numApprenant", null);
            }
            unApprenant = unApprenantService.getUnApprenantNum(apprenant.getNumapprenant());
            unApprenant.setNomapprenant(apprenant.getNomapprenant());
            unApprenant.setPrenomapprenant(apprenant.getPrenomapprenant());
        } catch (MonException e) { // S'il n'existe pas, on le crée
            unApprenant = apprenant;
        }
        unApprenantService.ajouterApprenant(unApprenant);

        return new ApprenantDto(unApprenant);
    }

    @DeleteMapping(value = "/deleteApprenant/{numApprenant}")
    public String deleteApprenantByNum(@PathVariable(value = "numApprenant") int numApprenant) {
        try{
            unApprenantService.deleteApprenant(numApprenant);
            return "Apprenant suprimmé !";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /*@RequestMapping(method = RequestMethod.POST, value = "/modifierApprenant/{numApprenant}")
    public Set<ApprenantEntity> modifierApprenant(@PathVariable(value = "numApprenant") int numApprenant) throws Exception {
        Set<ApprenantEntity> mesApprenants = new HashSet<>();

        try {
            unApprenantService.modifierApprenant(numApprenant);
            mesApprenants = unApprenantService.getTousLesApprenants();
        } catch (MonException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }

        return mesApprenants;
    }*/
}
