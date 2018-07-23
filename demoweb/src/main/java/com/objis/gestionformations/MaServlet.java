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

/**
 * Servlet implementation class MaServlet
 */
@WebServlet("/MaServlet")
public class MaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MaServlet() {
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
		

		// Etape 1 : R�cup�ration des param�tres de la requ�te :
		
		Utilisateur utilisateur = new Utilisateur(request.getParameter("loginuser"),request.getParameter("mdpuser"));

		
		
		// Etape 2 : Soumettre les param�tres de la requ�te � la couche service et pr�parer en fonction la r�ponse � envoyer
		
		
		RequestDispatcher dispatcher ;
		
		
		if (utilisateurService.testIdentification(utilisateur)) {
			dispatcher = request.getRequestDispatcher("Acceuil.html");
			
			
			
		} else {
			dispatcher = request.getRequestDispatcher("index.html");
		}

		// Etape 3 : envoyer la R�ponse � l'utilisateur
		dispatcher.forward(request, response);

	}
}

