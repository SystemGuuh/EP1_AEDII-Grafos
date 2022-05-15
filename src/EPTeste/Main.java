package EPTeste;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {

        //Instanciação de parametros, métodos, scannes
        ListaLigada lista = new ListaLigada();
        Scanner ler = new Scanner(System.in);


        //Variáveis
        System.out.println("Digite a entrada:");
        //int repeticao = ler.nextInt(); //variável apra controle da entrada
        int repeticao = 8;
        String[] teste = {"a: b;", "b: c; e; f;", "c: d; f;", "d: c; h;", "e: a; f;", "f: g;", "g: f; h;", "h: h;"};


        ListadeAdj List = new ListadeAdj(repeticao);

        for (int k = 0; k <= repeticao; k++) {
            String[] vertices = " ".split(teste[k]); //cria array separando os espaços
            List.addNo(vertices[0]);
            for (int i = 1; i <= vertices.length; i++) List.lista[i - 1].addVizinho(vertices[i]);
        }

         /*
    1. Se o grafo é fortemente conexo
    2. O número de componentes fortemente conectados
    3. Uma ordenação topológica do grafo de componentes fortemente conectados
    4. A representação em texto do grafo de componentes fortemente conectados
  */

        //Receber e montar gráfico

        //Se o grafo é fortemente conexo

        //O número de componentes fortemente conectados

        //Uma ordenação topológica do grafo de componentes fortemente conectados

        //A representação em texto do grafo de componentes fortemente conectados

        //Fazer Matriz Adjacência

        //Imprimir Matriz Adjacência

        //Fazer Lista Adjacência

        //Imprimir Lista Adjacência
    }
}
