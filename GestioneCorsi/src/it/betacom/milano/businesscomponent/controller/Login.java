package it.betacom.milano.businesscomponent.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.betacom.milano.architetture.dao.DAOException;
import it.betacom.milano.businnesscomponent.BC.ClientFacade;


@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	int tentativi_login=5;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			  throws ServletException, IOException {
		HttpSession session = request.getSession();
		long codice= Long.parseLong(request.getParameter("cod_admin"));
		String password= request.getParameter("password");
		
		try {
			if(ClientFacade.getInstance().amministratoregetByIdPass(codice, password)!=null) {
				session.setAttribute("cod_admin", codice);
				response.sendRedirect("listacorsi.jsp");
			
			}else if(tentativi_login>0) {
				--tentativi_login;
				response.sendRedirect("index.jsp");
				System.out.println(tentativi_login);
			}else {
				response.sendRedirect("tentativiesauriti.jsp");
			}
	
		} catch (DAOException | ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
