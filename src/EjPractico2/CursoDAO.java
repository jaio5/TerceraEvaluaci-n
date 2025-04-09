package EjPractico2;
//Corregir e implementar el DAO de Curso
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class CursoDAO {
	Conexion conexion;
	
	List<Curso> buscar(int id) {
		List<Curso> cursos = new LinkedList<>();
		
		//SQL
		String sql = "SELECT*FROM curso WHERE Curso_ID = ?";
		
		try (Connection con = conexion.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				int idCurso = rs.getInt("Curso_ID");
				String descripcion = rs.getString("Descripcion");
				int horas = rs.getInt("Num_Horas");
				int idInvestigador = rs.getInt("Inv_ID");
				
				
				// Crear un objeto Curso con los datos obtenidos
				Curso curso = new Curso(idCurso, descripcion, horas, null, null, null);
				cursos.add(curso);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al consultar los cursos.");
		}
		return cursos;
	}
}
