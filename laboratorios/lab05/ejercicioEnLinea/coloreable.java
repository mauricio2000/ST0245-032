import java.util.*;
/**
 * Write a description of class coloreable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class coloreable
{
    public boolean esColoreable(int[][] grafo){
        int [] colores= new int[grafo.length];
        for(int i=0;i<grafo.length;i++){
            colores[i]=0;
        }
        colores[0]=-1;
        for(int i=0;i<grafo.length;i++){
            for(int j=0;j<grafo.length;j++){
                if(grafo[i][j]!=0 && colores[j]==0 && colores[i]==-1){
                    colores[j]=-2;
                }else if(grafo[i][j]!=0 && colores[j]==0 && colores[i]==-2){
                    colores[j]=-1;
                }else if(colores[i]==colores[j] && grafo[i][j]!=0){
                    return false;
                }
            }
        }
        return true;
    }

    /* Title: esColoreable
     * Authors: Mesa, Daniel
     * Date: October 22, 2018
     * Taken from:https:https://github.com/damesaa201710054010/ST0247-032/blob/master/laboratorios/lab01/ejercicioEnLinea/Ejercicio2.java
     */
    public static void main(String[] args)
    {
        coloreable g = new coloreable();
        Scanner console =  new Scanner(System.in);
        int vertices= console.nextInt();
        int cont = 1;
        int edges = 0;
        int origin = 0;
        int destiny = 0;
        while(vertices != 0)
        {
            edges = console.nextInt();
            int [][] graph = new int[vertices][vertices];
            cont = 1;
            while(cont <= edges)
            {
                origin = console.nextInt();
                destiny = console.nextInt();
                graph[origin][destiny] = 1;
                cont++; 
            }
            String res = g.esColoreable(graph)? "BICOLORABLE" : "NOT BICOLORABLE";
            System.out.println(res);
            vertices = console.nextInt();
        }
    }
}
