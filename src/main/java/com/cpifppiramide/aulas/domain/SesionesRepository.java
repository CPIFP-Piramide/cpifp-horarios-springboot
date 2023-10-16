package com.cpifppiramide.aulas.domain;

import java.util.List;

public interface SesionesRepository {

    public List<Sesion> getFromAula(String aula);

}
