package desafioFibonacci;

// Desafio em questão
// Dado a sequência de Fibonacci, onde se inicia por 0 e 1 e o próximo valor sempre
// será a soma dos 2 valores anteriores
// (exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...)
// escreva um programa na linguagem que desejar onde, informado um número,
// ele calcule a sequência de Fibonacci e retorne uma mensagem avisando
// se o número informado pertence ou não a sequência.

public class Fibonacci {

    // Método para verificar se um número pertence à sequência de Fibonacci
    public boolean numeroFibonacci(int n) {
        if (n < 0) {
            return false; // Números negativos não estão na sequência de Fibonacci
        }

        // Inicializando os dois primeiros números da sequência de Fibonacci
        int a = 0;
        int b = 1;

        // Gerando a sequência de Fibonacci até que o próximo número seja maior que n
        while (a <= n) {
            System.out.print(a + " "); // Exibindo o número atual da sequência
            if (a == n) {
                return true;
            }
            int temp = a;
            a = b;
            b = temp + b;
        }

        return false;
    }

    // Método para exibir o resultado se um número pertence à sequência de Fibonacci
    public void verificarNumeroFibonacci(int numero) {

        // Usando o operador ternário para criar a mensagem
        String mensagem = numeroFibonacci(numero)
                ? "\nO número " + numero + " pertence à sequência de Fibonacci."
                : "\nO número " + numero + " NÃO pertence à sequência de Fibonacci.";

        // Exibindo a mensagem
        System.out.println(mensagem);
    }

}
