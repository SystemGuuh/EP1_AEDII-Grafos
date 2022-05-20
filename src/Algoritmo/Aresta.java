package Algoritmo;

import java.util.ArrayList;

public class Aresta<T> {
    public Vertice<T> inicio;
    public Vertice<T> fim;
    
    //Construtor da classe
    public Aresta(Vertice<T> inicio, Vertice<T> fim){

        this.inicio = inicio;
        this.fim = fim;
    }

    public Vertice<T> getInicio() {
        return inicio;
    }

    public void setInicio(Vertice<T> inicio) {
        this.inicio = inicio;
    }

    public Vertice<T> getFim() {
        return fim;
    }

    public void setFim(Vertice<T> fim) {
        this.fim = fim;
    }

}
