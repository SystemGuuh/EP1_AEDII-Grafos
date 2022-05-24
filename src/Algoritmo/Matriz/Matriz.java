package Algoritmo.Matriz;

import java.sql.SQLOutput;
import java.util.ArrayList;
import Algoritmo.Matriz.*;

public class Matriz<T> {
    int[][] matriz; //matriz para armazenar 0 ou 1
    public ArrayList<MatrizVertice<T>> vertices;
    int p; //quantidade de vertices

    //Construtor da classe
    public Matriz(int tamanho){
        this.vertices = new ArrayList<MatrizVertice<T>>();
        this.p = tamanho;
        inicializaMatriz(tamanho);
    }

    //cria a mtriz intera com 0
    public void inicializaMatriz(int tamanho){
        matriz = new int[tamanho][tamanho];
        for(int i=0; i<tamanho; i++){
            for(int j=0; j<tamanho; j++){
                matriz[i][j] = 0;
            }
        }
    }

    //Busca vértices
    public int buscaVertice(T dado){
        int valor;

        for(int i=0; i<vertices.size(); i++){
            if(vertices.get(i).dado.equals(dado)){
                valor = i;
                return valor;
            }
        }
        return -1;
    }

    //Adiciona um vértice
    public void adicionarVertice(T dado) {
        MatrizVertice<T> novoVertice = new MatrizVertice<>(dado);
        this.vertices.add(novoVertice);
    }

    //Adiciona uma conexão entre vértices
    public void adicionarConexao(T dadoInicio, T dadoFim){
        MatrizVertice<T> inicio = this.getVertice(dadoInicio);
        MatrizVertice<T> fim = this.getVertice(dadoFim);
        int nComeco = buscaVertice(dadoInicio); //busca a posição do dado
        int nFim = buscaVertice(dadoFim); //busca a posição do dado
        if(nComeco==-1 || nFim==-1){
            System.out.println("Erro, vértice não encontrado");
            System.exit(0);
        }
        matriz[nComeco][nFim] = 1;
    }

    public MatrizVertice<T> getVertice(T dado){
        MatrizVertice<T> vertice = null;
        for(int i=0; i < this.vertices.size(); i++){
            if (this.vertices.get(i).getDado().equals(dado)){
                vertice = this.vertices.get(i);
                break;
            }
        }
        return vertice;
    }

    public void imprimeMatriz(){
        System.out.print("     ");
        for(int i=0; i<this.p; i++){
            System.out.print(vertices.get(i).dado + "    ");
        }
        System.out.println();

        for(int i=0; i<this.p; i++){
            System.out.print(vertices.get(i).dado + "    ");
            for(int j=0; j<this.p;j++){
                System.out.print(matriz[i][j] + "    ");
            }
            System.out.println("");
        }
    }


}
