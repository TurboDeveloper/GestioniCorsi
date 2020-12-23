package it.betacom.milano.businesscomponent.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.betacom.milano.architetture.dao.DAOException;
import it.betacom.milano.businesscomponent.BC.ClientFacade;
import it.betacom.milano.businesscomponent.model.Corsista;

/**
 * Servlet implementation class CorsistaForm
 */
@WebServlet("/corsistaForm")
public class CorsistaForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Corsista c = new Corsista();

		try {
			c.setNome_corsista(request.getParameter("nome"));
			c.setCognome_corsista(request.getParameter("cognome"));
			c.setPrecententi_formativi(Long.parseLong(request.getParameter("select")));

			ClientFacade.getInstance().corsistaCreate(c);
			
			response.sendRedirect("listaCorsisti.jsp");
		} catch (DAOException | ClassNotFoundException | IOException e) {
			
			e.printStackTrace();
		}
	}

}
