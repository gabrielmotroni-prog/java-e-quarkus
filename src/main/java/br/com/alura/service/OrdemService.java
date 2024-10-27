package br.com.alura.service;

import br.com.alura.model.Ordem;
import br.com.alura.model.Usuario;
import br.com.alura.repository.OrdemRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.SecurityContext;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class OrdemService {
    @Inject
    OrdemRepository ordemRepository;

    public void inserir(SecurityContext securityContext, Ordem ordem) {

        //validar obter usuario com a id informada na requisao da compra
        Optional<Usuario> usuarioOptional = Usuario.findByIdOptional(ordem.getUserId());
        //caso nao exista o usuario lancar excessao
        Usuario usuario =  usuarioOptional.orElseThrow();

        //tratar fraude: nome do usuario logado for diferente do usuario id passado
        if(!usuario.getUsername().equals(securityContext.getUserPrincipal().getName())){
            throw  new RuntimeException("o usuário logado é diferente do userId");
        }


        //fluxo feliz: salvar ordem
        ordem.setData(LocalDate.now());
        ordem.setStatus("ENVIADA");
        ordemRepository.persist(ordem);
    }

    public List<Ordem> listar() {
        return  ordemRepository.listAll();
    }
}
