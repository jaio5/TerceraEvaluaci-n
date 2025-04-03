package EjPractico2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	 private static Connection conexion;
	  private static final String USUARIO="root";
	    private static final String PASSWORD="Iirne322*";
	    private static final String MAQUINA = "localhost";
	    private static final String BD = "prg_universidad";
	    

	public static Connection getConnection() {
	    Connection con = null;
	    String url = "jdbc:mysql://" + MAQUINA+ "/" + BD;
	    try {
	    	con = DriverManager.getConnection(url,USUARIO,PASSWORD);
	    }catch (SQLException ex)
	    {
	    		System.out.println("Error al conectar al SGBD");
	    }
	    return con;
	   }
	    
}
