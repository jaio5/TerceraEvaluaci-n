
package EjPractico2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ArticuloDAO {
    Conexion conexion;

    // Create
    public void insertar(Articulo articulo) {
        String sql = "INSERT INTO articulo (Articulo_ID, Titulo, Num_Paginas) VALUES (?, ?, ?)";
        try (Connection con = conexion.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, articulo.getArticuloID());
            stmt.setString(2, articulo.getTitulo());
            stmt.setInt(3, articulo.getNumPaginas());
            stmt.executeUpdate();
            System.out.println("Articulo inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error inserting Articulo.");
        }
    }

    // Read
    public List<Articulo> buscar(int id) {
        List<Articulo> articulos = new LinkedList<>();
        String sql = "SELECT * FROM articulo WHERE Articulo_ID = ?";
        try (Connection con = conexion.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int articuloID = rs.getInt("Articulo_ID");
                String titulo = rs.getString("Titulo");
                int numPaginas = rs.getInt("Num_Paginas");
                Articulo articulo = new Articulo(articuloID, titulo, numPaginas, null, null);
                articulos.add(articulo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error fetching Articulo.");
        }
        return articulos;
    }

    // Update
    public void actualizar(Articulo articulo) {
        String sql = "UPDATE articulo SET Titulo = ?, Num_Paginas = ? WHERE Articulo_ID = ?";
        try (Connection con = conexion.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, articulo.getTitulo());
            stmt.setInt(2, articulo.getNumPaginas());
            stmt.setInt(3, articulo.getArticuloID());
            stmt.executeUpdate();
            System.out.println("Articulo updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error updating Articulo.");
        }
    }

    // Delete
    public void eliminar(int id) {
        String sql = "DELETE FROM articulo WHERE Articulo_ID = ?";
        try (Connection con = conexion.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Articulo deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error deleting Articulo.");
        }
    }
}
