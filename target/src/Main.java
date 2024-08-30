import desafioFibonacci.Fibonacci;
import desafioSoma.Soma; // Importa a classe Soma do pacote desafioSoma

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main { // Declaração da classe Main

    private static Scanner scanner = new Scanner(System.in); // Atributo de classe para leitura de entrada

    // Método estático 'somar' que realiza a soma e imprime o resultado
    public static void somar() {

        // Imprime o título do desafio de soma usando texto formatado com quebra de linha
        System.out.println("""
        \n-------------
        Desafio Soma
        -------------
        """);

        // Cria uma nova instância da classe Soma
        Soma soma = new Soma();

        // Chama o método 'somar' da classe Soma e imprime o valor da soma
        System.out.printf("Valor da soma: %d.", soma.somar());
    }

    // Método para interagir com o usuário e chamar a lógica de Fibonacci
    public static void verificarNumeroFibonacci() {

        System.out.println("""
        \n-------------
        Desafio Fibonacci
        -------------
        """);

        boolean inputValido = false;
        int numero = 0;

        while (!inputValido) {
            try {
                // Solicita ao usuário para informar um número
                System.out.print("Informe um número: ");
                numero = scanner.nextInt();
                inputValido = true; // Se a entrada foi bem-sucedida, sai do loop
            } catch (InputMismatchException e) {
                // Captura a exceção se a entrada não for um número inteiro
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                scanner.next(); // Limpa o buffer do scanner
            }
        }

        // Cria uma instância da classe Fibonacci
        Fibonacci fibonacci = new Fibonacci();

        // Chama o método para verificar se o número pertence à sequência de Fibonacci
        fibonacci.verificarNumeroFibonacci(numero);
    }

    // Método 'main' que é o ponto de entrada do programa
    public static void main(String[] args) {

        // Imprime uma mensagem de boas-vindas ao usuário
        System.out.printf("Hello and welcome! Target Sistemas 👨‍💻");

        // Chama o método 'somar' para realizar o desafio de soma
        somar();
        verificarNumeroFibonacci(); // Chama o método que executa a lógica de Fibonacci
        scanner.close(); // Fecha o scanner
    }
}
