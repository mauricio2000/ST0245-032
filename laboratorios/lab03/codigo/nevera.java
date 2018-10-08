
public class nevera
{
    public int codigo;
    public String des;
    public nevera next;
    //des es la descripcion de la nevera
    public nevera(int codigo, String des){
        next = null;
        this.codigo=codigo;
        this.des=des;
    }

    public int cod(){
        return codigo;
    }

    public String descri(){
        return des;
    }
}
