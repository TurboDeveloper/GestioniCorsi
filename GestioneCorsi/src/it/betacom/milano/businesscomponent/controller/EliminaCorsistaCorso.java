package it.betacom.milano.businesscomponent.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.betacom.milano.architetture.dao.DAOException;
import it.betacom.milano.businesscomponent.BC.ClientFacade;

/**
 * Servlet implementation class EliminaCorsista
 */
@WebServlet("/eliminaCorsistaCorso")
public class EliminaCorsistaCorso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			ClientFacade.getInstance().corsoCorsistaDeleteCorsistaCorso(
								Long.parseLong(request.getParameter("corso")),
								Long.parseLong(request.getParameter("corsista")));
			response.sendRedirect("listaCorsisti.jsp");

		} catch (NumberFormatException | DAOException | ClassNotFoundException | IOException e) {

			e.printStackTrace();
		}
	}

	
}
