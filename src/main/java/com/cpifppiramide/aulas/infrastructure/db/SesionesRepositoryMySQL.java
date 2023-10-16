package com.cpifppiramide.aulas.infrastructure.db;

import com.cpifppiramide.aulas.DBConnection;
import com.cpifppiramide.aulas.domain.Sesion;
import com.cpifppiramide.aulas.domain.SesionesRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SesionesRepositoryMySQL implements SesionesRepository {

    @Override
    public List<Sesion> getFromAula(String aula) {
        List<Sesion> sesiones = new ArrayList<>();
        try {
            String query = "select * from sesiones where aula like ? order by sesion, dia";
            PreparedStatement statement = DBConnection.getInstance().prepareStatement(query);
            statement.setString(1,"%"+aula+"%");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Sesion sesion = new Sesion(
                        rs.getString("dia"),
                        rs.getInt("sesion"),
                        rs.getString("horaInicio"),
                        rs.getString("horaFin"),
                        rs.getString("modulo"),
                        rs.getString("aula")
                );
                sesiones.add(sesion);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return sesiones;
    }
}
