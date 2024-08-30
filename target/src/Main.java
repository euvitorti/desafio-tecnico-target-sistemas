import desafioSoma.Soma; // Importa a classe Soma do pacote desafioSoma

public class Main { // Declaração da classe Main

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

    // Método 'main' que é o ponto de entrada do programa
    public static void main(String[] args) {

        // Imprime uma mensagem de boas-vindas ao usuário
        System.out.printf("Hello and welcome! Target Sistemas 👨‍💻");

        // Chama o método 'somar' para realizar o desafio de soma
        somar();
    }
}
