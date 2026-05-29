package TP6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio2 {
    public static void main(String[] args) {
        // crear jframe
        JFrame ventana = new JFrame("Mini Editor de Texto");
        ventana.setSize(500, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);

        // se crea un JMenuBar y se fija
        JMenuBar barraMenu = new JMenuBar();
        ventana.setJMenuBar(barraMenu);

        // crear un jmenu que se llama archivo
        JMenu menuArchivo = new JMenu("Archivo");
        barraMenu.add(menuArchivo);

        // dentro dek menu se crea limpiar tecto y salir
        JMenuItem itemLimpiar = new JMenuItem("Limpiar texto");
        JMenuItem itemSalir = new JMenuItem("Salir");
        menuArchivo.add(itemLimpiar);
        menuArchivo.addSeparator(); // Agrega una línea divisoria estética
        menuArchivo.add(itemSalir);

        // JTextArea para editar texto
        JTextArea areaTexto = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(areaTexto);
        ventana.add(scrollPane, BorderLayout.CENTER);

        // asociar un ActionListener a cada JMenuItem
        
        // si se selecciona limpiar texto se borra el contenido
        itemLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaTexto.setText("");
            }
        });

        // si se selecciona salir, se sale
        itemSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Cierra la aplicación por completo
            }
        });

        // para que se muestre la ventana
        ventana.setVisible(true);
    }
}