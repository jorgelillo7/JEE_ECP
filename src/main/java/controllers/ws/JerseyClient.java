package controllers.ws;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import models.entities.Tema;

public class JerseyClient {

	public static void main(String[] args) {

		try {
			Tema tema = new Tema("rest", "¿te gusta rest?");
			Client client = ClientBuilder.newClient();
			WebTarget target = client.target(
					"http://localhost:8080/JEE_ECP/rest/").path("temas");

			target.request(MediaType.APPLICATION_XML).post(
					Entity.entity(tema, MediaType.APPLICATION_XML), Tema.class);

		} catch (Exception e) {

			e.printStackTrace();

		}
	}
}
