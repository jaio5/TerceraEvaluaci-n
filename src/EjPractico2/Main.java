package EjPractico2;

public class Main {
	public static void main(String[] args)
	{
		Conexion conexion;
		DepartamentoDAO depDAO = new DepartamentoDAO();
		
		// Obtener departamentos por ID
		Departamento departamento = depDAO.buscar(1);
		System.out.println("Departamento encontrado: " + departamento);
		
		
		
		
	}
}
