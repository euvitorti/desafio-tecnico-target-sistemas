package desafioFaturamento;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Faturamento {

    private double[] faturamentos;

    // Construtor privado para uso interno na leitura dos dados
    private Faturamento(double[] faturamentos) {
        this.faturamentos = faturamentos;
    }

    // Método estático para criar uma instância de Faturamento a partir de um arquivo XML
    public static Faturamento fromXML(String caminhoArquivo) throws Exception {
        List<Double> faturamentos = new ArrayList<>();

        // Usa o ClassLoader para carregar o arquivo do classpath
        ClassLoader classLoader = Faturamento.class.getClassLoader();
        File file = new File(classLoader.getResource(caminhoArquivo).getFile());

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);
        document.getDocumentElement().normalize();

        NodeList nodeList = document.getElementsByTagName("dia");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            String valorFaturamento = element.getElementsByTagName("faturamento").item(0).getTextContent();

            if (valorFaturamento != null && !valorFaturamento.isEmpty()) {
                double valor = Double.parseDouble(valorFaturamento);
                if (valor > 0) { // Considera apenas dias com faturamento positivo
                    faturamentos.add(valor);
                }
            }
        }

        return new Faturamento(faturamentos.stream().mapToDouble(Double::doubleValue).toArray());
    }

//    // Método privado para ler o arquivo XML e retornar os faturamentos
//    private static double[] lerFaturamentosDeArquivo(String caminhoArquivo) throws Exception {
//        List<Double> faturamentos = new ArrayList<>();
//        File file = new File(caminhoArquivo);
//
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder builder = factory.newDocumentBuilder();
//        Document document = builder.parse(file);
//        document.getDocumentElement().normalize();
//
//        NodeList nodeList = document.getElementsByTagName("dia");
//
//        for (int i = 0; i < nodeList.getLength(); i++) {
//            Element element = (Element) nodeList.item(i);
//            String valorFaturamento = element.getElementsByTagName("faturamento").item(0).getTextContent();
//
//            if (valorFaturamento != null && !valorFaturamento.isEmpty()) {
//                double valor = Double.parseDouble(valorFaturamento);
//                if (valor > 0) { // Considera apenas dias com faturamento positivo
//                    faturamentos.add(valor);
//                }
//            }
//        }
//
//        return faturamentos.stream().mapToDouble(Double::doubleValue).toArray();
//    }

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
