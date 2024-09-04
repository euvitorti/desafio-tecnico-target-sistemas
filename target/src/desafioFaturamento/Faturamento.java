package desafioFaturamento;

import lerArquivoXml.LerXML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class Faturamento {

    // Caminho padrão do arquivo XML contendo os dados de faturamento
    private static final String CAMINHO_PADRAO_ARQUIVO_XML = "arquivosFaturamento/faturamentos.xml";

    // Array para armazenar os valores de faturamento
    private double[] faturamentos;

    // Construtor privado para inicializar a instância com os dados de faturamento
    private Faturamento(double[] faturamentos) {
        this.faturamentos = faturamentos;
    }

    // Método estático para criar uma instância de Faturamento a partir de um arquivo XML
    public static Faturamento fromXML() {
        List<Double> faturamentos = new ArrayList<>();

        try {
            // Analisa o arquivo XML e cria um objeto Document
            Document document = LerXML.fromXML(CAMINHO_PADRAO_ARQUIVO_XML, Faturamento.class);

            // Obtém todos os elementos com a tag "dia"
            NodeList nodeList = document.getElementsByTagName("dia");

            // Itera sobre os elementos "dia" e extrai os dados de faturamento
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                String valorFaturamento = element.getElementsByTagName("faturamento").item(0).getTextContent();

                // Verifica se o valor de faturamento é não-nulo e não vazio
                if (valorFaturamento != null && !valorFaturamento.isEmpty()) {
                    try {
                        // Converte o valor de faturamento para double
                        double valor = Double.parseDouble(valorFaturamento);

                        // Considera apenas faturamentos positivos
                        if (valor > 0) {
                            faturamentos.add(valor);
                        }
                    } catch (NumberFormatException e) {
                        // Trata o caso onde o valor de faturamento não pode ser convertido para double
                        System.err.println("Valor de faturamento inválido: " + valorFaturamento);
                    }
                }
            }

        } catch (Exception e) {
            // Trata exceções relacionadas ao carregamento do arquivo, parsing XML, etc.
            e.printStackTrace();
        }

        // Converte a lista de faturamentos para um array de doubles e cria uma instância de Faturamento
        return new Faturamento(faturamentos.stream().mapToDouble(Double::doubleValue).toArray());
    }

    // Método para encontrar o menor valor de faturamento
    public double menorFaturamento() {
        double menor = Double.MAX_VALUE;

        // Itera sobre o array de faturamentos para encontrar o menor valor maior que zero
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

        // Itera sobre o array de faturamentos para encontrar o maior valor
        for (double faturamento : faturamentos) {
            if (faturamento > maior) {
                maior = faturamento;
            }
        }
        return maior;
    }

    // Método para calcular a média mensal de faturamento
    public double mediaMensal() {
        double soma = 0;
        int count = 0;

        // Calcula a soma de todos os faturamentos positivos e conta os dias válidos
        for (double faturamento : faturamentos) {
            if (faturamento > 0) {
                soma += faturamento;
                count++;
            }
        }

        // Retorna a média ou 0 se não houver dias válidos
        return (count > 0) ? soma / count : 0;
    }

    // Método para contar os dias com faturamento superior à média mensal
    public int diasAcimaDaMedia() {
        double media = mediaMensal();
        int count = 0;

        // Conta quantos dias tiveram faturamento acima da média mensal
        for (double faturamento : faturamentos) {
            if (faturamento > media) {
                count++;
            }
        }
        return count;
    }

    // Método para exibir as informações de faturamento
    public void mostrarFaturamento() {

        // Obtém o menor e maior faturamento, a média mensal e o número de dias acima da média
        double menorFaturamento = menorFaturamento();
        double maiorFaturamento = maiorFaturamento();
        double mediaMensal = mediaMensal();
        int diasAcimaDaMedia = diasAcimaDaMedia();

        // Exibe as informações formatadas
        System.out.printf("""
                   Menor valor de faturamento: %.2f
                   Maior valor de faturamento: %.2f
                   Média mensal: %.2f
                   Número de dias com faturamento acima da média: %d"""
                , menorFaturamento, maiorFaturamento, mediaMensal, diasAcimaDaMedia);
    }
}
