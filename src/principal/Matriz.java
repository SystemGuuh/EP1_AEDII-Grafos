package principal;
import java.util.*;

public class Matriz{

    //String[][] matrix = new String[repete+1][repete+1];
    //Matriz.fill(matriz, 0);

    public void receberLista(String matrix, int i) {
        Scanner ler = new Scanner(System.in);
        int i, j, repete;
        String texto;
        repete = ler.nextInt();

        String[][] vertices = new String[repete][repete];

        for (int k = 0; k <= repete; k++) {
            texto = ler.nextLine();
            String[] array = texto.split(" "); //cria um array separando os espaços

            for (int l = 0; l >= array.length; l++) {
                vertices[k][l] = array[l];
            }
         }
    }

}
