import java.util.Scanner;
public class ActividadSwitchCalculadora {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Seleccione una operación:");
        System.out.println("1) Sumar");
        System.out.println("2) Restar");
        System.out.println("3) Multiplicar");
        System.out.println("4) Dividir");

        System.out.print("Opción: ");
        int opcion = sc.nextInt();

        System.out.print("a: ");
        double a = sc.nextDouble();

        System.out.print("b: ");
        double b = sc.nextDouble();

        double resultado;

        switch (opcion) {

            case 1:
                resultado = a + b;
                System.out.println("Operación: Sumar");
                System.out.println("Valores ingresados: a = " + a + ", b = " + b);
                System.out.println("Resultado: " + resultado);
                break;

            case 2:
                resultado = a - b;
                System.out.println("Operación: Restar");
                System.out.println("Valores ingresados: a = " + a + ", b = " + b);
                System.out.println("Resultado: " + resultado);
                break;

            case 3:
                resultado = a * b;
                System.out.println("Operación: Multiplicar");
                System.out.println("Valores ingresados: a = " + a + ", b = " + b);
                System.out.println("Resultado: " + resultado);
                break;

            case 4:
                System.out.println("Operación: Dividir");
                System.out.println("Valores ingresados: a = " + a + ", b = " + b);

                if (b == 0) {
                    System.out.println("No se puede dividir entre cero");
                } else {
                    resultado = a / b;
                    System.out.println("Resultado: " + resultado);
                }
                break;

            default:
                System.out.println("Opción inválida");
                break;
        }

        sc.close();
    }
}

