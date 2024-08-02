package estrutura_de_dados;

import java.util.*;

/*
 * 3. Dada duas palavras (início e fim) e um dicionário, encontre o comprimento da sequência 
 * de transformação mais curta do início ao fim. De modo que apenas uma letra pode ser alterada 
 * por vez e cada palavra intermediária deve existir no dicionário, por exemplo:
 *  • Início: “hit”
 *  • Fim: “cog”
 *  • Dicionário: [“hot”, “dot”, “dog”, “lot”, “log”]
 * Uma transformação mais curta é “hit” -> “hot” -> “dot” -> “dog” -> “cog”. Assim, o programa 
 * deve retornar o comprimento 5 e o caminho percorrido
 */

public class Ex3TransformacaoPalavra {

    public static void main(String[] args) {
        String inicio = "hit";
        String fim = "cog";
        List<String> dicionario = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        Resultado resultado = encontrarSequenciaTransformacao(inicio, fim, dicionario);
        System.out.println("Comprimento: " + resultado.comprimento);
        System.out.println("Caminho: " + resultado.caminho);
    }

    public static class Resultado {
        int comprimento;
        List<String> caminho;

        Resultado(int comprimento, List<String> caminho) {
            this.comprimento = comprimento;
            this.caminho = caminho;
        }
    }

    public static Resultado encontrarSequenciaTransformacao(String inicio, String fim, List<String> dicionario) {
        Set<String> conjuntoPalavras = new HashSet<>(dicionario);
        if (!conjuntoPalavras.contains(fim)) {
            return new Resultado(0, new ArrayList<>());
        }

        Queue<List<String>> fila = new LinkedList<>();
        fila.add(Arrays.asList(inicio));
        
        while (!fila.isEmpty()) {
            int tamanho = fila.size();
            Set<String> palavrasVisitadas = new HashSet<>();
            
            for (int i = 0; i < tamanho; i++) {
                List<String> caminho = fila.poll();
                String ultimaPalavra = caminho.get(caminho.size() - 1);

                for (String vizinho : obterVizinhos(ultimaPalavra, conjuntoPalavras)) {
                    if (vizinho.equals(fim)) {
                        caminho.add(vizinho);
                        return new Resultado(caminho.size(), caminho);
                    }
                    palavrasVisitadas.add(vizinho);
                    List<String> novoCaminho = new ArrayList<>(caminho);
                    novoCaminho.add(vizinho);
                    fila.add(novoCaminho);
                }
            }
            
            conjuntoPalavras.removeAll(palavrasVisitadas);
        }
        
        return new Resultado(0, new ArrayList<>());
    }

    private static List<String> obterVizinhos(String palavra, Set<String> conjuntoPalavras) {
        List<String> vizinhos = new ArrayList<>();
        char[] arrayPalavra = palavra.toCharArray();

        for (int i = 0; i < arrayPalavra.length; i++) {
            char original = arrayPalavra[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == original) continue;
                arrayPalavra[i] = c;
                String novaPalavra = new String(arrayPalavra);
                if (conjuntoPalavras.contains(novaPalavra)) {
                    vizinhos.add(novaPalavra);
                }
            }
            arrayPalavra[i] = original;
        }

        return vizinhos;
    }
}

