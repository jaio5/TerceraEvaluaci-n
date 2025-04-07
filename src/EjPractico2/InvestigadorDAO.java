package EjPractico2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class InvestigadorDAO {
     private Conexion conexion;

    public List<Investigador> buscar(int id) {
    	
    	//Se crea la lista de investigadores
        List<Investigador> investigadores = new LinkedList<>();
        
        //Sentencia SQL para buscar los investigadores por id
        String sql = "SELECT * FROM investigador WHERE Inv_ID = ?";

        try (Connection con = conexion.getConnection(); 
               PreparedStatement stmt = con.prepareStatement(sql)) {
               stmt.setInt(1, id);
               ResultSet rs = stmt.executeQuery();

            //Recorremos los resultados de la consulta
            while (rs.next()) {
                int idInv = rs.getInt("Inv_ID");
                String nombre = rs.getString("Nombre");
                String apellidos = rs.getString("Apellidos");
                String telefono = rs.getString("Telefono");
                String correo = rs.getString("Correo");
                
                // Asumiendo que tienes un método para buscar el departamento por su ID
               
                Investigador investigador = new Investigador(idInv, nombre, apellidos, telefono, correo, null);
                investigadores.add(investigador);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al consultar los investigadores.");
        }
        return investigadores;
    }
    
    public void insertar(Investigador inv) {
    	//SQL para insertar un investigador
    	String sql = "INSERT INTO investigador (Inv_ID,Nombre,Apellidos,Telefono,Correo,Dept_ID) Values (?,?,?,?,?,?)";
    	
		try (Connection con = conexion.getConnection(); 
			PreparedStatement stmt = con.prepareStatement(sql)) {

			stmt.setInt(1, inv.getInvID());
			stmt.setString(2, inv.getNombre());
			stmt.setString(3, inv.getApellidos());
			stmt.setString(4, inv.getTelefono());
			stmt.setString(5, inv.getCorreo());
			stmt.setInt(6, inv.getDepartamento().getDepID());

			stmt.executeUpdate();
			System.out.println("Investigador insertado correctamente.");
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Error al insertar el investigador.");
		}
    }
    
    //Actualizar investigadores
    public void actualizar(Investigador inv) {
		// SQL para actualizar un investigador
		String sql = "UPDATE investigador SET Nombre = ?, Apellidos = ?, Telefono = ?, Correo = ? WHERE Inv_ID = ?";
		
		try (Connection con = conexion.getConnection(); 
				PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, inv.getNombre());
			stmt.setString(2, inv.getApellidos());
			stmt.setString(3, inv.getTelefono());
			stmt.setString(4, inv.getCorreo());
			stmt.setInt(5, inv.getInvID());
			
			stmt.executeUpdate();
			System.out.println("Investigador actualizado correctamente.");
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			System.out.println("Error al actualizar el investigador.");
		}
    }
    
}