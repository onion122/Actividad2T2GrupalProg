package actividadxProg;
import java.util.Scanner;
import java.util.regex.Pattern;
	
public class ActividadxProg {

    private static final String USUARIO1 = "usuario1";
    private static final String CONTRASENA1 = "clave123";
    private static final String USUARIO2 = "usuario2";
    private static final String CONTRASENA2 = "clave456";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Introduce el usuario: ");
            String usuario = scanner.nextLine();
            System.out.print("Introduce la contraseña: ");
            String contrasena = scanner.nextLine();

            validarUsuario(usuario);
            validarContrasena(contrasena);

            if ((USUARIO1.equals(usuario) && CONTRASENA1.equals(contrasena)) || (USUARIO2.equals(usuario) && CONTRASENA2.equals(contrasena))) {
                if (USUARIO1.equals(usuario)) {
                    realizarOperacionesMatematicas(scanner);
                } else if (USUARIO2.equals(usuario)) {
                    realizarSumaMatrices(scanner);
                }
            } else {
                throw new IllegalArgumentException("Credenciales inválidas.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void validarUsuario(String usuario) throws IllegalArgumentException {
        if (!Pattern.matches("^[a-zA-Z0-9]+$", usuario)) {
            throw new IllegalArgumentException("El usuario solo puede contener letras y números.");
        }
    }

    private static void validarContrasena(String contrasena) throws IllegalArgumentException {
        if (contrasena.length() < 6 || !Pattern.matches(".*\\d.*", contrasena)) {
            throw new IllegalArgumentException("La contraseña debe tener al menos 6 caracteres y debe incluir un número.");
        }
    }

    private static void realizarOperacionesMatematicas(Scanner scanner) {
        System.out.println("Operaciones disponibles: suma, resta, multiplicación, división");
        System.out.print("Introduce la operación: ");
        String operacion = scanner.nextLine();
        System.out.print("Introduce el primer número: ");
        double num1 = scanner.nextDouble();
        System.out.print("Introduce el segundo número: ");
        double num2 = scanner.nextDouble();

        double resultado;
        switch (operacion.toLowerCase()) {
            case "suma":
                resultado = num1 + num2;
                break;
            case "resta":
                resultado = num1 - num2;
                break;
            case "multiplicación":
                resultado = num1 * num2;
                break;
            case "división":
                if (num2 == 0) {
                    System.out.println("Error: División por cero.");
                    return;
                }
                resultado = num1 / num2;
                break;
            default:
                System.out.println("Operación no válida.");
                return;
        }
        System.out.println("El resultado es: " + resultado);
    }

    private static void realizarSumaMatrices(Scanner scanner) {
        System.out.print("Introduce el número de filas: ");
        int filas = scanner.nextInt();
        System.out.print("Introduce el número de columnas: ");
        int columnas = scanner.nextInt();

        int[][] matriz1 = new int[filas][columnas];
        int[][] matriz2 = new int[filas][columnas];

        System.out.println("Introduce los elementos de la primera matriz:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Introduce los elementos de la segunda matriz:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz2[i][j] = scanner.nextInt();
            }
        }

        int[][] matrizResultante = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matrizResultante[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }

        System.out.println("La matriz resultante es:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matrizResultante[i][j] + " ");
            }
            System.out.println();
        }
    }
}

