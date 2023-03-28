import java.util.Comparator;
import java.util.TreeMap;
import java.util.Vector;

public class Nodo {
    public String etichetta;
    TreeMap<Nodo,Integer> albero;
    private int pesoNodo;
    int distanza=Integer.MAX_VALUE;
    boolean visitato=false;
    public Nodo preve=null;

    String fine;

    public int getDistanza() {
        return distanza;
    }

    public int getPeso() {
        return pesoNodo;
    }


    public Nodo(String etichetta){
        this.etichetta=etichetta;
        albero=new TreeMap<>((a,b)-> a.etichetta.compareTo(b.etichetta));

    }
    public void collegamenti(Nodo nodo2, int peso){
        albero.put(nodo2,peso);
        nodo2.albero.put(this,peso);
    }
    public int pesoTot(Nodo n){
        return pesoNodo + albero.get(n);
    }

    public String getStrada(){
        fine=" ";
        String distanza =" ";
        if(this.distanza<Integer.MAX_VALUE){
            distanza+=this.distanza;

        }else{
            distanza="inf";
        }
        if(preve != null)
            fine= preve.getStrada() + "-" + preve.albero.get(this) + "-->";

            fine += "("+ etichetta + "-" + distanza + ")";

        return fine;
    }
    Comparator <Nodo> comp = (a,b)->{
        return a.distanza - b.distanza;
    };

    @Override
    public String toString() {
        String s="";
        s+=etichetta+ " ";
        s+=pesoNodo +" ";
        s+=distanza +" ";
        return s;
    }
}
