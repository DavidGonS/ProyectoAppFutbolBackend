package appfut.model.client;

import appfut.model.Jugador;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public class JugadorCliente implements JugadorApi{
    private RestTemplate restTemplate;
    private String host;

    public JugadorCliente(RestTemplate restTemplate, @Value("${jugador.api}") String host) {
        this.restTemplate = restTemplate;
        this.host = host;
    }

    @Override
    public void insertJugador(Jugador jugador, int idEquipo) {
        restTemplate.postForObject(host + "/jugadores/{idJugador}", jugador, Void.class);
    }
}
