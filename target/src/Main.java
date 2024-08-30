import desafioFaturamento.Faturamento;
import desafioFibonacci.Fibonacci;
import desafioSoma.Soma;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    // Método estático 'somar' que realiza a soma e imprime o resultado
    public static void somar() {
        System.out.println("""
        \n-------------
        Desafio Soma
        -------------
        """);

        Soma soma = new Soma();
        System.out.printf("Valor da soma: %d.\n", soma.somar());
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

    // Método para coletar os dados de faturamento do usuário
    public static double[] coletarFaturamentos() {
        double[] faturamentos = null;
        boolean inputValido = false;

        while (!inputValido) {
            try {
                System.out.print("Informe o número de dias do mês: ");
                int dias = scanner.nextInt();
                faturamentos = new double[dias];

                for (int i = 0; i < dias; i++) {
                    System.out.print("Informe o faturamento do dia " + (i + 1) + ": ");
                    faturamentos[i] = scanner.nextDouble();
                }

                inputValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira números válidos.");
                scanner.next();
            }
        }
        return faturamentos;
    }

    // Método para mostrar os resultados do desafio de faturamento
    public static void mostrarResultadosFaturamento() {
        System.out.println("""
        \n-------------
        Desafio Faturamento
        -------------
        """);

        double[] faturamentos = coletarFaturamentos();
        Faturamento faturamento = new Faturamento(faturamentos);

        double menor = faturamento.menorFaturamento();
        double maior = faturamento.maiorFaturamento();
        int diasAcimaDaMedia = faturamento.diasAcimaDaMedia();

        System.out.printf("Menor valor de faturamento: %.2f\n", menor);
        System.out.printf("Maior valor de faturamento: %.2f\n", maior);
        System.out.printf("Número de dias com faturamento acima da média: %d\n", diasAcimaDaMedia);
    }

    // Método 'main' que é o ponto de entrada do programa
    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("""
            \n-------------
            Target Sistemas
            -------------
            1. Desafio Soma
            2. Desafio Fibonacci
            3. Desafio Faturamento
            4. Sair
            """);

            System.out.print("Escolha uma opção: ");
            int opcao = 0;

            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
                scanner.next(); // Limpa o buffer do scanner
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
