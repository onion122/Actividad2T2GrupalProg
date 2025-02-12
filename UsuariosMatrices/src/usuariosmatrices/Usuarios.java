package usuariosmatrices;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Usuarios {
	
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
                    calcular(scanner);
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
	 * según los números y operador que introduzcamos. Usa la clase Scanner
	 * para obtener los números.
	 * @param scanner Escanea la operación y los números.
	 * @throws IllegalArgumentException Si el número se divide por 0.
	 * @throws IllegalArgumentException Si el operador no es válido.
	 * @author Javier
	 * @since 2025*/
    private static void calcular(Scanner scanner) {
 
    	System.out.print("Ingrese la operación (suma, resta, multiplicación, división): ");
    	String operacion = scanner.nextLine(); // scanner de la operación
    	System.out.print("Ingrese el primer número: ");
    	double num1 = scanner.nextDouble(); // scanner del primer número
    	System.out.print("Ingrese el segundo número: ");
    	double num2 = scanner.nextDouble(); // scanner del segundo número
    	scanner.close();
    	
    	switch (operacion) { // switch case con la operación que introduzcamos
        	case "suma": // en el caso de suma suma los dos números
            	System.out.println("Resultado: " + sumar(num1,num2));
            	break;
        	case "resta": // en el caso de resta los resta
            	System.out.println("Resultado: " + restar(num1,num2));
            	break;
        	case "multiplicación": // para multiplicación los multiplica
            	System.out.println("Resultado: " + multiplicar(num1,num2));
            	break;
        	case "división": // para división los divide
            	if (num2 == 0) { // si se divide entre 0 da error
                	throw new IllegalArgumentException("No se puede dividir por cero.");
            	}
            	System.out.println("Resultado: " + dividir(num1,num2));
            	break;
        	default: // por defecto la operación no es válida
        		throw new IllegalArgumentException("Operación no válida.");
    	}
    }
    
    private static double sumar(double num1, double num2) {
    	return num1 + num2;
    }
    
    private static double restar(double num1, double num2) {
    	return num1 - num2;
    }
    
    private static double multiplicar(double num1, double num2) {
    	return num1 * num2;
    }
    
    private static double dividir(double num1, double num2) {
    	return num1 / num2;
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
