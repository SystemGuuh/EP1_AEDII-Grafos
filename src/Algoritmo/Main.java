package Algoritmo;

import java.util.Scanner;

public class Main {

    static String[] v; //vai receber os dados do vértice para acelerar a busca

    //função para saber se um nó já foi criado
    static boolean testaValor(String valor) {
        for (int i = 0; i < v.length; i++) {
            if(valor.equals(v[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        //Variáveis, Scannes e Objetos
        Scanner ler = new Scanner(System.in);
        Grafo<String> grafo = new Grafo<String>(); //grafo principal
        int cont=0, impressao=1, rep=0, casoDeTeste=1;
        String[] teste = new String[0]; //Vetor de strings com os recebeimentos para casos te teste

        System.out.print("Selecione o caso de teste:");
        casoDeTeste = ler.nextInt();

        //Casos de teste
        if(casoDeTeste==1) {
            //Teste 1
            teste = new String[]{"a: b;", "b: c; e; f;", "c: d; f;", "d: c; h;", "e: a; f;", "f: g;", "g: f; h;", "h: h;"};
            rep = 8;
            impressao = 2;
        }else if(casoDeTeste==2) {
            //Teste 2
            teste = new String[]{"undershorts: pants; shoes;", "pants: belt; shoes;", "belt: jacket;", "shirt: belt; tie;",
                    "tie: jacket;", "jacket:", "socks: shoes;", "shoes:", "watch:"};
            rep = 9;
            impressao = 1;
        }else if(casoDeTeste==3) {
            //Teste 3
            teste = new String[]{"a: b; c;", "b: e;", "c: e;", "e: a;"};
            rep = 4;
            impressao = 1;
        }else if(casoDeTeste==4) {
            //Teste problema modelado
            teste = new String[]{"s1: s2;", "s2: s1; s3; s4", "s3: s2; s5", "s4: MS", "s5: MS;", "s6: s7;", "s7: s6; s8;", "s8: ", "MS:"};
            rep = 9;
            impressao = 1;
        }else {
            System.out.println("Nenhum caso selecionado");
            System.exit(0);
        }

        v=new String[rep]; //iniciando o vetor com o tamanho da quantidade de entradas
        for (int k = 0; k < rep; k++) {

            //arruma a entrada em um array por caracter,             teste[k]= "a: b; c;";
            teste[k] = teste[k].replace(":", "");  //teste[k]= "a b; c";
            teste[k] = teste[k].replace(";", "");  //teste[k]= "a b c";
            String[] vertices = teste[k].split(" ");          //vertices = {"a","b","c"}

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
        kosaraju<String> a = new kosaraju<String>(grafo, rep, impressao);
        a.printOT();
    }

}