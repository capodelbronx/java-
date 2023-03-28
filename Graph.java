import java.util.*;

public class Graph {
    private TreeMap<String, Nodo> nodi;

    public Graph() {
        nodi = new TreeMap<>();
    }

    public void aggiungiNodo(String etichetta) {
        nodi.put(etichetta, new Nodo(etichetta));
    }

    public void aggiungiCollegamento(String etichetta1, String etichetta2, int peso) {
        Nodo nodo1 = nodi.get(etichetta1);
        Nodo nodo2 = nodi.get(etichetta2);
        nodo1.collegamenti(nodo2, peso);
    }

    public void dijkstra(String source) {
        Nodo nodoSource = nodi.get(source);
        nodoSource.distanza = 0;

        PriorityQueue<Nodo> coda = new PriorityQueue<>(nodi.size(), nodoSource.comp);
        coda.add(nodoSource);

        while (!coda.isEmpty()) {
            Nodo nodoCorrente = coda.poll();
            nodoCorrente.visitato = true;

            for (Nodo nodoVicino : nodoCorrente.albero.keySet()) {
                int pesoArco = nodoCorrente.albero.get(nodoVicino);
                int pesoTotale = nodoCorrente.pesoTot(nodoVicino);

                if (!nodoVicino.visitato && pesoTotale < nodoVicino.distanza) {
                    coda.remove(nodoVicino);
                    nodoVicino.distanza = pesoTotale;
                    nodoVicino.preve = nodoCorrente;
                    coda.add(nodoVicino);
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Nodo nodo : nodi.values()) {
            sb.append(nodo.etichetta).append(": ");
            for (Nodo vicino : nodo.albero.keySet()) {
                sb.append("(").append(vicino.etichetta).append(", ").append(nodo.albero.get(vicino)).append(") ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public String percorsoVerso(String destinazione) {
        Nodo nodoDestinazione = nodi.get(destinazione);
        String percorso = nodoDestinazione.getStrada();
        return "Percorso da A a " + destinazione + ": " + (percorso);
    }

}
