package co.edu.uniquindio.poo.Punto4;

public class Main4 {

    public static void main(String[] args) {
        NodoArbol raiz = new NodoArbol(50);
        raiz.setHijoIzq(new NodoArbol(30));
        raiz.getHijoIzq().setHijoIzq(new NodoArbol(20));
        raiz.getHijoIzq().setHijoDer(new NodoArbol(40));

        raiz.setHijoDer(new NodoArbol(70));
        raiz.getHijoDer().setHijoIzq(new NodoArbol(60));
        raiz.getHijoDer().setHijoDer(new NodoArbol(80));

        int limiteInferior = 25;
        int limiteSuperior = 65;
        int cantidad = contarEquiposEnRango(raiz, limiteInferior, limiteSuperior);

        System.out.println("Equipos en rango [" + limiteInferior + ", " + limiteSuperior + "]: " + cantidad);
    }

    public static int contarEquiposEnRango(NodoArbol raiz, int limiteInferior, int limiteSuperior) {
        // Caso base: árbol vacío o rango inválido
        if (raiz == null || limiteInferior > limiteSuperior) {
            return 0;
        }

        // Poda 1: Si la clave del equipo es menor al límite inferior, descartamos subárbol izquierdo
        if (raiz.getClave() < limiteInferior) {
            return contarEquiposEnRango(raiz.getHijoDer(), limiteInferior, limiteSuperior);
        }

        // Poda 2: Si la clave del equipo es mayor al límite superior, descartamos subárbol derecho
        if (raiz.getClave() > limiteSuperior) {
            return contarEquiposEnRango(raiz.getHijoIzq(), limiteInferior, limiteSuperior);
        }

        // El nodo actual está dentro del rango, sumamos 1 y evaluamos ambos hijos
        return 1 + contarEquiposEnRango(raiz.getHijoIzq(), limiteInferior, limiteSuperior)
                + contarEquiposEnRango(raiz.getHijoDer(), limiteInferior, limiteSuperior);
    }
}

