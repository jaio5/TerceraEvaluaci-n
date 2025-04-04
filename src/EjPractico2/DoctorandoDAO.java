package EjPractico2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class DoctorandoDAO {

    Connection conexion;


    List<Investigador> investigadorxID(String nombre)
    {
        List<Investigador> mismoNombre = new LinkedList<>();

        conexion = Conexion.getConnection();


        String sqlInvestigador ="select doctorando.Inv_ID, doctorando.Fecha_inicio_doctorado "
        +"from doctorando";

        try
        {
            PreparedStatement sentencia = conexion.prepareStatement(sqlInvestigador);
            sentencia.setString(1, nombre + "%");

            ResultSet rs = sentencia.executeQuery();

            while (rs.next()) {
                int invid = rs.getInt("Inv_ID");
                Date inicioDoctorado = rs.getDate("Fecha_inicio_doctorado");

                Doctorando doctorando = new Doctorando(invid, inicioDoctorado);//Cuando departamento esté implementado
                mismoNombre.add(doctorando);
            }
        } catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Error al consultar un investigador.");
        }



		return mismoNombre;

    }
}
