
package dependencias;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final ArrayList<Empleado> empleados = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");
            switch (opcion) {
                case 1 -> registrarEmpleado();
                case 2 -> listarEmpleados();
                case 3 -> listarPorDependencia();
                case 4 -> calcularNomina();
                case 5 -> buscarEmpleadoPorId();
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("\n===== MENU GLOBALTECH =====");
        System.out.println("1. Registrar empleado");
        System.out.println("2. Listar todos los empleados");
        System.out.println("3. Listar por dependencia");
        System.out.println("4. Calcular nómina total");
        System.out.println("5. Buscar empleado por ID");
        System.out.println("0. Salir");
    }

    // FUNCIONES DEL MENÚ
    
    private static void registrarEmpleado() {
        System.out.println("\nSeleccione dependencia:");
        System.out.println("1) Ventas\n2) Soporte\n3) Desarrollo\n4) RRHH\n5) Finanzas\n6) Marketing\n7) Logística\n8) Producción\n9) Calidad\n10) I+D");
        int dep = leerEntero("Dependencia (1-10): ");

        String id = leerCadena("ID: ");
        String nombre = leerCadena("Nombre: ");
        double salario = leerDouble("Salario: ");

        try {
            Empleado e = switch (dep) {
                case 1 -> new EmpleadoVentas(id, nombre, salario, leerDouble("Comisión: "));
                case 2 -> new EmpleadoSoporte(id, nombre, salario, leerCadena("Nivel: "));
                case 3 -> new EmpleadoDesarrollo(id, nombre, salario, leerCadena("Lenguaje principal: "));
                case 4 -> new EmpleadoRecursosHumanos(id, nombre, salario, leerCadena("Especialidad: "));
                case 5 -> new EmpleadoFinanzas(id, nombre, salario, leerCadena("Área contable: "));
                case 6 -> new EmpleadoMarketing(id, nombre, salario, leerCadena("Canal: "));
                case 7 -> new EmpleadoLogistica(id, nombre, salario, leerCadena("Turno: "));
                case 8 -> new EmpleadoProduccion(id, nombre, salario, leerCadena("Línea: "));
                case 9 -> new EmpleadoCalidad(id, nombre, salario, leerCadena("Norma: "));
                case 10 -> new EmpleadoInvestigacionDesarrollo(id, nombre, salario, leerCadena("Proyecto: "));
                default -> null;
            };

            if (e != null) {
                empleados.add(e);
                System.out.println("Empleado registrado con éxito.");
            } else {
                System.out.println("Dependencia no válida.");
            }
        } catch (Exception ex) {
            System.out.println("Error al registrar: " + ex.getMessage());
        }
    }

    private static void listarEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            System.out.println("\n--- LISTA DE EMPLEADOS ---");
            empleados.forEach(e -> System.out.println(e.mostrarInfo()));
        }
    }

    private static void listarPorDependencia() {
        int dep = leerEntero("Ingrese número de dependencia (1-10): ");
        System.out.println("\n--- EMPLEADOS DE LA DEPENDENCIA " + dep + " ---");
        for (Empleado e : empleados) {
            if ((dep == 1 && e instanceof EmpleadoVentas) ||
                (dep == 2 && e instanceof EmpleadoSoporte) ||
                (dep == 3 && e instanceof EmpleadoDesarrollo) ||
                (dep == 4 && e instanceof EmpleadoRecursosHumanos) ||
                (dep == 5 && e instanceof EmpleadoFinanzas) ||
                (dep == 6 && e instanceof EmpleadoMarketing) ||
                (dep == 7 && e instanceof EmpleadoLogistica) ||
                (dep == 8 && e instanceof EmpleadoProduccion) ||
                (dep == 9 && e instanceof EmpleadoCalidad) ||
                (dep == 10 && e instanceof EmpleadoInvestigacionDesarrollo)) {
                System.out.println(e.mostrarInfo());
            }
        }
    }

    private static void calcularNomina() {
        double total = empleados.stream().mapToDouble(Empleado::getSalario).sum();
        System.out.println("Nómina total: $" + total);
    }

    private static void buscarEmpleadoPorId() {
        String idBuscado = leerCadena("Ingrese ID a buscar: ");
        for (Empleado e : empleados) {
            if (e.getId().equalsIgnoreCase(idBuscado)) {
                System.out.println("Empleado encontrado: " + e.mostrarInfo());
                return;
            }
        }
        System.out.println("No se encontró empleado con ID: " + idBuscado);
    }

    // MÉTODOS AUXILIARES
    
    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Intente de nuevo.");
            }
        }
    }

    private static double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Intente de nuevo.");
            }
        }
    }

    private static String leerCadena(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String input = sc.nextLine();
            if (!input.trim().isEmpty()) {
                return input;
            }
            System.out.println("Entrada inválida. No puede estar vacío.");
        }
    }
}