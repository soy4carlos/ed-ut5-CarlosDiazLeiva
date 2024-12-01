import java.util.Scanner;

// Clase que representa a un estudiante
class Estudiante {
    private String nombre;
    private int edad;
    private double notaFinal; // Nota del estudiante, inicialmente no asignada

    // Constructor de la clase
    public Estudiante(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.notaFinal = -1; // -1 indica que la nota aún no ha sido asignada
    }

    // Método get para obtener nombre
    public String getNombre() {
        return nombre;
    }

    // Método get para obtener edad
    public int getEdad() {
        return edad;
    }

    // Método get para obtener nota
    public double getNotaFinal() {
        return notaFinal;
    }

    // Método get para obtener informacion general
    public String getResumenEstudiante() {
        return "Nombre: " + nombre + ", Edad: " + edad + ", Nota Final: " + (notaFinal == -1 ? "Sin asignar" : notaFinal); // Se indica si la nota no está asignada;
    }

    // Método set para asignar una nota al estudiante
    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }


}

public class GestionEstudiantes {
    private static Estudiante[] estudiantes; // Array para almacenar estudiantes
    private static Scanner scanner = new Scanner(System.in); // Para leer teclado

    public static void main(String[] args) {
        inicializarEstudiantes(); // Crea una lista de estudiantes predefinida
        int opcion;

        // Bucle para mostrar el menú
        do {
            mostrarMenu(); // Muestra las opciones disponibles
            opcion = leerEntero("Selecciona una opción: "); // Leer la opción seleccionada por el usuario
            switch (opcion) {
                case 1:
                    introducirNota(); // Introducir la nota de un estudiante
                    break;
                case 2:
                    calcularNotaMedia(); // Calcular la nota media del curso
                    break;
                case 3:
                    mostrarInformacionEstudiantes(); // Mostrar información de todos los estudiantes
                    break;
                case 4:
                    mostrarEstudiantesPorInicial(); // Mostrar estudiantes por inicial especifica
                    break;
                case 5:
                    System.out.println("Saliendo del programa..."); // Opción para salir
                    break;
                default:
                    System.out.println("Opción no valida. Escoge otra:"); // Opción no válida
            }
        } while (opcion != 5); // Se repite hasta que el usuario elige salir (5)
    }

    // Inicializa el array de estudiantes con valores predefinidos
    private static void inicializarEstudiantes() {
        estudiantes = new Estudiante[]{
                new Estudiante("Ana", 20),
                new Estudiante("Luis", 22),
                new Estudiante("Anastasia", 21),
                new Estudiante("Maria", 19),
                new Estudiante("Carlos", 21),
                new Estudiante("Lucia", 23)
        };
    }

    // Muestra las opciones del menú
    private static void mostrarMenu() {
        System.out.println("Menú");
        System.out.println("1. Introducir nota de un estudiante");
        System.out.println("2. Calcular la nota media del curso");
        System.out.println("3. Mostrar información de los estudiantes");
        System.out.println("4. Mostrar estudiantes por inicial");
        System.out.println("5. Salir del programa");
    }

    // Permite introducir la nota de un estudiante específico
    private static void introducirNota() {
        mostrarNombresEstudiantes(); // Mostrar la lista de estudiantes para seleccionar
        int i_estudiante = leerEntero("Selecciona el número del estudiante: ") - 1; // Para obtener índice del estudiante


        // Repetir hasta que estudiante sea valido
        while (i_estudiante < 0 || i_estudiante >= estudiantes.length)
        {
            i_estudiante = leerEntero("El estudiante no existe. Elige otro: ") - 1; // Leer índice
        }


        double nota = leerDouble("Introduce la nota "+ estudiantes[i_estudiante].getNombre() +" (0-10): "); // Leer la nota

        // Repetir hasta que sea una nota valida
        while (nota < 0 || nota > 10) {
            nota = leerEntero("Nota no valida, introduce un valor ente 0 y 10:"); // Leer índice
        }

        estudiantes[i_estudiante].setNotaFinal(nota); // Asignar la nota al estudiante
        System.out.println("Nota asignada correctamente.\n");



    }

    // Calcula y muestra la nota media de todos los estudiantes
    private static void calcularNotaMedia() {
        double suma = 0; // Acumulador para la suma de las notas
        int contador = 0; // Contador de estudiantes con nota asignada

        // Recorrer el array de estudiantes
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getNotaFinal() != -1) { // Solo contar estudiantes con nota asignada
                suma += estudiante.getNotaFinal();
                contador++;
            }
        }

        // Mostrar la nota media o indicar si no hay notas
        if (contador > 0) {
            System.out.println("La nota media del curso es: " + (suma / contador)+"\n");
        } else {
            System.out.println("No hay notas registradas para calcular la media.\n");
        }
    }

    // Muestra información de todos los estudiantes
    private static void mostrarInformacionEstudiantes() {
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante.getResumenEstudiante()); // Llama al método getResumenEstudiante de cada estudiante
        }
        calcularNotaMedia(); // También muestra la nota media general
    }

    // Muestra los estudiantes cuyos nombres comiencen con una letra específica y nota media de estos
    private static void mostrarEstudiantesPorInicial() {
        String inicial = leerString("Introduce una inicial: ").toUpperCase(); // Leer y convertir a mayúsculas
        boolean encontrado = false; // Para saber si hay coincidencias
        double suma = 0;
        int contador = 0;

        // Recorrer el array buscando coincidencias
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getNombre().toUpperCase().startsWith(inicial)) { // Compara iniciales
                System.out.println(estudiante.getResumenEstudiante()); // Muestra datos del estudiante que coincide
                encontrado = true;
                if (estudiante.getNotaFinal() != -1) {
                    suma += estudiante.getNotaFinal();
                    contador++;
                }
            }
        }

        // Mostrar resultados según las coincidencias
        if (encontrado) {
            if (contador > 0) {
                System.out.println("Nota media de los estudiantes con inicial " + inicial + ": " + (suma / contador)+"\n");
            } else {
                System.out.println("No hay notas registradas para calcular la media.\n");
            }
        } else {
            System.out.println("No se encontraron estudiantes con esa inicial.\n");
        }
    }

    // Muestra solo los nombres de los estudiantes para facilitar la selección
    private static void mostrarNombresEstudiantes() {
        System.out.println("\nLista de estudiantes:");
        for (int i = 0; i < estudiantes.length; i++) {
            System.out.println((i + 1) + ". " + estudiantes[i].getNombre());
        }
    }

    // Lee un número entero con validación
    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) { // Validar que la entrada sea un número entero
            System.out.print("Entrada no valida. " + mensaje);
            scanner.next();
        }
        return scanner.nextInt();
    }

    // Lee un número decimal (double) con validación
    private static double leerDouble(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextDouble()) { // Validar que la entrada sea un número decimal
            System.out.print("Entrada no valida. " + mensaje);
            scanner.next();
        }
        return scanner.nextDouble();
    }

    // Lee una cadena de texto
    private static String leerString(String mensaje) {
        System.out.print(mensaje);
        return scanner.next(); // Leer texto ingresado por el usuario
    }

}
