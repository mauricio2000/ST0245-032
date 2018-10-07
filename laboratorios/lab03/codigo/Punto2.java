import java.util.*;
/**
 * TRABAJO REFERENCIADO DE: Santiago Isaza Cadavid Y Hamilton Smith Gómez Osorio 
 */
public class Punto2
{
    public static String linea(String str){
        List<String> listo = new ArrayList<>();
        boolean especial= true;
        int ind=0;
        String newString="";
        for(int i=0;i<str.length();i++){
            if(str.substring(i,i+1).equals("[")){
                especial=true;
                ind=0;
            }
            else if(str.substring(i,i+1).equals("]")){
                especial=false;
            }else if(!str.substring(i,i+1).equals("[") && !str.substring(i,i+1).equals("]")){
                if(especial){
                    listo.add(ind,str.substring(i,i+1));
                    ind++;
                }else{
                    listo.add(str.substring(i,i+1));
                }
            }
        }
        
        for(int i=0;i<listo.size();i++){
            newString= newString+listo.get(i);
        }
        
        return newString;
    }
}