package co.edu.uniquindio.poo.Punto3;

public class Main3 {
    public static void main(String[] args) {

        Cola<Solicitud> pendientes = new Cola<>();
        pendientes.encolar(new Solicitud("S1", "NORMAL", 10));
        pendientes.encolar(new Solicitud("S2", "ALTA", 30));
        pendientes.encolar(new Solicitud("S3", "ALTA", 15));
        pendientes.encolar(new Solicitud("S4", "NORMAL", 5));

        int minutosDisponibles = 25;

        Cola<Solicitud> seleccionadas = seleccionarSolicitudes(pendientes, minutosDisponibles);

        // 3. Mostramos las solicitudes seleccionadas
        System.out.println("\nCola de Seleccionadas:");
        imprimirCola(seleccionadas);

        // 4. Mostramos cómo quedó la cola de pendientes original (Debe quedar S2 -> S4)
        System.out.println("\nCola de Pendientes restante:");
        imprimirCola(pendientes);
    }
    public static Cola<Solicitud> seleccionarSolicitudes(Cola<Solicitud> pendientes, int minutosDisponibles) {
        Cola<Solicitud> seleccionadas = new Cola<>();
        if (minutosDisponibles <= 0 || pendientes.estavacia()) {
            return seleccionadas;
        }

        Cola<Solicitud> altas = new Cola<>();
        Cola<Solicitud> normales = new Cola<>();

        while (!pendientes.estavacia()) {
            Solicitud solicitud = pendientes.desencolar();
            if (solicitud.getPrioridad().equalsIgnoreCase("Alta")) {
                altas.encolar(solicitud);
            } else {
                normales.encolar(solicitud);
            }
        }

        while (!altas.estavacia()) {
            Solicitud solicitud = altas.desencolar();
            if (solicitud.getDuracionMinutos() <= minutosDisponibles) {
                seleccionadas.encolar(solicitud);
                minutosDisponibles -= solicitud.getDuracionMinutos();
            } else {
                pendientes.encolar(solicitud);
            }
        }

        while (!normales.estavacia()) {
            Solicitud solicitud = normales.desencolar();
            if (solicitud.getDuracionMinutos() <= minutosDisponibles) {
                seleccionadas.encolar(solicitud);
                minutosDisponibles -= solicitud.getDuracionMinutos();
            } else {
                pendientes.encolar(solicitud);
            }
        }
        return seleccionadas;
    }

    public static void imprimirCola(Cola<Solicitud> cola) {
        if (cola.estavacia()) {
            System.out.println("La cola esta vacia");
        } else {
            Cola<Solicitud> auxiliar = new Cola<>();
            while (!cola.estavacia()) {
                Solicitud s = cola.desencolar();
                System.out.print(s.getCodigo() + " -> ");
                auxiliar.encolar(s);
            }
            System.out.println("FIN");

            while (!auxiliar.estavacia()) {
                cola.encolar(auxiliar.desencolar());
            }
        }

    }

}
