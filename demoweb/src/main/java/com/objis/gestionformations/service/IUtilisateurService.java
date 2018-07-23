package com.objis.gestionformations.service;

import java.util.ArrayList;

import com.objis.gestionformations.domaine.Utilisateur;

public interface IUtilisateurService {

	boolean testIdentification(Utilisateur utilisateur);

	Utilisateur recupererUtilisateurByLoginAndMdp(Utilisateur utilisateur);
	
	ArrayList<Utilisateur> recupereTousLesUtilisateurs();

}