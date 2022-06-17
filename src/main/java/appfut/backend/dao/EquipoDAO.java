package appfut.backend.dao;

import appfut.model.Equipo;

public interface EquipoDAO {
    boolean insert(Equipo equipo);
    int remove(int idEquipo);

}
