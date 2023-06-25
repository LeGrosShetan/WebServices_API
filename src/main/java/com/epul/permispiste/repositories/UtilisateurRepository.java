package com.epul.permispiste.repositories;

import com.epul.permispiste.domains.UtilisateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<UtilisateurEntity, Integer> {
    public UtilisateurEntity rechercheNom(String login);
}
