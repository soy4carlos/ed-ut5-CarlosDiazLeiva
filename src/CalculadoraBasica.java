import java.util.Scanner;

public class CalculadoraBasica {
    public static void main (String[] args){

        int opcion, num1Suma, num2Suma, num1Resta, num2Resta, divisor, dividendo, base, exponente, numFactorial;

        //Inicializamos Scanner para leer teclado
        Scanner scanner = new Scanner(System.in);

        //Bucle do-while para mostrar el menú y ejecutar operaciones hasta que el usuario elija salir
        do {
            //Menú de opciones de la calculadora
            System.out.println("Calculadora Básica de Números Enteros");
            System.out.println("1. Sumar dos números");
            System.out.println("2. Restar dos números");
            System.out.println("3. Potencia (base y exponente)");
            System.out.println("4. Dividir dos números");
            System.out.println("5. Calcular factorial de un número positivo");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            //Lee la opción seleccionada por el usuario
            opcion = scanner.nextInt();


            //Switch para ejecutar la operación seleccionada en el menu
            switch (opcion) {
                case 1:
                    //Solicita los números para sumar y muestra el resultado
                    System.out.print("Ingresa el primer número: ");
                    num1Suma = scanner.nextInt();
                    System.out.print("Ingresa el segundo número: ");
                    num2Suma = scanner.nextInt();
                    //Realiza y muestra el resultado de la suma
                    System.out.println("El resultado de la suma " + num1Suma + "+" + num2Suma +" es: " + sumar(num1Suma, num2Suma));
                    break;
                case 2:
                    //Solicita los números para restar y muestra el resultado
                    System.out.print("Ingresa el primer número: ");
                    num1Resta = scanner.nextInt();
                    System.out.print("Ingresa el segundo número: ");
                    num2Resta = scanner.nextInt();
                    //Realiza y muestra el resultado de la resta
                    System.out.println("El resultado de la resta " + num1Resta + "-"+ num2Resta +" es: " + restar(num1Resta, num2Resta));
                    break;
                case 3:
                    //Solicita la base y el exponente para calcular la potencia
                    System.out.print("Ingresa la base: ");
                    base = scanner.nextInt();
                    System.out.print("Ingresa el exponente: ");
                    exponente = scanner.nextInt();
                    //Realiza y muestra el resultado del número elevado a un exponente
                    System.out.println("El resultado de " + base + " elevado a " + exponente + " es: " + potencia(base, exponente));
                    break;
                case 4:
                    //Solicita el dividendo y divisor para realizar la división
                    System.out.print("Ingresa el dividendo: ");
                    dividendo = scanner.nextInt();
                    System.out.print("Ingresa el divisor: ");
                    divisor = scanner.nextInt();

                    //Validación para evitar dividir por cero
                    if (divisor == 0) {
                        //While que aparece hasta que el usuario introduce un valor diferente a 0
                        while (divisor == 0) {
                            System.out.print("No se puede dividir por cero. Introduce un número válido: ");
                            divisor = scanner.nextInt();
                        }
                    }
                    //Realiza y muestra el resultado de la división
                    System.out.println("El resultado de la división " + dividendo + "/" + divisor + " es: " + dividir(dividendo, divisor));
                    break;
                case 5:
                    //Solicita un número positivo para calcular su factorial
                    System.out.print("Ingresa un número positivo para calcular su factorial: ");
                    numFactorial = scanner.nextInt();

                    //Validación para que el número no sea negativo
                    if (numFactorial < 0) {
                        //While que aparece hasta que el usuario introduce un número que no sea negativo
                        while (numFactorial < 0) {
                            System.out.print("El número no puede ser negativo. Introduce un número válido: ");
                            numFactorial = scanner.nextInt();
                        }
                    }
                    //Realiza y muestra el resultado del calculo factorial
                    System.out.println("El factorial de " + numFactorial + " es: " + factorial(numFactorial));

                    break;
                case 6:
                    //Opción para salir del programa
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    //Mensaje de error si la opción no es válida
                    System.out.println("Opción no válida. Elige una opción valida.");
            }
            System.out.println(); //Salto de línea para separar
        } while (opcion != 6); //El bucle y el programa termina si el usuario elige la opción 6

        //Cierra Scanner
        scanner.close();
    }


    //Método para sumar dos números enteros
    public static int sumar(int a, int b) {
        return a + b;
    }

    //Método para restar dos números enteros
    public static int restar(int a, int b) {
        return a - b;
    }

    //Método para calcular la potencia de un número
    public static int potencia(int base, int exponente) {
        int resultado = 1;
        for (int i = 0; i < exponente; i++) {
            resultado *= base;
        }
        return resultado;
    }

    //Método para dividir dos números enteros
    public static double dividir(int dividendo, int divisor) {
        return (double) dividendo / divisor;
    }

    //Método para calcular el factorial de un número entero positivo
    public static int factorial(int n) {
        if (n == 0) {
            return 1; //El factorial de 0 es 1
        } else {
            return n * factorial(n - 1); //Llamada recursiva para el cálculo del factorial
        }
    }
}