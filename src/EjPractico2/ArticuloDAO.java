package EjPractico2;
//!!!!!no entiendo el 99% de este código!!!!!
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ArticuloDAO {
	Connection conexion;
	 
	// Mostrar los artículos
	List<Articulo> articulosXID(String nombre)
	{
		//creamos la lista en la que se van a guardar todas nuestras coincidencias
		List<Articulo> mismoNombre = null;
		
		//conectamos con la base de datos
		conexion = Conexion.getConnection();
		
		//creo la consulta para construir mi objeto artículo
		String sqlArticulo = "select doctor.Inv_ID, doctor.Ano_tesis, doctor.Calificacion_tesis,doctorando.Fecha_inicio_doctorado,articulo.Titulo,articulo.Num_Paginas"
				 +"from doctor, doctorando, articulo where doctorando.Inv_ID  = articulo.Inv_ID && articulo.Inv_ID = doctor.Inv_ID &&"
				 +"articulo.Titulo Like '?%'";
		
		try {
			//preparamos nuestra sentencia y la lanzamos
			PreparedStatement sentencia = conexion.prepareStatement(sqlArticulo);
			
			sentencia.setString(1, sqlArticulo);
			
			ResultSet rs = sentencia.executeQuery();
			
			while(rs.next())
			{
				int id = rs.getInt("Inv_ID");
				Date anyoTesis=rs.getDate("Ano_tesis");
				String nota = rs.getString("Calificacion_tesis");
				Date fechaIn = rs.getDate("Fecha_inicio_doctorado");
				String titulo=rs.getString("Titulo");
				int paginas = rs.getInt("Num_Paginas");
				
				//creamos todos los componentes
				
				Doctor doctor = new Doctor(fechaIn, titulo, titulo, null, mismoNombre, null)
				
			}
			
			
		}catch(SQLException ex) {
			System.out.println("hay un error en la consulta de artículo");
		}
		
	    
	    
	}
}
