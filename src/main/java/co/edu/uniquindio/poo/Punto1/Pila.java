package co.edu.uniquindio.poo.Punto1;

public class Pila<T> {
    private Nodo<T> tope;
    private int tamano;

    public Pila() {
        this.tope = null;
        this.tamano = 0;
    }

    public void apilar(T elemento) {
        Nodo<T> nodito = new Nodo<>(elemento);
        if (tope != null) {
            nodito.setSiguiente(tope);
        }
        tope = nodito;
        tamano++;
    }

    public T desapilar() {
        if (estaVacia()) {
            return null;
        }
        T dato = tope.getDato();
        tope = tope.getSiguiente();
        tamano--;
        return dato;
    }
    public T verTope() {
        if (estaVacia()) {
            return null;
        }
        return tope.getDato();
    }

    public boolean estaVacia() {
        return tope == null;
    }

    public int getTamano() {
        return tamano;
    }
}
