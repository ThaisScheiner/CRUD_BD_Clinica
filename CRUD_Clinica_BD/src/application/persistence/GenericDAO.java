package application.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDAO 
{
	
	private Connection c;
		
		public Connection getConnection() throws ClassNotFoundException, SQLException
		{
			/*
			 -------------------CONEXÃO COM BANCO DE DADOS MARIA DB----------------------------------
			 try 
		        {
		            Class.forName("org.mariadb.jdbc.Driver");
		            con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
		        } 
		        catch (Exception e) 
		        {
		            e.printStackTrace();
		        }
			return con;
			
		*/	
			//-------------------CONEXÃO COM BANCO DE DADOS SQL SERVER----------------------------------
			String hostName = "localhost";
			String dbName = "clinica3";
			String user = "Thais";
			String senha = "123456";
			
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			
			c = DriverManager.getConnection(String.format("jdbc:jtds:sqlserver://%s:1433;databaseName=%s;user=%s;password=%s;",hostName, dbName,user, senha));
			
			return c;
			
			
		}
	
}
