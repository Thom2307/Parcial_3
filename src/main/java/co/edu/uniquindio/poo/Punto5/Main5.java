package co.edu.uniquindio.poo.Punto5;

public class Main5 {

    public static void main(String[] args) {
        Arbol<Integer> arbol = new Arbol<>();

        // Lista de inserción del Punto 5.a
        int[] numeros = {
                45, 33, 29, 28, 22, 32, 34, 39,
                36, 43, 60, 47, 46, 50, 49, 55,
                70, 69, 65, 86, 79, 88
        };

        // Inserción de nodos
        for (int numero : numeros) {
            arbol.insertar(numero);
        }

        System.out.println();

        // Recorridos en profundidad (recursivos)
        arbol.preOrden();
        arbol.inOrden();
        arbol.postOrden();

        System.out.println();

        // Recorrido en amplitud (usando la Cola propia)
        arbol.recorridoAmplitud();
    }
}