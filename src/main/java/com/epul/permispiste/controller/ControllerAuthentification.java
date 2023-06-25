package com.epul.permispiste.controller;

import com.epul.permispiste.domains.AppUser;
import com.epul.permispiste.domains.UtilisateurEntity;
import com.epul.permispiste.mesExceptions.MonException;
import com.epul.permispiste.service.AuthentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/authentification")
@RestController
@CrossOrigin
public class ControllerAuthentification {

    @Autowired
    private AuthentificationService unAuthenService;

    @GetMapping(value = "/login")
    public UtilisateurEntity controleLogin(@RequestBody AppUser appUser) throws Exception {
        UtilisateurEntity unUtilisateur = unAuthenService.authentification(appUser);
        if (unUtilisateur == null) {
            unUtilisateur.setNumUtil(-1);
        }
        return unUtilisateur;
    }

    @PostMapping(value = "/saveLogin")
    public UtilisateurEntity saveUser(@RequestBody AppUser appUser) throws Exception {
        UtilisateurEntity unUtilisateur = unAuthenService.authentification(appUser);

        if(unUtilisateur == null){
            unUtilisateur = new UtilisateurEntity();
        }

        unUtilisateur.setNomUtil(appUser.getNomUtil());
        unUtilisateur.setMotPasse(appUser.getMotPasse());
        unAuthenService.saveUtilisateur(unUtilisateur);

        return unUtilisateur;
    }

}