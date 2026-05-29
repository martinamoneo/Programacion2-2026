package TP6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// ventana que hereda de JDialog
class DialogoPreferencias extends JDialog {
    // componentes como atributos para poder usarlos
    private JCheckBox chkOscuro;
    private JCheckBox chkNotificaciones;
    private JCheckBox chkAutoguardado;
    private JButton botonAceptar;
    private JLabel etiquetaPrincipal;

    public DialogoPreferencias(JFrame padre, JLabel etiquetaPrincipal) {
        // bloquear la interacción con la ventana principal
        super(padre, "Preferencias", true);
        this.etiquetaPrincipal = etiquetaPrincipal;
        
        setSize(300, 200);
        setLocationRelativeTo(padre);
        setLayout(new FlowLayout());

        // poner las 3 opciones
        chkOscuro = new JCheckBox("Modo Oscuro");
        chkNotificaciones = new JCheckBox("Notificaciones");
        chkAutoguardado = new JCheckBox("Autoguardado");
        botonAceptar = new JButton("Aceptar");

        add(chkOscuro);
        add(chkNotificaciones);
        add(chkAutoguardado);
        add(botonAceptar);

        // acepta las opciones
        botonAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // construye un string con las opc marcadas
                StringBuilder opciones = new StringBuilder();

                if (chkOscuro.isSelected()) {
                    opciones.append("Modo Oscuro ");
                }
                if (chkNotificaciones.isSelected()) {
                    opciones.append("Notificaciones ");
                }
                if (chkAutoguardado.isSelected()) {
                    opciones.append("Autoguardado ");
                }

                // si no se marcó ninguna se muestra
                String resultado = opciones.toString().trim();
                if (resultado.isEmpty()) {
                    resultado = "Ninguna";
                }

                // se actualiza el texto
                etiquetaPrincipal.setText("Opciones seleccionadas: " + resultado);

                // cierra la ventana
                dispose();
            }
        });
    }
}

public class Ejercicio3 {
    public static void main(String[] args) {
        // ventana principal
        JFrame ventana = new JFrame("Ventana Principal");
        ventana.setSize(400, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        ventana.add(panel);

        // muestra las opciones seleccionadas y el boton para configurar las preferencias
        JLabel etiquetaOpciones = new JLabel("Opciones seleccionadas: Ninguna");
        JButton botonConfigurar = new JButton("Configurar Preferencias");

        panel.add(etiquetaOpciones);
        panel.add(botonConfigurar);

        DialogoPreferencias dialogo = new DialogoPreferencias(ventana, etiquetaOpciones);

        // abrir la otra ventana cuando se toque editar preferencias
        botonConfigurar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialogo.setVisible(true);
            }
        });

        ventana.setVisible(true);
    }
}
