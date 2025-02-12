package usuariosmatrices;
import java.util.Scanner;
public class UsuariosMatrices {
	
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Solicitar usuario y contraseña
	        System.out.print("Ingrese el usuario: ");
	        String usuario = scanner.nextLine();
	        System.out.print("Ingrese la contraseña: ");
	        String contraseña = scanner.nextLine();

	        // Validar usuario y contraseña
	        if (!usuario.matches("[a-zA-Z0-9]+")) {
	            throw new IllegalArgumentException("El usuario solo puede contener letras y números.");
	        }
	        if (contraseña.length() < 6 || !contraseña.matches(".*\\d.*")) {
	            throw new IllegalArgumentException("La contraseña debe tener al menos 6 caracteres y contener al menos un número.");
	        }

	        // Credenciales simuladas
	        String usuarioAlmacenado = "usuario123";
	        String contraseñaAlmacenada = "contraseña123";

	        // Comparar credenciales
	        if (!usuario.equals(usuarioAlmacenado) || !contraseña.equals(contraseñaAlmacenada)) {
	            throw new IllegalArgumentException("Usuario o contraseña incorrectos.");
	        }

	        // Operaciones matemáticas
	        System.out.print("Ingrese la operación (suma, resta, multiplicación, división): ");
	        String operacion = scanner.nextLine();
	        System.out.print("Ingrese el primer número: ");
	        double num1 = scanner.nextDouble();
	        System.out.print("Ingrese el segundo número: ");
	        double num2 = scanner.nextDouble();

	        switch (operacion) {
	            case "suma":
	                System.out.println("Resultado: " + (num1 + num2));
	                break;
	            case "resta":
	                System.out.println("Resultado: " + (num1 - num2));
	                break;
	            case "multiplicación":
	                System.out.println("Resultado: " + (num1 * num2));
	                break;
	            case "división":
	                if (num2 == 0) {
	                    throw new IllegalArgumentException("No se puede dividir por cero.");
	                }
	                System.out.println("Resultado: " + (num1 / num2));
	                break;
	            default:
	                throw new IllegalArgumentException("Operación no válida.");
	        }

	        // Suma de matrices
	        int[][] matriz1 = {{1, 2}, {3, 4}};
	        int[][] matriz2 = {{5, 6}, {7, 8}};
	        int[][] resultado = sumarMatrices(matriz1, matriz2);

	        System.out.println("Resultado de la suma de matrices:");
	        for (int i = 0; i < resultado.length; i++) {
	            for (int j = 0; j < resultado[i].length; j++) {
	                System.out.print(resultado[i][j] + " ");
	            }
	            System.out.println();
	        }
	    }

	    public static int[][] sumarMatrices(int[][] matriz1, int[][] matriz2) {
	        if (matriz1.length != matriz2.length || matriz1[0].length != matriz2[0].length) {
	            throw new IllegalArgumentException("Las matrices deben tener las mismas dimensiones.");
	        }

	        int[][] resultado = new int[matriz1.length][matriz1[0].length];
	        for (int i = 0; i < matriz1.length; i++) {
	            for (int j = 0; j < matriz1[i].length; j++) {
	                resultado[i][j] = matriz1[i][j] + matriz2[i][j];
	            }
	        }
	        return resultado;
	    }
	}
