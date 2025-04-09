package EjPractico2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Date;

public class DoctorDAO {

   Conexion conexion;
    
	public void buscar(int id) {
		//SQL para buscar un doctor
		String sql = "SELECT*FROM doctor WHERE Inv_ID = ?";
		try (Connection con= conexion.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int idInv = rs.getInt("Inv_ID");
				Date anoTesis = rs.getDate("Ano_Tesis");
				String tituloTesis = rs.getString("Titulo_Tesis");
				String calificacion = rs.getString("Calificacion_Tesis");
				
				InvestigadorDAO investigadorDAO = new InvestigadorDAO();
				Investigador investigador = investigadorDAO.buscar(idInv);
				
				DepartamentoDAO departamentoDAO = new DepartamentoDAO();
				Departamento departamento = departamentoDAO.buscar(id);
				
				SeImparteEn seImparte = 
				// Crear un objeto Doctor con los datos obtenidos
				Doctor doctor = new Doctor(idInv, investigador.getNombre(),investigador.getApellidos(), investigador.getTelefono(), investigador.getCorreo(),
						departamento, anoTesis, calificacion, calificacion, null, null,null);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error al consultar los doctores.");
		}
	}
    
}
