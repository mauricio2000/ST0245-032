import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import javafx.geometry.Point3D;
import java.util.ArrayList;
import java.lang.Math;
import java.io.PrintWriter;
public class DetectarColisiones{
    static ArrayList<abeja> enjambre = new ArrayList<abeja>(); // este array sirve para saber todas las abejas que se ingresaron
    private ArrayList<abeja> panal= new ArrayList(); 
    static ArrayList <cajon> cajones = new ArrayList<cajon>(); // es el arreglo de cajones donde se escuentran la abeja 
    static ArrayList<Double> hashExi=new ArrayList<Double>(); // para guardadr las llaves de la tabla de hash y comparar si alguna abeja ya tiene una
    // o si ya le toca asignar alguna
    ArrayList<abeja> choques=new ArrayList(); // este arreglo es donde se guardan codas las abejas que tiene peligro de colision
    public DetectarColisiones(File file){
        colisiones(meterEnCajones(leer(file)));
    }

    public static ArrayList meterEnCajones(ArrayList<abeja> todas){
        for(int i=0;i<todas.size() ;i++){
            double x, y, z;
            x=todas.get(i).getX(); // aca se le asignarn la coordenadas a cada abeja
            y=todas.get(i).getY();
            z=todas.get(i).getZ();
            double r=Hash(x, y, z);
            boolean t=false;
            t= revisar(t, r, todas.get(i)); //comparar si ya existe un arraylist para esa abeja
            int index=ind(r);
            enjambre.add(todas.get(i)); // aca cada abeja se agraga al enjambre
            if(t){
                agregarAbeja(index, todas.get(i)); //agregar abeja a un arraylist si ya le existe un cajon
            }else{
                hashExi.add(r); // aca se le crea su propio cajon a la nueva abeja
                cajon c=new cajon();
                c.add(todas.get(i));
                cajones.add(index,c);
            }
        }
        return cajones;
    }

    public ArrayList<abeja> colisiones(ArrayList<cajon> c){
        // este ciclo revisa todos los cajones, si el cajon tiene mas de una abeja agrrega todas las abejas dentro de el al arreglo colsiones
        for(int i=0;i<c.size();i++){
            if(c.get(i).size()>1){
                for(int j=0;j<c.get(i).colmena.size();j++){
                    choques.add(c.get(i).get(j));
                }
            }else{
                // en este caso si hay una sola abeja toca compararla con todas las abejas que hay
                for(int j=0;j<enjambre.size();j++){
                    if(c.get(i).get(0)!= enjambre.get(j) &&  Math.sqrt(  Math.pow((c.get(i).get(0).getX() - enjambre.get(j).getX()),2) +
                        Math.pow((c.get(i).get(0).getY() - enjambre.get(j).getY()),2) +
                        Math.pow(c.get(i).get(0).getZ() - enjambre.get(j).getZ(),2)
                    )<=100){
                        choques.add(c.get(i).get(0));
                        break;
                    }
                }
            }
        }
        System.out.println(choques.size()/2);
        System.out.println(enjambre.size());
        ArrayList<abeja> va= new ArrayList();
        return va;
    }

    public static void agregarAbeja(int ind, abeja a){
        cajones.get(ind).add(a); // este metodo agrega una abeja a un cajon
    }

    public static double Hash(double x, double y, double z){ // este emtodo es el encargado de implementar la funcion hash
        double r;//se inicializa una variable la cual se va a usar para el resultado
        int xi=(int)x;//se les asigna la parte entera de la coordenada
        int yi=(int)y;
        int zi=(int)z;
        xi=(int)x/57; // se revisa en cual cajon debe de ir la abeja segun su cociente con el lado del cubo
        yi=(int)y/57;
        zi=(int)z/57;

        double xo=(double)xi+0.0;//se vuelve double la variable entera para que de un resultado double unico con la funcion hash
        double yo=(double)yi+0.0;
        double zo=(double)zi+0.0;
        r=(double) (((xo)*((17*17*17)/3))*41)+(((yo)*((15*15)/5))*47)+(((zo)*((13*13*13*13*13)/7))*21*53); //funcion hash
        return r;
    }

    public static ArrayList crear(abeja a, String st){
        ArrayList<abeja> str = new ArrayList<abeja>();
        str.add(a); // añade una abeja a un arreglo
        return str;
    }

    public static boolean revisar(boolean t, double r, abeja a){
        //aqui se revisa si ya exise una llave para la tabla de hash
        for(int j=0;j<hashExi.size();j++){
            if(r==hashExi.get(j)){ t=true; break;}
        }
        // si no existe una llave la crea y le asigna un cajon
        if(!t){
            hashExi.add(r);
            cajon c= new cajon();
            c.add(a);
            cajones.add(c);
        }   
        return t;
    }

    public static int ind(double r){
        //si ya existe una llave para la abeja busqca en que posicion se escuentra el cajon al que le corresponde la llave e ingresa la llave ahi
        for(int i=0;i<hashExi.size();i++){
            if(r==hashExi.get(i)){
                return i;
            }
        }
        return -1;
    }

    public ArrayList<abeja> leer(File file){
        // este metodo sirve para leer las coordenadas de las abejas y pasarlas a metros
        try{
            BufferedReader r = new BufferedReader(new FileReader(file));
            String a=r.readLine();
            String[] coordenadas;
            abeja b;
            for(int i=0;(a=r.readLine())!=null;i++){
                coordenadas=a.split(",");
                b=new abeja(Double.parseDouble(coordenadas[0])*111111,
                    Double.parseDouble(coordenadas[1])*111111,
                    Double.parseDouble(coordenadas[2]));
                panal.add(b);
            }
        }catch (IOException e){
            System.out.println("hubo un error leyendo el archivo");
        }
        return panal;
    }

    

    public void guardar(){
        // este metodo se encaraga de guardar el archivo de abejas con posibilidad de colsion
        File file=new File("Colisiones.txt");
        try{
            if(file.exists()){
                file.delete();
            }
            file.createNewFile();
            PrintWriter w=new PrintWriter(file);
            for(int i=0; i<panal.size();i++){

            }
            w.close();
        }catch (IOException e){
            System.out.println("Hubo un erro guardando el archivo");
        }
    }
}