package co.edu.uniquindio.poo.Punto2;
import co.edu.uniquindio.poo.Punto1.Pila;

public class Main2 {
    public static void main(String[] args) {
            // 1. Creamos la pila original
            Pila<String> historial = new Pila<>();

            // 2. Apilamos de abajo hacia arriba para que A6 quede en el tope (posición 1)
            historial.apilar("A1");
            historial.apilar("A2");
            historial.apilar("A3");
            historial.apilar("A4");
            historial.apilar("A5");
            historial.apilar("A6");

            int inicio = 2;
            int fin = 4;

            Pila<String> resultado = obtenerSegmento(historial, inicio, fin);

            System.out.println("Pila resultante:");
            while (!resultado.estaVacia()) {
                System.out.println("- " + resultado.desapilar());
            }

            System.out.println("\nTamaño del historial original intacto: " + historial.getTamano());
        }

        public static Pila<String> obtenerSegmento(Pila<String> historial, int inicio, int fin) {
            Pila<String> resultado = new Pila<>();

            if (inicio < 1 || inicio > fin || fin > historial.getTamano()) {
                return resultado;
            }

            Pila<String> auxiliar = new Pila<>();
            Pila<String> tempSegmento = new Pila<>();
            int posicionActual = 1;

            // Fase 1: Recorrer, contar y separar
            while (!historial.estaVacia()) {
                String accion = historial.desapilar();
                auxiliar.apilar(accion); // Guardar para no dañar el historial

                // Si la posición actual está dentro del rango (inicio a fin), lo separamos
                if (posicionActual >= inicio && posicionActual <= fin) {
                    tempSegmento.apilar(accion);
                }
                posicionActual++;
            }

            // Fase 2: Restaurar la pila original exactamente igual
            while (!auxiliar.estaVacia()) {
                historial.apilar(auxiliar.desapilar());
            }

            // Fase 3: Invertir el segmento para que el índice de 'inicio' quede en el tope
            while (!tempSegmento.estaVacia()) {
                resultado.apilar(tempSegmento.desapilar());
            }

            return resultado;
        }
    }

