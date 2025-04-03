package ej1316;

import java.time.LocalDate;
import java.util.Objects;

public class Socio implements Comparable<Socio> {
	private String dni;
	private String nombre;
	private LocalDate fechaNacimiento;
	private LocalDate fechaAlta;
	private int cuota;
	private int numeroFamiliares;
	
	
	public Socio(String dni, String nombre, LocalDate fechaNacimiento, LocalDate fechaAlta, int cuota,
			int numeroFamiliares) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaAlta = fechaAlta;
		this.cuota = cuota;
		this.numeroFamiliares = numeroFamiliares;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public LocalDate getFechaAlta() {
		return fechaAlta;
	}


	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}


	public int getCuota() {
		return cuota;
	}


	public void setCuota(int cuota) {
		this.cuota = cuota;
	}


	public int getNumeroFamiliares() {
		return numeroFamiliares;
	}


	public void setNumeroFamiliares(int numeroFamiliares) {
		this.numeroFamiliares = numeroFamiliares;
	}

	public int getEdad()
	{
		return LocalDate.now().getYear() - fechaNacimiento.getYear();
	}
	
	public int getAntiguedad()
	{
		return LocalDate.now().getYear() - fechaAlta.getYear();
	}
	public int compareTo(Socio socio)
	{
		return dni.compareTo(socio.dni);
	}
	@Override
	public String toString() {
		return "Socio [dni=" + dni + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", fechaAlta="
				+ fechaAlta + ", cuota=" + cuota + ", numeroFamiliares=" + numeroFamiliares + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(cuota, dni, fechaAlta, fechaNacimiento, nombre, numeroFamiliares);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Socio other = (Socio) obj;
		return Objects.equals(dni, other.dni);
	}




}
