package br.com.alura.repository;

import br.com.alura.model.Ordem;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;


@QuarkusTest
public class OrdemRepositoryTest {
    @InjectMock
    OrdemRepository ordemRepository;

    @Test
    public void testarSeListAllRetornaOrdensCorretas(){
        Ordem primeiraOrdem = new Ordem();
        Ordem segundaOrdem = new Ordem();

        List<Ordem> ordens = new ArrayList<>();

        ordens.add(primeiraOrdem);
        ordens.add(segundaOrdem);

        //mockar
        Mockito.when(ordemRepository.listAll()).thenReturn(ordens);

        // segundo item do array deve ser segundaOrdem
        Assertions.assertSame(segundaOrdem, ordemRepository.listAll().get(1));

    }
}
