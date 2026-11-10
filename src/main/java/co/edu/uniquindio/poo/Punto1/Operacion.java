package co.edu.uniquindio.poo.Punto1;

public class Operacion {
    private String codigo;
    private String estado; // Puede ser "CONFIRMADA" o "ANULADA"

    public Operacion(String codigo, String estado) {
        this.codigo = codigo;
        this.estado = estado;
    }

    public String getCodigo() { return codigo; }
    public String getEstado() { return estado; }

    @Override
    public String toString() {
        return codigo + " " + estado;
    }
}