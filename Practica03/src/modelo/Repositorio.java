package modelo;

import java.util.ArrayList;

// RNF-01 y RNF-02: Clase genérica y ArrayList
public class Repositorio<T extends Persona> {

    private ArrayList<T> empleados;

    public Repositorio() {
        empleados = new ArrayList<>();
    }

    // Método para registrar empleados
    public void agregar(T empleado) {
        empleados.add(empleado);
    }

    // Método para buscar empleados por cédula
    public T buscarPorCedula(String cedula) {

        for (T empleado : empleados) {

            if (empleado.getCedula().equals(cedula)) {
                return empleado;
            }
        }

        return null;
    }

    // Método para listar empleados
    public ArrayList<T> listar() {
        return empleados;
    }

    // Método para contar empleados
    public int cantidad() {
        Integer total = empleados.size(); // Boxing
        return total; // Unboxing
    }
}