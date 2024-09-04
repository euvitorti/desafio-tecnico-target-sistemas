package desafioInverterString;

public class InverterString {

    // Método para inverter os caracteres de uma string
    public static void inverter(String str) {
        char[] caracteres = str.toCharArray(); // Converte a string em um array de caracteres
        int inicio = 0; // Índice inicial (primeiro caractere)
        int fim = caracteres.length - 1; // Índice final (último caractere)

        // Troca os caracteres do início com os do fim até que os índices se encontrem ou se cruzem
        while (inicio < fim) {
            char temp = caracteres[inicio]; // Armazena temporariamente o caractere no índice 'inicio'
            caracteres[inicio] = caracteres[fim]; // Substitui o caractere no índice 'inicio' pelo caractere no índice 'fim'
            caracteres[fim] = temp; // Coloca o caractere armazenado temporariamente no índice 'fim'
            inicio++; // Avança o índice 'inicio' para a próxima posição
            fim--; // Retrocede o índice 'fim' para a posição anterior
        }

        // Converte o array de caracteres de volta para uma string e imprime o resultado
        System.out.printf("Palavra invertida: %s.", new String(caracteres));
    }
}
