package appfut.backend.jdbc;

import appfut.backend.dao.JugadorDAO;
import appfut.model.Jugador;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class JDBJugadorDAO implements JugadorDAO {

    private static final String INSERT_JUGADOR_IN_TEAM = "INSERT INTO Jugadores(nombre, apellido, fechaNacimiento, dorsal, nacionalidad, posicion, valorMercado, idEquipo) " +
                                                    "VALUES( :nombre, :apellido, :fechaNacimiento, :dorsal, :nacionalidad, :posicion, :valorMercado, :idEquipo)";

    private static final String UPDATE_JUGADOR="UPDATE Jugadores SET nombre = :nombre, apellido = :apellido, " +
                                                "fechaNacimiento = :fechaNacimiento, dorsal = :dorsal, " +
                                                "nacionalidad = :nacionalidad, posicion = :posicion, " +
                                                "valorMercado = :valorMercado, idEquipo = :idEquipo " +
                                                "WHERE idJugador = :idJugador";

    private static final String DELETE_JUGADOR="DELETE FROM Jugadores WHERE idJugador = :idJugador";

    private NamedParameterJdbcTemplate jdbcTemplate;

    public JDBJugadorDAO(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean insert(Jugador jugador, int idEquipo) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("nombre", jugador.getNombre());
            params.put("apellido", jugador.getApellido());
            params.put("fechaNacimiento", jugador.getFechaNacimiento());
            params.put("dorsal", jugador.getDorsal());
            params.put("nacionalidad", jugador.getNacionalidad());
            params.put("posicion", jugador.getPosicion());
            params.put("valorMercado", jugador.getValorMercado());
            params.put("idEquipo", jugador.getIdEquipo());
            return jdbcTemplate.update(INSERT_JUGADOR_IN_TEAM, params) == 1;
        } catch (DuplicateKeyException e) {
            return false;
        }
    }

    @Override
    public boolean modify(Jugador jugador) {
        Map<String, Object> params = new HashMap<>();
        params.put("nombre", jugador.getNombre());
        params.put("apellido", jugador.getApellido());
        params.put("fechaNacimiento", jugador.getFechaNacimiento());
        params.put("dorsal", jugador.getDorsal());
        params.put("nacionalidad", jugador.getNacionalidad());
        params.put("posicion", jugador.getPosicion());
        params.put("valorMercado", jugador.getValorMercado());
        params.put("idEquipo", jugador.getIdEquipo());
        return jdbcTemplate.update(UPDATE_JUGADOR, params) == 1;
    }

    @Override
    public int remove(int idJugador) {
        Map<String, Object> params = new HashMap<>();
        params.put("idJugador", idJugador);
        return jdbcTemplate.update(DELETE_JUGADOR, params);
    }
}
