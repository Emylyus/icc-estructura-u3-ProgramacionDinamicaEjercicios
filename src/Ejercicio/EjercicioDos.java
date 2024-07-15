package Ejercicio;

import java.util.ArrayList;
import java.util.List;

/*
 * Dados n pares de paréntesis, implementa un algoritmo para generar todas las combinaciones
 * válidas de paréntesis.
 *
 * Ejemplo 1:
 *  Input:
 *    n: 1
 *  Output:
 *    ["()"]
 *
 * Ejemplo 2:
 *  Input:
 *    n: 3
 *  Output:
 *    ["((()))","(()())","(())()","()(())","()()()"]
 *
 * Ecoja la mejor estructura de datos para que sea mas eficiente
 * Se debe usar StringBuilder
 */


public class EjercicioDos {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisHelper(n, 0, 0, new StringBuilder(), result);// StringBuilder construir cadenas de caracteres de manera eficiente. A 
                                                                                    //diferencia de la clase String, que es inmutable (es decir, una vez creada, no se puede modificar)
        return result;
    }

    private void generateParenthesisHelper(int n, int open, int close, StringBuilder sb, List<String> result) {
        // Caso base: cuando hemos formado una combinación válida de paréntesis
        if (sb.length() == 2 * n) {
            result.add(sb.toString());
            return;
        }

        // Agregamos '(' si aún hay disponibles
        if (open < n) {
            sb.append('(');
            generateParenthesisHelper(n, open + 1, close, sb, result);
            sb.deleteCharAt(sb.length() - 1); // backtrack
        }

        // Agregamos ')' si es válido (hay más paréntesis abiertos que cerrados)
        if (close < open) {
            sb.append(')');
            generateParenthesisHelper(n, open, close + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1); // backtrack
        }
    }
}

//StringBuilder()-> usa el mismo espacio de memoria
//String-> usa difrente espacio de memoria

