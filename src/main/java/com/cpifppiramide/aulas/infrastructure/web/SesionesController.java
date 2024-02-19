package com.cpifppiramide.aulas.infrastructure.web;

import com.cpifppiramide.aulas.application.SesionesUseCases;
import com.cpifppiramide.aulas.domain.Sesion;
import com.cpifppiramide.aulas.infrastructure.db.SesionesRepositoryMySQL;
import com.cpifppiramide.aulas.infrastructure.db.SesionesRepositoryPostgres;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class SesionesController {


    SesionesUseCases sesionesUseCases;

    public SesionesController(){
        this.sesionesUseCases = new SesionesUseCases(
                new SesionesRepositoryPostgres()
        );
    }

    @GetMapping("/{aula}")
    public String getAllFromAula(@PathVariable String aula, Model model){
        HashMap<Integer, Sesion[]> sesiones = sesionesUseCases.getAll(aula);
        List<Sesion[]> sesionesTemplate = new ArrayList<>();
        for (int i = 1; i <= sesiones.keySet().size(); i++) {
            sesionesTemplate.add(sesiones.get(i));
        }
        model.addAttribute("aula", aula);
        model.addAttribute("sesiones", sesionesTemplate);

        return "horario";
    }

}
