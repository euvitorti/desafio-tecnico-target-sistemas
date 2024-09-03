package desafioPercentualFaturamento;

import lerArquivoXml.LerXML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class PercentualFaturamento {

    private static final String CAMINHO_PADRAO_ARQUIVO_XML = "arquivosFaturamento/percentualFaturamento.xml";
    private List<Double> faturamentos;
    private List<String> estados;

    // Construtor privado para uso interno na leitura dos dados
    private PercentualFaturamento(List<Double> faturamentos, List<String> estados) {
        this.faturamentos = faturamentos;
        this.estados = estados;
    }

    // Método estático para criar uma instância de PercentualFaturamento a partir de um arquivo XML
    public static PercentualFaturamento fromXML() {

        List<Double> faturamentos = new ArrayList<>();
        List<String> estados = new ArrayList<>();

        try {

            // Analisa o arquivo XML e cria um objeto Document
            Document document = LerXML.fromXML(CAMINHO_PADRAO_ARQUIVO_XML, PercentualFaturamento.class);

            // Obtém todos os elementos com a tag "estado"
            NodeList nodeList = document.getElementsByTagName("estado");

            // Itera sobre os elementos "estado" e extrai os dados
            for (int i = 0; i < nodeList.getLength(); i++) {

                Element element = (Element) nodeList.item(i);
                String nomeEstado = element.getElementsByTagName("nome").item(0).getTextContent();
                String valorFaturamento = element.getElementsByTagName("faturamento").item(0).getTextContent();

                if (valorFaturamento != null && !valorFaturamento.isEmpty()) {
                    try {

                        // Converte o valor de faturamento para double
                        double valor = Double.parseDouble(valorFaturamento);

                        if (valor > 0) { // Considera apenas faturamentos positivos
                            faturamentos.add(valor);
                            estados.add(nomeEstado);
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

        // Retorna uma nova instância de PercentualFaturamento com os dados carregados
        return new PercentualFaturamento(faturamentos, estados);
    }

    // Método para calcular e exibir o percentual de faturamento por estado
    public void calcularPercentuais() {

        // Calcula o total de faturamento somando todos os valores
        double totalFaturamento = faturamentos.stream().mapToDouble(Double::doubleValue).sum();

        // Exibe o percentual de faturamento de cada estado
        System.out.println("\nPercentual de Faturamento por Estado:");

        for (int i = 0; i < faturamentos.size(); i++) {

            // Calcula o percentual de faturamento de um estado específico
            double percentual = (faturamentos.get(i) / totalFaturamento) * 100;
            System.out.printf("%s: %.2f%%\n", estados.get(i), percentual);
        }
    }
}
