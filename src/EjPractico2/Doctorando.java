package EjPractico2;

import java.util.Date;
import java.util.List;

public class Doctorando extends Investigador {
	private Date fechaInicioDoctorando;
	private List<Articulo> articulos;
	private List<Curso> cursos;
	
	public Doctorando(int invID, String nombre, String apellidos, String telefono, String correo,
			Departamento departamento, Date fechaInicioDoctorando, List<Articulo> articulos, List<Curso> cursos) {
		super(invID, nombre, apellidos, telefono, correo, departamento);
		this.fechaInicioDoctorando = fechaInicioDoctorando;
		this.articulos = articulos;
		this.cursos = cursos;
	}

	public Date getFechaInicioDoctorando() {
		return fechaInicioDoctorando;
	}

	public void setFechaInicioDoctorando(Date fechaInicioDoctorando) {
		this.fechaInicioDoctorando = fechaInicioDoctorando;
	}

	public List<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	public int getDoctorandoID()
	{
		return getInvID();
	}

	@Override
	public String toString() {
		return "Doctorando [fechaInicioDoctorando=" + fechaInicioDoctorando + ", articulos=" + articulos + ", cursos="
				+ cursos + "]";
	}

	
}
