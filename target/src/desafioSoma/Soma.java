package desafioSoma; // Define o pacote onde a classe Soma está localizada

// Observe o trecho de código abaixo:
// int INDICE = 12, SOMA = 0, K = 1; enquanto K < INDICE faça { K = K + 1; SOMA = SOMA + K; } imprimir(SOMA);
// Ao final do processamento, qual será o valor da variável SOMA?

public class Soma { // Declaração da classe Soma

    private int soma; // Variável que irá armazenar o valor da soma acumulada

    private int k = 1; // Variável inicial para o contador de soma
    private int i = 12; // Valor padrão para a soma

    // Método público que realiza a operação de soma usando o valor padrão de 'i'
    public int somarNumeroPadrao() {
        return somar(i); // Chama o método 'somar' passando o valor padrão 'i'
    }

    // Método privado que realiza a soma de 1 até o número fornecido
    private int somar(int numero) {
        while(k != numero) { // Loop até que 'k' seja igual ao número fornecido
            k = k + 1; // Incrementa o valor de 'k' em 1 a cada iteração
            this.soma = soma + k; // Adiciona o novo valor de 'k' à variável 'soma'
        }

        // Retorna o resultado final da soma chamando o método 'getSoma'
        return getSoma();
    }

    // Método público que permite somar até um número especificado pelo usuário
    public int escolherSomarNumero(int numero) {
        return somar(numero); // Chama o método 'somar' passando o número especificado
    }

    // Método getter para retornar o valor atual da variável 'soma'
    public int getSoma() {
        return soma; // Retorna o valor acumulado de 'soma'
    }
}
