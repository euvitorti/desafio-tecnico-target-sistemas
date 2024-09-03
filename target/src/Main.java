import desafioFaturamento.Faturamento;
import desafioFibonacci.Fibonacci;
import desafioInverterString.InverterString;
import desafioPercentualFaturamento.PercentualFaturamento;
import desafioSoma.Soma;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void somar() {
        System.out.println("""
        \n------------
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
            Faturamento faturamento = Faturamento.fromXML();
            faturamento.mostrarFaturamento();
        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo de faturamento: " + e.getMessage());
        }
    }

    public static void mostrarPercentualFaturamento() {
        System.out.println("""
    \n----------------------------
    Desafio Percentual Faturamento
    ------------------------------
    """);

        try {
            PercentualFaturamento percentualFaturamento = PercentualFaturamento.fromXML();
            percentualFaturamento.calcularPercentuais();
        } catch (Exception e) {
            System.out.println("Erro ao calcular percentual de faturamento: " + e.getMessage());
        }
    }

    public static void inverterString() {
        System.out.println("""
        \n-----------------------------
        Desafio Inversão de String
        -----------------------------
        """);

        System.out.print("Informe a string para inverter: ");
        String str = scanner.nextLine(); // Lê a string informada pelo usuário

        String resultado = InverterString.inverter(str); // Inverte a string
        System.out.printf("String invertida: %s", resultado);
    }

    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("""
            \n-----------------------------
            👩‍💻     Target Sistemas     👨‍💻
            -----------------------------
            1. Desafio Soma
            2. Desafio Fibonacci
            3. Desafio Faturamento
            4. Desafio Percentual Faturamento
            5. Desafio Inversão de String
            6. Sair
            """);

            System.out.print("Escolha uma opção: ");
            int opcao = 0;

            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha deixada pelo nextInt()
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
                scanner.next(); // Limpar o buffer
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
                    mostrarPercentualFaturamento();
                    break;
                case 5:
                    inverterString();
                    break;
                case 6:
                    continuar = false;
                    System.out.println("""
                            
                            #QueroSerTargetiano 👨‍💻
                            
                            Antes de ir... Acesse o meu portfólio: https://meuportfolio-euvitortis-projects.vercel.app/
                            
                            Saindo... Obrigado por usar o programa. 👋
                            """);
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção entre 1 e 6.");
                    break;
            }
        }

        scanner.close(); // Fecha o scanner
    }
}
