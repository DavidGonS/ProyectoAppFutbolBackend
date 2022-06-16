package appfut.model.client;

import appfut.model.Jugador;

import java.util.List;

public interface JugadorApi {
    void insertJugador(Jugador jugador, int Equipo);
    void updateJugador(int idJugador, Jugador jugador);
    void deleteJugador(int idJugador);

    List<Jugador> getJugadores();
}
