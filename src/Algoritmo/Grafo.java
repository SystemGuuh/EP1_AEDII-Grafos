package Algoritmo;

import java.util.ArrayList;
import java.util.Stack;

public class Grafo<TIPO> {
    public ArrayList<Vertice<TIPO>> vertices;
    public ArrayList<Aresta<TIPO>> arestas;
    
    //Construtor da classe
    public Grafo(){
        this.vertices = new ArrayList<Vertice<TIPO>>();
        this.arestas = new ArrayList<Aresta<TIPO>>();
    }
    
    public void adicionarVertice(TIPO dado){
        Vertice<TIPO> novoVertice = new Vertice<TIPO>(dado);
        this.vertices.add(novoVertice);
    }
    
    public void adicionarAresta(TIPO dadoInicio, TIPO dadoFim){
        Vertice<TIPO> inicio = this.getVertice(dadoInicio);
        Vertice<TIPO> fim = this.getVertice(dadoFim);
        Aresta<TIPO> aresta = new Aresta<TIPO>(inicio, fim);
        inicio.adicionarArestaSaida(aresta);
        fim.adicionarArestaEntrada(aresta);
        this.arestas.add(aresta);
    }
    

    public Vertice<TIPO> getVertice(TIPO dado){
        Vertice<TIPO> vertice = null;
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
        ArrayList<Vertice<TIPO>> marcados = new ArrayList<Vertice<TIPO>>();
        ArrayList<Vertice<TIPO>> fila = new ArrayList<Vertice<TIPO>>();
        Vertice<TIPO> atual = this.vertices.get(0);
        marcados.add(atual);
        System.out.println(atual.getDado());
        fila.add(atual);
        while(fila.size() > 0){
            Vertice<TIPO> visitado = fila.get(0);
            for(int i=0; i < visitado.getArestasSaida().size(); i++){
                Vertice<TIPO> proximo = visitado.getArestasSaida().get(i).getFim();
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
        ArrayList<Vertice<TIPO>> marcados = new ArrayList<Vertice<TIPO>>();
        //ArrayList<Vertice<TIPO>> fila = new ArrayList<Vertice<TIPO>>();
        Vertice<TIPO> visitado;
        Vertice<TIPO> atual;

        for (int k = 0; k <vertices.size(); k++) {
            atual = this.vertices.get(k);
            if(!marcados.contains(atual)) {
                marcados.add(atual);
                System.out.print(atual.getDado() + ": ");
                visitado = marcados.get(k);
                for (int i = 0; i < visitado.getArestasSaida().size(); i++) {
                    Vertice<TIPO> proximo = visitado.getArestasSaida().get(i).getFim();
                    System.out.print(proximo.getDado() + "; ");
                }
                System.out.println("");
            }

        }
    }

    //preenche a pila para execução do algoritmo de kosaraju
    void preencher(Grafo<TIPO> grafo, int i, Stack visitados){

    }

}
