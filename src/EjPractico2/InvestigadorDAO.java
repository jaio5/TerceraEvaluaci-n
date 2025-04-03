package EjPractico2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class InvestigadorDAO {
    Connection conexion;
    
    // crear un investigador
	 public void create(Investigador investigador, Departamento departamento) {
         //si investigador es null crea una clase
	        if (investigador != null) {
                //se inserta en la base de datos un nuevo investigador
	            String sql = "INSERT INTO investigador (invID, nombre, apellidos, telefono, correo, departamento) "
	            		+ " VALUES ( ?,    ?,     ?,     ?,     ?,    ?  )";

                //el try hace una prueba de conexion
	            try {
                    //establecemos la conexion como "conexion"
	            	conexion = Conexion.getConnection();
	            	
                    //las distintas sentencias de todas las columnas referentes al investigador
	                PreparedStatement sentencia = conexion.prepareStatement(sql);
	                sentencia.setInt(1, investigador.getInvID());
	                sentencia.setString(2, investigador.getNombre());
	                sentencia.setString(3, (investigador.getApellidos()));
	                sentencia.setString(4, investigador.getTelefono());
	                sentencia.setString(5, investigador.getCorreo());
                    sentencia.setInt(6, departamento.getDepID());

                    

	                sentencia.executeUpdate();
	                conexion.close();
	            } catch (SQLException ex) {
	                System.out.println("Error al insertar.");
	            }
	        }
	    }
        List<Investigador> investigadoresXid(int ID){
            
            List<Investigador> investigadores = new LinkedList<>();
            investigadores = null;

            List<Departamento> departamentos =new LinkedList<>();
            departamento=null;

            String sql = "SELECT *"+
            "FROM investigador, departamento" +
            "WHERE departamento.dept_ID = investigador.Dept_ID & invID = ?";
            String sqlDep = "SELECT *"+
            "FROM departamento"+
            "where departamento.dept_ID = investigador.Dept_ID";

            

            try {
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            PreparedStatement sentenciaDep = conexion.prepareStatement(sqlDep);

            

            ResultSet rs = sentencia.executeQuery();

            if (rs.next()) { 
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");
                
               
                // rellenar con las partes del departamento
                departamentos = new Departamento();
                investigador = new Investigador(InvID, nombre, apellidos, telefono, correo, );
                investigadores.add(investigador);

            }
        } catch (SQLException ex) {
            System.out.println("Error al consultar un investigador.");
        }

            return investigador;
        }
}
