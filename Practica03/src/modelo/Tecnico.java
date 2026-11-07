package modelo;

// RF-03: Registrar un empleado técnico
public class Tecnico extends Obrero {

    private String claveAcceso;

    public Tecnico(String nombre, String cedula,
                   String codigo, String claveAcceso) {

        super(nombre, cedula, codigo);
        this.claveAcceso = claveAcceso;
    }

    public String getClaveAcceso() {
        return claveAcceso;
    }

    @Override
    public String getTipo() {
        return "Tecnico";
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nClave de acceso: " + claveAcceso;
    }
}