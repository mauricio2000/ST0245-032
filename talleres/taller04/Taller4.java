/**
 *La clase Taller5 dos tiene como objetivo dar solución al taller5
 *
 *
 *@autor Mauricio Toro, Camilo Paez
 *@version 1
 */
import java.util.concurrent.TimeUnit;
public class Taller5 {

    /**
     * @param array es un arreglo de numeros enteros
     * @param n la longitud del array anterior 
     *
     *en este método se busca hacer la suma de los numeros en un
     *arreglo de forma recursiva.
     *
     * @return la suma
     */
    public static int arrayMax(int[] array, int n) {
        long m = System.currentTimeMillis();
        if(n==array.length){
            long s= System.currentTimeMillis();
            System.out.println(s-m);
            return 0;
        }else{
            return array[n]+arrayMax(array,n+1);
        }
    }

    /**
     * @param start es un contador, nos sirve para saber cuando debemos parar
     * @param array es un arreglo de numeros enteros, representan volumen
     * @param target es la meta, el numero que debe alacanzar la suma 
     *
     * en este método se busca hacer la suma de los volumnes posibles
     * de modo que se acomode de tal forma que se alcance el valor target
     * pista: la clave esta en el numero de elementos y que no siempre se toman
     * los elementos, en ocaciones pasan por ejemplo en un conjuntos [5,6,7,8] para un
     * target 12 se toman el 5 y el 7 pasando por 6 sin cogerlo.
     *
     *
     * @return verdadero si hay una combinación que suponga el valor target, falso de lo contrario
     */
    public static boolean groupSum(int start, int[] nums, int target) {
        if(start==nums.length && target==0) {
            return true;
        }else if (start<nums.length){
            return groupSum(start+1,nums,target-nums[start]) || groupSum(start+1,nums,target);
        }else{ 
            return false;
        }
    }

    
}