package com.cpifppiramide.aulas.application;

import com.cpifppiramide.aulas.domain.Sesion;
import com.cpifppiramide.aulas.domain.SesionesRepository;

import java.util.HashMap;
import java.util.List;

public class SesionesUseCases {

    SesionesRepository sesionesRepository;

    public SesionesUseCases(SesionesRepository sesionesRepository){
        this.sesionesRepository = sesionesRepository;
    }

    public HashMap<Integer,Sesion[]> getAll(String aula){
        HashMap<Integer, Sesion[]> sesionesHorario = new HashMap<>();
        List<Sesion> sesiones = this.sesionesRepository.getFromAula(aula);
        int franjasHorario = 13, dias = 5;
        for (int i = 1; i <= franjasHorario; i++) {
            sesionesHorario.put(i,new Sesion[dias]);
            for (int j = 0; j < dias; j++) {
                sesionesHorario.get(i)[j] = new Sesion();
            }
        }
        for(Sesion sesion: sesiones){
                int index = -1;
                if(sesion.getDia().equals("Lunes")) index = 0;
                else if(sesion.getDia().equals("Martes")) index = 1;
                else if(sesion.getDia().equals("Miercoles")) index = 2;
                else if(sesion.getDia().equals("Jueves")) index = 3;
                else if(sesion.getDia().equals("Viernes")) index = 4;
                sesionesHorario.get(sesion.getSesion())[index] = sesion;
            sesionesHorario.get(sesion.getSesion())[0].setHoraInicio(sesion.getHoraInicio());
            sesionesHorario.get(sesion.getSesion())[0].setHoraFin(sesion.getHoraFin());
        }
        return sesionesHorario;
    }

}
