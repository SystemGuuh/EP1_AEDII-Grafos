package Algoritmo;

import Algoritmo.Grafo.Grafo;
import Algoritmo.Grafo.kosaraju;
import Algoritmo.Grafo.recebeGrafo;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        //Scanner e variável para recebimento
        Scanner ler = new Scanner(System.in);
        int casoDeTeste;


        System.out.print("Selecione o caso de teste:");
        casoDeTeste = ler.nextInt();
        casosTeste escolha = new casosTeste(casoDeTeste);

    }
}