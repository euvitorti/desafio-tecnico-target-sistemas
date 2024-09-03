package lerArquivoXml;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class LerXML {

    // Método para ler e retornar o objeto Document de um arquivo XML
    public static Document fromXML(String caminhoArquivo, Class<?> className) throws Exception {
        // Usa o ClassLoader da classe fornecida
        ClassLoader classLoader = className.getClassLoader();
        File file = new File(classLoader.getResource(caminhoArquivo).getFile());

        // Configura e cria o DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Lê e retorna o objeto Document que representa o conteúdo do arquivo XML
        return builder.parse(file);
    }
}
