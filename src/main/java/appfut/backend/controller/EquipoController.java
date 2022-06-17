package appfut.backend.controller;

import appfut.backend.dao.EquipoDAO;
import appfut.model.Equipo;
import appfut.model.client.EquipoApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class EquipoController implements EquipoApi {

    @Autowired
    private EquipoDAO equipoDAO;

    @Override
    @RequestMapping(method = RequestMethod.POST, path = "/ligas/{idLiga}/equipos")
    public void insertEquipo(
            @RequestBody Equipo equipo,
            @PathVariable("idLiga") int idLiga) {
        equipo.setIdLiga(idLiga);
        if (!equipoDAO.insert(equipo)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Duplicado");
        }
    }

    @Override
    @RequestMapping(method = RequestMethod.DELETE, path = "/equipos/{idEquipo}")
    public void deleteEquipo(@PathVariable("idEquipo") int idEquipo) {
        if (equipoDAO.remove(idEquipo) == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no encontrado");
        }
    }
}
