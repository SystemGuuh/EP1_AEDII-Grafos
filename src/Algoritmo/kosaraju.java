package Algoritmo;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Stack;
import java.util.ArrayList;

public class kosaraju<TIPO> {

     int p;
    Grafo<TIPO> grafo;
    boolean[] visitados;
    Stack pilha = new Stack(); // Classe Pilha
    int i=0;

    kosaraju(Grafo <TIPO>grafo, int rep){
        this.grafo = grafo;
        this.p=rep;
        visitados = new boolean[p];
    }

    Grafo<TIPO> getTransposto(){
        Grafo<TIPO> g = new Grafo<TIPO>();
        g.vertices = grafo.vertices;


        for (int v = 0; v < grafo.vertices.size(); v++){

            int i = grafo.vertices.get(v).getArestasSaida().size();
            while(i!=0){
                g.adicionarAresta(grafo.vertices.get(i).getDado(), grafo.vertices.get(v).getDado());
                i--;
        }


        }
        return g;
    }


    void preencher(int v, Stack pilha){
        visitados[v] = true;
        int i = grafo.vertices.get(v).getArestasSaida().size();
        while (i!=0){
            if(!visitados[i]) preencher(i, pilha);
            i--;
        }
        pilha.push(grafo.vertices.get(v).getArestasSaida().get(i));
    }

    // Função recursiva para imprimir vértices fortemente conectados
    void DFS(int v, Stack stack)
    {
        // Mark the current node as visited and print it
        visitados[stack.size()] = true;

        System.out.print(grafo.vertices.get(v).getDado() + ": ");

        int n;

        // Recur for all the vertices adjacent to this vertex
        int i = grafo.vertices.get(v).getArestasSaida().size();
        while (i>0 && (stack.size())>0){
            n = stack.size()-1;
            if (!visitados[n]) {
                System.out.print(grafo.vertices.get(n).getDado() + "; ");
                stack.pop();
            }
            i--;
        }
    }

    //printa a ordenação topológica
    void printOT()
    {
        Stack stack = new Stack();
        int V =  p;
        // Mark all the vertices as not visited (For first DFS)
        for (int i = 0; i < visitados.length; i++){
            visitados[i] = false;
        }

        // Fill vertices in stack according to their finishing
        // times
        for (int i = 0; i < V; i++)
            if (!visitados[i]) {
                preencher(i, stack);
            }
        // Create a reversed graph

        Grafo gr = getTransposto();

        // Mark all the vertices as not visited (For second DFS)
        for (int i = 0; i < V; i++) visitados[i] = false;


        grafo.imprimeBonito();
        // Now process all vertices in order defined by Stack
        /*while (!stack.empty())
        {
            // Pop a vertex from stack
           int v = (stack.size()-1);
           stack.pop();

            // Print Strongly connected component of the popped vertex
            if (!visitados[v])
            {
                DFS(v, stack);
                System.out.println("");
            }
        }*/
    }
}
