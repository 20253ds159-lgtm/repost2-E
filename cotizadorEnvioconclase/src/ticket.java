public class ticket {
    public static void imprimirTicket(double pesoKg, int distanciaKm, int tipoServicio, boolean zonaRemota, double subtotal, double iva, double total) {

        String servicio = (tipoServicio == 1) ? "Estándar" : "Express";

        System.out.println("========== TICKET ==========");
        System.out.println("Servicio: " + servicio);
        System.out.println("Peso: " + pesoKg + " kg");
        System.out.println("Distancia: " + distanciaKm + " km");
        System.out.println("Zona remota: " + zonaRemota);
        System.out.printf("Subtotal: ", subtotal);
        System.out.printf("IVA (16%): ", iva);
        System.out.printf("TOTAL FINAL: ", total);
        System.out.println("============================");
    }
}
