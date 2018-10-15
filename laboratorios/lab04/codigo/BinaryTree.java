public class BinaryTree {

    // Sirve como raíz del árbol
    public Node root;
    public void insertarArbol(int[] a){
        for(int i=0;i<a.length;i++){
            insertar(a[i]);
        }
    }

    public void posOrden(){
        helpPosOrden(root);
        //reparar funciona para poder volver a usar posOrden al ingresar nuevos valores al arbol, desmarcando todos los nodos marcados
        reparar(root);
    }
    private void reparar(Node n){
        if(n.left==null && n.right==null){
            n.marca=false;
        }else if(n.left!=null){
            n.left.marca=false;
            reparar(n);
        }else if(n.right!=null){
            n.right.marca=false;
            reparar(n);
        }
    }
    private void helpPosOrden(Node n){
        if(root.marca!=true){
            if(n.left!=null){
                helpPosOrden(n.left);
            }
            if(n.right!=null){
                helpPosOrden(n.right);
            }
            if(n.right==null && n.left==null){
                System.out.println(n.data);
                n.marca=true;
            }
            else if(n.right==null && n.left!=null){
                if(n.left.marca==true){
                    System.out.println(n.data);
                    n.marca=true;
                }
            } else if(n.right!=null && n.left==null){
                if(n.right.marca==true){
                    System.out.println(n.data);
                    n.marca=true;
                }
            }else if(n.right.marca==true && n.left.marca==true){
                System.out.println(n.data);
                n.marca=true;
            }
        }
    }

    /**
     * @param n el dato del nodo que se busca buscar
     * Metodo auxiliar de insetarAux.
     *
     */
    public void insertar(int n) {
        insertarAux(root, n);
    }

    /**
     * @param node es la raíz del arbol
     * @param n el data del nodo que se busca insertar
     * nota: metodo recursivo.
     * Inserta un dato respetando claro las desigualdades en el árbol
     */
    private  void insertarAux(Node node, int n) {
        if(node==null){
            root = new Node(n);
        }else if(n<node.data){
            if(node.left==null){
                Node meow= new Node(n);
                node.left=meow;
            }else{
                insertarAux(node.left , n);
            }
        }else if(n>node.data){
            if(node.right==null){
                Node meow= new Node(n);
                node.right=meow;
            }else{
                insertarAux(node.right , n);
            }
        }
    }

    /**
     * @param n el dato del nodo que se busca.
     * Metodo auxiliar de buscarAux.
     * @return true si el metodo buscarAux es true
     */
    public boolean buscar(int n) {
        return buscarAux(root, n);
    }

    /**
     * @param node es la raíz del arbol
     * @param n el data del nodo que se busca
     * nota: metodo recursivo.
     * Inserta un dato respetando claro las desigualdades en el árbol
     * @return true si se encuentra el elemento en el árbol, false de lo contrario
     */ 

    private boolean buscarAux(Node node, int n) {
        if (node.data == n)
            return true;
        if (node.right == null || node.left == null)
            return false;
        if (n > node.data)
            return buscarAux(node.right, n); 
        else 
            return buscarAux(node.left, n); 
    }

    /**
     * @param n el dato del nodo que se busca borrar.
     * Metodo auxiliar de buscarAux.
     * 
     */
    public void borrar(int n) {
        borrarAux(root, n);
    }

    /**
     * @param node es la raíz del arbol
     * @param n el data del nodo que se busca borrar
     * nota: metodo recursivo.
     * borra un dato respetando claro las desigualdades en el árbol
     */ 
    private Node borrarAux(Node node, int n) {
        return node;
    }

    /*
    Los metodos posteriores son para imprimir el arbol de manera
    que sirven para debuggeo
     */

    /**
     * @param node el nodo desde el cual se imprimirá
     * imprime el arbol desde el nodo node
     */
    private void recursivePrintAUX(Node node)
    {
        if (node != null)
        {
            recursivePrintAUX(node.left);
            recursivePrintAUX(node.right);
            System.out.println(node.data);
        }

    }

    /**
     * Metodo auxiliar de recursivePrintAUX
     *
     */
    public void recursivePrint()
    {
        recursivePrintAUX(root);
    }

}