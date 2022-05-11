package principal;

public class No (){

    No prox;
    No anterior;
    String valor;
    String[] vizinho;

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
        this.vizinho[posicao] = valor;
    }

    public String getVizinho(int i) {
        return String.valueOf(vizinho[i]);
    }
}
