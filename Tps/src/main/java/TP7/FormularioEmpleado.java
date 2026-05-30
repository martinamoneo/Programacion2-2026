package TP7;

import java.util.List;
import javax.swing.table.DefaultTableModel;

public class FormularioEmpleado extends javax.swing.JFrame {

    private DefaultTableModel modeloTabla;

    public FormularioEmpleado() {
        // inicia los componenentes visuales
        initComponentsCustom();
        
        modeloTabla = new DefaultTableModel(new Object[]{"ID", "Nombre", "ID Depto", "Ruta Foto"}, 0);
        tablaEmpleados.setModel(modeloTabla);
        
        // deptos
        cmbDepartamento.removeAllItems();
        cmbDepartamento.addItem("Recursos Humanos");
        cmbDepartamento.addItem("Finanzas");
        cmbDepartamento.addItem("Sistemas");
        cmbDepartamento.addItem("Marketing");
        
        // empleados a BD
        cargarDatosTabla();
    }

    private void cargarDatosTabla() {
        modeloTabla.setRowCount(0);
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        List<Empleado> lista = empleadoDAO.consultarTodos();
        if (lista != null) {
            for (Empleado emp : lista) {
                modeloTabla.addRow(new Object[]{emp.getId(), emp.getNombre(), emp.getIdDepto(), emp.getRutaFoto()});
            }
        }
    }

    private void initComponentsCustom() {
        // inicializar componentes
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        lblIdEtiqueta = new javax.swing.JLabel("ID:");
        lblNombreEtiqueta = new javax.swing.JLabel("Nombre:");
        lblDeptoEtiqueta = new javax.swing.JLabel("Departamento:");
        
        txtId = new javax.swing.JTextField();
        txtId.setEditable(false); // id no editable
        txtNombre = new javax.swing.JTextField();
        cmbDepartamento = new javax.swing.JComboBox<>();
        
        btnModificar = new javax.swing.JButton("Modificar");
        btnEliminar = new javax.swing.JButton("Eliminar");
        btnBuscarFoto = new javax.swing.JButton("Buscar Foto");
        lblFoto = new javax.swing.JLabel();
        lblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CRUD Empleados - Ejercicio 7");

        jScrollPane1.setViewportView(tablaEmpleados);

        // seleccionar filas
        tablaEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int fila = tablaEmpleados.getSelectedRow();
                if (fila != -1) {
                    txtId.setText(tablaEmpleados.getValueAt(fila, 0).toString());
                    txtNombre.setText(tablaEmpleados.getValueAt(fila, 1).toString());
                    int idDepto = Integer.parseInt(tablaEmpleados.getValueAt(fila, 2).toString());
                    cmbDepartamento.setSelectedIndex(idDepto - 1);
                    
                    Object fotoObj = tablaEmpleados.getValueAt(fila, 3);
                    String ruta = (fotoObj != null) ? fotoObj.toString() : "";
                    lblFoto.setToolTipText(ruta);
                    
                    if (!ruta.isEmpty()) {
                        
                        javax.swing.ImageIcon icon = new javax.swing.ImageIcon(ruta);
                        java.awt.Image img = icon.getImage().getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
                        lblFoto.setIcon(new javax.swing.ImageIcon(img));
                    } else {
                        lblFoto.setIcon(null);
                    }
                }
            }
        });

        // boton modificar
        btnModificar.addActionListener(evt -> {
            if (!txtId.getText().isEmpty()) {
                Empleado emp = new Empleado();
                emp.setId(Integer.parseInt(txtId.getText()));
                emp.setNombre(txtNombre.getText());
                emp.setIdDepto(cmbDepartamento.getSelectedIndex() + 1);
                String ruta = lblFoto.getToolTipText();
                emp.setRutaFoto(ruta != null ? ruta : "");
                
                new EmpleadoDAO().actualizar(emp);
                cargarDatosTabla();
                limpiarCampos();
            }
        });

        // boton eliminar
        btnEliminar.addActionListener(evt -> {
            if (!txtId.getText().isEmpty()) {
                int id = Integer.parseInt(txtId.getText());
                new EmpleadoDAO().borrar(id);
                cargarDatosTabla();
                limpiarCampos();
            }
        });

        // boton foto
        btnBuscarFoto.addActionListener(evt -> {
            javax.swing.JFileChooser selector = new javax.swing.JFileChooser();
            javax.swing.filechooser.FileNameExtensionFilter filtro = new javax.swing.filechooser.FileNameExtensionFilter("Imágenes", "jpg", "png", "jpeg");
            selector.setFileFilter(filtro);
            if (selector.showOpenDialog(this) == javax.swing.JFileChooser.APPROVE_OPTION) {
                String ruta = selector.getSelectedFile().getAbsolutePath();
                lblFoto.setToolTipText(ruta);
                
                javax.swing.ImageIcon imagen = new javax.swing.ImageIcon(ruta);
                java.awt.Image imgEscalada = imagen.getImage().getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
                lblFoto.setIcon(new javax.swing.ImageIcon(imgEscalada));
            }
        });

        // interfaz hecha asi porq me daba problemas hacerlo desde el jframe
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombreEtiqueta)
                            .addComponent(lblIdEtiqueta)
                            .addComponent(lblDeptoEtiqueta))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtId)
                            .addComponent(txtNombre)
                            .addComponent(cmbDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnBuscarFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIdEtiqueta)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombreEtiqueta)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDeptoEtiqueta)
                            .addComponent(cmbDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnModificar)
                            .addComponent(btnEliminar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarFoto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 20, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pack();
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        cmbDepartamento.setSelectedIndex(0);
        lblFoto.setIcon(null);
        lblFoto.setToolTipText("");
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new FormularioEmpleado().setVisible(true));
    }

    // declarar variables
    private javax.swing.JButton btnBuscarFoto;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cmbDepartamento;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblIdEtiqueta;
    private javax.swing.JLabel lblNombreEtiqueta;
    private javax.swing.JLabel lblDeptoEtiqueta;
    private javax.swing.JTable tablaEmpleados;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
}
