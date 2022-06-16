package appfut.backend.controller;

import appfut.backend.dao.JugadorDAO;
import appfut.model.Jugador;
import appfut.model.client.JugadorApi;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class JugadorController implements JugadorApi {

    private JugadorDAO jugadorDAO;

    @Override
    @RequestMapping(method = RequestMethod.POST, path = "/")
    public void insertJugador(@RequestBody Jugador jugador, @PathVariable("idEquipo") int idEquipo) {
        if (!jugadorDAO.insert(jugador, idEquipo)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Duplicado");
        }
    }

    @Override
    @RequestMapping(method = RequestMethod.PUT, path = "/jugadores/{idJugador}")
    public void updateJugador(@PathVariable("idJugador") int idJugador, @RequestBody Jugador jugador) {
        if(!jugadorDAO.modify(jugador)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe");
        }
    }
}