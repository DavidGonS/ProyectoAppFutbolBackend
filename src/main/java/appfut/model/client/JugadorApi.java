package appfut.model.client;

import appfut.model.Jugador;

public interface JugadorApi {
    void insertJugador(Jugador jugador, int Equipo);
    void updateJugador(int idJugador, Jugador jugador);
    void deleteJugador(int idJugador);
}
