package it.betacom.milano.businesscomponent.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.betacom.milano.architetture.dao.DAOException;
import it.betacom.milano.businesscomponent.BC.ClientFacade;
import it.betacom.milano.businesscomponent.model.CorsoCorsista;

@WebServlet("/iscriviForm")
public class IscriviForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		CorsoCorsista c = new CorsoCorsista();
		String messaggio=null;
		long id = Long.parseLong(request.getParameter("corsoId"));
		long select = Long.parseLong(request.getParameter("select"));
		try {
			CorsoCorsista savedc[] = ClientFacade.getInstance().corsocorsistGetAll();
			for (int i = 0; i < savedc.length; i++) {
				if ((savedc[i].getCodice_corso() != id) || (savedc[i].getCodice_corsista() != select)) {
					c.setCodice_corso(id);
					c.setCodice_corsista(select);
					
				} else {
					System.out.println(request.getParameter("select"));
					messaggio="Il corsista "+ClientFacade.getInstance().corsistaGetById(select).getNome_corsista()+" "+ClientFacade.getInstance().corsistaGetById(select).getCognome_corsista()+" è già iscritto al corso";
					session.setAttribute("messaggio", messaggio);				
					response.sendRedirect("iscriviCorsista.jsp?id="+request.getParameter("corsoId"));
					return;
				}
			}
			ClientFacade.getInstance().corsoCorsistaCreate(c);
		} catch (DAOException | ClassNotFoundException | IOException e) {

			e.printStackTrace();
		}
		response.sendRedirect("listacorsi.jsp");

	}

}
