package appfut.backend.dao;

import appfut.model.Jugador;

import java.util.List;

public interface JugadorDAO {
    boolean insert(Jugador jugador);
    boolean modify(Jugador jugador);
    int remove(int idJugador);

    List<Jugador> getAll();

    List<Jugador> getByEquipo(int idEquipo);
}
