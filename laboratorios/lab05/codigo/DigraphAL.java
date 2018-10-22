import java.util.ArrayList;
import java.util.LinkedList;
import javafx.util.Pair;

/**
 * codigo basado en Hamilton Gómez y Santiago Isaza
 */
public class DigraphAL extends Graph
{
    ArrayList<LinkedList<Pair1>> list = new ArrayList<>();
    public DigraphAL(int size)
    {
        super(size);
        for(int i=0; i<size;i++){
            list.add(new LinkedList());
        }
    }

    public void addArc(int source, int destination, int weight)

    {
        Pair1 pair = new Pair1(destination, weight);
        LinkedList<Pair1> a = list.get(source);
        a.add(pair);
        list.add(source, a);
    }

    public int getWeight(int source, int destination)

    {
        LinkedList<Pair1> a = list.get(source);
        for(int i=0;i<a.size();i++){
            if(a.get(i).vertice == destination){
                return a.get(i).weight;
            }
            break;
        }
        return 0;
    }

    public ArrayList<Integer> getSuccessors(int vertice)
    {
        LinkedList<Pair1> a = list.get(vertice);
        ArrayList<Integer>successors = new ArrayList<>();
        for(int i=0; i<a.size();i++){
            if(a.get(i).weight!=0){
                successors.add(a.get(i).vertice);
            }
        }
        return successors;
    }
}