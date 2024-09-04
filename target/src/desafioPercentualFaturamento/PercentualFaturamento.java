package desafioPercentualFaturamento;

import lerArquivoXml.LerXML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class PercentualFaturamento {

    // Caminho padrão para o arquivo XML que contém os dados de faturamento
    private static final String CAMINHO_PADRAO_ARQUIVO_XML = "arquivosFaturamento/percentualFaturamento.xml";

    // Lista para armazenar os valores de faturamento
    private List<Double> faturamentos;

    // Lista para armazenar os nomes dos estados correspondentes aos faturamentos
    private List<String> estados;

    // Construtor privado, chamado apenas internamente, que inicializa as listas de faturamentos e estados
    private PercentualFaturamento(List<Double> faturamentos, List<String> estados) {
        this.faturamentos = faturamentos;
        this.estados = estados;
    }

    // Método estático que cria uma instância de PercentualFaturamento a partir dos dados de um arquivo XML
    public static PercentualFaturamento fromXML() {

        // Listas para armazenar temporariamente os dados extraídos do XML
        List<Double> faturamentos = new ArrayList<>();
        List<String> estados = new ArrayList<>();

        try {
            // Analisa o arquivo XML e cria um objeto Document para manipular a estrutura do XML
            Document document = LerXML.fromXML(CAMINHO_PADRAO_ARQUIVO_XML, PercentualFaturamento.class);

            // Obtém todos os elementos "estado" do arquivo XML
            NodeList nodeList = document.getElementsByTagName("estado");

            // Itera sobre cada elemento "estado" para extrair o nome do estado e o faturamento
            for (int i = 0; i < nodeList.getLength(); i++) {

                // Pega o elemento atual da lista
                Element element = (Element) nodeList.item(i);

                // Extrai o nome do estado
                String nomeEstado = element.getElementsByTagName("nome").item(0).getTextContent();

                // Extrai o valor de faturamento como String
                String valorFaturamento = element.getElementsByTagName("faturamento").item(0).getTextContent();

                // Verifica se o valor de faturamento não é nulo ou vazio
                if (valorFaturamento != null && !valorFaturamento.isEmpty()) {
                    try {
                        // Converte o valor de faturamento de String para double
                        double valor = Double.parseDouble(valorFaturamento);

                        // Se o valor do faturamento for positivo, adiciona às listas de faturamentos e estados
                        if (valor > 0) {
                            faturamentos.add(valor);
                            estados.add(nomeEstado);
                        }
                    } catch (NumberFormatException e) {
                        // Tratamento para caso o valor não possa ser convertido para double
                        System.err.println("Valor de faturamento inválido: " + valorFaturamento);
                    }
                }
            }

        } catch (Exception e) {
            // Tratamento de exceções relacionadas à leitura do arquivo XML
            e.printStackTrace();
        }

        // Retorna uma nova instância de PercentualFaturamento com os dados extraídos
        return new PercentualFaturamento(faturamentos, estados);
    }

    // Método para calcular e exibir os percentuais de faturamento de cada estado
    public void calcularPercentuais() {

        // Calcula o faturamento total somando todos os valores da lista de faturamentos
        double totalFaturamento = faturamentos.stream().mapToDouble(Double::doubleValue).sum();

        // Exibe o percentual de faturamento correspondente a cada estado
        System.out.println("\nPercentual de Faturamento por Estado:");

        // Itera sobre cada faturamento e estado para calcular e exibir o percentual
        for (int i = 0; i < faturamentos.size(); i++) {

            // Calcula o percentual de faturamento para o estado atual
            double percentual = (faturamentos.get(i) / totalFaturamento) * 100;

            // Exibe o nome do estado e o percentual de faturamento formatado
            System.out.printf("%s: %.2f%%\n", estados.get(i), percentual);
        }
    }
}
