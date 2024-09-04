import desafioFaturamento.Faturamento;
import desafioFibonacci.Fibonacci;
import desafioInverterString.InverterString;
import desafioPercentualFaturamento.PercentualFaturamento;
import desafioSoma.Soma;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in); // Scanner para entrada do usuário
    private static final String OPCAO_INVALIDA = "Opção inválida. Por favor, escolha uma opção válida.";

    // Menu principal com as opções dos desafios
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

    // Menu para o desafio de soma com subopções
    private static final String MENU_SOMA = """
       \n------------
       Desafio Soma
       ------------
       1. Somar Número Padrão do Caso
       2. Escolher Somar Número
       """;

    // Método para ler a opção escolhida pelo usuário
    private static int lerOpcao(String menu) {
        System.out.println(menu); // Exibe o menu

        while (true) {
            try {
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt(); // Lê a opção do usuário
                scanner.nextLine(); // Consome a nova linha deixada pelo nextInt()

                if (opcao > 0) return opcao; // Retorna a opção se for válida
                System.out.println(OPCAO_INVALIDA); // Exibe mensagem de erro se a opção for inválida

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
                scanner.next(); // Limpa o buffer para evitar loop infinito
            }
        }
    }

    // Método para ler um número inteiro fornecido pelo usuário
    private static int lerNumero() {
        while (true) {
            try {
                int numero = scanner.nextInt(); // Lê o número inteiro
                scanner.nextLine(); // Consome a nova linha deixada pelo nextInt()
                return numero;

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                scanner.next(); // Limpa o buffer para evitar loop infinito
            }
        }
    }

    // Método para executar o desafio de soma
    private static void somar() {
        int opcao = lerOpcao(MENU_SOMA); // Lê a opção do usuário dentro do menu de soma
        Soma soma = new Soma(); // Cria uma instância da classe Soma

        // Executa a soma com base na opção escolhida
        int resultado = switch (opcao) {
            case 1 -> soma.somarNumeroPadrao(); // Soma usando o número padrão
            case 2 -> {
                System.out.print("Informe um número para somar: ");
                yield soma.escolherSomarNumero(lerNumero()); // Soma usando o número fornecido pelo usuário
            }
            default -> {
                System.out.println(OPCAO_INVALIDA); // Mensagem de erro para opção inválida
                yield 0;
            }
        };

        if (resultado != 0)
            System.out.printf("Valor da soma: %d.\n", resultado); // Exibe o resultado da soma
    }

    // Método para executar o desafio de Fibonacci
    private static void verificarNumeroFibonacci() {
        System.out.println("""
       -----------------
       Desafio Fibonacci
       -----------------""");
        System.out.print("Informe um número: ");
        new Fibonacci().verificarNumeroFibonacci(lerNumero()); // Verifica se o número está na sequência de Fibonacci
    }

    // Método para executar o desafio de faturamento
    private static void mostrarResultadosFaturamento() {
        System.out.println("""
       -------------------
       Desafio Faturamento
       -------------------""");
        try {
            Faturamento.fromXML().mostrarFaturamento(); // Lê e exibe os resultados do faturamento a partir de um arquivo XML
        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo de faturamento: " + e.getMessage());
        }
    }

    // Método para executar o desafio de percentual de faturamento
    private static void mostrarPercentualFaturamento() {
        System.out.println("""
       ------------------------------
       Desafio Percentual Faturamento
       ------------------------------""");
        try {
            PercentualFaturamento.fromXML().calcularPercentuais(); // Calcula e exibe os percentuais de faturamento
        } catch (Exception e) {
            System.out.println("Erro ao calcular percentual de faturamento: " + e.getMessage());
        }
    }

    // Método para executar o desafio de inversão de string
    private static void inverterString() {
        System.out.println("""
               ---------------------------
               Desafio Inversão de String
               ---------------------------""");
        System.out.print("Informe a string para inverter: ");
        InverterString.inverter(scanner.nextLine()); // Inverte e exibe a string fornecida pelo usuário
    }

    // Método principal que controla o fluxo do programa
    public static void main(String[] args) {
        while (true) {
            int opcao = lerOpcao(MENU_PRINCIPAL); // Lê a opção do menu principal
            switch (opcao) {
                case 1 -> somar(); // Executa o desafio de soma
                case 2 -> verificarNumeroFibonacci(); // Executa o desafio de Fibonacci
                case 3 -> mostrarResultadosFaturamento(); // Executa o desafio de faturamento
                case 4 -> mostrarPercentualFaturamento(); // Executa o desafio de percentual de faturamento
                case 5 -> inverterString(); // Executa o desafio de inversão de string
                case 6 -> { // Sai do programa
                    System.out.println("""
                   #QueroSerTargetiano 👨‍💻
                   Antes de ir... Acesse o meu portfólio: https://meuportfolio-euvitortis-projects.vercel.app/
                   Saindo... Obrigado por usar o programa. 👋
                   """);
                    scanner.close(); // Fecha o scanner
                    return; // Termina a execução do programa
                }
                default -> System.out.println(OPCAO_INVALIDA); // Mensagem de erro para opção inválida
            }
        }
    }
}
