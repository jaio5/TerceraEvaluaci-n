package EjPractico2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ArticuloDAO {
    Connection conexion ;

    // Mostrar los artículos por nombre de título
    public List<Articulo> articulosXID(String nombre) {
        List<Articulo> mismoNombre = new LinkedList<>();

        conexion = Conexion.getConnection();

        String sql = "SELECT articulo.Articulo_ID, articulo.Inv_ID, articulo.Titulo, articulo.Num_Paginas " +
                     "FROM articulo WHERE articulo.Titulo LIKE ?";

        try {
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, nombre + "%");

            ResultSet rs = sentencia.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("Articulo_ID");
                int invId = rs.getInt("Inv_ID");
                String titulo = rs.getString("Titulo");
                int numPaginas = rs.getInt("Num_Paginas");

                Articulo articulo = new Articulo(id, titulo, numPaginas, Doctor.class,Doctorando.class);//Cuando Doctor y Doctorando estén implementados
                mismoNombre.add(articulo);
            }

        } catch (SQLException ex) {
            System.out.println("Hay un error en la consulta de artículo: " + ex.getMessage());
        }
        return mismoNombre;
    }
    
}
