package modelo;

public abstract class Persona {

    private String nombre;
    private String cedula;

    public Persona(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public abstract String getTipo();

    @Override
    public String toString() {
        return "Nombre: " + nombre +
               "\nCedula: " + cedula +
               "\nTipo: " + getTipo();
    }
}