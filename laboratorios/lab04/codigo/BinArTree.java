public class BinArTree {
   public Node raiz;
   
   public BinArTree(){
       raiz=null;
    }
    
    private int max2(int n, int m)
    {
        if (n > m){
            return n;}
        return m;
    }
    
    public int maxalt()
    {
        return maxaltAUX(raiz);
    }
    private int maxaltAUX(Node node)
    {
        if (node == null)
            return 0;
        else 
            return max2(maxaltAUX(node.izq), maxaltAUX(node.der))+1;
    }
    private void recPrintAUX(Node node)
    {
        if (node != null)
        {
            recPrintAUX(node.der);
            recPrintAUX(node.izq);
            System.out.println(node.dato);
        }

    }
    public void recursivePrint()
    {
        recPrintAUX(raiz);
    }
    public static void abuela(Node str){
        if(str!=null){
            if(str.izq.izq!= null){
                System.out.println("Abuela: "+ str.izq.izq);
            }else{
                System.out.println("Sin Abuela");
            }
        }
    }
}