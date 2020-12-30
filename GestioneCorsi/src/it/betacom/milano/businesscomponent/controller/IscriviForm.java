package it.betacom.milano.businesscomponent.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.betacom.milano.architetture.dao.DAOException;
import it.betacom.milano.businesscomponent.BC.ClientFacade;
import it.betacom.milano.businesscomponent.model.CorsoCorsista;

/**
 * Servlet implementation class IscriviForm
 */
@WebServlet("/iscriviForm")
public class IscriviForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CorsoCorsista c = new CorsoCorsista();
		try {
			c.setCodice_corso(Long.parseLong(request.getParameter("corsoId")));
			c.setCodice_corsista(Long.parseLong(request.getParameter("select")));
			ClientFacade.getInstance().corsoCorsistaCreate(c);
		} catch (DAOException | ClassNotFoundException | IOException e) {

			e.printStackTrace();
		}
		response.sendRedirect("listacorsi.jsp");

	}

}
