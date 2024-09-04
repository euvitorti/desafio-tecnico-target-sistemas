package desafioSoma;

/**
 * O objetivo é somar números sequencialmente até um determinado limite, seja ele
 * um valor padrão ou um valor fornecido pelo usuário.
 */
public class Soma {

    // Variável que irá armazenar o valor acumulado da soma
    private int soma;

    // Variável inicial para o contador de soma, começando de 1
    private int k = 0;

    // Valor padrão até onde a soma será realizada, equivalente ao valor de INDICE no problema
    private int i = 13;

    /**
     * Método público que realiza a operação de soma usando o valor padrão de 'i'.
     * Este método utiliza o valor padrão de 'i' (que é 12) para somar todos os números
     * de 1 até 12, como descrito no desafio.
     *
     * @return O resultado final da soma até o valor de 'i'.
     */
    public int somarNumeroPadrao() {
        return somar(i); // Chama o método privado 'somar' passando o valor padrão 'i'
    }

    /**
     * Método privado que realiza a soma de 1 até o número fornecido como parâmetro.
     * O método incrementa o valor de 'k' até que ele atinja o número fornecido, acumulando
     * o resultado na variável 'soma'.
     *
     * @param numero O número até o qual a soma será realizada.
     * @return O resultado final da soma até o número especificado.
     */
    private int somar(int numero) {
        while(k != numero) { // Loop que continua até que 'k' seja diferente do número fornecido
            k = k + 1; // Incrementa o valor de 'k' em 1 a cada iteração
            this.soma = soma + k; // Adiciona o valor atual de 'k' à variável 'soma'
        }

        // Retorna o resultado final da soma chamando o método 'getSoma'
        return getSoma();
    }

    /**
     * Método público que permite somar até um número especificado pelo usuário.
     * Este método é semelhante ao 'somarNumeroPadrao', mas permite que o usuário
     * forneça o valor até onde a soma deve ser realizada.
     */
    public int escolherSomarNumero(int numero) {
        return somar(numero); // Chama o método privado 'somar' passando o número especificado
    }

    //    Este método permite que outras classes ou métodos obtenham o valor acumulado da soma.
    public int getSoma() {
        return soma;
    }
}