package EjPractico2;
import java.util.List;
import java.util.Scanner;
public class Main {
	public static void main(String[] args)
	{
		DepartamentoDAO depDAO = new DepartamentoDAO();
		Departamento busca = depDAO.buscar(1);
		Departamento dep = new Departamento(5, "av", 4, busca.getInvestigadores());
		System.out.println(dep);
		
	}
}
