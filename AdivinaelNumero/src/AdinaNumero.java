import java.util.Scanner;
import java.util.Random;
public class AdinaNumero {
static int numericos = 0;
static int letras = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int numeroSecreto = rand.nextInt(100) + 1; // 1 a 100
        int intentos = 0;
        int maxIntentos = 7;

        boolean gano = false;


        System.out.println(" Adivina el número secreto (1 a 100)");
        System.out.println("Tienes máximo " + maxIntentos + " intentos.");

        while (intentos < maxIntentos && !gano) {
            System.out.print("\nIntento " + (intentos + 1) + ": ");

            if (!sc.hasNextInt()) {
                System.out.println("Entrada no numérica. Intenta de nuevo.");
                letras++;

                sc.next();
                continue;
            }

            int numeroUsuario = sc.nextInt();
            // aqui va la validacion para aber si el dato ingreado en numerico

            if (numeroUsuario < 1 || numeroUsuario > 100) {
                System.out.println("Número fuera de rango (1 a 100).");
                numericos++;

                continue;
            }

            intentos++;

            if (numeroUsuario == numeroSecreto) {
                System.out.println("¡Ganaste!");
                System.out.println("los datos fuera de rango son : "+ numericos);
                System.out.println("los datosno no  numericos son: "+ letras);
                gano = true;
            } else if (numeroUsuario < numeroSecreto) {
                System.out.println("El número secreto es MAYOR.");
            } else {
                System.out.println("El número secreto es MENOR.");
            }
        }

        System.out.println("\n Resumen del juego:");
        System.out.println("Intentos usados: " + intentos);


        if (!gano) {
            System.out.println("Perdiste. El número secreto era: " + numeroSecreto);
            System.out.println("los datosno no  numericos son: "+ letras);
            System.out.println("los datos fuera de rango son : "+ numericos);
        }

        sc.close();
    }
}
