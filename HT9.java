import java.io.*;

public class HT9 {
    public static void HT9(String[] args) {
        // Instancia árbol Huffman
        ArbolHuffman arbol = new ArbolHuffman();

        // Leer .txt
        String texto = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("texto.txt"));
            texto = br.readLine();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Construyir árbol Huffman
        arbol.construir(texto);

        // Comprimir el texto
        String codigo = comprimir(texto, arbol);

        // Escribir código y árbol en archivos binarios
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("codigo.huff"));
            bw.write(codigo);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Descomprimir código
        String textoOriginal = descomprimir(codigo, arbol);

        // Verificar texto original y texto descomprimido di son iguales
        assert texto.equals(textoOriginal);
    }

    // Comprimir texto con árbol Huffman
    public static String comprimir(String texto, ArbolHuffman arbol) {
        // Comprimir
        return "";
    }

    // Descomprimir código con árbol Huffman
    public static String descomprimir(String codigo, ArbolHuffman arbol) {
        // descomprimir
        return codigo;

    }
}
