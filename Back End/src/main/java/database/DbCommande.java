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
	
	
	/*
    while ( rs.next() ) {
            int numColumns = rs.getMetaData().getColumnCount();
            for ( int i = 1 ; i <= numColumns ; i++ ) {
               System.out.println( "COLUMN " + i + " = " + rs.getObject(i) );
            }
        }
	 */
	

}
