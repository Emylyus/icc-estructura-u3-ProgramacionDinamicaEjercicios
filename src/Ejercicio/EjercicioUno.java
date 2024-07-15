package Ejercicio;

import java.util.ArrayList;
import java.util.List;

/*
 * Implementa un método para devolver todos los subconjuntos de un arreglo de enteros
 * 
 * Se puede sin recursividad
 * Ejemplo:
 *  Input: [1,2,3]
 *
 *  Output:
 *    [
 *      [1,2,3],
 *      [1,2],
 *      [1,3],
 *      [2,3],
 *      [1],
 *      [2],
 *      [3],
 *      []
 *    ]
 * 
 * El  metodo me debe devolver una lista de listas de enteros. 
 * Se puede usar varios metodos 
 * 
 * Ecoja la mejor estructura de datos para que sea mas eficiente
 */
public class EjercicioUno {

    
    public List<List<Integer>> subsets(List<Integer> set) {
        List<List<Integer>> result = new ArrayList<>();

        //sacamos el tamaño de n
        int n = set.size();
        
        // Iterar sobre todos los números de 0 a (2^n - 1)
        for (int i = 0; i < (1 << n); i++) {//<< se utiliza para calcular potencias de 2
            List<Integer> subset = new ArrayList<>();
            
            // Construir el subconjunto actual
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    subset.add(set.get(j));
                }
            }
            
            // Agregar el subconjunto actual a la lista de resultados
            result.add(subset);
        }
        
        return result;
    }
    
}
