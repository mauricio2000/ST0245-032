import java.util.*;

public class Laboratory2 {
    public static ArrayList<Integer> lista;
    public static int size;
    
    public static void smartInsert(ArrayList<Integer> lista, int data){
        size=lista.size();
        boolean sePuede=true;
        for(int i=0;i<size;i++){
            if(data==lista.get(i)){
              sePuede=false;
              break;
            }
        }
        if(sePuede){
            lista.add(data);
        }else{
            System.out.println("el valor ingresado ya se encuentra en la lista");
        }
    }

    

    /**
     * Tests the methods.
     * @param args
     */
    public static void main(String[] args) {
        //pruebas
        ArrayList<Integer> a = new ArrayList<>();
        a.addAll(Arrays.asList(new Integer[] {1, 4, 9, 16}));
        smartInsert(a, 25);
        ArrayList<Integer> b = new ArrayList<>();
        b.addAll(Arrays.asList(new Integer[] {3, 7, 10, 13, 16, 19}));
        smartInsert(b, 19);
        

       
    }
}