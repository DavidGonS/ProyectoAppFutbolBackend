package appfut.backend.controller;

import appfut.backend.dao.JugadorDAO;
import appfut.model.Jugador;
import appfut.model.client.JugadorApi;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class JugadorController implements JugadorApi {

    private JugadorDAO jugadorDAO;

    @Override
    public void insertJugador(Jugador jugador, int idEquipo) {
        if (!jugadorDAO.insert(jugador, idEquipo)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Duplicado");
        }
    }
}