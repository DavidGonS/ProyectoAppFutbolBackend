package appfut;

import appfut.model.client.EquipoCliente;
import appfut.model.client.JugadorCliente;
import appfut.model.client.LIgaCliente;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@Configuration
@PropertySource("application.properties")
public class ClientConfiguration {

    @Bean
    public LIgaCliente lIgaCliente(RestTemplate restTemplate, @Value("${ligas.api}")String host) {
        return new LIgaCliente(restTemplate, host);
    }
    @Bean
    public JugadorCliente jugadorCliente(RestTemplate restTemplate, @Value("${jugadores.api}")String host) {
        return new JugadorCliente(restTemplate, host);
    }

    @Bean
    public EquipoCliente equipoCliente(RestTemplate restTemplate, @Value("${equipo.api}")String host) {
        return new EquipoCliente(restTemplate, host);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
