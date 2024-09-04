import desafioFaturamento.Faturamento;
import desafioFibonacci.Fibonacci;
import desafioInverterString.InverterString;
import desafioPercentualFaturamento.PercentualFaturamento;
import desafioSoma.Soma;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String OPCAO_INVALIDA = "Opção inválida. Por favor, escolha uma opção válida.";

    private static final String MENU_PRINCIPAL = """
       \n-----------------------------
       👩‍💻     Target Sistemas     👨‍💻
       -----------------------------
       1. Desafio Soma
       2. Desafio Fibonacci
       3. Desafio Faturamento
       4. Desafio Percentual Faturamento
       5. Desafio Inversão de String
       6. Sair
       """;

    private static final String MENU_SOMA = """
       \n------------
       Desafio Soma
       ------------
       1. Somar Número Padrão do Caso
       2. Escolher Somar Número
       """;

    private static int lerOpcao(String menu) {

        System.out.println(menu);

        while (true) {

            try {

                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha deixada pelo nextInt()

                if (opcao > 0) return opcao;
                System.out.println(OPCAO_INVALIDA);

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
                scanner.next(); // Limpar o buffer para evitar loop infinito
            }
        }
    }

    private static int lerNumero() {

        while (true) {

            try {

                int numero = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha deixada pelo nextInt()
                return numero;

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                scanner.next(); // Limpar o buffer para evitar loop infinito
            }
        }
    }

    private static void somar() {

        int opcao = lerOpcao(MENU_SOMA);
        Soma soma = new Soma();

        int resultado = switch (opcao) {
            case 1 -> soma.somarNumeroPadrao();
            case 2 -> {
                System.out.print("Informe um número para somar: ");
                yield soma.escolherSomarNumero(lerNumero());
            }
            default -> {
                System.out.println(OPCAO_INVALIDA);
                yield 0;
            }
        };

        if (resultado != 0)
            System.out.printf("Valor da soma: %d.\n", resultado);
    }

    private static void verificarNumeroFibonacci() {
        System.out.println("""
       -----------------
       Desafio Fibonacci
       -----------------""");
        System.out.print("Informe um número: ");
        new Fibonacci().verificarNumeroFibonacci(lerNumero());
    }

    private static void mostrarResultadosFaturamento() {
        System.out.println("""
       -------------------
       Desafio Faturamento
       -------------------""");
        try {
            Faturamento.fromXML().mostrarFaturamento();
        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo de faturamento: " + e.getMessage());
        }
    }

    private static void mostrarPercentualFaturamento() {
        System.out.println("""
       ------------------------------
       Desafio Percentual Faturamento
       ------------------------------""");
        try {
            PercentualFaturamento.fromXML().calcularPercentuais();
        } catch (Exception e) {
            System.out.println("Erro ao calcular percentual de faturamento: " + e.getMessage());
        }
    }

    private static void inverterString() {
        System.out.println("""
               ---------------------------
               Desafio Inversão de String
               ---------------------------""");

        System.out.print("Informe a string para inverter: ");
        InverterString.inverter(scanner.nextLine());
    }

    public static void main(String[] args) {
        while (true) {
            int opcao = lerOpcao(MENU_PRINCIPAL);
            switch (opcao) {
                case 1 -> somar();
                case 2 -> verificarNumeroFibonacci();
                case 3 -> mostrarResultadosFaturamento();
                case 4 -> mostrarPercentualFaturamento();
                case 5 -> inverterString();
                case 6 -> {
                    System.out.println("""
                   #QueroSerTargetiano 👨‍💻
                   Antes de ir... Acesse o meu portfólio: https://meuportfolio-euvitortis-projects.vercel.app/
                   Saindo... Obrigado por usar o programa. 👋
                   """);
                    scanner.close();
                    return;
                }
                default -> System.out.println(OPCAO_INVALIDA);
            }
        }
    }
}
