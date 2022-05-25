package Algoritmo;

import Algoritmo.Grafo.Grafo;
import Algoritmo.Grafo.kosaraju;
import Algoritmo.Matriz.Matriz;
import Algoritmo.Matriz.mKosaraju;

public class casosTeste {
    int casoDeTeste, rep, impressao;
    String[] teste = new String[0]; //Vetor de strings com os recebeimentos para casos te teste
    int cont=0;

    static String[] v; //vai receber os dados do vértice para acelerar a busca

    //Construtor que chama a escolha
    public casosTeste(int i){
        this.casoDeTeste=i;
        dadosCaso();
    }

    //testa para saber se um valor já foi adicionado
    static boolean testaValor(String valor) {
        for (String s : v) {
            if (valor.equals(s)) return false;
        }
        return true;
    }

    //Dadps dp casp de teste
    public void dadosCaso() {
        //Casos de teste
        if(casoDeTeste==1) {
            //Teste 1
            teste = new String[]{"a: b;", "b: c; e; f;", "c: d; f;", "d: c; h;", "e: a; f;", "f: g;", "g: f; h;", "h: h;"};
            this.rep = 8;
            impressao = 2;
        }else if(casoDeTeste==2) {
            //Teste 2
            teste = new String[]{"undershorts: pants; shoes;", "pants: belt; shoes;", "belt: jacket;", "shirt: belt; tie;",
                    "tie: jacket;", "jacket:", "socks: shoes;", "shoes:", "watch:"};
            this.rep = 9;
            impressao = 1;
        }else if(casoDeTeste==3) {
            //Teste 3
            teste = new String[]{"a: b; c;", "b: e;", "c: e;", "e: a;"};
            this.rep = 4;
            impressao = 1;
        }else if(casoDeTeste==4) {
            //Teste problema modelado
            teste = new String[]{"s1: s2;", "s2: s1; s3; s4", "s3: s2; s5", "s4: MS", "s5: MS;", "s6: s7;", "s7: s6; s8;", "s8: ", "MS:"};
            this.rep = 9;
            impressao = 1;
        }else {
            System.out.println("Nenhum caso selecionado");
            System.exit(0);
        }

        //Seleciona o caso em que vamos montar o grafo
        if(impressao == 1){
            addGrafo();
        } else if(impressao == 2){
            addMatriz();
        }else{
            System.out.println("Opção inválida !!");
        }
    }

    //Adiciona entrada no grafo e chama o resto do programa
    public void addGrafo(){
        Grafo<String> grafo = new Grafo<String>(); //grafo principal
        v=new String[rep]; //iniciando o vetor com o tamanho da quantidade de entradas
        for (int k = 0; k < rep; k++) {

            //arruma a entrada em um array por caracter,                        teste[k]= "a: b; c;";
            teste[k] = teste[k].replace(":", "");              //teste[k]= "a b; c";
            teste[k] = teste[k].replace(";", "");              //teste[k]= "a b c";
            String[] vertices = teste[k].split(" ");                      //vertices = {"a","b","c"}

            //testa para saber se o nó foi criado, se não cria
            if (testaValor(vertices[0])) {
                grafo.adicionarVertice(vertices[0]);
                v[cont] = vertices[0];
                cont++;
            }

            //testa para saber se foi criado, se não, cria depois conecta
            for (int i = 1; i < (vertices.length); i++){
                if(testaValor(vertices[i])) {
                    grafo.adicionarVertice(vertices[i]);
                    v[cont] = vertices[i];
                    cont++;
                }
                grafo.adicionarAresta(vertices[0], vertices[i]);
            }
        }

        //cria chama o kosaraju para encontrar os fortemente conectados e imprimir
        kosaraju<String> a = new kosaraju<String>(grafo, rep);
        a.printOT();
    }

    //Adiciona entrada na matriz e chama o resto do programa
    public void addMatriz(){
        Matriz<String> matriz = new Matriz<String>(rep);//matriz principal
        v=new String[rep]; //iniciando o vetor com o tamanho da quantidade de entradas
        for (int k = 0; k < rep; k++) {

            //arruma a entrada em um array por caracter,                        teste[k]= "a: b; c;";
            teste[k] = teste[k].replace(":", "");              //teste[k]= "a b; c";
            teste[k] = teste[k].replace(";", "");              //teste[k]= "a b c";
            String[] vertices = teste[k].split(" ");                      //vertices = {"a","b","c"}

            //testa para saber se o nó foi criado, se não cria
            if (testaValor(vertices[0])) {
                matriz.adicionarVertice(vertices[0]);
                v[cont] = vertices[0];
                cont++;
            }

            //testa para saber se foi criado, se não, cria depois conecta
            for (int i = 1; i < (vertices.length); i++){
                if(testaValor(vertices[i])) {
                    matriz.adicionarVertice(vertices[i]);
                    v[cont] = vertices[i];
                    cont++;
                }
                matriz.adicionarConexao(vertices[0], vertices[i]);
            }
        }

        //cria chama o kosaraju para encontrar os fortemente conectados e imprimir
        mKosaraju<String> a = new mKosaraju<String>(matriz, this.rep);
        a.printOT();
    }
}
