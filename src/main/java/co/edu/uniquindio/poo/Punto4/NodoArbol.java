package co.edu.uniquindio.poo.Punto4;

public class NodoArbol {
    private int clave;
    private NodoArbol hijoIzq;
    private NodoArbol hijoDer;

    public NodoArbol(int clave) {
        this.clave = clave;
        this.hijoIzq = null;
        this.hijoDer = null;
    }

    public int getClave() { return clave; }
    public NodoArbol getHijoIzq() { return hijoIzq; }
    public void setHijoIzq(NodoArbol hijoIzq) { this.hijoIzq = hijoIzq; }
    public NodoArbol getHijoDer() { return hijoDer; }
    public void setHijoDer(NodoArbol hijoDer) { this.hijoDer = hijoDer; }
}