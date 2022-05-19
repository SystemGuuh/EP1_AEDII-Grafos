package Algoritmo;

import java.util.ArrayList;

public class Aresta<TIPO> {
    public Vertice<TIPO> inicio;
    public Vertice<TIPO> fim;
    
    //Construtor da classe
    public Aresta(Vertice<TIPO> inicio, Vertice<TIPO> fim){

        this.inicio = inicio;
        this.fim = fim;
    }

    public Vertice<TIPO> getInicio() {
        return inicio;
    }

    public void setInicio(Vertice<TIPO> inicio) {
        this.inicio = inicio;
    }

    public Vertice<TIPO> getFim() {
        return fim;
    }

    public void setFim(Vertice<TIPO> fim) {
        this.fim = fim;
    }

    public int getVertice(Grafo<TIPO> grafo, int j) {
         Vertice<TIPO> a = grafo.vertices.get(j);
        int k=0;
        for (int i=0; i<grafo.arestas.size(); i++){
            if(grafo.arestas.get(i).inicio.equals(a)){
                k++;
            }

        }
        return k;
    }
}
