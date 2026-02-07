import java.util.Scanner;

public class app {

    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        // Input
        String nombre = leerTextoNoVacio(scanner, "Nombre del alumno: ");
        double p1 = leerDoubleEnRango(scanner, "Calificación parcial 1: ", 0, 100);
        double p2 = leerDoubleEnRango(scanner, "Calificación parcial 2: ", 0, 100);
        double p3 = leerDoubleEnRango(scanner, "Calificación parcial 3: ", 0, 100);
        int asistencia = leerIntEnRango(scanner, "Asistencia: ", 0, 100);
        boolean entregoProyecto = leerBoolean(scanner, "¿Entregó proyecto? (true/false): ");


        // Proceso
        GradeService gradeService = new GradeService();
        double promedio = gradeService.calcularPromedio(p1, p2, p3);
        double calificacionFinal = gradeService.calcularFinal(promedio, asistencia);
        String estado = gradeService.determinarEstado(calificacionFinal, asistencia, entregoProyecto);


        // Output
        imprimirReporte(nombre, p1, p2, p3, promedio, asistencia, entregoProyecto, calificacionFinal, estado);


        scanner.close();
    }


    // Métodos de INPUT
    public static String leerTextoNoVacio(Scanner sc, String mensaje) {
        String texto;
        do {
            System.out.print(mensaje);
            texto = sc.nextLine().trim();
            if (texto.isEmpty()) {
                System.out.println("Error: No puede estar vacío.");
            }
        } while (texto.isEmpty());
        return texto;
    }


    public static double leerDoubleEnRango(Scanner sc, String mensaje, double min, double max) {
        double valor;
        do {
            System.out.print(mensaje);
            try {
                valor = Double.parseDouble(sc.nextLine());
                if (valor < min || valor > max) {
                    System.out.println("Error: Debe estar entre " + min + " y " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ser un número válido.");
                valor = min - 1; // Para forzar la repetición
            }
        } while (valor < min || valor > max);
        return valor;
    }


    public static int leerIntEnRango(Scanner sc, String mensaje, int min, int max) {
        int valor;
        do {
            System.out.print(mensaje);
            try {
                valor = Integer.parseInt(sc.nextLine());
                if (valor < min || valor > max) {
                    System.out.println("Error: Debe estar entre " + min + " y " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ser un número entero válido.");
                valor = min - 1; // Para forzar la repetición
            }
        } while (valor < min || valor > max);
        return valor;
    }


    public static boolean leerBoolean(Scanner sc, String mensaje) {
        String valor;
        do {
            System.out.print(mensaje);
            valor = sc.nextLine().trim().toLowerCase();
            if (!valor.equals("true") && !valor.equals("false")) {
                System.out.println("Error: Debe ser 'true' o 'false'.");
            }
        } while (!valor.equals("true") && !valor.equals("false"));
        return Boolean.parseBoolean(valor);
    }


    public static void imprimirReporte(String nombre, double p1, double p2, double p3, double promedio, int asistencia, boolean entregoProyecto, double calificacionFinal, String estado) {
        System.out.println("\n--- REPORTE FINAL ---");
        System.out.println("Nombre: " + nombre);
        System.out.println("Parciales: " + p1 + ", " + p2 + ", " + p3);
        System.out.println("Promedio: " + promedio);
        System.out.println("Asistencia: " + asistencia + "%");
        System.out.println("Entregó proyecto: " + entregoProyecto);
        System.out.println("Final: " + calificacionFinal);
        System.out.println("Estado: " + estado);
    }
}