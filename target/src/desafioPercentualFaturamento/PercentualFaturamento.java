package desafioPercentualFaturamento;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class PercentualFaturamento {

    private List<Double> faturamentos;
    private List<String> estados;

    // Construtor privado para uso interno na leitura dos dados
    private PercentualFaturamento(List<Double> faturamentos, List<String> estados) {
        this.faturamentos = faturamentos;
        this.estados = estados;
    }

    // Método estático para criar uma instância de PercentualFaturamento a partir de um arquivo XML
    public static PercentualFaturamento fromXML(String caminhoArquivo) throws Exception {
        List<Double> faturamentos = new ArrayList<>();
        List<String> estados = new ArrayList<>();

        // Usa o ClassLoader para carregar o arquivo do classpath
        ClassLoader classLoader = PercentualFaturamento.class.getClassLoader();
        File file = new File(classLoader.getResource(caminhoArquivo).getFile());

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);
        document.getDocumentElement().normalize();

        NodeList nodeList = document.getElementsByTagName("estado");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            String nomeEstado = element.getElementsByTagName("nome").item(0).getTextContent();
            String valorFaturamento = element.getElementsByTagName("faturamento").item(0).getTextContent();

            if (valorFaturamento != null && !valorFaturamento.isEmpty()) {
                double valor = Double.parseDouble(valorFaturamento);
                if (valor > 0) { // Considera apenas faturamentos positivos
                    faturamentos.add(valor);
                    estados.add(nomeEstado);
                }
            }
        }

        return new PercentualFaturamento(faturamentos, estados);
    }

    public void calcularPercentuais() {
        double totalFaturamento = faturamentos.stream().mapToDouble(Double::doubleValue).sum();

        System.out.println("\nPercentual de Faturamento por Estado:");
        for (int i = 0; i < faturamentos.size(); i++) {
            double percentual = (faturamentos.get(i) / totalFaturamento) * 100;
            System.out.printf("%s: %.2f%%\n", estados.get(i), percentual);
        }
    }
}
