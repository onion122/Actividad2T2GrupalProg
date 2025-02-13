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
            System.out.print("Introduce la contrase帽a: ");
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
                throw new IllegalArgumentException("Credenciales inv谩lidas.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

	private static void validarUsuario(String usuario) throws IllegalArgumentException {
        if (!Pattern.matches("^[a-zA-Z0-9]+$", usuario)) {
            throw new IllegalArgumentException("El usuario solo puede contener letras y n煤meros.");
        }
    }

    private static void validarContrasena(String contrasena) throws IllegalArgumentException {
        if (contrasena.length() < 6 || !Pattern.matches(".*\\d.*", contrasena)) {
            throw new IllegalArgumentException("La contrase帽a debe tener al menos 6 caracteres y debe incluir un n煤mero.");
        }
    }
    
	/** El m茅todo calcular, realizar una suma, resta, multiplicaci贸n o divisi贸n 
	 * seg煤n los n煤meros y operador que introduzcamos. Usa la clase Scanner
	 * para obtener los n煤meros.
	 * @param scanner Escanea la operaci贸n y los n煤meros.
	 * @throws IllegalArgumentException Si el n煤mero se divide por 0.
	 * @throws IllegalArgumentException Si el operador no es v谩lido.
	 * @author Javier
	 * @since 2025*/
    private static void calcular(Scanner scanner) {
 
    	System.out.print("Ingrese la operaci贸n (suma, resta, multiplicaci贸n, divisi贸n): ");
    	String operacion = scanner.nextLine(); // scanner de la operaci贸n
    	System.out.print("Ingrese el primer n煤mero: ");
    	double num1 = scanner.nextDouble(); // scanner del primer n煤mero
    	System.out.print("Ingrese el segundo n煤mero: ");
    	double num2 = scanner.nextDouble(); // scanner del segundo n煤mero
    	scanner.close();
    	
    	switch (operacion) { // switch case con la operaci贸n que introduzcamos
        	case "suma": // en el caso de suma suma los dos n煤meros
            	System.out.println("Resultado: " + sumar(num1,num2));
            	break;
        	case "resta": // en el caso de resta los resta
            	System.out.println("Resultado: " + restar(num1,num2));
            	break;
        	case "multiplicaci贸n": // para multiplicaci贸n los multiplica
            	System.out.println("Resultado: " + multiplicar(num1,num2));
            	break;
        	case "divisi贸n": // para divisi贸n los divide
            	if (num2 == 0) { // si se divide entre 0 da error
                	throw new IllegalArgumentException("No se puede dividir por cero.");
            	}
            	System.out.println("Resultado: " + dividir(num1,num2));
            	break;
        	default: // por defecto la operaci贸n no es v谩lida
        		throw new IllegalArgumentException("Operaci贸n no v谩lida.");
    	}
    }
    
    /**
     * Suma dos n鷐eros.
     * @param num1 Primer n鷐ero.
     * @param num2 Segundo n鷐ero.
     * @return La suma de num1 y num2.
     */
    private static double sumar(double num1, double num2) {
        return num1 + num2;
    }

    /**
     * Resta dos n鷐eros.
     * @param num1 Primer n鷐ero.
     * @param num2 Segundo n鷐ero.
     * @return La resta de num1 menos num2.
     */
    private static double restar(double num1, double num2) {
        return num1 - num2;
    }

    /**
     * Multiplica dos n鷐eros.
     * @param num1 Primer n鷐ero.
     * @param num2 Segundo n鷐ero.
     * @return El producto de num1 y num2.
     */
    private static double multiplicar(double num1, double num2) {
        return num1 * num2;
    }

    /**
     * Divide dos n鷐eros.
     * @param num1 Dividendo.
     * @param num2 Divisor.
     * @return El cociente de num1 entre num2.
     * @throws ArithmeticException Si num2 es 0.
     */
    private static double dividir(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("No se puede dividir por cero.");
        }
        return num1 / num2;
    }

    /**
     * Realiza la suma de dos matrices introducidas por el usuario.
     * Las matrices deben tener las mismas dimensiones.
     * @param scanner Objeto Scanner para leer los datos introducidos por el usuario.
     */
    private static void realizarSumaMatrices(Scanner scanner) {
        System.out.print("Introduce el n鷐ero de filas: ");
        int filas = scanner.nextInt();
        System.out.print("Introduce el n鷐ero de columnas: ");
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

