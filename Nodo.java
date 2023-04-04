import java.util.Comparator;
import java.util.TreeMap;

public class Nodo {
    public String etichetta;
    TreeMap<Nodo,Integer> albero;
    private int pesoNodo = 0;
    int distanza = Integer.MAX_VALUE;
    boolean visitato = false;
    public Nodo preve = null;
    private int pesoPercorso;

    public Nodo(String etichetta) {
        this.etichetta = etichetta;
        albero = new TreeMap<>((a, b) -> a.etichetta.compareTo(b.etichetta));
    }

    public void collegamenti(Nodo nodo2, int peso) {
        albero.put(nodo2, peso);
        nodo2.albero.put(this, peso);
        nodo2.pesoPercorso = pesoPercorso + peso;
    }

    public int pesoTot(Nodo n) {
        return pesoNodo + albero.get(n);
    }

    public String getStrada() {
        String fine = "";
        int pesoPercorso = 0;
        String distanzaStr = "";
        if (distanza < Integer.MAX_VALUE) {
            distanzaStr = Integer.toString(distanza);
        } else {
            distanzaStr = "inf";
        }
        if (preve != null) {
            fine = preve.getStrada();
            int pesoArco = preve.albero.get(this);
            fine += "->(" + preve.etichetta + "," + etichetta + ")" + pesoArco;
            pesoPercorso = preve.pesoPercorso + pesoArco;
        } else {
            pesoPercorso = pesoNodo;
        }
        fine += "->(" + etichetta + "," + distanzaStr + ")";
        return fine + " (Peso totale: " + pesoPercorso + ")";
    }

    Comparator<Nodo> comp = (a, b) -> a.distanza - b.distanza;

    @Override
    public String toString() {
        String s = "";
        s += "Etichetta: " + etichetta + ", ";
        s += "Peso: " + pesoNodo + ", ";
        s += "Distanza: " + distanza;
        return s;
    }
}
