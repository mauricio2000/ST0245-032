
import java.util.*;

/**
 * La clase Taller8 tiene la intención de
 * enfatizar en el uso de pilas y colas ya 
 * implementadas en java
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Queue.html"> Ver más acerca de colas<a/>
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html"> Ver más acerca de pilas <a/> 
 * @author Mauricio Toro, Andrés Páez 
 */
public class Taller8 {

    /**
     * @param stack es una pila ya implementada que se crea en el test
     * Este método se encarga de poner la pila stack en orden inverso
     * Nota: recuerde que la funcion pop() no solo expulsa la última 
     * posición de una pila si no que tambien devuelve su valor.
     * @return una pila que haga el inverso de stack
     */
    public static Stack<Integer> inversa (Stack<Integer> stack){
        int n=stack.pop();
        return stack;
    }

    /*
     * @param queue es una cola ya implementada que se crea en el test
     * Este método se encarga de atender a personas.
     * Nota: Se debe imprimir en consola a quién atiende y sacarlo de la cola
     * existe una función "pull" que hace el trabajo más fácil
     * 
     */
    public static void cola (Queue<String> queue){
        System.out.println("ya se atendio a "+queue.poll());
    }

    /**
     * @param string es una cadena de texto que viene de este modo 3 4 5 * + o de esta manera 2 3 * 5 +
     * todo viene separado por espacios por lo que la funcion split.("") vendría muy bien para separarlos
     * Se intenta hacer el calculo por medio del metodo polaco posfijo
     * @return un entero resultado de la operación
     */
    public static int polaca  (String s){
        String []p= s.split(" ");
        Stack<String> q= new Stack<String>();
        String r;
        int n;
        for(int i=0;i<p.length;i++){
            r=p[i];
            if(isInteger(r)){
                q.add(r);
            } else{
                if(r.equals("+")){
                    n= Integer.parseInt(q.get(0))+Integer.parseInt(q.get(1));
                    q.remove(q.get(0));
                    q.remove(q.get(1));
                    q.push(Integer.toString(n));
                }
                if(r.equals("-")){
                    n= Integer.parseInt(q.get(0))-Integer.parseInt(q.get(1));
                    q.remove(q.get(0));
                    q.remove(q.get(1));
                    q.push(Integer.toString(n));
                }
                if(r.equals("*")){
                    n= Integer.parseInt(q.get(0))*Integer.parseInt(q.get(1));
                    q.remove(q.get(0));
                    q.remove(q.get(1));
                    q.push(Integer.toString(n));
                }
                if(r.equals("/")){
                    n= Integer.parseInt(q.get(0))/Integer.parseInt(q.get(1));
                    q.remove(q.get(0));
                    q.remove(q.get(1));
                    q.push(Integer.toString(n));
                }
                if(r.equals("%")){
                    n= Integer.parseInt(q.get(0))%Integer.parseInt(q.get(1));
                    q.remove(q.get(0));
                    q.remove(q.get(1));
                    q.push(Integer.toString(n));
                }
            }

        }
        n=Integer.parseInt(q.get(0));
        return n;
    }
    // tomado de https://stackoverflow.com/questions/5439529/determine-if-a-string-is-an-integer-in-java
    public static boolean isInteger(String s) {
        try { 
            Integer.parseInt(s); 
        } catch(NumberFormatException e) { 
            return false; 
        } catch(NullPointerException e) {
            return false;
        }
        return true;
    }
}