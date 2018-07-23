package com.objis.gestionformations;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.objis.gestionformations.domaine.Utilisateur;
import com.objis.gestionformations.service.IUtilisateurService;
import com.objis.gestionformations.service.UtilisateurService;

@WebServlet("/MaServlet2")
public class MaServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MaServlet2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		traitement(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		traitement(request, response);
	}

	protected void traitement(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		IUtilisateurService utilisateurService = new UtilisateurService();
		

		// Etape 1 : Récupération des paramètres de la requête :
		
		Utilisateur utilisateur = new Utilisateur(request.getParameter("loginuser"),request.getParameter("mdpuser"));

		
		
		// Etape 2 : Soumettre les paramètres de la requête à la couche service et préparer en fonction la réponse à envoyer
		
		
		//RequestDispatcher dispatcher ;
		
		
		if (utilisateurService.testIdentification(utilisateur)) {
			//dispatcher = request.getRequestDispatcher("Acceuil.html");
			
			ArrayList<Utilisateur> maliste = utilisateurService.recupereTousLesUtilisateurs();
			
			PrintWriter out = response.getWriter();
			out.println("<HTML>");
			out.println("<HEAD><TITLE>Liste des formations du catalogue</TITLE></HEAD>");
			out.println("<BODY>");
			
			for (Utilisateur util : maliste) {
				out.println("<br>");
				out.println(util);
				out.println("<br>");
			}
			
			out.println("</BODY>");
			out.println("</HTML>");
			
		/*} else {
			dispatcher = request.getRequestDispatcher("index.html");
		}

		// Etape 3 : envoyer la Réponse à l'utilisateur
		dispatcher.forward(request, response);*/

	}
}

}
