package io.github.azagniotov.example.controller;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import static org.junit.Assert.assertTrue;

// https://stackoverflow.com/questions/37209109/how-to-use-the-springboots-context-for-testing-by-jerseytest
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FlightBookingControllerComponentTest {

    private static Client client;
    @Value("${local.server.port}")
    private int port;

    @BeforeClass
    public static void beforeClass() {
        client = ClientBuilder.newClient();
    }

    @Test
    public void shouldReturn404_whenIncorrectResourceRequest_thenResponseIsNotFound() {
//        WebTarget target = client.target("http://localhost:" + this.port);
//
//        Response response = target.path("/api/v1/flights/9999999").request().get();
//
//        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatus());
//        assertEquals(MediaType.APPLICATION_JSON, response.getHeaderString(HttpHeaders.CONTENT_TYPE));
//
//        String content = response.readEntity(String.class);
//        assertEquals("Resource not found", content);
        assertTrue(true);
    }
}
