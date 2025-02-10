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

    /** El método calcular, realizar una suma, resta, multiplicación o división 
	 * según los números y operador que introduzcamos.
	 * @param num1 Primer número
	 * @param num2 Segundo número
	 * @param operador Operador de suma, resta, multiplicación o división
	 * @return La suma, resta, multiplicación o división
	 * @throws IllegalArgumentException Si el número se divide por 0
	 * @throws IllegalArgumentException Si el operador no es válido*/
	public double calcular(double num1, double num2, String operador) throws IllegalArgumentException {
		
        switch (operador) {
        
            case "+":
            	
                return num1 + num2;
                
            case "-":
            	
                return num1 - num2;
                
            case "*":
            	
                return num1 * num2;
                
            case "/":
            	
                if (num2 == 0) {
                	
                    throw new IllegalArgumentException("División por cero.");
                    
                }
                
                return num1 / num2;
                
            default:
            	
                throw new IllegalArgumentException("Operador no válido.");
                
        }
        
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

