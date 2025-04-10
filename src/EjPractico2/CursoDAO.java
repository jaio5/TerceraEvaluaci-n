package EjPractico2;
//rehacer insertar
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class CursoDAO {
    Conexion conexion;

    // Create
    public void insertar(Curso curso) {
        String sql = "INSERT INTO curso (Curso_ID, Descripcion, Num_Horas, Inv_ID) VALUES (?, ?, ?, ?)";
        try (Connection con = conexion.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, curso.getCursoID());
            stmt.setString(2, curso.getDescripcion());
            stmt.setInt(3, curso.getNumHoras());
            
            SeImparteEn seImparteEn = curso.getSeImparteEn();
            List<Doctorando> doctorando = curso.getDoctorando();
            List<Doctor> doctor = curso.getDoctor();
            
            stmt.executeUpdate();
            System.out.println("Curso inserted successfully.");
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error inserting Curso.");
        }
    }

    // Read
    public List<Curso> buscar(int id) {
        List<Curso> cursos = new LinkedList<>();
        String sql = "SELECT * FROM curso WHERE Curso_ID = ?";
        try (Connection con = conexion.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int idCurso = rs.getInt("Curso_ID");
                String descripcion = rs.getString("Descripcion");
                int horas = rs.getInt("Num_Horas");
                Curso curso = new Curso(idCurso, descripcion, horas, null, null, null);
                cursos.add(curso);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error fetching Curso.");
        }
        return cursos;
    }

    // Update
    public void actualizar(Curso curso) {
        String sql = "UPDATE curso SET Descripcion = ?, Num_Horas = ? WHERE Curso_ID = ?";
        try (Connection con = conexion.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, curso.getDescripcion());
            stmt.setInt(2, curso.getNumHoras());
            stmt.setInt(3, curso.getCursoID());
            stmt.executeUpdate();
            System.out.println("Curso updated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error updating Curso.");
        }
    }

    // Delete
    public void eliminar(int id) {
        String sql = "DELETE FROM curso WHERE Curso_ID = ?";
        try (Connection con = conexion.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Curso deleted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error deleting Curso.");
        }
    }
}
