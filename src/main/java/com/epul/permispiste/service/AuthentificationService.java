package com.epul.permispiste.service;

import com.epul.permispiste.domains.AppUser;
import com.epul.permispiste.domains.UtilisateurEntity;
import com.epul.permispiste.mesExceptions.MonException;
import com.epul.permispiste.repositories.UtilisateurRepository;
import com.epul.permispiste.utilitaires.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthentificationService implements IAuthentificationService{
    private UtilisateurRepository unUtilisateurRepostory;

    @Autowired
    public AuthentificationService(UtilisateurRepository UtilisateurRepostory) {
        this.unUtilisateurRepostory = UtilisateurRepostory;
    }

    @Override
    public UtilisateurEntity authentification(AppUser unUti) throws Exception {
        UtilisateurEntity unUtilisateur = null;
        String message;
        String login = unUti.getNomUtil();
        String pwd = unUti.getMotPasse();
        unUtilisateur = unUtilisateurRepostory.rechercheNom(unUti.getNomUtil());
        if (unUtilisateur != null) {
            try {
                if(!unUtilisateur.getMotPasse().equals(pwd)){
                    return null;
                }
            } catch (MonException e) {
                throw e;
            } catch (Exception e) {
                throw e;
            }
        }
        return unUtilisateur;
    }

    public void saveUtilisateur(UtilisateurEntity utilisateur){
        try{
            unUtilisateurRepostory.save(utilisateur);
        } catch (Exception e) {
            throw new MonException("Insert", "Sql", e.getMessage());
        }
    }
}