package br.com.alura.resource;

import br.com.alura.model.Usuario;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/usuarios")
public class UsuarioResource {

    @POST
    @PermitAll
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void inserir(Usuario usuario){
        System.out.println(usuario);
        //persisitindo na base
        Usuario.inserir(usuario);
    }

    @GET
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> listar(){
        return  Usuario.listAll();
    }
}
