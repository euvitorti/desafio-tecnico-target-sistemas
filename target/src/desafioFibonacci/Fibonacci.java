package desafioFibonacci;

// Desafio: Dado a sequência de Fibonacci, onde se inicia por 0 e 1, e o próximo valor
// é sempre a soma dos 2 valores anteriores (exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...),
// escreva um programa que, ao receber um número, calcule a sequência de Fibonacci e
// retorne uma mensagem avisando se o número informado pertence ou não à sequência.

public class Fibonacci {

    //     Método para verificar se um número pertence à sequência de Fibonacci.
    //     @param n Número a ser verificado.
    public boolean numeroFibonacci(int n) {
        if (n < 0) {
            return false; // Números negativos não fazem parte da sequência de Fibonacci.
        }

        // Inicializando os dois primeiros números da sequência de Fibonacci.
        int a = 0;
        int b = 1;

        // Gerando a sequência de Fibonacci até que o próximo número seja maior que n.
        while (a <= n) {
            System.out.print(a + " "); // Exibindo cada número gerado da sequência.
            if (a == n) {
                return true; // Se o número informado é encontrado na sequência, retorna true.
            }
            // Avança na sequência: 'a' recebe o valor de 'b' e 'b' recebe a soma de 'a' e 'b'.
            int temp = a;
            a = b;
            b = temp + b;
        }

        return false; // Se o número não for encontrado na sequência, retorna false.
    }

//    Método para verificar se um número pertence à sequência de Fibonacci e exibir o resultado.

    public void verificarNumeroFibonacci(int numero) {

        // Usando o operador ternário para criar a mensagem de acordo com o resultado da verificação.
        String mensagem = numeroFibonacci(numero)
                ? "\nO número " + numero + " pertence à sequência de Fibonacci."
                : "\nO número " + numero + " NÃO pertence à sequência de Fibonacci.";

        System.out.println(mensagem);
    }
}