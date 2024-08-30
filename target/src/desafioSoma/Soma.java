package desafioSoma; // Define o pacote onde a classe Soma está localizada

// DESAFIO EM QUESTÃO
// Observe o trecho de código abaixo:
// int INDICE = 13, SOMA = 0, K = 0; Enquanto K < INDICE faça { K = K + 1; SOMA = SOMA + K; }
// Imprimir(SOMA); Ao final do processamento, qual será o valor da variável SOMA?

public class Soma { // Declaração da classe Soma

    // Declaração de variáveis de instância privadas
    private int soma; // Variável que irá armazenar o valor da soma acumulada
    private int k; // Variável auxiliar usada para incrementar a cada iteração

    // Método público que realiza a operação de soma
    public int somar() {

        // Loop 'for' que itera de 0 a 12 (13 iterações)
        for(int i = 0; i <= 12; i++){
            this.k = k + 1; // Incrementa o valor de 'k' em 1 a cada iteração (k = k + 1)
            this.soma = soma + k; // Adiciona o novo valor de 'k' à variável 'soma' (soma = soma + k)
        }

        // Retorna o resultado final da soma chamando o método 'getSoma'
        return getSoma();
    }

    // Método getter para retornar o valor da variável 'soma'
    public int getSoma() {
        return soma;
    }
}
