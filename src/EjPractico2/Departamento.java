package EjPractico2;

import java.util.List;

public class Departamento {
	private int depID;
	private String descripcion;
	private int numeroInvestigadores;
	List<Investigador> investigadores;
	
	public List<Investigador> getInvestigadores() {
		return investigadores;
	}

	public void setInvestigadores(List<Investigador> investigadores) {
		this.investigadores = investigadores;
	}

	public Departamento(int depID, String descripcion, int numeroInvestigadores, List<Investigador> investigadores) {
		super();
		this.depID = depID;
		this.descripcion = descripcion;
		this.numeroInvestigadores = numeroInvestigadores;
		this.investigadores = investigadores;
	}


	public int getDepID() {
		return depID;
	}

	public void setDepID(int depID) {
		this.depID = depID;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getNumeroInvestigadores() {
		return numeroInvestigadores;
	}

	public void setNumeroInvestigadores(int numeroInvestigadores) {
		this.numeroInvestigadores = numeroInvestigadores;
	}

	@Override
	public String toString() {
		return "Departamento [depID=" + depID + ", descripcion=" + descripcion + ", numeroInvestigadores="
				+ numeroInvestigadores + ", investigadores=" + investigadores + "]";
	}
	
}
