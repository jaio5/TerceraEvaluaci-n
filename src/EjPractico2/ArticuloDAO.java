package EjPractico2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ArticuloDAO {
    Conexion conexion ;
    
    public List<Articulo> buscar(int id){
    	List articulos = new LinkedList();
    	
    	//SQL para buscar el artículo
    	String sql = "SELECT * FROM articulo WHERE Articulo_ID = ?";
    	
    	try(Connection con = conexion.getConnection();
    			PreparedStatement stmt = con.prepareStatement(sql)){
    		
    		stmt.setInt(1, id);
    		ResultSet rs = stmt.executeQuery();
    		
    		while(rs.next()) {
    			int idArticulo = rs.getInt("Articulo_ID");
    			String titulo = rs.getString("Titulo");
    			
    			Articulo articulo = new Articulo(idArticulo, titulo);
    			
    			articulos.add(articulo);
    		}
    		
    	}catch (SQLException ex) {
    		ex.printStackTrace();
    		System.out.println("Error al consultar los articulos.");
    	}
    }
}
