package com.objis.gestionformations.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.objis.gestionformations.domaine.Utilisateur;

public class UtilisateurDAO implements IUtilisateurDAO {
	
	
	
	/* (non-Javadoc)
	 * @see com.objis.gestionformations.dao.IUtilisateurDAO#getUtilisateurByLoginAndMdp(com.objis.gestionformations.domaine.Utilisateur)
	 */
	public Utilisateur getUtilisateurByLoginAndMdp(Utilisateur utilisateur) {
		
		Statement st=null;
		Connection cn=null;
		ResultSet rs=null;
		String url = "jdbc:mysql://localhost/siteinternet";
		String login = "root";
		String passwd = "";
		Utilisateur utilisateur2=null;
		
		try {

			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : récupération de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Préparer la requête
			st = cn.createStatement();
			String sql = "SELECT * FROM `utilisateur` WHERE login ='" + utilisateur.getLogin()+"' AND mdp='"+ utilisateur.getMdp()+"'";
			rs = st.executeQuery(sql);

			while (rs.next()) {
				int i = rs.getInt("Id");
				String s = rs.getString("Login");
				String s2 = rs.getString("Mdp");
				String s3 = rs.getString("Prenom");
				String s4 = rs.getString("Nom");
				String s5 = rs.getString("Email");
				utilisateur2= new Utilisateur(i,s,s2,s3,s4,s5);
				}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO: gestion erreur 
			e.printStackTrace();
		}   
		finally {
			try {
			// Etape 6 : libérer ressources de la mémoire.
				cn.close();
				st.close();
			} catch (SQLException e) {
				// TODO: gestion erreur 
				e.printStackTrace();
			}
		}
		if (utilisateur2==null)
			{return utilisateur;}
		else {return utilisateur2;}
		
	
		
		
		

	}

	
public ArrayList<Utilisateur> getAllUtilisateurs(){
	Statement st=null;
	Connection cn=null;
	ResultSet rs=null;
	String url = "jdbc:mysql://localhost/siteinternet";
	String login = "root";
	String passwd = "";
	ArrayList<Utilisateur> listeUtilisateur = new ArrayList<Utilisateur>();
	Utilisateur utilisateur;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");

		// Etape 2 : récupération de la connexion
		cn = DriverManager.getConnection(url, login, passwd);

		// Etape 3 : Préparer la requête
		st = cn.createStatement();
		String sql = "SELECT * FROM `utilisateur` ";
		rs = st.executeQuery(sql);

		while (rs.next()) {
			int i = rs.getInt("Id");
			String s = rs.getString("Login");
			String s2 = rs.getString("Mdp");
			String s3 = rs.getString("Prenom");
			String s4 = rs.getString("Nom");
			String s5 = rs.getString("Email");
			utilisateur= new Utilisateur(i,s,s2,s3,s4,s5);
			
			listeUtilisateur.add(utilisateur);
			
		}

		
		
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO: gestion erreur 
		e.printStackTrace();
	} 
	finally {
		try {
		// Etape 6 : libérer ressources de la mémoire.
			cn.close();
			st.close();
		} catch (SQLException e) {
			// TODO: gestion erreur 
			e.printStackTrace();
		} 
	}
	return listeUtilisateur;
}
}


