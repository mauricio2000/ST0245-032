public class abeja{
    boolean c;
    private double x;
    private double y;
    private double z;
    public abeja(double x, double y, double z){
        this.x=x;
        this.y=y;
        this.z=z;
        c=false;   //aca se le asignan las coordenadas a las abejas
    }
    //estos metodos sirven para retornar sus coordenadas en cada dimension
    public double getX(){
        return x;
    }
    
    public double getY(){
        return y;
    }
    
    public double getZ(){
        return z;
    }
}