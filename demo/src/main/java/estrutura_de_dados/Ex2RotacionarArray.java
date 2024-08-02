package estrutura_de_dados;

import java.util.Arrays;

/*
 * 2. Implemente um algoritmo que rotacione um array de 𝑛 elementos para a direita 
 * em 𝑘 passos. Por exemplo, com 𝑛 = 7 e 𝑘 = 3, o array [1, 2, 3, 4, 5, 6, 7] é 
 * modificado para [5, 6, 7, 1, 2, 3, 4].
 */

public class Ex2RotacionarArray {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        
        System.out.println("Array original: " + Arrays.toString(array));
        rotacionarDireita(array, k);
        System.out.println("Array após rotação: " + Arrays.toString(array));
    }

    public static void rotacionarDireita(int[] array, int k) {
        int n = array.length;
        k = k % n; // Caso k seja maior que n

        // Reverte todo o array
        reverter(array, 0, n - 1);
        // Reverte os primeiros k elementos
        reverter(array, 0, k - 1);
        // Reverte os últimos n-k elementos
        reverter(array, k, n - 1);
    }

    public static void reverter(int[] array, int inicio, int fim) {
        while (inicio < fim) {
            int temp = array[inicio];
            array[inicio] = array[fim];
            array[fim] = temp;
            inicio++;
            fim--;
        }
    }
}
