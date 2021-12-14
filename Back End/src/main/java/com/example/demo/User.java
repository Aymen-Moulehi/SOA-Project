package com.example.demo;

public class User {
	
	
	public String[] utilisateur = {"utilisateur" ,"id","nom","prenom","mot_de_passe","user_name","admin"};
	
	String nom ;
	String prenom ;
	String user_name ;
	String mot_de_passe ;
	boolean admin = false ;
	public User(String nom, String prenom, String user_name, String mot_de_passe, boolean admin) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.user_name = user_name;
		this.mot_de_passe = mot_de_passe;
		this.admin = admin;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getMot_de_passe() {
		return mot_de_passe;
	}
	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	

}
