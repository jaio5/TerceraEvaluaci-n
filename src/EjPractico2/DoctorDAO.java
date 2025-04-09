
package EjPractico2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class DoctorDAO {

    Conexion conexion;

    public void buscar(int id) {
        // SQL to search for a doctor
        String sql = "SELECT * FROM doctor WHERE Inv_ID = ?";
        try (Connection con = Conexion.getConnection(); // Static method call
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int idInv = rs.getInt("Inv_ID");
                Date anoTesis = rs.getDate("Ano_Tesis");
                String tituloTesis = rs.getString("Titulo_Tesis");
                String calificacion = rs.getString("Calificacion_Tesis");

                // Fetch the associated investigator
                InvestigadorDAO investigadorDAO = new InvestigadorDAO();
                List<Investigador> investigadores = investigadorDAO.buscar(idInv);
                Investigador investigador = investigadores.isEmpty() ? null : investigadores.get(0);

                if (investigador == null) {
                    System.out.println("No investigator found for ID: " + idInv);
                    continue;
                }

                // Fetch the associated department
                DepartamentoDAO departamentoDAO = new DepartamentoDAO();
                Departamento departamento = departamentoDAO.buscar(id);

                // Create a SeImparteEn object (example values used)
                SeImparteEn seImparte = new SeImparteEn(null, null); // Replace with actual data

                // Create a Doctor object with the retrieved data
                Doctor doctor = new Doctor(
                    idInv,
                    investigador.getNombre(),
                    investigador.getApellidos(),
                    investigador.getTelefono(),
                    investigador.getCorreo(),
                    departamento,
                    anoTesis,
                    tituloTesis,
                    calificacion,
                    seImparte,
                    null, // Articulos (replace with actual data if needed)
                    null  // Cursos (replace with actual data if needed)
                );

                // Print the doctor object (or handle it as needed)
                System.out.println(doctor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while querying doctors.");
        }
    }
}
