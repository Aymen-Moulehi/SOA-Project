package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import database.DbCommande;

@RestController
public class ProductController {
	
	@PostMapping("add/product")
	public void addUser(@RequestBody Product p) throws ClassNotFoundException, SQLException {


		DbCommande db = new DbCommande();
		java.sql.Connection cnx = db.connection() ;
		String req = "insert into product(imglink,pname,price,category,descreption) values('"+
		p.getImglink()+"','"+p.getPname()+"','"+p.getPrice()+"','"+p.getCategory()+"','"+p.getDescreption()+"')";
		db.insert(cnx, req);
		db.closeConnection(cnx);
	}
	
	
	
	@GetMapping("get/product")
	public ArrayList<Product> getusers(@RequestParam(name = "category") String category) throws ClassNotFoundException, SQLException{
		
		
		System.out.println(category);
		
		ArrayList<Product> p = new ArrayList<>() ;

		DbCommande db = new DbCommande();
		java.sql.Connection cnx = db.connection() ;
	
		String req = "select * from product where category = '"+category+"';";
	
		ResultSet rs = db.select(cnx,req);

	    while ( rs.next() ) {
	    	p.add(new Product(rs.getString("imglink"),rs.getString("pname"),rs.getString("price"),rs.getString("category"),rs.getString("descreption"))) ;
        }
		return p;
		

	}
}
