package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Scooter;
import za.ac.cput.domain.ScooterType;
import za.ac.cput.factory.ScooterFactory;
import za.ac.cput.factory.ScooterTypeFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ScooterControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseUrl = "http://localhost:8080";

    ScooterType scooterType = ScooterTypeFactory.buildScooterType("Electric", 150, 500.00);
    Scooter scooter = ScooterFactory.buildScooter("123ABC", "ModelX", "Black", "2023", "BrandY", scooterType);

    @Test
    void a_create() {
        String url = baseUrl + "/scooter/create";
        ResponseEntity<Scooter> postResponse = restTemplate.postForEntity(url, scooter, Scooter.class);
        assertNotNull(postResponse);
        System.out.println(postResponse);
        assertNotNull(postResponse.getBody());
        Scooter scooter1 = postResponse.getBody();
        System.out.println("Saved Scooter " + scooter1);
        assertNotNull(scooter1.getNumberPlate());
    }

    @Test
    void b_read() {
        String url = baseUrl + "/scooter/get/" + scooter.getNumberPlate();
        System.out.println("URL " + url);
        ResponseEntity<Scooter> getResponse = restTemplate.getForEntity(url, Scooter.class);
        System.out.println(getResponse.getBody());
        assertNotNull(getResponse.getBody());
        assertEquals(scooter.getNumberPlate(), getResponse.getBody().getNumberPlate());
        System.out.println("Scooter: " + getResponse.getBody());
    }

    @Test
    void c_update() {
        // Update test case to be implemented based on your update logic
        Scooter updatedScooter = new Scooter("123ABC", "ModelY", "Red", "2023", "BrandY", scooterType);
        String url = baseUrl + "/scooter/update";
        ResponseEntity<Scooter> postResponse = restTemplate.postForEntity(url, updatedScooter, Scooter.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Scooter scooter1 = postResponse.getBody();
        assertEquals("ModelY", scooter1.getModel());
        assertEquals("Red", scooter1.getColor());
        System.out.println("Updated Scooter " + scooter1);
    }

    @Test
    void e_delete() {
        String url = baseUrl + "/scooter/delete/" + scooter.getNumberPlate();
        System.out.println("URL " + url);
        restTemplate.delete(url);
    }

    @Test
    void d_getAll() {
        String url = baseUrl + "/scooter/getAll";
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        System.out.println("All Scooters");
        System.out.println(response);
        System.out.println(response.getBody() + "\n");
    }
}
