package com.epul.permispiste.controller;

import com.epul.permispiste.mesExceptions.MonException;
import com.epul.permispiste.domains.ActionEntity;
import com.epul.permispiste.domains.RegleEntity;
import com.epul.permispiste.service.ActionService;
import com.epul.permispiste.service.RegleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.Set;

@RequestMapping("/regle")
@RestController
@CrossOrigin
public class ControllerRegles {
    @Autowired
    private RegleService uneRegleService;

    @Autowired
    private ActionService uneActionService;

    @GetMapping(value = "/getRegles")
    public Set<RegleEntity> getRegles() {
        Set<RegleEntity> mesRegles = new HashSet<>();

        mesRegles = uneRegleService.getToutesLesRegles();

        return mesRegles;
    }

    @GetMapping(value = "/getRegles/{numAction}")
    public Set<RegleEntity> getReglesByAction(HttpServletRequest request, HttpServletResponse response, @PathVariable(value = "numAction") int numAction) {
        Set<RegleEntity> mesRegles = new HashSet<>();
        ActionEntity monAction;
        monAction = uneActionService.getUneActionNum(numAction);
        if(monAction != null) {
            mesRegles = monAction.getRegles();
        }

        return mesRegles;
    }

    @GetMapping(value = "/getUneRegle/{numRegle}")
    public RegleEntity getRegleByNum(@PathVariable(value = "numRegle") int numRegle) {
        RegleEntity uneRegle;

        uneRegle = uneRegleService.getUneRegleNum(numRegle);

        return uneRegle;
    }
}
