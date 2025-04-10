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
    	String sql = "INSERT INTO curso (cursoID,descripcion,) VALUES(?,?,?)";
    }
}
