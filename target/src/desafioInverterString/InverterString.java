package desafioInverterString;

public class InverterString {

    // Método para inverter os caracteres da string
    public static String inverter(String str) {
        char[] caracteres = str.toCharArray(); // Converte a string em um array de caracteres
        int inicio = 0; // Índice inicial
        int fim = caracteres.length - 1; // Índice final

        // Troca os caracteres do início com os do fim até chegar ao meio do array
        while (inicio < fim) {
            char temp = caracteres[inicio];
            caracteres[inicio] = caracteres[fim];
            caracteres[fim] = temp;
            inicio++;
            fim--;
        }

        // Converte o array de caracteres de volta para uma string
        return new String(caracteres);
    }
}
