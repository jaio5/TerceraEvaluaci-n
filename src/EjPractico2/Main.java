package EjPractico2;

public class Main {
	public static void main(String[] args)
	{
		Conexion conexion;
		DepartamentoDAO depDAO = new DepartamentoDAO();
		
		// Obtener departamentos por ID
		Departamento departamento = depDAO.buscar(3);
		System.out.println("Departamento encontrado: " + departamento);
		
		// Insertar un nuevo departamento
		Departamento nuevoDepartamento = new Departamento(4, "Matemáticas", 5, null);
		depDAO.insertar(nuevoDepartamento);
		System.out.println("Nuevo departamento insertado: " + nuevoDepartamento);
		
		//eliminar un departamento 
		
		depDAO.eliminar(4);
		
	}
}
