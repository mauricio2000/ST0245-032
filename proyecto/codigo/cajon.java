import java.util.ArrayList;
public class cajon{
    ArrayList<abeja> colmena= new ArrayList();
    public void add(abeja a){
        colmena.add(a);
    }
    public abeja r(int i){
        return colmena.get(i);
    }
    public int size(){
        return colmena.size();
    }
    public abeja get(int i){
        return colmena.get(i);
    }
}