package br.ce.wcaquino.tasks.apitest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;

public class APITest {

    @BeforeClass
    public static void setup(){
        RestAssured.baseURI = "http://localhost:8001/tasks-backend";
    }

    @Test
    public void deveRetornarTarefas(){
        RestAssured
                .given()
                .when()
                .get("/todo")
                .then()
                .statusCode(200)
                .log()
                .all();
    }

    @Test
    public void deveAdicionarTarefaComSucesso(){
        RestAssured
                .given()
                .body("{\"task\": \"Teste via API\",\"dueDate\": \"2023-12-12\"}")
                .contentType(ContentType.JSON)
                .when().post("/todo")
                .then()
                .statusCode(201)
                .log()
                .all();
    }
}
