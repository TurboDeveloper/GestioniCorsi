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
 * Servlet implementation class listacorsi
 */
@WebServlet("/eliminacorso")
public class eliminacorso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
			
				try {
					ClientFacade.getInstance().corsoDelete(Long.parseLong(request.getParameter("id")));
				} catch (NumberFormatException |DAOException
						| ClassNotFoundException | IOException e) {
					
					e.printStackTrace();
				}
			
			response.sendRedirect("listacorsi.jsp");
			
	}

}
