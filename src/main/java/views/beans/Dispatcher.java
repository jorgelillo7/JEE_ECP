package views.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.ejbs.ControllerEjbFactory;
import models.entities.Tema;
import models.entities.Voto;
import models.utils.NivelEstudios;

@WebServlet("/jsp/*")
public class Dispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String PATH_ROOT_VIEW = "/viewsJSP/";

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String action = request.getPathInfo().substring(1);
		String view;
		request.setCharacterEncoding("UTF-8");
		switch (action) {
		case "nuevoTema":
			NuevoTemaView nuevoTemaView = new NuevoTemaView();
			request.setAttribute(action, nuevoTemaView);
			view = action;
			break;
		case "eliminarTema":
			System.out.print("GET ELIM");
			EliminarTemaView eliminarTemaView = new EliminarTemaView();
			eliminarTemaView.setControllerFactory(new ControllerEjbFactory());
			eliminarTemaView.mostrarListaTemas();
			request.setAttribute("temaView", eliminarTemaView);
			view = action;
			break;
		case "a�adirVoto":
			A�adirVotoView a�adirVotoView = new A�adirVotoView();
			a�adirVotoView.setVoto(new Voto());
			a�adirVotoView.setControllerFactory(new ControllerEjbFactory());
			a�adirVotoView.updateView();
			request.setAttribute("a�adirVotoView", a�adirVotoView);
			view = action;
			break;
		case "verVotaciones":
			VerVotacionesView verVotacionesView = new VerVotacionesView();
			verVotacionesView.setControllerFactory(new ControllerEjbFactory());
			verVotacionesView.configurarTabla();
			request.setAttribute("votacionesView", verVotacionesView);
			view = action;
			break;
		default:
			view = "home";
		}

		this.getServletContext()
				.getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
				.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo().substring(1);
		String view = "home";
		
		boolean checkPassword = false;

		request.setCharacterEncoding("UTF-8");
		switch (action) {
		case "nuevoTema":
			String pregunta = (request.getParameter("pregunta"));
			String categoria = (request.getParameter("categoria"));
			NuevoTemaView nuevoTemaView = new NuevoTemaView(categoria, pregunta);
			nuevoTemaView.setControllerFactory(new ControllerEjbFactory());
			request.setAttribute(action, nuevoTemaView);
			view = nuevoTemaView.process();
			break;
		case "eliminarTema": 
			String password = String.valueOf(request.getParameter("password"));
			HomeView homeView = new HomeView();
			homeView.setPassword(password);
			homeView.setControllerFactory(new ControllerEjbFactory());
			request.setAttribute("homeView", homeView);
			checkPassword = homeView.checkPassword();
			view = homeView.process();
			break;

		case "eliminarTemaAutenticado":
			int temaid = Integer.valueOf(request.getParameter("temaABorrar"));
			EliminarTemaView eliminarTemaViewAutenticated = new EliminarTemaView();
			eliminarTemaViewAutenticated
					.setControllerFactory(new ControllerEjbFactory());
			eliminarTemaViewAutenticated.setId(temaid);
			eliminarTemaViewAutenticated.eliminarTema();
			view = "home";
			break;
		case "a�adirVoto":
			int temaSeleccionado = Integer.valueOf(request
					.getParameter("temaAVotar"));
			A�adirVotoView a�adirVotoView = new A�adirVotoView();
			a�adirVotoView.setControllerFactory(new ControllerEjbFactory());
			a�adirVotoView.setIdTema(temaSeleccionado);

			String nivel = request.getParameter("nivelEstudios");
			a�adirVotoView.setNivelEstudios(NivelEstudios.valueOf(nivel));

			int valoracion = Integer
					.valueOf(request.getParameter("valoracion"));
			a�adirVotoView.setValoracion(valoracion);

			a�adirVotoView.setIp(request.getRemoteAddr());

			view = a�adirVotoView.saveVoto();

			break;
		default:
			view = "home";
		}

		if(checkPassword){
			response.sendRedirect(view);
		} else {
			this.getServletContext()
			.getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
			.forward(request, response);
		}
		

	}

}
