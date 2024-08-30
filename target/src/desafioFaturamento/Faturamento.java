package desafioFaturamento;

public class Faturamento {

    private double[] faturamentos;

    // Construtor para inicializar o vetor de faturamentos
    public Faturamento(double[] faturamentos) {
        this.faturamentos = faturamentos;
    }

    // Método para encontrar o menor valor de faturamento
    public double menorFaturamento() {
        double menor = Double.MAX_VALUE;
        for (double faturamento : faturamentos) {
            if (faturamento < menor && faturamento > 0) {
                menor = faturamento;
            }
        }
        return menor;
    }

    // Método para encontrar o maior valor de faturamento
    public double maiorFaturamento() {
        double maior = Double.MIN_VALUE;
        for (double faturamento : faturamentos) {
            if (faturamento > maior) {
                maior = faturamento;
            }
        }
        return maior;
    }

    // Método para calcular a média mensal
    public double mediaMensal() {
        double soma = 0;
        int count = 0;
        for (double faturamento : faturamentos) {
            if (faturamento > 0) {
                soma += faturamento;
                count++;
            }
        }
        return (count > 0) ? soma / count : 0;
    }

    // Método para contar os dias com faturamento superior à média mensal
    public int diasAcimaDaMedia() {
        double media = mediaMensal();
        int count = 0;
        for (double faturamento : faturamentos) {
            if (faturamento > media) {
                count++;
            }
        }
        return count;
    }
}

