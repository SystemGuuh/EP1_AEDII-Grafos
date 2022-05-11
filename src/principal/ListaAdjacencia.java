package principal;
import java.util.*;

public class ListaAdjacencia{
    private No primeiro, noatual;
    Scanner ler = new Scanner(System.in);

    //construtor da lista
    ListaAdjacencia(){
        noatual = null;
        primeiro = null;
    }

    //retor true ou false para saber se tem nó inicial
    public boolean isVazia() {
        return (primeiro == null);
    }

    //cria lista de adjacencia
    public void addNO(String valor) {
        String[] vertice = valor.split(" "); //cria array separando os espaços
        No novoNo = new No(vertice, (vertice.length-1)); //cria um novo nó com (n-1) espaços para filhos

        if (isVazia()) { //se a lista tiver vazia o novo nó será o primeiro
            primeiro = novoNo;
            noatual = novoNo;
            novoNo.prox = null;
            novoNo.anterior = null;
        }else { //se a lista não for vazia, o novo nó será o próximo do anterior
            noatual.prox = novoNo;
            novoNo.anterior = noatual;
            noatual = novoNo;
        }
    }

    //mostra a lista de adjacencia
    public void listar(){


    }

}

