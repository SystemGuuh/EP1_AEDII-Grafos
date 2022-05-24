package Algoritmo.Grafo;

public class recebeGrafo {
    int rep, cont=0;
    String[] teste = new String[0];
    Grafo<String> grafo = new Grafo<String>(); //grafo principal

    static String[] v; //vai receber os dados do vértice para acelerar a busca

    public recebeGrafo(int rep, String[] teste){
        this.rep = rep;
        this.teste = teste;
    }

    //função para saber se um nó já foi criado
    static boolean testaValor(String valor) {
        for (int i = 0; i < v.length; i++) {
            if(valor.equals(v[i])) return false;
        }
        return true;
    }

    public void recebe(){

    }
}
