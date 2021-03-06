package br.ce.waquino.rest;

import br.ce.wcaquino.rest.User;
import io.restassured.http.ContentType;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class MapTest {

    @Test
    public void salvarUsandoMap() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", "Usuario via Map");
        params.put("age", 25);

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(params)
        .when()
                .post("http://restapi.wcaquino.me/users")
        .then()
                .log().all()
                .statusCode(201);
    }

    @Test
    public void salvarUsandoObjeto() {
        User user = new User("Lucas", 20);

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(user)
        .when()
                .post("http://restapi.wcaquino.me/users")
        .then()
                .log().all()
                .statusCode(201);
    }
}
