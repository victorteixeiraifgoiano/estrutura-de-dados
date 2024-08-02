package estrutura_de_dados;

/*
 * 1. Implemente um algoritmo que verifique parênteses, colchetes e chaves 
 * correspondentes. Esse algoritmo deve receber um valor String de entrada e 
 * retornar um Boolean.
 * Exemplo.:
 * "1 + 3 / (3 + 5)" // Retorna true
 * "(1 + 3) / [(3 + 5) * 5]" // Retorna true
 * "1 + [3 / (3] + 5)" // Retorna false
 * "{1 + [3} / (3 + 5)" // Retorna false
 */

public class Ex1VerificarParenteses {

    public static void main(String[] args) {
        String expressao1 = "1 + 3 / (3 + 5)";
        String expressao2 = "(1 + 3) / [(3 + 5) * 5]";
        String expressao3 = "1 + [3 / (3] + 5)";
        String expressao4 = "{1 + [3} / (3 + 5)";

        System.out.println(expressao1 + " // Retorna " + verificarParenteses(expressao1));
        System.out.println(expressao2 + " // Retorna " + verificarParenteses(expressao2));
        System.out.println(expressao3 + " // Retorna " + verificarParenteses(expressao3));
        System.out.println(expressao4 + " // Retorna " + verificarParenteses(expressao4));
    }

    public static boolean verificarParenteses(String expressao) {
        char[] pilha = new char[expressao.length()];
        int topo = -1;

        for (char c : expressao.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                pilha[++topo] = c;
            } else if (c == ')' || c == ']' || c == '}') {
                if (topo == -1) {
                    return false;
                }
                char topoPilha = pilha[topo--];
                if (!correspondente(topoPilha, c)) {
                    return false;
                }
            }
        }

        return topo == -1;
    }

    private static boolean correspondente(char abertura, char fechamento) {
        return (abertura == '(' && fechamento == ')') ||
               (abertura == '[' && fechamento == ']') ||
               (abertura == '{' && fechamento == '}');
    }
}
