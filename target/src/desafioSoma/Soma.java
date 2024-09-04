package desafioSoma; // Define o pacote onde a classe Soma está localizada

// Observe o trecho de código abaixo:
// int INDICE = 12, SOMA = 0, K = 1; enquanto K < INDICE faça { K = K + 1; SOMA = SOMA + K; } imprimir(SOMA);
// Ao final do processamento, qual será o valor da variável SOMA?

public class Soma {

    private int soma;

    private int k = 1;
    private int i = 12; // Valor padrão para a soma

    // Método público que realiza a operação de soma usando o valor padrão de 'i'
    public int somarNumeroPadrao() {
        return somar(i); // Chama o método 'somar' passando o valor padrão 'i'
    }

    // Método privado que realiza a soma de 1 até o número fornecido
    private int somar(int numero) {

        while(k != numero) {
            k = k + 1; // Incrementa o valor de 'k' em 1 a cada iteração
            this.soma = soma + k; // Adiciona o novo valor de 'k' à variável 'soma'
        }
        return getSoma();
    }

    public int escolherSomarNumero(int numero) {
        return somar(numero); // Chama o método 'somar' passando o número especificado
    }

    public int getSoma() {
        return soma;
    }
}
