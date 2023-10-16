package com.cpifppiramide.aulas.domain;

public class Sesion {

    private String dia, horaInicio, horaFin, modulo, aula;
    private Integer sesion;

    public Sesion(){}
    public Sesion(String dia, Integer sesion, String horaInicio, String horaFin, String modulo, String aula) {
        this.dia = dia;
        this.sesion = sesion;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.modulo = modulo;
        this.aula = aula;
    }

    public String getDia() {
        return dia;
    }

    public Integer getSesion() {
        return sesion;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public String getModulo() {
        return modulo;
    }

    public String getAula() {
        return aula;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }
}
