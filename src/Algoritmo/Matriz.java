package Algoritmo;

public class Matriz<TIPO> {
    int[][] matriz;
    Grafo<TIPO> grafo;
    int quantEntrada, tamanho;

    //Construtor da classe
    Matriz(Grafo<TIPO> grafo, int q){
        this.grafo = grafo;
        this.quantEntrada = q;
        this.matriz = new int[grafo.vertices.size()][grafo.vertices.size()];
        tamanho = grafo.vertices.size();

        //zerando a matriz
        for(int h=0; h<tamanho; h++){
            for (int b=0;b<tamanho; b++) matriz[h][b] = 0;
        }

        //setando a posição para montar a matriz
        for(int i=0; i<tamanho; i++) grafo.vertices.get(i).posicao = i;
    }

    //preenche o grafo com os valores conectados
    public void marcaVertices(){
        for(int i=0; i<tamanho; i++){
            for(int j=0;j<grafo.vertices.get(i).arestasSaida.size();j++){
                matriz[i][grafo.vertices.get(i).arestasSaida.get(j).fim.posicao] =1;
            }
        }
    }

    //printa o grafo
    public void printaGrafo(){
        marcaVertices();

        System.out.print("  ");
        for(int h=0; h<tamanho; h++){
            System.out.print("  "+grafo.vertices.get(h).dado);
        }
        System.out.println();

        for(int h=0; h<tamanho; h++){
            System.out.print(grafo.vertices.get(h).dado);
            for (int b=0;b<tamanho; b++) System.out.print("  " + matriz[h][b]);
            System.out.println();
        }
    }


}
