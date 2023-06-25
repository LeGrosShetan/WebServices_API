package com.epul.permispiste.controller;

import com.epul.permispiste.dto.ActionDto;
import com.epul.permispiste.mesExceptions.MonException;
import com.epul.permispiste.domains.ActionEntity;
import com.epul.permispiste.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.Set;

@RequestMapping("/action")
@RestController
@CrossOrigin
public class ControllerAction {

    @Autowired
    private ActionService uneActionService;

    /**
     * Liste toutes les actions et renvoie à la vue de liste des actions.
     * @return Un appel à la vue qui liste les actions.
     */
    @GetMapping(value = "/getActions")
    public Set<ActionDto> getActions() {
        Set<ActionEntity> mesActions = new HashSet<>();
        Set<ActionDto> mesActionsDto = new HashSet<>();
        mesActions = uneActionService.getToutesLesActions();

        for(ActionEntity action : mesActions){
            mesActionsDto.add(new ActionDto(action));
        }

        return mesActionsDto;
    }

    /**
     * Récupère une action via son numéro d'action.
     * @param numAction Le numéro de l'action à chercher.
     * @return L'action correspondant au numéro d'action.
     */
    @GetMapping(value = "/getUneAction/{numAction}")
    public ActionDto getActionByNum(@PathVariable(value = "numAction") int numAction) {
        ActionEntity uneAction = null;
        try {
            uneAction = uneActionService.getUneActionNum(numAction);
        } catch (MonException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
        return new ActionDto(uneAction);
    }
}
