
package EjPractico2;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
        DoctorandoDAO doctorandoDAO = new DoctorandoDAO();
        ArticuloDAO articuloDAO = new ArticuloDAO();
        CursoDAO cursoDAO = new CursoDAO();
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Departamento");
            System.out.println("2. Doctorando");
            System.out.println("3. Artículo");
            System.out.println("4. Curso");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            int mainChoice = scanner.nextInt();

            switch (mainChoice) {
                case 1:
                    handleDepartamentoMenu(scanner, departamentoDAO);
                    break;
                case 2:
                    handleDoctorandoMenu(scanner, doctorandoDAO);
                    break;
                case 3:
                    handleArticuloMenu(scanner, articuloDAO);
                    break;
                case 4:
                    handleCursoMenu(scanner, cursoDAO);
                    break;
                case 0:
                    exit = true;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }
        scanner.close();
    }

    private static void handleDepartamentoMenu(Scanner scanner, DepartamentoDAO departamentoDAO) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Menú Departamento ---");
            System.out.println("1. Consultar");
            System.out.println("2. Crear");
            System.out.println("3. Editar");
            System.out.println("4. Borrar");
            System.out.println("0. Volver");
            System.out.print("Selecciona una opción: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Ingresa el ID del Departamento a consultar: ");
                    int depID = scanner.nextInt();
                    Departamento departamento = departamentoDAO.buscar(depID);
                    System.out.println(departamento);
                    break;
                case 2:
                    System.out.print("Ingresa el ID del Departamento: ");
                    depID = scanner.nextInt();
                    scanner.nextLine(); // Consumir salto de línea
                    System.out.print("Ingresa la descripción: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("Ingresa el número de investigadores: ");
                    int numInvestigadores = scanner.nextInt();
                    departamento = new Departamento(depID, descripcion, numInvestigadores, null);
                    departamentoDAO.insertar(departamento);
                    break;
                case 3:
                    System.out.print("Ingresa el ID del Departamento a editar: ");
                    depID = scanner.nextInt();
                    scanner.nextLine(); // Consumir salto de línea
                    System.out.print("Ingresa la nueva descripción: ");
                    descripcion = scanner.nextLine();
                    System.out.print("Ingresa el nuevo número de investigadores: ");
                    numInvestigadores = scanner.nextInt();
                    departamento = new Departamento(depID, descripcion, numInvestigadores, null);
                    departamentoDAO.actualizar(departamento);
                    break;
                case 4:
                    System.out.print("Ingresa el ID del Departamento a borrar: ");
                    depID = scanner.nextInt();
                    departamentoDAO.eliminar(depID);
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }
    }

    private static void handleDoctorandoMenu(Scanner scanner, DoctorandoDAO doctorandoDAO) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Menú Doctorando ---");
            System.out.println("1. Consultar");
            System.out.println("2. Crear");
            System.out.println("3. Editar");
            System.out.println("4. Borrar");
            System.out.println("0. Volver");
            System.out.print("Selecciona una opción: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Ingresa el ID del Doctorando a consultar: ");
                    int docID = scanner.nextInt();
                    List<Doctorando> doctorandos = doctorandoDAO.buscar(docID);
                    doctorandos.forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("Ingresa el ID del Doctorando: ");
                    docID = scanner.nextInt();
                    System.out.print("Ingresa la fecha de inicio (yyyy-MM-dd): ");
                    String fechaInicio = scanner.next();
                    Doctorando doctorando = new Doctorando(docID, null, null, null, null, null, java.sql.Date.valueOf(fechaInicio), null, null);
                    doctorandoDAO.insertar(doctorando);
                    break;
                case 3:
                    System.out.print("Ingresa el ID del Doctorando a editar: ");
                    docID = scanner.nextInt();
                    System.out.print("Ingresa la nueva fecha de inicio (yyyy-MM-dd): ");
                    fechaInicio = scanner.next();
                    doctorando = new Doctorando(docID, null, null, null, null, null, java.sql.Date.valueOf(fechaInicio), null, null);
                    doctorandoDAO.actualizar(doctorando);
                    break;
                case 4:
                    System.out.print("Ingresa el ID del Doctorando a borrar: ");
                    docID = scanner.nextInt();
                    doctorandoDAO.eliminar(docID);
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }
    }

    private static void handleArticuloMenu(Scanner scanner, ArticuloDAO articuloDAO) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Menú Artículo ---");
            System.out.println("1. Consultar");
            System.out.println("2. Crear");
            System.out.println("3. Editar");
            System.out.println("4. Borrar");
            System.out.println("0. Volver");
            System.out.print("Selecciona una opción: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Ingresa el ID del Artículo a consultar: ");
                    int artID = scanner.nextInt();
                    List<Articulo> articulos = articuloDAO.buscar(artID);
                    articulos.forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("Ingresa el ID del Artículo: ");
                    artID = scanner.nextInt();
                    scanner.nextLine(); // Consumir salto de línea
                    System.out.print("Ingresa el título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingresa el número de páginas: ");
                    int numPaginas = scanner.nextInt();
                    Articulo articulo = new Articulo(artID, titulo, numPaginas, null, null);
                    articuloDAO.insertar(articulo);
                    break;
                case 3:
                    System.out.print("Ingresa el ID del Artículo a editar: ");
                    artID = scanner.nextInt();
                    scanner.nextLine(); // Consumir salto de línea
                    System.out.print("Ingresa el nuevo título: ");
                    titulo = scanner.nextLine();
                    System.out.print("Ingresa el nuevo número de páginas: ");
                    numPaginas = scanner.nextInt();
                    articulo = new Articulo(artID, titulo, numPaginas, null, null);
                    articuloDAO.actualizar(articulo);
                    break;
                case 4:
                    System.out.print("Ingresa el ID del Artículo a borrar: ");
                    artID = scanner.nextInt();
                    articuloDAO.eliminar(artID);
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }
    }

    private static void handleCursoMenu(Scanner scanner, CursoDAO cursoDAO) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Menú Curso ---");
            System.out.println("1. Consultar");
            System.out.println("2. Crear");
            System.out.println("3. Editar");
            System.out.println("4. Borrar");
            System.out.println("0. Volver");
            System.out.print("Selecciona una opción: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Ingresa el ID del Curso a consultar: ");
                    int cursoID = scanner.nextInt();
                    List<Curso> cursos = cursoDAO.buscar(cursoID);
                    cursos.forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("Ingresa el ID del Curso: ");
                    cursoID = scanner.nextInt();
                    scanner.nextLine(); // Consumir salto de línea
                    System.out.print("Ingresa la descripción: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("Ingresa el número de horas: ");
                    int numHoras = scanner.nextInt();
                    Curso curso = new Curso(cursoID, descripcion, numHoras, null, null, null);
                    cursoDAO.insertar(curso);
                    break;
                case 3:
                    System.out.print("Ingresa el ID del Curso a editar: ");
                    cursoID = scanner.nextInt();
                    scanner.nextLine(); // Consumir salto de línea
                    System.out.print("Ingresa la nueva descripción: ");
                    descripcion = scanner.nextLine();
                    System.out.print("Ingresa el nuevo número de horas: ");
                    numHoras = scanner.nextInt();
                    curso = new Curso(cursoID, descripcion, numHoras, null, null, null);
                    cursoDAO.actualizar(curso);
                    break;
                case 4:
                    System.out.print("Ingresa el ID del Curso a borrar: ");
                    cursoID = scanner.nextInt();
                    cursoDAO.eliminar(cursoID);
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }
    }
}
