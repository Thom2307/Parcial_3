package co.edu.uniquindio.poo.Punto5;

import co.edu.uniquindio.poo.Punto3.Cola;

public class Arbol<T extends Comparable<T>> {

    private NodoArbol<T> raiz;

    public Arbol() {
        this.raiz = null;
    }

    public NodoArbol<T> getRaiz() {
        return raiz;
    }

    // ==========================================
    // INSERCIÓN DE NODOS
    // ==========================================

    public void insertar(T dato) {
        raiz = insertarRecursivo(raiz, dato);
    }

    private NodoArbol<T> insertarRecursivo(NodoArbol<T> actual, T dato) {
        if (actual == null) {
            return new NodoArbol<>(dato);
        }
        if (dato.compareTo(actual.getDato()) < 0) {
            actual.setHijoIzq(insertarRecursivo(actual.getHijoIzq(), dato));
        } else if (dato.compareTo(actual.getDato()) > 0) {
            actual.setHijoDer(insertarRecursivo(actual.getHijoDer(), dato));
        }
        return actual;
    }

    // ==========================================
    // RECORRIDOS EN PROFUNDIDAD (RECURSIVOS)
    // ==========================================

    // Preorden: Raíz -> Izquierda -> Derecha
    public void preOrden() {
        System.out.print("Preorden:  ");
        preOrdenRecursivo(raiz);
        System.out.println();
    }

    private void preOrdenRecursivo(NodoArbol<T> nodo) {
        if (nodo != null) {
            System.out.print(nodo.getDato() + " ");
            preOrdenRecursivo(nodo.getHijoIzq());
            preOrdenRecursivo(nodo.getHijoDer());
        }
    }

    // Inorden: Izquierda -> Raíz -> Derecha
    public void inOrden() {
        System.out.print("Inorden:   ");
        inOrdenRecursivo(raiz);
        System.out.println();
    }

    private void inOrdenRecursivo(NodoArbol<T> nodo) {
        if (nodo != null) {
            inOrdenRecursivo(nodo.getHijoIzq());
            System.out.print(nodo.getDato() + " ");
            inOrdenRecursivo(nodo.getHijoDer());
        }
    }

    // Postorden: Izquierda -> Derecha -> Raíz
    public void postOrden() {
        System.out.print("Postorden: ");
        postOrdenRecursivo(raiz);
        System.out.println();
    }

    private void postOrdenRecursivo(NodoArbol<T> nodo) {
        if (nodo != null) {
            postOrdenRecursivo(nodo.getHijoIzq());
            postOrdenRecursivo(nodo.getHijoDer());
            System.out.print(nodo.getDato() + " ");
        }
    }

    // ==========================================
    // RECORRIDO EN AMPLITUD (BFS CON COLA PROPIA)
    // ==========================================

    public void recorridoAmplitud() {
        System.out.print("Amplitud:  ");
        if (raiz == null) {
            System.out.println("(Árbol vacío)");
            return;
        }

        Cola<NodoArbol<T>> cola = new Cola<>();
        cola.encolar(raiz);

        while (!cola.estavacia()) {
            NodoArbol<T> actual = cola.desencolar();
            System.out.print(actual.getDato() + " ");

            if (actual.getHijoIzq() != null) {
                cola.encolar(actual.getHijoIzq());
            }
            if (actual.getHijoDer() != null) {
                cola.encolar(actual.getHijoDer());
            }
        }
        System.out.println();
    }
}