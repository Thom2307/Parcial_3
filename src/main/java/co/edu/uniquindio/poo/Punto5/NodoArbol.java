package co.edu.uniquindio.poo.Punto5;

public class NodoArbol<T> {
    private T dato;
    private NodoArbol<T> hijoIzq;
    private NodoArbol<T> hijoDer;

    public NodoArbol(T dato) {
        this.dato = dato;
        this.hijoIzq = null;
        this.hijoDer = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoArbol<T> getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoIzq(NodoArbol<T> hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public NodoArbol<T> getHijoDer() {
        return hijoDer;
    }

    public void setHijoDer(NodoArbol<T> hijoDer) {
        this.hijoDer = hijoDer;
    }
}