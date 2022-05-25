package Algoritmo.Matriz;

import Algoritmo.Matriz.*;
import java.util.Stack;
import java.util.Arrays;

public class mKosaraju<T> {

    /*VARIÁVEIS*/
    Matriz<T> matriz; //matriz principal
    Matriz<T> matrizInversa;  //grafo auxiliar
    Matriz<String> matrizForte; //matriz de elementos fortemente conectados
    int quantVert; //quantidae de termos recebidos
    int cont =0; //contador para cria a matrizForte
    boolean[] visitados; //array para marcar os visitados
    Stack pilha = new Stack(); // Pilha
    String resposta = ""; //recebe a resposta dos vértices fortemente conectados

    //Construtor da classe kosaraju
    public mKosaraju(Matriz<T>  matriz, int i){
        this.quantVert = i;
        this.matriz = matriz;
        visitados = new boolean[i];
        matrizInversa = new Matriz<T>(quantVert);
        matrizForte = new Matriz<String>(quantVert);
    }

    /*MÉTODOS*/

    //cria as arestas dos grafo fortemente conectado **DIFICULDADE**
    public void criaGrafoForte() {
        for(int l1=0; l1<quantVert; l1++){ //pra linha da matriz principal
            for(int c1=0; c1<quantVert; c1++) { //pra coluna da matriz principal
                if(matriz.matriz[l1][c1] == 1){
                    for(int l2=0; l2<matrizForte.p; l2++) { //pra linha da matriz principal
                        for (int c2 = 0; c2 < matrizForte.p; c2++) { //pra coluna da matriz principal
                            if(matrizForte.vertices.get(l2).dado.contains((CharSequence) matriz.vertices.get(l1).dado)
                                    && matrizForte.vertices.get(c2).dado.contains((CharSequence) matriz.vertices.get(c1).dado)
                                        && !(matrizForte.vertices.get(l2).dado.contains((CharSequence) matrizForte.vertices.get(c2).dado))){
                                matrizForte.matriz[l2][c2] =1;
                            }
                        }
                    }
                }
            }
        }
    }

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

    //Gera o transposto na matriz que copiamos
    public void getTransposto(){
        //cria e coloca os vértices
        for(int i=0; i<quantVert; i++){
            matrizInversa.adicionarVertice(matriz.vertices.get(i).dado);
            matrizInversa.vertices.get(i).posicao = i;
        }

        //invete as conexões
        for (int l=0; l<quantVert; l++) {
            for(int c=0; c<quantVert; c++) {
                if(matriz.matriz[l][c] == 1){
                    matrizInversa.matriz[c][l] = 1;
                }
            }
        }
    }

    // Função recursiva para imprimir vértices fortemente conectados
    void DFS(int v, Stack stack){
        // Marco o nó como visitado
        visitados[v] = true;
        resposta = resposta+matrizInversa.vertices.get(v).getDado();
        int m; //variável pra receber as posições das arestas de sáida


        //recusão para adjacentes
        for (int c = 0; c < quantVert; c++) {
            if (matrizInversa.matriz[v][c] == 1) {
                m = matrizInversa.vertices.get(c).posicao;
                if (!visitados[c]) DFS(m, stack);
            }
        }
    }

    //Imprime a repsosta identada
    public void resposta(){
        System.out.println("");

        //Checa se o grafo é fortemente conexo, atravez da contagem de vértices fortemente conectados
        if(cont == 1) System.out.println("Sim");
        else System.out.println("Não");

        System.out.println(cont);
        System.out.println(resposta);
        System.out.println("");

        criaGrafoForte();
        matrizForte.imprimeMatriz();
    }

    //printa a ordenação topológica
    public void printOT()
    {
        Stack stack = new Stack(); //cria uma pilha vazia

        // Marca tadas conexões como não feitas
        Arrays.fill(visitados, false);

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
        getTransposto();


        // Volta a lista de visitados para falso, usaremos no segundo DFS
        Arrays.fill(visitados, false);

        // Agora imprimimos na ordem da pilha
        while (!stack.empty())
        {
            // Retira um valor da pilha
            int v = (quantVert-stack.size());
            stack.pop();

            // Printa o componente fortemente conectado
            if (!visitados[v])
            {
                DFS(v, stack);

                resposta = resposta + " ";
                String[] vertice = resposta.split(" ");
                matrizForte.adicionarVertice(vertice[cont]);
                cont++;

            }
        }
        matrizForte.p = cont; //coloca a quantiade de vértices
        matrizForte.inicializaMatriz(matrizForte.vertices.size()); //reinicia a matriz com a quantidade de vértices
        resposta();
    }
}
