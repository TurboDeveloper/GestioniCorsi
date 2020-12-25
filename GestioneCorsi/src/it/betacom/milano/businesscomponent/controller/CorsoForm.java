package it.betacom.milano.businesscomponent.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.betacom.milano.architetture.dao.DAOException;
import it.betacom.milano.businesscomponent.BC.ClientFacade;
import it.betacom.milano.businesscomponent.model.Corso;

/**
 * Servlet implementation class CorsoForm
 */
@WebServlet("/corsoForm")
public class CorsoForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Corso c = new Corso();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		try {
			c.setNome_corso(request.getParameter("nomecorso"));
			c.setData_iniziocorso(formato.parse(request.getParameter("datainizio")));
			c.setData_finecorso(formato.parse(request.getParameter("datafine")));
			c.setCosto_corso(Double.parseDouble(request.getParameter("costocorso")));
			c.setCommenti_corso(request.getParameter("commento"));
			c.setAula_corso(request.getParameter("aula"));
			c.setCod_docente(Integer.parseInt(request.getParameter("select")));
			ClientFacade.getInstance().corsoCreate(c);
			response.sendRedirect("listaCorsisti.jsp");
		} catch (DAOException | ClassNotFoundException | IOException|ParseException e) {
			
			e.printStackTrace();
		} 

}
}