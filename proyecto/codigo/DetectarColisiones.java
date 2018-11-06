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
    static ArrayList<abeja> enjambre = new ArrayList<abeja>();
    private ArrayList<abeja> panal= new ArrayList();
    static ArrayList <cajon> cajones = new ArrayList<cajon>();
    static ArrayList<abeja> mismoCajon = new ArrayList<abeja>();
    static ArrayList<Double> hashExi=new ArrayList<Double>();
    ArrayList<abeja> choques=new ArrayList();
    public DetectarColisiones(File file){
        colisiones(meterEnCajones(leer(file)));
    }
    public static ArrayList meterEnCajones(ArrayList<abeja> todas){
        for(int i=0;i<todas.size() ;i++){
            double x, y, z;
            x=todas.get(i).getX();
            y=todas.get(i).getY();
            z=todas.get(i).getZ();
            double r=Hash(x, y, z);
            boolean t=false;
            t= revisar(t, r, todas.get(i)); //comparar si ya existe un arraylist para esa abeja
            int index=ind(r);
            enjambre.add(todas.get(i));
            if(t){
                agregarAbeja(index, todas.get(i));//agregar abeja a un arraylist
            }else{
                hashExi.add(r);
                cajon c=new cajon();
                c.add(todas.get(i));
                cajones.add(index,c);
            }
        }
        return cajones;
    }
    public ArrayList<abeja> colisiones(ArrayList<cajon> c){
        
        for(int i=0;i<c.size();i++){
            if(c.get(i).size()>1){
                for(int j=0;j<c.get(i).colmena.size();j++){
                    choques.add(c.get(i).get(j));
                }
            }else{
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
        System.out.println(choques.size());
        System.out.println(enjambre.size());
        return choques;
    }
    public static void agregarAbeja(int ind, abeja a){
        cajones.get(ind).add(a);
    }

    public static double Hash(double x, double y, double z){
        double r;
        int xi=(int)x;
        int yi=(int)y;
        int zi=(int)z;
        xi=(int)x/57;
        yi=(int)y/57;
        zi=(int)z/57;
        System.out.println(xi);
        double xo=(double)xi+0.0;
        double yo=(double)yi+0.0;
        double zo=(double)zi+0.0;
        r=(double) (((xo)*((17*17*17)/3))*41)+(((yo)*((15*15)/5))*47)+(((zo)*((13*13*13*13*13)/7))*21*53);
        return r;
    }

    public static ArrayList crear(abeja a, String st){
        ArrayList<abeja> str = new ArrayList<abeja>();
        str.add(a);
        return str;
    }

    public static boolean revisar(boolean t, double r, abeja a){
        for(int j=0;j<hashExi.size();j++){
            if(r==hashExi.get(j)){ t=true; break;}
        }
        if(!t){
            hashExi.add(r);
            cajon c= new cajon();
            
            cajones.add(c);
        }   
        return t;
    }

    public static int ind(double r){
        for(int i=0;i<hashExi.size();i++){
            if(r==hashExi.get(i)){
                return i;
            }
        }
        return -1;
    }
    public ArrayList<abeja> leer(File file){
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
    public void detectar(){
    }
    public void guardar(){
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