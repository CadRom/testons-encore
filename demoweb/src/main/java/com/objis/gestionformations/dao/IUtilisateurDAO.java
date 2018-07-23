package com.objis.gestionformations.dao;

import java.util.ArrayList;

import com.objis.gestionformations.domaine.Utilisateur;

public interface IUtilisateurDAO {

	Utilisateur getUtilisateurByLoginAndMdp(Utilisateur utilisateur);
	
	ArrayList<Utilisateur> getAllUtilisateurs();

}