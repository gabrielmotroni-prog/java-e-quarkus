package br.com.alura.service;

import br.com.alura.model.Bitcoin;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("/bitcoins")
//@RegisterRestClient(configKey = "bitcoin-api")
//@RegisterRestClient(baseUri = "https://api.mockfly.dev/mocks/ad58e432-15a7-4b11-8877-2b7306b6ed02")
//@RegisterRestClient(configKey="extensions-api")
//@RegisterRestClient()
@RegisterRestClient()
public interface BitcoinService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)

    public List<Bitcoin> listar();
}
