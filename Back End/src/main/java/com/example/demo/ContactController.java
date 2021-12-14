package com.example.demo;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import database.DbCommande;

@RestController
public class ContactController {
	
	@PostMapping("add/contact")
	public void addUser(@RequestBody Contact c) throws ClassNotFoundException, SQLException {


		DbCommande db = new DbCommande();
		java.sql.Connection cnx = db.connection() ;
		String req = "insert into contact(uname,email,message) values('"+
		c.getUname()+"','"+c.getEmail()+"','"+c.getMessage()+"')";
		db.insert(cnx, req);
		db.closeConnection(cnx);
	}

	

}
