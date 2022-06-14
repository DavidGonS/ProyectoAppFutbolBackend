package appfut.backend.controller;

import appfut.backend.dao.LigaDAO;
import appfut.model.Liga;
import appfut.model.client.LigaApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
    public void updateLiga(int id, Liga liga) {

    }
}
