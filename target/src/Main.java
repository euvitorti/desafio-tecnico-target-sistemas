import desafioFaturamento.Faturamento;
import desafioFibonacci.Fibonacci;
import desafioSoma.Soma;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void somar() {
        System.out.println("""
        \n----------
        Desafio Soma
        ------------
        """);

        Soma soma = new Soma();
        System.out.printf("Valor da soma: %d.\n", soma.somar());
    }

    public static void verificarNumeroFibonacci() {
        System.out.println("""
        \n---------------
        Desafio Fibonacci
        -----------------
        """);

        boolean inputValido = false;
        int numero = 0;

        while (!inputValido) {
            try {
                System.out.print("Informe um número: ");
                numero = scanner.nextInt();
                inputValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                scanner.next();
            }
        }

        Fibonacci fibonacci = new Fibonacci();
        fibonacci.verificarNumeroFibonacci(numero);
    }

    public static void mostrarResultadosFaturamento() {
        System.out.println("""
    \n-----------------
    Desafio Faturamento
    -------------------
    """);

        try {
            // Caminho relativo dentro do diretório src/recursos
            Faturamento faturamento = Faturamento.fromXML("arquivosFaturamento/faturamentos.xml");
            double menor = faturamento.menorFaturamento();
            double maior = faturamento.maiorFaturamento();
            double media = faturamento.mediaMensal();
            int diasAcimaDaMedia = faturamento.diasAcimaDaMedia();

            System.out.printf("Menor valor de faturamento: %.2f\n", menor);
            System.out.printf("Maior valor de faturamento: %.2f\n", maior);
            System.out.printf("Média mensal: %.2f\n", media);
            System.out.printf("Número de dias com faturamento acima da média: %d\n", diasAcimaDaMedia);
        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo de faturamento: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("""
            \n-------------
            Menu Principal
            -------------
            1. Desafio Soma
            2. Desafio Fibonacci
            3. Desafio Faturamento
            4. Sair
            """);

            System.out.print("Escolha uma opção: ");
            int opcao = -1;

            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
                scanner.next();
            }

            switch (opcao) {
                case 1:
                    somar();
                    break;
                case 2:
                    verificarNumeroFibonacci();
                    break;
                case 3:
                    mostrarResultadosFaturamento();
                    break;
                case 4:
                    continuar = false;
                    System.out.println("Saindo... Obrigado por usar o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção entre 1 e 4.");
                    break;
            }
        }

        scanner.close(); // Fecha o scanner
    }
}
