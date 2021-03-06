package appfut.backend.jdbc;

import appfut.backend.dao.LigaDAO;
import appfut.model.Liga;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class JDBCLigaDAO implements LigaDAO {

    private static final String INSERT_LIGA = "INSERT INTO Ligas(nombre, pais) VALUES( :nombre, :pais)";
    private static final String UPDATE_LIGA="UPDATE Ligas SET nombre = :nombre, :pais WHERE idLiga = :idLiga";

    private static final String DELETE_LIGA ="DELETE FROM Ligas WHERE idLiga = :idLiga";
    private NamedParameterJdbcTemplate jdbcTemplate;

    public JDBCLigaDAO(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean insert(Liga liga) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("nombre", liga.getNombre());
            params.put("pais", liga.getPais());
            return jdbcTemplate.update(INSERT_LIGA, params) == 1;
        } catch (DuplicateKeyException e) {
            return false;
        }
    }

    @Override
    public boolean ligaModify(Liga liga, int idLiga) {
        Map<String, Object> params = new HashMap<>();
        params.put("nombre", liga.getNombre());
        params.put("pais", liga.getPais());
        params.put("idLiga", liga.getId());

        return jdbcTemplate.update(UPDATE_LIGA, params) == 1;
    }

    @Override
    public int remove(int idLiga) {
        Map<String, Object> params = new HashMap<>();
        params.put("idLiga", idLiga);
        return jdbcTemplate.update(DELETE_LIGA, params);
    }
}
