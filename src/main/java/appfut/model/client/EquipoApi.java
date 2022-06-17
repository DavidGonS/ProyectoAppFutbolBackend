package appfut.model.client;

import appfut.model.Equipo;

public interface EquipoApi {
    void insertEquipo(Equipo equipo, int idLiga);
    void deleteEquipo(int idEquipo);
}
