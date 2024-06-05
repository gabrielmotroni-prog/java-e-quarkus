package br.com.alura.resource;

import br.com.alura.model.Ordem;
import br.com.alura.repository.OrdemRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

import java.time.LocalDate;

@Path("/ordens")
public class OrdemResource {
    @Inject
    OrdemRepository ordemRepository;

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void inserir(Ordem ordem){
        ordem.setData(LocalDate.now());
        ordem.setStatus("ENVIADA");

        ordemRepository.persist(ordem);
    }
}
