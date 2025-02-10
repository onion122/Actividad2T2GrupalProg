package usuariosmatrices;

public class Usuarios {
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
	
}
