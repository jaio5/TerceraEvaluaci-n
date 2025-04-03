package EjPractico2;

import java.util.Date;
import java.util.List;

public class Doctor {
	
	private Date anyoTesis;
	private String tituloTesis;
	private String calificacionTesis;
	private SeImparteEn seImparte;
	private List<Articulo> articulos;
	private List<Curso> cursos;
	
	public Doctor(Date anyoTesis, String tituloTesis, String calificacionTesis, SeImparteEn seImparte,
			List<Articulo> articulos, List<Curso> cursos) {
		super();
		this.anyoTesis = anyoTesis;
		this.tituloTesis = tituloTesis;
		this.calificacionTesis = calificacionTesis;
		this.seImparte = seImparte;
		this.articulos = articulos;
		this.cursos = cursos;
	}

	public Date getAnyoTesis() {
		return anyoTesis;
	}

	public void setAnyoTesis(Date anyoTesis) {
		this.anyoTesis = anyoTesis;
	}

	public String getTituloTesis() {
		return tituloTesis;
	}

	public void setTituloTesis(String tituloTesis) {
		this.tituloTesis = tituloTesis;
	}

	public String getCalificacionTesis() {
		return calificacionTesis;
	}

	public void setCalificacionTesis(String calificacionTesis) {
		this.calificacionTesis = calificacionTesis;
	}

	public SeImparteEn getSeImparte() {
		return seImparte;
	}

	public void setSeImparte(SeImparteEn seImparte) {
		this.seImparte = seImparte;
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

	@Override
	public String toString() {
		return "Doctor [anyoTesis=" + anyoTesis + ", tituloTesis=" + tituloTesis + ", calificacionTesis="
				+ calificacionTesis + ", seImparte=" + seImparte + ", articulos=" + articulos + ", cursos=" + cursos
				+ "]";
	}
	
	
}
