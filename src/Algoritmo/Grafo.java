package Algoritmo;

import java.util.ArrayList;
import java.util.Stack;

public class Grafo<T> {
    public ArrayList<Vertice<T>> vertices;
    public ArrayList<Aresta<T>> arestas;
    
    //Construtor da classe
    public Grafo(){
        this.vertices = new ArrayList<Vertice<T>>();
        this.arestas = new ArrayList<Aresta<T>>();
    }
    
    public void adicionarVertice(T dado){
        Vertice<T> novoVertice = new Vertice<T>(dado);
        this.vertices.add(novoVertice);
    }
    
    public void adicionarAresta(T dadoInicio, T dadoFim){
        Vertice<T> inicio = this.getVertice(dadoInicio);
        Vertice<T> fim = this.getVertice(dadoFim);
        Aresta<T> aresta = new Aresta<T>(inicio, fim);
        inicio.adicionarArestaSaida(aresta);
        fim.adicionarArestaEntrada(aresta);
        this.arestas.add(aresta);
    }
    

    public Vertice<T> getVertice(T dado){
        Vertice<T> vertice = null;
        for(int i=0; i < this.vertices.size(); i++){
            if (this.vertices.get(i).getDado().equals(dado)){
                vertice = this.vertices.get(i);
                break;
            }
        }
        return vertice;
    }

    //busca e impressão em largura
    public void buscaEmLargura(){
        ArrayList<Vertice<T>> marcados = new ArrayList<Vertice<T>>(); //vertices visitados
        ArrayList<Vertice<T>> fila = new ArrayList<Vertice<T>>(); //vertices que precisam ser visitados
        Vertice<T> atual = this.vertices.get(0);
        marcados.add(atual);//elementos para visitar na busca em largura
        System.out.println(atual.getDado());
        fila.add(atual);
        while(fila.size() > 0){
            Vertice<T> visitado = fila.get(0);
            for(int i=0; i < visitado.getArestasSaida().size(); i++){
                Vertice<T> proximo = visitado.getArestasSaida().get(i).getFim();
                if (!marcados.contains(proximo)){ //se o vértice ainda não foi marcado
                    marcados.add(proximo);
                    System.out.println(proximo.getDado());
                    fila.add(proximo);
                }
            }
            fila.remove(0);
        }
    }

    //Imprime o grafo da mesma forma que recebemos o valor
    public void imprimeBonito() {
        ArrayList<Vertice<T>> marcados = new ArrayList<Vertice<T>>();

        Vertice<T> visitado;
        Vertice<T> atual;

        for (int k = 0; k <vertices.size(); k++) {
            atual = this.vertices.get(k);
            if(!marcados.contains(atual)) {
                marcados.add(atual);
                System.out.print(atual.getDado() + ": ");
                visitado = marcados.get(k);
                for (int i = 0; i < visitado.getArestasSaida().size(); i++) {
                    Vertice<T> proximo = visitado.getArestasSaida().get(i).getFim();
                    System.out.print(proximo.getDado() + "; ");
                }
                System.out.println("");
            }

        }
    }



}
