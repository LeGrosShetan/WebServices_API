package com.epul.permispiste.service;

import com.epul.permispiste.mesExceptions.MonException;
import com.epul.permispiste.domains.ActionEntity;
import com.epul.permispiste.repositories.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ActionService {

    @Autowired
    private ActionRepository uneActionRepository;

    /**
     * Tri toutes les actions par ordre alphabétique.
     * @return Une liste triée de toutes les actions.
     */
    private Sort sortByNom() {
        return new Sort(Sort.Direction.ASC, "libAction");
    }

    /**
     * Liste toutes les actions.
     * @return La liste de toutes les actions.
     */
    public Set<ActionEntity> getToutesLesActions() {

        List<ActionEntity> mesActions = new ArrayList<>();
        try {
            mesActions = uneActionRepository.findAll(sortByNom());
        } catch (Exception e) {
            throw new MonException("Insert", "Sql", e.getMessage());
        }
        return new HashSet<>(mesActions);
    }

    /**
     * Cherche une Action par son numéro d'action.
     * @param numAction Le numéro d'action.
     * @return L'action correspondant au numAction.
     */
    public ActionEntity getUneActionNum(int numAction){
        return uneActionRepository.findById(numAction).orElseThrow(
                () -> new MonException("Client", "numAction", numAction)
        );
    }

}
