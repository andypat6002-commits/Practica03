package vista;

import javax.swing.*;
import java.awt.*;
import controlador.ControladorEmpleados;
import modelo.Persona;

public class VentanaPrincipal extends JFrame {

    private ControladorEmpleados controlador;

    private JTextField txtNombre;
    private JTextField txtCedula;
    private JTextField txtDato1;
    private JTextField txtDato2;

    private JComboBox<String> cmbTipo;
    private JTextArea areaResultado;

    public VentanaPrincipal() {

        controlador = new ControladorEmpleados();

        setTitle("Sistema de Gestión de Empleados");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        // Panel principal
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        panel.setBorder(
            BorderFactory.createEmptyBorder(15, 15, 15, 15));

        cmbTipo = new JComboBox<>(
            new String[]{"Administrativo", "Obrero", "Tecnico"});

        txtNombre = new JTextField();
        txtCedula = new JTextField();
        txtDato1 = new JTextField();
        txtDato2 = new JTextField();

        panel.add(new JLabel("Tipo de empleado:"));
        panel.add(cmbTipo);

        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombre);

        panel.add(new JLabel("Cédula:"));
        panel.add(txtCedula);

        panel.add(new JLabel("Cargo / Código:"));
        panel.add(txtDato1);

        panel.add(new JLabel("Clave de acceso (Técnico):"));
        panel.add(txtDato2);

        JButton btnRegistrar = new JButton("Registrar");
        JButton btnConsultar = new JButton("Consultar");
        JButton btnListar = new JButton("Listar todos");

        panel.add(btnRegistrar);
        panel.add(btnConsultar);
        panel.add(btnListar);

        areaResultado = new JTextArea(10, 40);
        areaResultado.setEditable(false);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(areaResultado), BorderLayout.CENTER);

        // Acción del botón Registrar
        btnRegistrar.addActionListener(e -> registrar());

        // Acción del botón Consultar
        btnConsultar.addActionListener(e -> consultar());

        // Acción del botón Listar
        btnListar.addActionListener(e -> listar());

    }

    private void registrar() {

        String tipo = (String) cmbTipo.getSelectedItem();

        String nombre = txtNombre.getText();
        String cedula = txtCedula.getText();
        String dato1 = txtDato1.getText();
        String dato2 = txtDato2.getText();

        String mensaje = "";

        if (tipo.equals("Administrativo")) {

            mensaje = controlador.registrarAdministrativo(
                nombre, cedula, dato1);

        } else if (tipo.equals("Obrero")) {

            mensaje = controlador.registrarObrero(
                nombre, cedula, dato1);

        } else {

            mensaje = controlador.registrarTecnico(
                nombre, cedula, dato1, dato2);
        }

        areaResultado.setText(mensaje);
    }

    private void consultar() {

        String cedula = txtCedula.getText();

        if (!cedula.matches("\\d{10}")) {
            areaResultado.setText(
                "Ingrese una cédula válida de 10 dígitos.");
            return;
        }

        Persona empleado = controlador.consultar(cedula);

        if (empleado != null) {
            areaResultado.setText(empleado.toString());
        } else {
            areaResultado.setText(
                "Empleado no encontrado.");
        }
    }

    private void listar() {

        StringBuilder resultado = new StringBuilder();

        resultado.append("ADMINISTRATIVOS\n");

        controlador.listarAdministrativos().forEach(
            p -> resultado.append(p).append("\n\n"));

        resultado.append("OBREROS\n");

        controlador.listarObreros().forEach(
            p -> resultado.append(p).append("\n\n"));

        resultado.append("TÉCNICOS\n");

        controlador.listarTecnicos().forEach(
            p -> resultado.append(p).append("\n\n"));

        areaResultado.setText(resultado.toString());
    }
}