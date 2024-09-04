package lerArquivoXml;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class LerXML {

    // Método estático para ler e retornar um objeto Document a partir de um arquivo XML
    public static Document fromXML(String caminhoArquivo, Class<?> className) throws Exception {
        // Obtém o ClassLoader da classe fornecida para localizar o arquivo XML
        ClassLoader classLoader = className.getClassLoader();

        // Cria um objeto File a partir do caminho do recurso XML
        File file = new File(classLoader.getResource(caminhoArquivo).getFile());

        // Cria uma instância de DocumentBuilderFactory para configurar o DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Cria um DocumentBuilder a partir da fábrica
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Lê o conteúdo do arquivo XML e retorna o objeto Document que representa a estrutura do XML
        return builder.parse(file);
    }
}
