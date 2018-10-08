import java.lang.IndexOutOfBoundsException;
public class Tienda
{
    private nevera first;
    private int size;
    public Tienda()
    {
        size = 0;
        first = null;   
    }
    //metodo sacado del taller 6, metodo getNode
    private nevera getNevera(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < size) {
            nevera temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
    public void insert(int cod, String des)
    {
        nevera temp= new nevera(cod,des);
        if(size==0){
            first=temp;
        }else{
            temp.next=first;
            first=temp;
        }
        size++;
    }
    // metodos sacados del taller de nodos
    public void remove(int index)
    {
        if(index==0){
            first=getNevera(0).next;
            getNevera(0).next=null;
        }else{
            getNevera(index-1).next=getNevera(index).next;
            //getNode(index).next=null;
        }
        size--;
    }
    
    public void asignar(int n){
        for(int i=0;i<size;i=i){
            System.out.println("se ha sacado la nevera con el codigo " +getNevera(0).codigo+ " y descripcion" +getNevera(0).des );
            remove(0);
        }
    }
}
