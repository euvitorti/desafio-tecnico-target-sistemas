import desafioFaturamento.Faturamento;
import desafioFibonacci.Fibonacci;
import desafioInverterString.InverterString;
import desafioPercentualFaturamento.PercentualFaturamento;
import desafioSoma.Soma;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    // Mensagens e opções usadas em múltiplos lugares
    private static String MENU_PRINCIPAL = """
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

    private static String MENU_SOMA = """
        \n------------
        Desafio Soma
        ------------
        1. Somar Número Padrão do Caso
        2. Escolher Somar Número
        """;

    private static final String OPCAO_INVALIDA = "Opção inválida. Por favor, escolha uma opção válida.";

    private static int lerOpcao(String menu) {
        int opcao = 0;
        boolean inputValido = false;

        // Exibe o menu e lê a opção escolhida pelo usuário
        System.out.println(menu);
        while (!inputValido) {
            try {
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha deixada pelo nextInt()

                if (opcao > 0) {
                    inputValido = true; // Se a opção for válida, sai do loop
                } else {
                    System.out.println(OPCAO_INVALIDA);
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
                scanner.next(); // Limpar o buffer para evitar loop infinito
            }
        }

        return opcao;
    }

    private static int lerNumero() {
        int numero = 0;
        boolean inputValido = false;

        while (!inputValido) {
            try {
                numero = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha deixada pelo nextInt()
                inputValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                scanner.next(); // Limpar o buffer para evitar loop infinito
            }
        }

        return numero;
    }

    private static void somar() {
        int opcao = lerOpcao(MENU_SOMA);
        Soma soma = new Soma(); // Cria uma instância da classe Soma
        int resultado;

        switch (opcao) {
            case 1:
                resultado = soma.somarNumeroPadrao(); // Soma os números padrão
                System.out.printf("Valor da soma com número padrão: %d.\n", resultado);
                break;
            case 2:
                System.out.print("Informe um número para somar: ");
                int numero = lerNumero(); // Lê o número informado pelo usuário
                resultado = soma.escolherSomarNumero(numero); // Soma o número informado
                System.out.printf("Valor da soma com número informado: %d.\n", resultado);
                break;
            default:
                System.out.println(OPCAO_INVALIDA);
                break;
        }
    }

    private static void verificarNumeroFibonacci() {
        System.out.println("""
        \n---------------
        Desafio Fibonacci
        -----------------
        """);

        System.out.print("Informe um número: ");
        int numero = lerNumero(); // Lê o número informado pelo usuário

        Fibonacci fibonacci = new Fibonacci(); // Cria uma instância da classe Fibonacci
        fibonacci.verificarNumeroFibonacci(numero); // Verifica se o número faz parte da sequência de Fibonacci
    }

    private static void mostrarResultadosFaturamento() {
        System.out.println("""
        \n-----------------
        Desafio Faturamento
        -------------------
        """);

        try {
            Faturamento faturamento = Faturamento.fromXML(); // Lê os dados de faturamento do arquivo XML
            faturamento.mostrarFaturamento(); // Mostra os resultados do faturamento
        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo de faturamento: " + e.getMessage());
        }
    }

    private static void mostrarPercentualFaturamento() {
        System.out.println("""
        \n----------------------------
        Desafio Percentual Faturamento
        ------------------------------
        """);

        try {
            PercentualFaturamento percentualFaturamento = PercentualFaturamento.fromXML(); // Lê os dados de percentual do arquivo XML
            percentualFaturamento.calcularPercentuais(); // Calcula e mostra os percentuais de faturamento
        } catch (Exception e) {
            System.out.println("Erro ao calcular percentual de faturamento: " + e.getMessage());
        }
    }

    private static void inverterString() {
        System.out.println("""
        \n-----------------------------
        Desafio Inversão de String
        -----------------------------
        """);

        System.out.print("Informe a string para inverter: ");
        String str = scanner.nextLine(); // Lê a string informada pelo usuário

        String resultado = InverterString.inverter(str); // Inverte a string
        System.out.printf("String invertida: %s\n", resultado);
    }

    public static void main(String[] args) {
        boolean continuar = true; // Controle para manter o loop do menu ativo

        // Loop do menu principal
        while (continuar) {
            int opcao = lerOpcao(MENU_PRINCIPAL);

            switch (opcao) {
                case 1:
                    somar(); // Chama o método de soma
                    break;
                case 2:
                    verificarNumeroFibonacci(); // Chama o método de verificação Fibonacci
                    break;
                case 3:
                    mostrarResultadosFaturamento(); // Chama o método de mostrar resultados de faturamento
                    break;
                case 4:
                    mostrarPercentualFaturamento(); // Chama o método de mostrar percentual de faturamento
                    break;
                case 5:
                    inverterString(); // Chama o método de inversão de string
                    break;
                case 6:
                    continuar = false; // Sinaliza para sair do loop e encerrar o programa
                    System.out.println("""
                        
                        #QueroSerTargetiano 👨‍💻
                        
                        Antes de ir... Acesse o meu portfólio: https://meuportfolio-euvitortis-projects.vercel.app/
                        
                        Saindo... Obrigado por usar o programa. 👋
                        """);
                    break;
                default:
                    System.out.println(OPCAO_INVALIDA);
                    break;
            }
        }

        scanner.close(); // Fecha o scanner para liberar recursos
    }
}
