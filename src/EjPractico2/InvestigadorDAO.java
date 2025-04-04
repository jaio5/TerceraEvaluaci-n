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
        List<Investigador> investigadores = new LinkedList<>();
        String sql = "SELECT * FROM investigador WHERE Inv_ID = ?";

        try (Connection con = conexion.getConnection(); 
               PreparedStatement stmt = con.prepareStatement(sql)) {
               stmt.setInt(1, id);
               ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int idInv = rs.getInt("Inv_ID");
                String nombre = rs.getString("Nombre");
                String apellidos = rs.getString("Apellidos");
                String telefono = rs.getString("Telefono");
                String correo = rs.getString("Correo");
                
                   // Asumiendo que tienes un método para buscar el departamento por su ID
                DepartamentoDAO departamentoDAO = new DepartamentoDAO();
                Departamento departamento = departamentoDAO.buscar(id);
                

                Investigador investigador = new Investigador(idInv, nombre, apellidos, telefono, correo, null);
                investigadores.add(investigador);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al consultar los investigadores.");
        }

        return investigadores;
    }
}