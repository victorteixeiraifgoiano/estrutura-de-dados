package estrutura_de_dados;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Ex4KEsimoMaiorElemento {

    public static void main(String[] args) {
        Integer[] array = {3, 2, 1, 5, 6, 4};
        int k = 2;

        // Embaralha o array
        List<Integer> lista = Arrays.asList(array);
        Collections.shuffle(lista, new Random());
        lista.toArray(array);

        // Mostra array embaralhado no console
        System.out.println("Array embaralhado: " + Arrays.toString(array));

        // Encontra o k-ésimo maior elemento
        int kesimoMaior = encontrarKEsimoMaior(array, k);

        // Mostra o k-ésimo maior elemento no console
        System.out.println(k + "º maior elemento: " + kesimoMaior);
    }

    public static int encontrarKEsimoMaior(Integer[] array, int k) {
        return particaoIndiceDesejado(array, 0, array.length - 1, array.length - k);
    }

    private static int particaoIndiceDesejado(Integer[] array, int esquerda, int direita, int k) {
        if (esquerda == direita) {
            return array[esquerda];
        }

        int pivoIndex = particao(array, esquerda, direita);
        if (k == pivoIndex) {
            return array[k];
        } else if (k < pivoIndex) {
            return particaoIndiceDesejado(array, esquerda, pivoIndex - 1, k);
        } else {
            return particaoIndiceDesejado(array, pivoIndex + 1, direita, k);
        }
    }

    private static int particao(Integer[] array, int esquerda, int direita) {
        int pivo = array[direita];
        int i = esquerda;
        for (int j = esquerda; j < direita; j++) {
            if (array[j] <= pivo) {
                trocarDoisElementos(array, i, j);
                i++;
            }
        }
        trocarDoisElementos(array, i, direita);
        return i;
    }

    private static void trocarDoisElementos(Integer[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
