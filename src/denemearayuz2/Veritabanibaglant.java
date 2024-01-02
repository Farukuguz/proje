package denemearayuz2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Veritabanibaglant {
	static final String DB = "jdbc:mysql://localhost:3306/Oyunskor";
	static final String USER = "root";
	static final String PASS = "farkuugz196??";
	public Connection con;
	public Statement st;
	public Connection getCon() {
		return con;
	}
	public void setCon(Connection con) {
		this.con = con;
	}
	public Veritabanibaglant() {
		
		try {
			con = DriverManager.getConnection(DB, USER, PASS);
		    st=con.createStatement();
			String sql="CREATE DATABASE Oyunskor";
			st.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Database zaten var.");
		}

		try {
			String sql2="CREATE TABLE Skorkaydi "+
				    "(id INTEGER not NULL AUTO_INCREMENT, "+
				    "adi VARCHAR(20), "+
				    "skor INTEGER, "+				    
				    "PRIMARY KEY(id))";
			st.executeUpdate(sql2);
		} catch (SQLException e) {
			System.out.println("Tablo zaten var.");
		}
		
	}
	public Statement getSt() {
		return st;
	}
	public void setSt(Statement st) {
		this.st = st;
	}
	

	
}