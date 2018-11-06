import java.util.ArrayList;
public class cajon{
    ArrayList<abeja> colmena= new ArrayList();  //este seria el arreglo de abejas que hay dentro de un cajon
    public void add(abeja a){ // sirve para agregar abejas al cajon
        colmena.add(a);
    }
    public abeja r(int i){ 
        return colmena.get(i);
    }
    public int size(){ //muestra el numero de abejas dentro del cajon
        return colmena.size();
    }
    public abeja get(int i){ // devuelve una abeja en cierta posiion del cajon
        return colmena.get(i);
    }
}