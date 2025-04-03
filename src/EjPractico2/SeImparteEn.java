package EjPractico2;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

public class SeImparteEn {
	private Time hora;
	private Date fecha;
	
	
	public SeImparteEn(Time hora, Date fecha) {
		super();
		this.hora = hora;
		this.fecha = fecha;
	}


	public Time getHora() {
		return hora;
	}


	public void setHora(Time hora) {
		this.hora = hora;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	@Override
	public String toString() {
		return "seImparteEn [hora=" + hora + ", fecha=" + fecha + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(fecha, hora);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SeImparteEn other = (SeImparteEn) obj;
		return Objects.equals(fecha, other.fecha) && Objects.equals(hora, other.hora);
	}
	
	
}
