void main() {
    int contadorCelsiusFahrenheit = 0;
    int contadorFahrenheitCelsius = 0;
    int contadorKmMillas = 0;
    int contadorMillasKm = 0;
    Scanner scanner = new Scanner(System.in);
    int opcion;
    do {
        IO.println("\n--- Menú de Conversiones ---");
        IO.println("1) °C a °F");
        IO.println("2) °F a °C");
        IO.println("3) Km a Millas");
        IO.println("4) Millas a Km");
        IO.println("5) Salir");
        IO.print("Selecciona una opción (1-5): ");

        while (!scanner.hasNextInt()) {
            IO.println("Error: La opción debe ser un número entero.");
            scanner.next();
            IO.print("Selecciona una opción válida (1-5): ");
        }
        opcion = scanner.nextInt();

        if (opcion < 1 || opcion > 5) {
            IO.println("Error: Opción no válida. Debe estar entre 1 y 5.");
            continue;
        }
        switch (opcion) {
            case 1:
                IO.print("Ingresa la temperatura en °C: ");
                double celsius = obtenerValorNumericoValido(scanner);
                double fahrenheit = (celsius * 9 / 5) + 32;
                System.out.printf("%.2f °C = %.2f °F%n", celsius, fahrenheit);
                contadorCelsiusFahrenheit++;
                break;

            case 2:
                IO.print("Ingresa la temperatura en °F: ");
                double fahr = obtenerValorNumericoValido(scanner);
                double cels = (fahr - 32) * 5 / 9;
                System.out.printf("%.2f °F = %.2f °C%n", fahr, cels);
                contadorFahrenheitCelsius++;
                break;

            case 3:
                IO.print("Ingresa la distancia en Km: ");
                double km = obtenerValorNumericoValido(scanner);
                double millas = km * 0.621371;
                System.out.printf("%.2f Km = %.2f Millas%n", km, millas);
                contadorKmMillas++;
                break;

            case 4:
                IO.print("Ingresa la distancia en Millas: ");
                double mill = obtenerValorNumericoValido(scanner);
                double kilometros = mill / 0.621371;
                System.out.printf("%.2f Millas = %.2f Km%n", mill, kilometros);
                contadorMillasKm++;
                break;

            case 5:
                int totalConversiones = contadorCelsiusFahrenheit + contadorFahrenheitCelsius +
                        contadorKmMillas + contadorMillasKm;
                IO.println("\n--- Resumen de Conversiones ---");
                IO.println("Total de conversiones realizadas: " + totalConversiones);
                IO.println("°C a °F: " + contadorCelsiusFahrenheit);
                IO.println("°F a °C: " + contadorFahrenheitCelsius);
                IO.println("Km a Millas: " + contadorKmMillas);
                IO.println("Millas a Km: " + contadorMillasKm);
                IO.println("¡Hasta luego!");
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
        IO.println("Error: El valor ingresado no es numérico. Inténtalo de nuevo.");
        scanner.next(); // Limpiar entrada inválida
        IO.print("Ingresa un valor válido: ");
    }
    return scanner.nextDouble();
}