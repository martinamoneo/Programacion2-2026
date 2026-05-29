package TP6;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio1 {
    public static void main(String[] args) {
        // se crea una ventana principal con jframe y le asigno un tamaño
        JFrame ventana = new JFrame("Formulario Interactivo");
        ventana.setSize(400, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null); 

        // contenedor
        JPanel panel = new JPanel();
        ventana.add(panel);

        // label con introduce tu nombre y un text field para escribir
        JLabel etiquetaInstruccion = new JLabel("Introduce tu nombre:");
        panel.add(etiquetaInstruccion);

        JTextField campoTexto = new JTextField(20);
        panel.add(campoTexto);

        // boton y label vacia para que muestre el saludo ahí
        JButton botonSaludar = new JButton("Saludar");
        panel.add(botonSaludar);

        JLabel etiquetaResultado = new JLabel(""); 
        panel.add(etiquetaResultado);

        // se asocia la interfaz ActionListener con el botón mediante addActionListener(). 
        botonSaludar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = campoTexto.getText();
                etiquetaResultado.setText("¡Hola, " + nombre + "!");
            }
        });

        // para que se muestre la ventana
        ventana.setVisible(true);
    }
}
