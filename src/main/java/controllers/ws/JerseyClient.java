package controllers.ws;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.entities.Tema;
import models.entities.Voto;
import models.utils.NivelEstudios;

public class JerseyClient {

	public static void main(String[] args) {

		try { 
			addVoto();

		} catch (Exception e) {

			e.printStackTrace();

		}
	}
	
	private static void addTema(){
		Tema tema = new Tema("rest", "¿te gusta rest?");
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(
				"http://localhost:8080/JEE_ECP/rest/").path("temas");

		target.request(MediaType.APPLICATION_XML).post(
				Entity.entity(tema, MediaType.APPLICATION_XML), Tema.class);
	}
	
	private static  void addVoto(){
		TemaDao temaDao = DaoFactory.getFactory().getTemaDao();
		Tema tema = temaDao.read(1);
		Voto voto = new Voto(NivelEstudios.FP, "172.289.1.5", 5, tema);
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(
				"http://localhost:8080/JEE_ECP/rest/").path("votos");

		target.request(MediaType.APPLICATION_XML).post(
				Entity.entity(voto, MediaType.APPLICATION_XML), Voto.class);
	}
}
