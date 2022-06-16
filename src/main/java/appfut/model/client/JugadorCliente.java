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
        restTemplate.postForObject(host + "/jugadores/" + idEquipo, jugador, Void.class);
    }

    @Override
    public void updateJugador(int idJugador, Jugador jugador) {
        restTemplate.put(host + "/jugadores/" + idJugador, jugador, Void.class);
    }

    @Override
    public void deleteJugador(int idJugador) {
        restTemplate.delete(host + "/jugadores/" + idJugador, Void.class);
    }
}
