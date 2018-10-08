import java.lang.IndexOutOfBoundsException; // Usar esto cuando se salga el índice
// Una lista simplemente enlazada
public class LinkedListMauricio {
    private Node first;
    private int size;
    public LinkedListMauricio()
    {
        size = 0;
        first = null;   
    }

    /**
     * Returns the node at the specified position in this list.
     * @param index - index of the node to return
     * @return the node at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    private Node getNode(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < size) {
            Node temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index - index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    public int get(int index) throws IndexOutOfBoundsException {
        return getNode(index).data;
    }

    // Retorna el tamaño actual de la lista
    public int size()
    {
        return size;
    }

    // Inserta un dato en la posición index
    public void insert(int data, int index)
    {
        Node temp= new Node(data);
        if(size==0){
            first=temp;
        }else if(index==0){
            temp.next=first;
            first=temp;
        }else{
            temp.next=getNode(index-1).next;
            getNode(index-1).next=temp; 
        }
        size++;
    }

    // Borra el dato en la posición index
    public void remove(int index)
    {
        if(index==0){
            getNode(0).next=null;
        }else{
            getNode(index-1).next=getNode(index).next;
            //getNode(index).next=null;
        }
        size--;
    }

    // Verifica si está un dato en la lista
    /**for (int i = 0; i < size; i++) {
    if(getNode(i).data==data){
    return true;
    }
    }
    return false;
    }  un intento fallido O(n^2)
     */
    public boolean contains(int data)
    {
        return containsRec(data,getNode(0));
    }
    private boolean containsRec(int data, Node temp){
        if (temp == null)

            return false;
        else {
            if (temp.data == data)
                return true;
            else
                return containsRec(data, temp.next);
        }
    }
}