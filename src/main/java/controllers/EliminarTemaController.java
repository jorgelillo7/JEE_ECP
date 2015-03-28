package controllers;

import java.util.List;

import models.entities.Tema;

public interface EliminarTemaController {

	boolean deleteTema(Integer id);

	List<Tema> mostrarTemas();

	boolean passwordCorrecto(String password);

}
