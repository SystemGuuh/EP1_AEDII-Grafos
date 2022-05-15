package EPTeste;


public class ListadeAdj {
    int tamanho, i=0;
    No lista[] = new No[tamanho];
    public ListadeAdj(int tam) {
        this.tamanho = tam;
    }

    public void addNo(String valor)
    {
        No no = new No(valor);
        //for(int i=0;i<tamanho;i++){
            if(lista.length == 0){
                lista[i] = (No) clone(no);
                i++;
                //break;
            }else {
                No aux = acharNo(lista, no.valor);
                if(aux == null){
                    i++;
                    lista[i] = (No) clone(no);
                   // break;
                }else{
                    i++;
                    lista[i] = (No) clone(aux);
                   // break;
                }
            //}
        }
    }
    //Foi duro implementar isso aqui
    private Object clone(No no) {
        try{
            return this.clone();
        }    catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public No acharNo(No lista[], String valor) {
        if (lista.length == 0) {
            return null;
        }else{
            for(int i = 0; i < lista.length;i++)
            {
                for(No no: lista[i].vizinhos)
                {
                    if(no.valor == valor) {
                        return no;
                    }
                }
            }
        }
        return null;
    }
}