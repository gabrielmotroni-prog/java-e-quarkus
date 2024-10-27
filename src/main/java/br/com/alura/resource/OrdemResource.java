package br.com.alura.resource;

import br.com.alura.model.Ordem;
import br.com.alura.repository.OrdemRepository;
import br.com.alura.service.OrdemService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;

import java.time.LocalDate;
import java.util.List;

@Path("/ordens")
public class OrdemResource {

    @Inject
    OrdemService ordemService;

    @POST
    @Transactional
    @RolesAllowed("user")
    @Consumes(MediaType.APPLICATION_JSON)
    public void inserir(@Context SecurityContext securityContext, Ordem ordem){

        ordemService.inserir(securityContext, ordem);
    }
    @GET
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ordem> listar(){
        return  ordemService.listar();
    }
}
