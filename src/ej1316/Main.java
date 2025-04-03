package ej1316;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main   {
	public static void main(String []args)
	{
		List<Socio> socios = new ArrayList<Socio>();
		
		//añade los socios al ArrayList
		socios.add(new Socio("12345678B", "Pepe", LocalDate.of(1989, 1, 1), LocalDate.of(2020, 1, 1), 5, 1));
		socios.add(new Socio("12345678C", "Luis", LocalDate.of(1990, 1, 1), LocalDate.of(2020, 1, 1), 100, 0));
		socios.add(new Socio("12345678D", "Maria", LocalDate.of(1990, 1, 1), LocalDate.of(2020, 1, 1), 100, 0));
		socios.add(new Socio("12345678E", "Ana", LocalDate.of(1990, 1, 1), LocalDate.of(2020, 1, 1), 100, 0));
		socios.add(new Socio("12345678A", "Juan", LocalDate.of(1995, 1, 1), LocalDate.of(2022, 1, 1), 100, 0));
		
		Stream<Socio> streamSocios = socios.stream();
		
		//Saca los socios por pantalla para poder ver los cambios realizados posteriormente
		streamSocios.sorted().forEach(System.out::println);

		System.out.println(" ");
		System.out.println(" ");
		
		//creao un stream y muestro los socios que tienen una cuota mayor o igual a 100
		Stream<Socio> streamSocios2 = socios.stream();
		
		streamSocios2.filter(s -> s.getCuota() >= 100).forEach(System.out::println);
		
		System.out.println(" ");
		System.out.println(" ");
		
		//crea un stream y muestra los socios que empiezan por "A"
		Stream<Socio> streamSocios3 = socios.stream();
		
		streamSocios3.filter(s -> s.getNombre().toUpperCase().startsWith("A")).forEach(System.out::println);
		
		System.out.println(" ");
		System.out.println(" ");
		
		//creo un stream para mostrar los socios ordenados por sus antiguedades
		Stream<Socio> antiguedad = socios.stream();
		
		antiguedad.sorted((s1,s2) -> s1.getAntiguedad() - s2.getAntiguedad()).forEach(System.out::println);
		
		System.out.println(" ");
		System.out.println(" ");
		
		//creo un stream para mostrar a los socios por edad
		
		Stream<Socio> birthDate = socios.stream();
		
		birthDate.sorted((s1,s2) -> s1.getEdad() - s2.getEdad()).forEach(System.out::println);
		
		System.out.println(" ");
		System.out.println(" ");
		
		//Sacamos por pantalla solo los DNI con un String.
		
		Stream<Socio> dni = socios.stream();
		
		String [] arrayDni = dni.map(socio -> socio.getDni()).toArray(String[]::new);
		
		System.out.println(Arrays.toString(arrayDni));
		
		//Sacamos por pantalla solo los DNI con un List
        Stream<Socio> dniList = socios.stream();
		
		List<String> listDni = dniList.map(socio -> socio.getDni()).toList();
		
		System.out.println(listDni);
		
		System.out.println(" ");
		System.out.println(" ");
		
		//coleccion ordenada por orden alfabetico
		
		Stream<Socio> ordenAlfabetico = socios.stream();
		
		ordenAlfabetico.sorted((s1, s2) -> s1.getNombre().compareTo(s2.getNombre())).forEach(System.out::println);
		
		System.out.println(" ");
		System.out.println(" ");
		
		//promedio de familiares por socio
		
		Stream<Socio> promedioFamiliares = socios.stream();
		
		double mediaFamiliares = promedioFamiliares.mapToInt(s-> s.getNumeroFamiliares()).average().getAsDouble();
		System.out.println("Media de familiares");
		System.out.println(mediaFamiliares);
 	}
	
	
}
