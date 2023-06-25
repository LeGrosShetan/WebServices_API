package com.epul.permispiste.service;

import com.epul.permispiste.domains.AppUser;
import com.epul.permispiste.domains.UtilisateurEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public interface IAuthentificationService {
    public UtilisateurEntity authentification(@RequestBody AppUser unUti) throws Exception;
}
