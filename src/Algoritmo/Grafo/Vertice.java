package Algoritmo.Grafo;

import java.util.ArrayList;
import Algoritmo.Grafo.*;

public class Vertice<T> {
    public T dado;
    public ArrayList<Aresta<T>> arestasEntrada;
    public ArrayList<Aresta<T>> arestasSaida;
    public int posicao;
    
    //Construtor da classe
    public Vertice(T valor){
        this.dado = valor;
        this.arestasEntrada = new ArrayList<Aresta<T>>();
        this.arestasSaida = new ArrayList<Aresta<T>>();
    }

    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }
    
    public void adicionarArestaEntrada(Aresta<T> aresta){
        this.arestasEntrada.add(aresta);
    }
    
    public void adicionarArestaSaida(Aresta<T> aresta){
        this.arestasSaida.add(aresta);
    }

    public ArrayList<Aresta<T>> getArestasEntrada() {
        return arestasEntrada;
    }

    public ArrayList<Aresta<T>> getArestasSaida() {
        return arestasSaida;
    }

}
