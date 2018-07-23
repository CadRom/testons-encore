package com.objis.gestionformations.service;

import java.util.ArrayList;

import com.objis.gestionformations.dao.IUtilisateurDAO;
import com.objis.gestionformations.dao.UtilisateurDAO;
import com.objis.gestionformations.domaine.Identifiant;
import com.objis.gestionformations.domaine.Utilisateur;

public class UtilisateurService implements IUtilisateurService{
	
	IUtilisateurDAO utilisateurDAO = new UtilisateurDAO();
	
	/* (non-Javadoc)
	 * @see com.objis.gestionformations.service.IUtilisateurService#testIdentification(com.objis.gestionformations.domaine.Utilisateur)
	 */
	public boolean testIdentification(Utilisateur utilisateur) {
		Utilisateur notreUtilisateur = utilisateurDAO.getUtilisateurByLoginAndMdp(utilisateur);
		if (notreUtilisateur.getEmail()=="inconnu") {
			return false;
		}
		return true;
		
	}
	
	


	/* (non-Javadoc)
	 * @see com.objis.gestionformations.service.IUtilisateurService#recupererUtilisateurByLoginAndMdp(com.objis.gestionformations.domaine.Utilisateur)
	 */
	public Utilisateur recupererUtilisateurByLoginAndMdp(Utilisateur utilisateur) {
		return utilisateurDAO.getUtilisateurByLoginAndMdp(utilisateur);
		}
	
	public ArrayList<Utilisateur> recupereTousLesUtilisateurs(){
		return utilisateurDAO.getAllUtilisateurs();
	}
	
}
