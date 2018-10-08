import java.util.*;
public class pivote
{
    public int pivote(ArrayList<Integer> lista){
        int sum=0;
        for(int i=0;i<lista.size();i++){
            sum=sum+lista.get(i);
        }
        int pivote=0;
        int ref=0;
        for(int j=0;j<lista.size();j++){
            pivote=pivote+lista.get(j);
            ref=j;
            if(pivote>=sum/2){
                
                break;
            }
        }
        System.out.println("El pivote debe de estar en la posicion "+ref);
        return pivote;
    }
}
