package modelo;

// RF-02: Registrar un empleado obrero
public class Obrero extends Persona {

    private String codigo;

    public Obrero(String nombre, String cedula, String codigo) {
        super(nombre, cedula);
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String getTipo() {
        return "Obrero";
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nCodigo: " + codigo;
    }
}