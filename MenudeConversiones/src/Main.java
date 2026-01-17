import java.util.Scanner;

public class menudeConversiones {
    public static void main(String[] args) {

        int contadorCelsiusFahrenheit = 0;
        int contadorFahrenheitCelsius = 0;
        int contadorKmMillas = 0;
        int contadorMillasKm = 0;
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú de Conversiones ---");
            System.out.println("1) °C a °F");
            System.out.println("2) °F a °C");
            System.out.println("3) Km a Millas");
            System.out.println("4) Millas a Km");
            System.out.println("5) Salir");
            System.out.print("Selecciona una opción (1-5): ");

            while (!scanner.hasNextInt()) {
                System.out.println("Error: La opción debe ser un número entero.");
                scanner.next(); // Limpiar entrada inválida
                System.out.print("Selecciona una opción válida (1-5): ");
            }
            opcion = scanner.nextInt();

            if (opcion < 1 || opcion > 5) {
                System.out.println("Error: Opción no válida. Debe estar entre 1 y 5.");
                continue; // Volver al inicio del menú
            }
            switch (opcion) {
                case 1:
                    System.out.print("Ingresa la temperatura en °C: ");
                    double celsius = obtenerValorNumericoValido(scanner);
                    double fahrenheit = (celsius * 9/5) + 32;
                    System.out.printf("%.2f °C = %.2f °F%n", celsius, fahrenheit);
                    contadorCelsiusFahrenheit++;
                    break;

                case 2:
                    System.out.print("Ingresa la temperatura en °F: ");
                    double fahr = obtenerValorNumericoValido(scanner);
                    double cels = (fahr - 32) * 5/9;
                    System.out.printf("%.2f °F = %.2f °C%n", fahr, cels);
                    contadorFahrenheitCelsius++;
                    break;

                case 3:
                    System.out.print("Ingresa la distancia en Km: ");
                    double km = obtenerValorNumericoValido(scanner);
                    double millas = km * 0.621371;
                    System.out.printf("%.2f Km = %.2f Millas%n", km, millas);
                    contadorKmMillas++;
                    break;

                case 4:
                    System.out.print("Ingresa la distancia en Millas: ");
                    double mill = obtenerValorNumericoValido(scanner);
                    double kilometros = mill / 0.621371;
                    System.out.printf("%.2f Millas = %.2f Km%n", mill, kilometros);
                    contadorMillasKm++;
                    break;

                case 5:
                    int totalConversiones = contadorCelsiusFahrenheit + contadorFahrenheitCelsius +
                            contadorKmMillas + contadorMillasKm;
                    System.out.println("\n--- Resumen de Conversiones ---");
                    System.out.println("Total de conversiones realizadas: " + totalConversiones);
                    System.out.println("°C a °F: " + contadorCelsiusFahrenheit);
                    System.out.println("°F a °C: " + contadorFahrenheitCelsius);
                    System.out.println("Km a Millas: " + contadorKmMillas);
                    System.out.println("Millas a Km: " + contadorMillasKm);
                    System.out.println("¡Hasta luego!");
                    break;
            }
        } while (opcion != 5);

        scanner.close();
    }

    /**
     * Valida que la entrada sea numérica y la retorna como double
     */
    private static double obtenerValorNumericoValido(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.println("Error: El valor ingresado no es numérico. Inténtalo de nuevo.");
            scanner.next(); // Limpiar entrada inválida
            System.out.print("Ingresa un valor válido: ");
        }
        return scanner.nextDouble();
    }
}