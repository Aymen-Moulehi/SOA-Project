# SOA-Project
## Front-End
<p align="center">
  <img src="https://anthoncode.com/wp-content/uploads/2019/01/php-logo-elephant-png.png" />
</p>

On A utilisé côté front end  de notre site web php qui communique directement avec avec le API 
Pour l’ajout ou bien la récupération de données . 

> **index.php** : récupérer la liste des produits à partir de la catégorie . <br />
> **product .php** : un simple formulaire pour l'ajout des produits sont donnés vont être envoyés vers postProducct.php . <br />
> **postProducct.php** : permet l’envoi de données vers l’API par la méthode POST . <br />
> **Contact.php** : un simple formulaire pour l'ajout les avis des clients sont donnés vont être envoyés vers postContact.php . <br />
> **postContact.php** :permet l’envoi de données vers l’API par la méthode POST . <br />
> **About.php** : simple page qui est static . <br />


## Back-End
<p align="center">
  <img src="https://miro.medium.com/max/700/1*-uckV8DOh3l0bCvqZ73zYg.png" />
</p>


>**DbCommande.java** : est une classe intermédiaire entre les classe de l’APi et la base de données . <br />
```java
package database;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbCommande {
	
	
	public java.sql.Connection connection() throws ClassNotFoundException, SQLException {        
		Class.forName("com.mysql.jdbc.Driver");
		String mysqlConnUrl = "jdbc:mysql://localhost:3306/shope";
		String mysqlUserName = "root";
		String mysqlPassword = "";
		java.sql.Connection conn = DriverManager.getConnection(mysqlConnUrl, mysqlUserName , mysqlPassword);
		return conn ;
	}
	
	public void closeConnection(java.sql.Connection conn) throws SQLException {
		conn.close();
	}
	
	
	public void insert(java.sql.Connection conn,String req) throws SQLException {
		 PreparedStatement preparedStmt = conn.prepareStatement(req);
		 preparedStmt.execute();		 
	}
	
	
	public void update(java.sql.Connection conn,String req) throws SQLException {
		 PreparedStatement preparedStmt = conn.prepareStatement(req);
		 preparedStmt.execute();		 
	}
	
	public void delete(java.sql.Connection conn,String req) throws SQLException {
		 PreparedStatement preparedStmt = conn.prepareStatement(req);
		 preparedStmt.execute();		 
	}
	
	public ResultSet select(java.sql.Connection conn,String req) throws SQLException {
		Statement stmt = conn.createStatement() ;
		ResultSet rs =stmt.executeQuery(req) ;
		return rs ;
	}
	

}
```

>**Product.javat** : la classe qui contient les attribut nécessaire pour la représentation d' un produit avec les getter et les setter .  <br />

```java
package com.example.demo;

public class Product {
	
		String imglink ;
		String pname  ;
		String price ; 
		String category ; 
		String descreption ;
		public Product(String imglink, String pname, String price, String category, String descreption) {
			super();
			this.imglink = imglink;
			this.pname = pname;
			this.price = price;
			this.category = category;
			this.descreption = descreption;
		}
		public String getImglink() {
			return imglink;
		}
		public void setImglink(String imglink) {
			this.imglink = imglink;
		}
		public String getPname() {
			return pname;
		}
		public void setPname(String pname) {
			this.pname = pname;
		}
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getDescreption() {
			return descreption;
		}
		public void setDescreption(String descreption) {
			this.descreption = descreption;
		} 
		
		

}
```

>**ProductController** : la classe api responsable au gestion des produits . <br />
```java
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
```

>**Contact.javat** : la classe qui contient les attribut nécessaire pour la représentation le contact de client produit avec les getter et les setter .  <br />

```java
package com.example.demo;

public class Contact {
	String uname ;
	String email;
	String message;
	public Contact(String uname, String email, String message) {
		super();
		this.uname = uname;
		this.email = email;
		this.message = message;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
```

>**contactController** : la classe api responsable au gestion des contacts . <br />

```java
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
```
## Base de données
<p align="center">
  <img src="https://pngpress.com/wp-content/uploads/2020/09/uploads_mysql_mysql_PNG32.png" />
</p>

On a tout simplement 2 tableaux l’un pour les produits  et l’autre pour les contacts .
