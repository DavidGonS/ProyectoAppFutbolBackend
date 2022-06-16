package appfut.model.client;

import appfut.model.Liga;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public class LIgaCliente implements LigaApi{
    private RestTemplate restTemplate;
    private String host;

    public LIgaCliente(RestTemplate restTemplate, @Value("${liga.api}") String host) {
        this.restTemplate = restTemplate;
        this.host = host;
    }

    @Override
    public void postLiga(Liga liga) {
        restTemplate.postForObject(host + "/ligas", liga, Void.class);
    }

    @Override
    public void updateLiga(int id, Liga liga) {
        restTemplate.put(host + "/ligas/" + id, liga, Void.class);
    }

    @Override
    public void deleteLiga(int idLiga) {
        restTemplate.delete(host + "/ligas/" + idLiga, Void.class);
    }
}
