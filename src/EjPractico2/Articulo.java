package EjPractico2;

import java.util.List;

public class Articulo {
	
	private int articuloID;
	private String titulo;
	private int numPaginas;
	private List<Doctorando> doctorando;
	private List<Doctor> doctor;
	
	public Articulo(int articuloID, String titulo, int numPaginas, List<Doctorando> doctorando, List<Doctor> doctor) {
		super();
		this.articuloID = articuloID;
		this.titulo = titulo;
		this.numPaginas = numPaginas;
		this.doctorando = doctorando;
		this.doctor = doctor;
	}

	public int getArticuloID() {
		return articuloID;
	}

	public void setArticuloID(int articuloID) {
		this.articuloID = articuloID;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}

	public List<Doctorando> getDoctorando() {
		return doctorando;
	}

	public void setDoctorando(List<Doctorando> doctorando) {
		this.doctorando = doctorando;
	}

	public List<Doctor> getDoctor() {
		return doctor;
	}

	public void setDoctor(List<Doctor> doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "Articulo [articuloID=" + articuloID + ", titulo=" + titulo + ", numPaginas=" + numPaginas
				+ ", doctorando=" + doctorando + ", doctor=" + doctor + "]";
	}

	
}
