package appfut.backend.controller;

import appfut.backend.dao.JugadorDAO;
import appfut.model.Jugador;
import appfut.model.client.JugadorApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class JugadorController implements JugadorApi {

    @Autowired
    private JugadorDAO jugadorDAO;

    @Override
    @RequestMapping(method = RequestMethod.POST, path = "/equipos/{idEquipo}/jugadores")
    public void insertJugador(@RequestBody Jugador jugador, @PathVariable("idEquipo") int idEquipo) {
        jugador.setIdEquipo(idEquipo);
        if (!jugadorDAO.insert(jugador)) {
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

    @Override
    @RequestMapping(method = RequestMethod.DELETE, path = "/jugadores/{idJugador}")
    public void deleteJugador(@PathVariable("idJugador") int idJugador) {
        if (jugadorDAO.remove(idJugador) == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no encontrado");
        }
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, path = "/jugadores")
    public List<Jugador> getJugadores() {
        return jugadorDAO.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/equipos/{idEquipo}/jugadores")
    public List<Jugador> getJugadoresEquipo(@PathVariable("idEquipo") int idEquipo) {
        return jugadorDAO.getByEquipo(idEquipo);
    }
}