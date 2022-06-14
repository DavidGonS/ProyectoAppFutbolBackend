package appfut.backend.controller;

import appfut.backend.dao.LigaDAO;
import appfut.model.Liga;
import appfut.model.client.LigaApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class LigaController implements LigaApi {

    private LigaDAO ligaDAO;

    @RequestMapping(method = RequestMethod.POST, path = "/ligas")
    public void postLiga(Liga liga) {
        if (!ligaDAO.insert(liga)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Duplicado");
        }
    }

    @Override
    @RequestMapping(method = RequestMethod.PUT, path = "/ligas/{idLiga}")
    public void updateLiga(@PathVariable("idLiga") int id, @RequestBody Liga liga) {
        if (!ligaDAO.ligaModify(liga)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe la liga");
        }
    }
}
