package EPTeste;

import java.io.*;
import java.util.*;

public class No implements Cloneable{
    String valor;
    No prox;
    No ant;
    int cor;  //cor do nó, sendo 0-branco, 1-cinza e 2-preto

    ArrayList<No> vizinhos = new ArrayList<>();

    //construtor do nó
    public No (String elem){
        valor = elem;
        prox = null;
        ant = null;
        cor=0;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    //Adicionando vizinhos a lista, ou seja, em teoria
    public void addVizinho(String valor)
    {
        No vizinho = new No(valor);
        this.vizinhos.add(vizinho); //clonar
    }

    public void imprimirLista(No no)
    {
        System.out.printf("%s:"+no.valor);
        System.out.printf(" %s: "+no.vizinhos);
    }

    public No getClone() {
        try{
            return (No) super.clone();
        }    catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
