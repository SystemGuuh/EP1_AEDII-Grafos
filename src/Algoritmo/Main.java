package Algoritmo;

import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static String[] v;
    //função para saber se um nó já foi criado
    static boolean testaValor(String valor) {
        for (int i = 0; i < v.length; i++) {
            if(valor.equals(v[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int rep =8, cont=0;
        Grafo<String> grafo = new Grafo<String>();
        String[] teste = {"a: b;", "b: c; e; f;", "c: d; f;", "d: c; h;", "e: a; f;", "f: g;", "g: f; h;", "h: h;"};
        v = new String[rep];

        for (int k = 0; k < rep; k++) {

            //arruma a entrada em um array por caracter
            teste[k] = teste[k].replace(":", "");
            teste[k] = teste[k].replace(";", "");
            String[] vertices = teste[k].split(" "); //cria array separando os espaços

            //testa para saber se o nó foi criado
            if (testaValor(vertices[0])) {
                grafo.adicionarVertice(vertices[0]);
                v[cont] = vertices[0];
                cont++;
            }

            for (int i = 1; i < (vertices.length); i++){
                if(testaValor(vertices[i])) {
                    grafo.adicionarVertice(vertices[i]);
                    v[cont] = vertices[i];
                    cont++;
                }
                grafo.adicionarAresta(vertices[0], vertices[i]);
            }
        }

        //Função que imprime do mesmo jeito da entrada
        grafo.imprimeBonito();

        System.out.println("");

        kosaraju<String> a = new kosaraju<String>(grafo, rep);
        a.printOT();

        //grafo.buscaEmLargura();


    }


}



