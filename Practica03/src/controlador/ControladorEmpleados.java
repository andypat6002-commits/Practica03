package controlador;

import java.util.ArrayList;
import modelo.*;

// Controlador de gestión de empleados
public class ControladorEmpleados {

    private Repositorio<Administrativo> administrativos;
    private Repositorio<Obrero> obreros;
    private Repositorio<Tecnico> tecnicos;

    public ControladorEmpleados() {
        administrativos = new Repositorio<>();
        obreros = new Repositorio<>();
        tecnicos = new Repositorio<>();
    }

    // RF-01: Registrar administrativo
    public String registrarAdministrativo(
            String nombre, String cedula, String cargo) {

        String error = validar(nombre, cedula);

        if (error != null) return error;

        if (cargo == null || cargo.trim().isEmpty())
            return "El cargo es obligatorio.";

        administrativos.agregar(
            new Administrativo(nombre, cedula, cargo));

        return "Administrativo registrado correctamente.";
    }

    // RF-02: Registrar obrero
    public String registrarObrero(
            String nombre, String cedula, String codigo) {

        String error = validar(nombre, cedula);

        if (error != null) return error;

        if (codigo == null || codigo.trim().isEmpty())
            return "El código es obligatorio.";

        obreros.agregar(new Obrero(nombre, cedula, codigo));

        return "Obrero registrado correctamente.";
    }

    // RF-03: Registrar técnico
    public String registrarTecnico(
            String nombre, String cedula,
            String codigo, String clave) {

        String error = validar(nombre, cedula);

        if (error != null) return error;

        if (codigo == null || codigo.trim().isEmpty())
            return "El código es obligatorio.";

        if (clave == null || clave.trim().isEmpty())
            return "La clave es obligatoria.";

        tecnicos.agregar(
            new Tecnico(nombre, cedula, codigo, clave));

        return "Técnico registrado correctamente.";
    }

    // RF-06: Validaciones generales
    private String validar(String nombre, String cedula) {

        if (nombre == null || nombre.trim().isEmpty())
            return "El nombre es obligatorio.";

        if (cedula == null || !cedula.matches("\\d{10}"))
            return "La cédula debe tener 10 números.";

        if (consultar(cedula) != null)
            return "La cédula ya está registrada.";

        return null;
    }

    // RF-04: Consultar empleado
    public Persona consultar(String cedula) {

        Persona p = administrativos.buscarPorCedula(cedula);

        if (p == null)
            p = obreros.buscarPorCedula(cedula);

        if (p == null)
            p = tecnicos.buscarPorCedula(cedula);

        return p;
    }

    // RF-05: Listar empleados
    public ArrayList<Administrativo> listarAdministrativos() {
        return administrativos.listar();
    }

    public ArrayList<Obrero> listarObreros() {
        return obreros.listar();
    }

    public ArrayList<Tecnico> listarTecnicos() {
        return tecnicos.listar();
    }

    // RNF-01: Métodos genéricos
    public <T extends Persona> T buscar(
            Repositorio<T> repositorio, String cedula) {
        return repositorio.buscarPorCedula(cedula);
    }

    public <T extends Persona> ArrayList<T> listar(
            Repositorio<T> repositorio) {
        return repositorio.listar();
    }
}