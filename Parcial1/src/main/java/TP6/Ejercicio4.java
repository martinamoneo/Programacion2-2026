package TP6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Ejercicio4 {
    // atributo privado para guardar la contraseña
    private static final String CONTRASEÑA_SECRETA = "martina123";

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Autenticación de Usuario");
        ventana.setSize(350, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);

        // contenedor principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10)); // ordenar
        ventana.add(panel);

        // jlabel usuario y un campo de texto
        JLabel etiquetaUsuario = new JLabel("Usuario:", SwingConstants.RIGHT);
        JTextField campoUsuario = new JTextField(20);
        panel.add(etiquetaUsuario);
        panel.add(campoUsuario);

        // jlabel contraseña
        JLabel etiquetaPassword = new JLabel("Contraseña:", SwingConstants.RIGHT);
        JPasswordField campoPassword = new JPasswordField("", 20);
        
        // usar * para la contraseña
        campoPassword.setEchoChar('*');
        
        panel.add(etiquetaPassword);
        panel.add(campoPassword);

        // botón acceder
        JButton botonAcceder = new JButton("Acceder");
        
        panel.add(new JLabel("")); 
        panel.add(botonAcceder);
        
        botonAcceder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // guarda la contraseña
                char[] passwordIntroducido = campoPassword.getPassword();
                
                // comparar contraseña
                char[] passwordCorrecto = CONTRASEÑA_SECRETA.toCharArray();
                
                if (Arrays.equals(passwordIntroducido, passwordCorrecto)) {
                    // coincide
                    JOptionPane.showMessageDialog(ventana, 
                            "¡Acceso concedido! Bienvenido al sistema.", 
                            "Éxito", 
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    //no coincide
                    JOptionPane.showMessageDialog(ventana, 
                            "Contraseña incorrecta. Inténtalo de nuevo.", 
                            "Error de Autenticación", 
                            JOptionPane.ERROR_MESSAGE);
                }
                Arrays.fill(passwordIntroducido, '0');
                Arrays.fill(passwordCorrecto, '0');
            }
        });

         // para que se muestre la ventana
        ventana.setVisible(true);
    }
}
