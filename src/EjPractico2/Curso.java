package EjPractico2;

import java.util.List;

public class Curso {
	private int cursoID;
	private String descripcion;
	private int numHoras;
	private SeImparteEn seImparteEn;
	private List<Doctorando> doctorando;
	private List<Doctor> doctor;
	
	public Curso(int cursoID, String descripcion, int numHoras, SeImparteEn seImparteEn, List<Doctorando> doctorando,
			List<Doctor> doctor) {
		super();
		this.cursoID = cursoID;
		this.descripcion = descripcion;
		this.numHoras = numHoras;
		this.seImparteEn = seImparteEn;
		this.doctorando = doctorando;
		this.doctor = doctor;
	}

	public int getCursoID() {
		return cursoID;
	}

	public void setCursoID(int cursoID) {
		this.cursoID = cursoID;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getNumHoras() {
		return numHoras;
	}

	public void setNumHoras(int numHoras) {
		this.numHoras = numHoras;
	}

	public SeImparteEn getSeImparteEn() {
		return seImparteEn;
	}

	public void setSeImparteEn(SeImparteEn seImparteEn) {
		this.seImparteEn = seImparteEn;
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
		return "Curso [cursoID=" + cursoID + ", descripcion=" + descripcion + ", numHoras=" + numHoras
				+ ", seImparteEn=" + seImparteEn + ", doctorando=" + doctorando + ", doctor=" + doctor + "]";
	}
	
}
