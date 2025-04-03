package ej1327;

import java.sql.Connection;

public interface AlumnoDAO {
	
	Connection conectar();
	void create(Alumno alumno);
	Alumno read(int id);
	void update(Alumno alumno);
	void delete(int id);

}
