package EPTeste;

public class No {
    String valor;
    No prox;
    No ant;
    int cor;  //cor do nó, sendo 0-branco, 1-cinza e 2-preto
    No[] vizinhos;

    //construtor do nó
    public No (String elem){
        valor = elem;
        prox = null;
        ant = null;
        cor=0;
    }

}
