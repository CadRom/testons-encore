package com.objis.gestionformations.service;

import com.objis.gestionformations.domaine.Identifiant;
import com.objis.gestionformations.domaine.Utilisateur;

public class IdentifiantService {
	
	
	
	public boolean testIdentification(Identifiant identifiant, Utilisateur utilisateur) {
	
	if ((identifiant.getLogin().equalsIgnoreCase(utilisateur.getLogin()))
			&& (identifiant.getMdp().equalsIgnoreCase(utilisateur.getMdp()))) {
		return true;
		
	}
	return false;
	}

}
