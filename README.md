# estrutura-de-dados

### Lista de exercícios - Revisão de algoritmos

Obs.: não usar função de ordenação de vetor

1. Implemente um algoritmo que verifique parênteses, colchetes e chaves correspondentes. Esse
   algoritmo deve receber um valor String de entrada e retornar um Boolean.
   Exemplo.:
   "1 + 3 / (3 + 5)" // Retorna true
   "(1 + 3) / [(3 + 5) * 5]" // Retorna true
   "1 + [3 / (3] + 5)" // Retorna false
   "{1 + [3} / (3 + 5)" // Retorna false
2. Implemente um algoritmo que rotacione um array de 𝑛 elementos para a direita em 𝑘 passos. Por
   exemplo, com 𝑛 = 7 e 𝑘 = 3, o array [1, 2, 3, 4, 5, 6, 7] é modificado para [5, 6, 7, 1, 2, 3, 4].
3. Dada duas palavras (início e fim) e um dicionário, encontre o comprimento da sequência de
   transformação mais curta do início ao fim. De modo que apenas uma letra pode ser alterada por vez
   e cada palavra intermediária deve existir no dicionário, por exemplo:
   • Início: “hit”
   • Fim: “cog”
   • Dicionário: [“hot”, “dot”, “dog”, “lot”, “log”]
   Uma transformação mais curta é “hit” -> “hot” -> “dot” -> “dog” -> “cog”. Assim, o programa deve
   retornar o comprimento 5 e o caminho percorrido
4. Encontre o k-ésimo maior elemento de um array desordenado. Por exemplo, dado o array [3, 2, 1, 5, 6,
   4] e 𝑘 = 2, retorne 5. Assuma que 𝑘 é sempre um valor válido. (sem numeros repetidos, k não pode estrapolar o tamanho do array, array pode estar desordenado)
