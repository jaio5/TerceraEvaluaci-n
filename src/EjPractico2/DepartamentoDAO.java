
package EjPractico2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DepartamentoDAO {
    private Conexion conexion;

    public Departamento buscar(int id) {
        Departamento departamento = null;
        String sql = "SELECT * FROM departamento WHERE Dept_ID = ?";

        try (Connection con = Conexion.getConnection(); 
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
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al consultar el departamento.");
        }

        return departamento;
    }

    
    
}
