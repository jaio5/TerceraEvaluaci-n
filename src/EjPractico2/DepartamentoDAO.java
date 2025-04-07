
package EjPractico2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DepartamentoDAO {
    private Conexion conexion;

    public Departamento buscar(int id) {
    	//Se crea la lista de investigadores
        Departamento departamento = null;
        //Sentencia SQL para buscar los departamentos por id
        String sql = "SELECT * FROM departamento WHERE Dept_ID = ?";

        try (Connection con = conexion.getConnection(); 
        		
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
            	
                int idDept = rs.getInt("Dept_ID");
                String descripcion = rs.getString("descripcion");
                int numInvestigadores = rs.getInt("Num_Profesores");

                // Llamamos a InvestigadorDAO para obtener los investigadores del departamento
                InvestigadorDAO investigadorDAO = new InvestigadorDAO();
               
                List<Investigador> investigadores = investigadorDAO.buscar(idDept); 

                // Construimos el objeto Departamento con la lista de investigadores
                departamento = new Departamento(idDept, descripcion, numInvestigadores, investigadores);
                //cerramos la conexión
                con.close();
            }

        } catch (SQLException ex) {
        	
            ex.printStackTrace();
            System.out.println("Error al consultar el departamento.");
        }

        return departamento;
    }
    
    //insertamos un nuevo departamento en la base de datos
    public void insertar (Departamento dep) {
    	
        //SQL para insertar un departamento
    	String sql = "INSERT INTO departamento (Dept_ID, Descripcion,Num_Profesores) VALUES (?, ?, ?)";
    	
    	//Conexión a la base de datos
    	try(Connection con = conexion.getConnection();
    			
    		//preparamos la sentencia SQL
    		PreparedStatement stmt = con.prepareStatement(sql)){
    		
    		//asignamos los valores a la sentencia
    		stmt.setInt(1, dep.getDepID());
    		stmt.setString(2, dep.getDescripcion());
    		stmt.setInt(3, dep.getNumeroInvestigadores());
    		
    		//ejecutamos la sentencia
    		stmt.executeUpdate();
    		//cerramos la conexión
    		con.close();
    		
    		System.out.println("Departamento insertado correctamente.");
    		
    	}catch(SQLException ex) {
    		
    		//salen los errores en pantalla.
			ex.printStackTrace();
			System.out.println("Error al insertar el departamento.");
    	}
    }
    
    //Actualizar departamento
    public void actualizar (Departamento dep) {
    	//SQL para actualizar
    	String sql = "UPDATE departamento SET Descripcion = ?, Num_Profesores = ? WHERE Dept_ID = ?";
    	
    	//Conexión a la base de datos
    	try(Connection con = conexion.getConnection();
    			PreparedStatement stmt = con.prepareStatement(sql)){
    		
    		//asignamos los valores a la sentencia
    		stmt.setString(1, dep.getDescripcion());
    		stmt.setInt(2, dep.getNumeroInvestigadores());
    		stmt.setInt(3, dep.getDepID());
    		
    		//ejecutamos la sentencia
    		stmt.executeUpdate();
    		//cerramos la conexión
    		con.close();
    		
    		System.out.println("Departamento actualizado correctamente.");
    	}catch(SQLException ex) {
    		
    		//salen los errores en pantalla.
    		 ex.printStackTrace();
    		 
    		 System.out.println("Error al actualizar el departamento.");
    		            
    	}
    }
    
	public void eliminar(int id) {
		// SQL para eliminar
		String sql = "DELETE FROM departamento WHERE Dept_ID = ?";

		try (Connection con = conexion.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {

			// asignamos los valores a la sentencia
			stmt.setInt(1, id);

			// ejecutamos la sentencia
			stmt.executeUpdate();
			// cerramos la conexión
			con.close();

			System.out.println("Departamento eliminado correctamente.");
		} catch (SQLException ex) {

			// salen los errores en pantalla.
			ex.printStackTrace();

			System.out.println("Error al eliminar el departamento.");

		}
	}
}
