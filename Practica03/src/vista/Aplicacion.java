package vista;

import javax.swing.SwingUtilities;

public class Aplicacion {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            VentanaPrincipal ventana =
                new VentanaPrincipal();

            ventana.setVisible(true);

        });
    }
}