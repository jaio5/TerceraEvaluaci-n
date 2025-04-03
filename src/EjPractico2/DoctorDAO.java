package EjPractico2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DoctorDAO {

   Connection conexion;
    
	 public void create(Articulo articulo) {
	        if (articulo != null) {
	            String sql = "INSERT INTO Doctor (anyoTesis, tituloTesis, calificacionTesis, seImparte, curso) "
	                    + "             VALUES ( ?,    ?,     ?,     ?,     ?  )";

	            try {
	            	conexion = Conexion.getConnection();
	            	
	                PreparedStatement sentencia = conexion.prepareStatement(sql);
	                sentencia.setInt(1, articulo.getId());
	                sentencia.setString(2, articulo.getNombre());
	                sentencia.setDate(3, new java.sql.Date(articulo.getfNacimiento().getTime()));
	                sentencia.setDouble(4, articulo.getNotaMedia());
	                sentencia.setString(5, articulo.getCurso());

	                sentencia.executeUpdate();
	                conexion.close();
	            } catch (SQLException ex) {
	                System.out.println("Error al insertar.");
	            }
	        }
	    }
   
    
    List<Doctor> 
    
}
    
}
