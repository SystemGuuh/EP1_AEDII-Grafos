package EPTeste;

public class ListaLigada {

    No primeiro, ultimo;

    //construtor da lista ligada
    public ListaLigada() {
        primeiro = null;
        ultimo = null;
    }

    //checa se uma lista está vazia
    public boolean isVazia (){
        if (primeiro == null) { return true; }
        else { return false; }
    }

    //insere um nó no começo da lista
    public void inserirInicio (String valor){
        No busca = buscaNo(valor);
        if(busca==null) {
            No novoNo = new No(valor);
            if (isVazia()) {
                ultimo = novoNo;
            } else {
                novoNo.prox = primeiro;
            }
            primeiro = novoNo;
        }else ultimo = busca;
    }

    //insere um nó no final da lista
    public void inserirFinal (String valor){
        No novoNo = new No(valor);
        if (isVazia()){ primeiro = novoNo; }
        else { ultimo.prox = novoNo; }
        ultimo = novoNo;
    }

    //método para contar nós
    public int contarNos ( ){
        int tamanho = 0;
        No temporario = primeiro;
        while (temporario != null){
            tamanho = tamanho + 1;
            temporario = temporario.prox;
        }
        return tamanho;
    }

    //inserir nós no meio da lista
    public void inserirMeio(String valor, int posicao){
        No busca = buscaNo(valor);
        if(busca==null) {
            No novoNo = new No(valor);
            No aux = primeiro;
            int nroNos, posAux = 1;
            nroNos = contarNos();
            if (posicao < 1) {
                inserirInicio(novoNo.valor);
            } else {
                ultimo.vizinhos.add(novoNo);
                novoNo.ant = ultimo;
            }
        }else{
            ultimo.vizinhos.add(busca);
        }
    }

    //busca um nó e retorna um valor positivo e negativo
    public No buscaNo (String valor){
        No noTemp = primeiro;
        boolean found = false;
        while ((!found)){
            if (noTemp.valor.equals(valor)){
                found = true;
            } else {
                /*EM CONSTRUÇÃO*/
            }
        }
        if(found) return noTemp;
        else return null;
    }

    //imprime a lista na tela
    public void mostrarLista (No raiz){
        System.out.println("The new List is: " + raiz.vizinhos);
    }

}