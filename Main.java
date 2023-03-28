public class Main {
    public static void main(String[] args) {
        Graph grafo = new Graph();

        grafo.aggiungiNodo("A");
        grafo.aggiungiNodo("B");
        grafo.aggiungiNodo("C");
        grafo.aggiungiNodo("D");
        grafo.aggiungiNodo("E");
        grafo.aggiungiNodo("F");

        grafo.aggiungiCollegamento("A", "B", 4);
        grafo.aggiungiCollegamento("A", "C", 2);
        grafo.aggiungiCollegamento("B", "E", 3);
        grafo.aggiungiCollegamento("C", "D", 2);
        grafo.aggiungiCollegamento("C", "F", 4);
        grafo.aggiungiCollegamento("D", "E", 3);
        grafo.aggiungiCollegamento("D", "F", 1);

        grafo.dijkstra("A");
        String s= grafo.toString();
        String percorso = grafo.percorsoVerso("D");


        System.out.println(percorso);
    }

}