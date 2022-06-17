package appfut.model.client;

import appfut.model.Equipo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public class EquipoCliente implements EquipoApi{
    private RestTemplate restTemplate;
    private String host;

    public EquipoCliente(RestTemplate restTemplate, @Value("${equipo.api}") String host) {
        this.restTemplate = restTemplate;
        this.host = host;
    }


    @Override
    public void insertEquipo(Equipo equipo, int idLiga) {
        restTemplate.postForObject(host + "/equipos/" + idLiga, equipo, Void.class);
    }

    @Override
    public void deleteEquipo(int idEquipo) {
        restTemplate.delete(host + "/equipos/" + idEquipo, Void.class);
    }
}
