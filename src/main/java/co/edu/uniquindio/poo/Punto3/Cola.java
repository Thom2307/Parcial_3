package co.edu.uniquindio.poo.Punto3;
import co.edu.uniquindio.poo.Punto1.Nodo;

public class Cola<T> {
    private Nodo<T> frente;
    private Nodo<T> fin;
    private int tamano;

    public Cola() {
        this.frente = null;
        this.fin = null;
        this.tamano = tamano;
    }

    public int getTamano() {
        return tamano;
    }

    public boolean estavacia() {
        return frente == null;

    }

    public void encolar(T elemento) {
        Nodo<T> nodito = new Nodo<>(elemento);
        if (estavacia()) {
            frente = nodito;
        }
        else {
            fin.setSiguiente(nodito);
        }
        fin = nodito;
        tamano++;
    }

    public T desencolar() {
        if (estavacia()) {
            return null;
        }
        T dato = frente.getDato();
        frente = frente.getSiguiente();
        tamano--;
        return dato;
    }

    public T verFrente(T elemento) {
        if (estavacia()) {
            return null;
        }
        return frente.getDato();
    }
}
