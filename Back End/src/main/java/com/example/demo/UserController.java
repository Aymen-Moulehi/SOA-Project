package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import database.DbCommande;

@RestController
public class UserController {
	@PostMapping("add/user")
	public void addUser(@RequestBody User u) throws ClassNotFoundException, SQLException {
	//	System.out.println(u.getNom());
		DbCommande db = new DbCommande();
		java.sql.Connection cnx = db.connection() ;
		String req = "insert into utilisateur(nom,prenom,mot_de_passe,user_name) values('"+
		u.getNom()+"','"+u.getPrenom()+"','"+u.getMot_de_passe()+"','"+u.getUser_name()+"')";
		db.insert(cnx, req);
		db.closeConnection(cnx);
	}
	
	
	@GetMapping("get/user")
	public List<Object> getusers() throws ClassNotFoundException, SQLException{
		ArrayList<Object>  users = new ArrayList<>() ;
		DbCommande db = new DbCommande();
		java.sql.Connection cnx = db.connection() ;
		String req = "select * from utilisateur;";
		ResultSet rs = db.select(cnx,req);
	    while ( rs.next() ) {
	    	users.add(rs.getString("nom")) ;
        }
		return users;
		
	}
	
	@DeleteMapping(path="delete/{username}")
	public String deleteUser(@PathVariable String username) throws ClassNotFoundException, SQLException {
		
		DbCommande db = new DbCommande();
		java.sql.Connection cnx = db.connection() ;
		String req ="delete from utilisateur where user_name = '"+username+"';"; 
		db.delete(cnx, req);
		db.closeConnection(cnx);
		return " user deleted ! " ;
	}

}
