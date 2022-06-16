package appfut.backend.dao;

import appfut.model.Jugador;

public interface JugadorDAO {
    boolean insert(Jugador jugador, int idEquipo);
}
