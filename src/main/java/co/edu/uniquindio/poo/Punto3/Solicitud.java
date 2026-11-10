package co.edu.uniquindio.poo.Punto3;

public class Solicitud {
    private String codigo;
    private String prioridad;
    private int duracionMinutos;

    public Solicitud(String codigo, String prioridad, int duracionMinutos) {
        this.codigo = codigo;
        this.prioridad = prioridad;
        this.duracionMinutos = duracionMinutos;
    }

    public String getCodigo() { return codigo; }
    public String getPrioridad() { return prioridad; }
    public int getDuracionMinutos() { return duracionMinutos; }

    @Override
    public String toString() {
        return codigo + " " + prioridad.toLowerCase() + " " + duracionMinutos + " min";
    }
}