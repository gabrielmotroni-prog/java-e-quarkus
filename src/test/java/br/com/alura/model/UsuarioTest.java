package br.com.alura.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

@QuarkusTest
public class UsuarioTest {

    @Test
    public void testarSefindByIdOptionalRetornaUsuarioCorreto(){
        // Arrange

        // para mockar funcao estaticas de acesso a base de dados de usuario model (activate record)
        PanacheMock.mock(Usuario.class);

        // usuario que vai ser retornado no mock
        Usuario u = new Usuario();
        Optional<PanacheEntityBase> usuarioMock = Optional.of(u);

        // Retornar mock quando for chamado tal metodo com tal parametro
        Mockito.when(Usuario.findByIdOptional(40)).thenReturn(usuarioMock);

        // Assert

        // compara se usuario retornado da chamada é igual usuario u
        Assertions.assertSame(u, Usuario.findByIdOptional(40).get());

    }
}
