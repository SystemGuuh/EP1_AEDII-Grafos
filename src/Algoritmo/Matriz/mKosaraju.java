package Algoritmo.Matriz;

import Algoritmo.Matriz.*;
import java.util.Stack;
import java.util.Iterator;

public class mKosaraju<T> {

    /*VARIÁVEIS*/
    Matriz<T> matriz; //matriz principal
    int quantVert; //quantidade de termos recebidos
    boolean[] visitados;
    Stack pilha = new Stack(); // Pilha

    //Construtor da classe kosaraju
    public mKosaraju(Matriz<T>  matriz, int i){
        this.quantVert = i;
        this.matriz = matriz;
        visitados = new boolean[i];
    }

    /*MÉTODOS*/

    //preenche a pilha com todos os vértices
    void preencher(int i, Stack pilha){
        visitados[i] = true;


        for(int j=quantVert; j>0; j--) {
            if(matriz.matriz[i][j-1] == 1) {
                if (!visitados[j-1]) preencher(j-1, pilha);
            }
        }
        pilha.push(matriz.vertices.get(i).dado);
    }

    //printa a ordenação topológica
    public void printOT()
    {
        Stack stack = new Stack(); //cria uma pilha vazia

        // Marca tadas conexões como não feitas
        for (int i = 0; i < quantVert; i++){
            visitados[i] = false;
        }

        //dando posições para os vertice, assim nos localizamos em relação a pilha
        for (int i=0; i<quantVert; i++){
            matriz.vertices.get(i).setPosicao(i);
        }

        // Coloca os vértices na pilha de acordo com o final
        for (int i = 0; i < quantVert; i++) {
            if (!visitados[i]) {
                preencher(i, stack);
            }
        }

        // Grafo reverso
        copiaGrafo();
        gf = getTransposto(gf);
        // Volta a lista de visitados para falso, usaremos no segundo DFS
        for (int i = 0; i < V; i++) visitados[i] = false;

        // Agora imprimimos na ordem da pilha
        while (!stack.empty())
        {

            // Retira um valor da pilha
            int v = (p-stack.size());
            stack.pop();

            // Printa o componente fortemente conectado
            if (!visitados[v])
            {
                DFS(v, stack);

                resposta = resposta + " ";
                String[] vertice = resposta.split(" ");
                gr.adicionarVertice(vertice[cont]);
                cont++;

            }
        }

        resposta();
    }
}
