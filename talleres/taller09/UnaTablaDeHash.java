import javafx.util.Pair;
import java.util.*;
/**
* La clase UnaTablaDeHash, es un plantilla para crear nuestra propia estructura hash
* Dentro de sus características esta que tiene un string como llave (key) y un entero
* como valor (value)
* @author Mauricio Toro, Andres Paez
* @version 1
*/
public class UnaTablaDeHash
{
   /*
   * Utilizamos array por simplicidad sin embargo el uso de este no permite manejar coliciones
   * de manera eficiente, por lo cual esta primera versión de hash no implementa colisiones, esta
   * característica se implementará posteriormente.
   */
    //private ArrayList<LinkedList<Pair<String,Integer>>> tabla;
    private int[]tabla;


   /**
   * Este método define el array utilizado con 10 posiciones de manera que tenemos un límite de 10 elementos
   * La usamois de 27 posiciones por cada letra del abecedario incluyendo la "ñ"
   */
   public UnaTablaDeHash(){
      tabla = new int[10];
   }

   /**
   * @param k es la llave del elemento que servirá como referencia al buscar
   * Este método se utiliza para darle una posicion dentro de la tabla, donde el %10 asegura que solo
   * se utilicen digitos de 0 a 10.
   */
   private int funcionHash(String k){
       return ((int) k.charAt(0)) % 10 ;
   }

   /**
   * @param k es la llave del elemento que servirá como referencia al buscar
   * Este método se utiliza para obtener el elmento con la clave k, se enlaza con funcionHash
   */
   public int get(String k){
       return tabla[funcionHash(k)];
   }

   /**
   * @param k es la llave del elemento que servirá como referencia al buscar posteriormente
   * @param v es el valor asociado a la llave k
   * Este método se utiliza para agregar un nuevo elemento
   */
   public void put(String k, int v){
       tabla[funcionHash(k)]=v;
   }
}