package EjPractico2;

public class Aula {

	private int aulaID;
	private String numero;
	private int capacidad;
	private SeImparteEn seImparte;
	
	public Aula(int aulaID, String numero, int capacidad, SeImparteEn seImparte) {
		super();
		this.aulaID = aulaID;
		this.numero = numero;
		this.capacidad = capacidad;
		this.seImparte = seImparte;
	}

	public int getAulaID() {
		return aulaID;
	}

	public void setAulaID(int aulaID) {
		this.aulaID = aulaID;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public SeImparteEn getSeImparte() {
		return seImparte;
	}

	public void setSeImparte(SeImparteEn seImparte) {
		this.seImparte = seImparte;
	}

	@Override
	public String toString() {
		return "Aula [aulaID=" + aulaID + ", numero=" + numero + ", capacidad=" + capacidad + ", seImparte=" + seImparte
				+ "]";
	}
	
	
}
