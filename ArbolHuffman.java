public class ArbolHuffman {
    NodoH raiz;

    // Insertar nodo árbol Huffman
    public void insertar(NodoH nodo) {
        // Raíz nula, el nodo insertado se convierte en la raíz
        if (raiz == null) {
            raiz = nodo;
        } else {
            // Frecuencia (nuevo nodo) <= raíz,
            // nuevo nodo se convierte en la nueva raíz y el antiguo nodo raíz se convierte
            // en su hijo izquierdo
            if (nodo.frecuencia <= raiz.frecuencia) {
                NodoH temp = raiz;
                raiz = nodo;
                nodo.izquierda = temp;
            } else {
                // Frecuencia (nuevo nodo) > raíz,
                // se busca lugar para insertarlo en el árbol
                NodoH actual = raiz;
                NodoH padre = null;
                while (actual != null && actual.frecuencia < nodo.frecuencia) {
                    padre = actual;
                    actual = actual.derecha;
                }
                // Se inserta el nuevo nodo en el lugar adecuado
                padre.derecha = nodo;
                nodo.izquierda = actual;
            }
        }
    }

    // Construir árbol Huffman
    public void construir(String texto) {
        // Contar frecuencia c/carácter en el texto (solo ASCII)
        int[] frecuencia = new int[256];
        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            frecuencia[caracter]++;
        }

        // Crear nodo para c/carácter y su frecuencia, agregarlo al árbol
        for (int i = 0; i < frecuencia.length; i++) {
            if (frecuencia[i] != 0) {
                NodoH nodo = new NodoH((char) i, frecuencia[i]);
                insertar(nodo);
            }
        }
    }
}