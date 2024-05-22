package br.com.alura.resource;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

//Teste de integração

//QuarkusTest informa que classe eh escocpo teste
@QuarkusTest
public class BitcoinResouceTest {

@Test
    public void testarSeStatusCodeDaRequisicaoE200(){
    RestAssured.given().get("bitcoins").then().statusCode(200);
}

}

