package modelo;

// RF-01: Registrar un empleado administrativo
public class Administrativo extends Persona {

    private String cargo;

    public Administrativo(String nombre, String cedula, String cargo) {
        super(nombre, cedula);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String getTipo() {
        return "Administrativo";
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nCargo: " + cargo;
    }
}