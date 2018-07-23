package com.objis.gestionformations.domaine;

public class Utilisateur {
	
	private int id;
	private String login;
	private String mdp;
	
	private String prenom;
	private String nom;
	private String email;
	
	
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Utilisateur(int id, String login, String mdp,  String prenom, String nom, String email) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.id=id;
		this.login = login;
		this.mdp = mdp;
		this.email=email;
	}
	
	public Utilisateur(String login, String mdp) {
		this(0,login,mdp,"inconnu","inconnu","inconnu");
	}
	
	
	
	public String toString() {
		return this.getId()+ " "+ this.getPrenom()+" "+ this.getNom() +" "+this.getEmail();
	}

}
