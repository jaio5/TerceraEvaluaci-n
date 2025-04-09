
package EjPractico2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class DoctorandoDAO {
    Conexion conexion;

    // Create
    public void insertar(Doctorando doctorando) {
        String sql = "INSERT INTO doctorando (Inv_ID, Fecha_Inicio) VALUES (?, ?)";
        try (Connection con = conexion.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, doctorando.getDoctorandoID());
            stmt.setDate(2, new java.sql.Date(doctorando.getFechaInicioDoctorando().getTime()));
            stmt.executeUpdate();
            System.out.println("Doctorando inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error inserting Doctorando.");
        }
    }

    // Read
    public List<Doctorando> buscar(int id) {
        List<Doctorando> doctorandos = new LinkedList<>();
        String sql = "SELECT * FROM doctorando WHERE Inv_ID = ?";
        try (Connection con = conexion.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int invID = rs.getInt("Inv_ID");
                Date fechaInicio = rs.getDate("Fecha_Inicio");

                InvestigadorDAO investigadorDAO = new InvestigadorDAO();
                Investigador investigador = investigadorDAO.buscar(invID).get(0);

                Doctorando doctorando = new Doctorando(
                    invID,
                    investigador.getNombre(),
                    investigador.getApellidos(),
                    investigador.getTelefono(),
                    investigador.getCorreo(),
                    investigador.getDepartamento(),
                    fechaInicio,
                    null,
                    null
                );
                doctorandos.add(doctorando);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error fetching Doctorando.");
        }
        return doctorandos;
    }

    // Update
    public void actualizar(Doctorando doctorando) {
        String sql = "UPDATE doctorando SET Fecha_Inicio = ? WHERE Inv_ID = ?";
        try (Connection con = conexion.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setDate(1, new java.sql.Date(doctorando.getFechaInicioDoctorando().getTime()));
            stmt.setInt(2, doctorando.getDoctorandoID());
            stmt.executeUpdate();
            System.out.println("Doctorando updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error updating Doctorando.");
        }
    }

    // Delete
    public void eliminar(int id) {
        String sql = "DELETE FROM doctorando WHERE Inv_ID = ?";
        try (Connection con = conexion.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Doctorando deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error deleting Doctorando.");
        }
    }
}
