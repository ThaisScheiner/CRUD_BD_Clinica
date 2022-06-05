package application.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDAO 
{
	private Connection c;
	
	private static final String JDBC_URL = "jdbc:mariadb://localhost:3306/clinica";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "123456";
    private Connection con = null;

		public Connection getConnection() throws ClassNotFoundException, SQLException
		{
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
			
			
			
			
			/*
			
			String hostName = "localhost";
			String dbName = "clinica";
			String user = "Thais";
			String senha = "";
			
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			
			c = DriverManager.getConnection(String.format("jdbc:jtds:sqlserver://%s:1433;databaseName=$s;user=%s;password=%s",hostName, dbName,user, senha));
			
			return c;
			
			*/
		}
	
}
