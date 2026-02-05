import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShippingCalculator calculator = new ShippingCalculator();

        double pesoKg = leerDoubleEnRango(
                sc, "Peso del paquete (0.1 - 50.0 kg): ", 0.1, 50.0);

        int distanciaKm = leerIntEnRango(
                sc, "Distancia en km (1 - 2000): ", 1, 2000);

        int tipoServicio = leerIntEnRango(
                sc, "Tipo de servicio (1=Estándar, 2=Express): ", 1, 2);

        boolean zonaRemota = leerBoolean(
                sc, "¿Zona remota? (true/false): ");

        double subtotal = calculator.calcularSubtotal(
                pesoKg, distanciaKm, tipoServicio, zonaRemota);

        double iva = calculator.calcularIVA(subtotal);
        double total = calculator.calcularTotal(subtotal, iva);
        sc.close();
    }
    public static double leerDoubleEnRango(Scanner sc, String mensaje, double min, double max) {
        double valor;
        do {
            System.out.print(mensaje);
            while (!sc.hasNextDouble()) {
                System.out.print("Dato inválido. Intente de nuevo: ");
                sc.next();
            }
            valor = sc.nextDouble();
        } while (valor < min || valor > max);
        return valor;
    }

    public static int leerIntEnRango(Scanner sc, String mensaje, int min, int max) {
        int valor;
        do {
            System.out.print(mensaje);
            while (!sc.hasNextInt()) {
                System.out.print("Dato inválido. Intente de nuevo: ");
                sc.next();
            }
            valor = sc.nextInt();
        } while (valor < min || valor > max);
        return valor;
    }

    public static boolean leerBoolean(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextBoolean()) {
            System.out.print("Solo true o false: ");
            sc.next();
        }
        return sc.nextBoolean();
    }
}
