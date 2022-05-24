package Algoritmo.Matriz;

import java.util.ArrayList;
import Algoritmo.Matriz.*;

public class MatrizVertice<T> {
    public T dado;
    public int posicao;

    MatrizVertice(T valor){
        this.dado = valor;
    }

    public T getDado() {
        return dado;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }
}
 