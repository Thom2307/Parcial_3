package co.edu.uniquindio.poo.Punto1;

public class Historial {

    public static void main(String[] args) {
        Pila<Operacion> historial = new Pila<>();

        historial.apilar(new Operacion("O1", "ANULADA"));
        historial.apilar(new Operacion("O2", "CONFIRMADA"));
        historial.apilar(new Operacion("O3", "CONFIRMADA"));
        historial.apilar(new Operacion("O4", "ANULADA"));
        historial.apilar(new Operacion("O5", "CONFIRMADA"));

        System.out.println("--- Prueba Punto 1.0 ---");
        System.out.println("Tamaño del historial original antes: " + historial.getTamano());

        int n = 2;
        Pila<Operacion> resultado = obtenerUltimasConfirmadas(historial, n);

        System.out.println("\nPila resultante (leída desde el tope hacia abajo):");
        while (!resultado.estaVacia()) {
            Operacion op = resultado.desapilar();
            System.out.println("- " + op.getCodigo() + " " + op.getEstado());
        }

        System.out.println("\nTamaño del historial original después: " + historial.getTamano());

    }

    public static Pila<Operacion> obtenerUltimasConfirmadas(Pila<Operacion> historial, int n) {
        Pila<Operacion> resultado = new Pila<>();

        if (n <= 0 || historial.estaVacia()) {
            return resultado;
        }

        Pila<Operacion> aux = new Pila<>();
        Pila<Operacion> tempConfirmadas = new Pila<>();
        int encontradas = 0;

        while (!historial.estaVacia()) {
            Operacion opActual = historial.desapilar();
            aux.apilar(opActual);

            if (opActual.getEstado().equals("CONFIRMADA") && encontradas < n) {
                tempConfirmadas.apilar(opActual);
                encontradas++;
            }
        }

        while (!aux.estaVacia()) {
            historial.apilar(aux.desapilar());
        }

        while (!tempConfirmadas.estaVacia()) {
            resultado.apilar(tempConfirmadas.desapilar());
        }

        return resultado;
    }
}