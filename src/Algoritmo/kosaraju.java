package Algoritmo;

import java.util.Stack;
import java.util.ArrayList;
import java.util.Iterator;

public class kosaraju<TIPO> {

    int p; //quantidade de vertices
    int cont=0; //quantidade de vertices fortemente conectados
    int impressao; //impressão matricial ou igual como recebemos
    String resposta = ""; //recebe a resposta dos vértices fortemente conectados
    Grafo<TIPO> grafo;
    Grafo<TIPO> gf = new Grafo<TIPO>();
    boolean[] visitados;
    Stack pilha = new Stack(); // Classe Pilha
    int i=0;
    Iterator<TIPO> it;

    kosaraju(Grafo <TIPO>grafo, int rep, int impressao){
        this.grafo = grafo;
        this.p=rep;
        visitados = new boolean[p];
        this.impressao = impressao;
    }

    //Imprime a repsosta identada
    public void resposta(int cont){
        String[] vertices = resposta.split(" ");
        System.out.println("");

        //Checa se o grafo é fortemente conexo, atravez da contagem de vértices fortemente conectados
        if(cont == 1) System.out.println("Sim");
        else System.out.println("Não");

        System.out.println(cont);
        System.out.println(resposta);
    }

    //Cria uma cópia do grafo original
    public void copiaGrafo(){
        for(int i=0; i<p; i++){
            gf.adicionarVertice(grafo.vertices.get(i).dado);
        }

        for (int i=0; i<p; i++){
            gf.vertices.get(i).posicao = i;
        }
    }

    //Gera o transposto no grafo que copiamos
    Grafo<TIPO> getTransposto(Grafo<TIPO> gf) {
        for (int v = 0; v < p; v++) {
            int n = grafo.vertices.get(v).getArestasSaida().size();
            while(n>0){
                gf.adicionarAresta(grafo.vertices.get(v).arestasSaida.get(n-1).fim.dado, grafo.vertices.get(v).getDado());
                n--;
            }

        }
        return gf;
    }

    //Preenche a pilha com os valores do grafo original
    void preencher(int i, Stack pilha){
        visitados[i] = true;

        //int i = grafo.vertices.get(k).getArestasSaida().size();
        it = (Iterator<TIPO>) grafo.vertices.get(i).arestasSaida.iterator();
        int n = grafo.vertices.get(i).getArestasSaida().size();
        while(it.hasNext()){
            it.next();
            int posicao = grafo.vertices.get(i).arestasSaida.get(n-1).getFim().posicao;
            if(!visitados[posicao]) preencher(posicao, pilha);
            n--;
        }
        pilha.push(grafo.vertices.get(i).dado);
    }

    // Função recursiva para imprimir vértices fortemente conectados
    void DFS(int v, Stack stack)
    {
        // Marco o nó como visitado
        visitados[v] = true;
        resposta = resposta + gf.vertices.get(v).getDado();
        int m; //variável pra receber as posições das arestas de sáida

        // Recursão para os adjacentes
        int n = gf.vertices.get(v).getArestasSaida().size();
        while(n>0){
            m = gf.vertices.get(v).arestasSaida.get(n-1).getFim().posicao;
            if (!visitados[m]) {
                DFS(m, stack);
            }
            n--;

        }
    }

    //printa a ordenação topológica
    void printOT()
    {
        Stack stack = new Stack(); //cria uma pilha vazia
        int V =  p; //V = a quantidade de vértices

        // Marca todos os vértices como não visitados para o preencher
        for (int i = 0; i < visitados.length; i++){
            visitados[i] = false;
        }

        //dando posições para os vertice, assim nos localizamos em relação a pilha
        for (int i=0; i<V; i++){
            grafo.vertices.get(i).posicao = i;
        }

        // Coloca os vértices na pilha de acordo com o final
        for (int i = 0; i < V; i++)
            if (!visitados[i]) {
                preencher(i, stack);
            }

        // Grafo reverso
        copiaGrafo();
        gf = getTransposto(gf);

        // Volta a lista de visitados para falso, usaremos no segundo DFS
        for (int i = 0; i < V; i++) visitados[i] = false;

        // Agora imprimimos na ordem da pilha
        while (!stack.empty())
        {

            // Pop a vertex from stack
           int v = (p-stack.size());
           stack.pop();

            // Print Strongly connected component of the popped vertex
            if (!visitados[v])
            {
                DFS(v, stack);

                resposta = resposta + " ";
                cont++;
            }
        }

        resposta(cont);
        //gf.imprimeBonito();
    }
}
