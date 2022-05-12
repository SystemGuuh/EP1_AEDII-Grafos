package principal;

public class No {

    No prox; //próximo valor da lista
    No anterior; //valor da lista anterior ao nó atual
    String valor; //valor que guardaremos do nó
    int Cor;  //cor do nó, sendo 0-branco, 1-cinza e 2-preto
    No[] vizinho; //array com vizinhos

    public No(String[] valor, int n) {
        this.valor = valor[0];
        for(int i=0; i<=n;i++){ setVizinho(valor[i], i); }
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public void setVizinho(String valor, int posicao) {
        this.vizinho[posicao].valor = valor;
    }

    public String getVizinho(int i) {
        return String.valueOf(vizinho[i]);
    }
}
