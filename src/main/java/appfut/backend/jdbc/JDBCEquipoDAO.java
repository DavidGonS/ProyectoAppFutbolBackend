package appfut.backend.jdbc;

import appfut.backend.dao.EquipoDAO;
import appfut.model.Equipo;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class JDBCEquipoDAO implements EquipoDAO {

    private static final String INSERT_EQUIPO = "INSERT INTO Equipos(nombre, estadio, puntuacion, idLiga) " +
            "VALUES(:nombre, :estadio, :puntuacion, :idLiga)";

    private static final String DELETE_EQUIPO = "DELETE FROM Equipos WHERE idEquipo = :idEquipo";
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public JDBCEquipoDAO(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public boolean insert(Equipo equipo) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("nombre", equipo.getNombre());
            params.put("estadio", equipo.getEstadio());
            params.put("puntuacion", equipo.getPuntuacion());
            params.put("idLiga", equipo.getIdLiga());
            return namedParameterJdbcTemplate.update(INSERT_EQUIPO, params) == 1;
        } catch (DuplicateKeyException e) {
            return false;
        }
    }

    @Override
    public int remove(int idEquipo) {
        Map<String, Object> params = new HashMap<>();
        params.put("idEquipo", idEquipo);
        return namedParameterJdbcTemplate.update(DELETE_EQUIPO, params);
    }
}

