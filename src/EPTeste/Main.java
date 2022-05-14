package EPTeste;
import java.util.Scanner;

public class Main {
        public static void main (String args[]) {

            //Instanciação de parametros, métodos, scannes
            ListaLigada lista = new ListaLigada();
            Scanner ler = new Scanner(System.in);

            //Variáveis
            System.out.println("Digite a entrada:");
            int repeticao = ler.nextInt(); //variável apra controle da entrada

            /*for (int k = 0; k <= repeticao; k++) {
                String entrada = ler.nextLine();
                String[] vertices = " ".split(entrada); //cria array separando os espaços
                //esse for tá dando erro, não sei porque
                for (int i = 0; i <= vertices.length; i++) lista.inserirMeio(vertices[i], i);
            }*/

            //CASO DE TESTE:
            lista.inserirInicio("a:");
            lista.inserirMeio("b;", 0);

            lista.inserirInicio("b:");
            lista.inserirMeio("c;", 0);
            lista.inserirMeio("e:", 1);
            lista.inserirMeio("f;", 2);

            lista.inserirInicio("c:");
            lista.inserirMeio("d;", 0);
            lista.inserirMeio("f:", 1);

            lista.inserirInicio("d:");
            lista.inserirMeio("c;", 0);
            lista.inserirMeio("h:", 1);

            lista.inserirInicio("e:");
            lista.inserirMeio("a;", 0);
            lista.inserirMeio("f:", 1);

            lista.inserirInicio("f:");
            lista.inserirMeio("g;", 0);

            lista.inserirInicio("g:");
            lista.inserirMeio("f;", 0);
            lista.inserirMeio("h:", 1);

            lista.inserirInicio("h:");
            lista.inserirMeio("h;", 1);

            lista.mostrarLista( "a" );
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
