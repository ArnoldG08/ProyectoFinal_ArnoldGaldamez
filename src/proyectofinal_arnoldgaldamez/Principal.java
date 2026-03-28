/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyectofinal_arnoldgaldamez;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;

/**
 *
 * @author USER
 */
public class Principal extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Principal.class.getName());
    ArrayList<Figuras> figuras = new ArrayList<>();
    ArrayList<Variable> variables = new ArrayList<>();
    ArrayList<Clase> clases = new ArrayList<>();
    private JLabel figuraCopiada = null;
    private String textoCopiado = "";
    private int xInicial = 30;
    private int yInicial = 30;

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        jPanel1.setLayout(null);
        lbl_base.setVisible(false);
        jMenu1.add(menu_guardar_proyecto);
        

    }






private void popupClase(JLabel clase) {
    JPopupMenu menu = new JPopupMenu();

    JMenuItem atributo = new JMenuItem("Agregar atributo");
    JMenuItem metodo = new JMenuItem("Agregar metodo");
    JMenuItem herencia = new JMenuItem("Herencia");

    atributo.addActionListener(e -> {
        String a = JOptionPane.showInputDialog("Ej: int edad");
        if (a != null && !a.trim().isEmpty()) {
            clase.setText(clase.getText().replace("</html>", a + "<br></html>"));
        }
    });

    metodo.addActionListener(e -> {
        String m = JOptionPane.showInputDialog("Ej: void saludar()");
        if (m != null && !m.trim().isEmpty()) {
            clase.setText(clase.getText().replace("</html>", m + "<br></html>"));
        }
    });

    herencia.addActionListener(e -> {
        String padre = JOptionPane.showInputDialog("Clase padre:");
        if (padre != null && !padre.trim().isEmpty()) {
            String texto = clase.getText();
            texto = texto.replace("<b>", "<b>" + padre + " <- ");
            clase.setText(texto);
        }
    });

    menu.add(atributo);
    menu.add(metodo);
    menu.add(herencia);

    clase.setComponentPopupMenu(menu);
}
    private void popupFigura(JLabel figura) {
  JPopupMenu menu = new JPopupMenu();

    JMenuItem editar = new JMenuItem("Editar texto");
    JMenuItem colorFondo = new JMenuItem("Color fondo");
    JMenuItem colorLetra = new JMenuItem("Color letra");
    JMenuItem tamano = new JMenuItem("Tamano letra");
    JMenuItem estilo = new JMenuItem("Estilo letra");
    JMenuItem fuente = new JMenuItem("Tipo fuente");
    JMenuItem copiar = new JMenuItem("Copiar");
    JMenuItem eliminar = new JMenuItem("Eliminar");

    editar.addActionListener(e -> {
        String nuevo = JOptionPane.showInputDialog("Nuevo texto:");
        if (nuevo != null && !nuevo.trim().isEmpty()) {
            figura.setText(nuevo);
        }
    });

    colorFondo.addActionListener(e -> {
        String color = JOptionPane.showInputDialog("rojo, azul, verde, amarillo, blanco");
        if (color != null) {
            if (color.equalsIgnoreCase("rojo")) {
                figura.setBackground(Color.RED);
            } else if (color.equalsIgnoreCase("azul")) {
                figura.setBackground(Color.BLUE);
            } else if (color.equalsIgnoreCase("verde")) {
                figura.setBackground(Color.GREEN);
            } else if (color.equalsIgnoreCase("amarillo")) {
                figura.setBackground(Color.YELLOW);
            } else if (color.equalsIgnoreCase("blanco")) {
                figura.setBackground(Color.WHITE);
            }
        }
    });

    colorLetra.addActionListener(e -> {
        String color = JOptionPane.showInputDialog("negro, rojo, azul, verde");
        if (color != null) {
            if (color.equalsIgnoreCase("negro")) {
                figura.setForeground(Color.BLACK);
            } else if (color.equalsIgnoreCase("rojo")) {
                figura.setForeground(Color.RED);
            } else if (color.equalsIgnoreCase("azul")) {
                figura.setForeground(Color.BLUE);
            } else if (color.equalsIgnoreCase("verde")) {
                figura.setForeground(Color.GREEN);
            }
        }
    });

    tamano.addActionListener(e -> {
        String t = JOptionPane.showInputDialog("Tamano:");
        if (t != null && !t.trim().isEmpty()) {
            figura.setFont(new java.awt.Font("Arial", figura.getFont().getStyle(), Integer.parseInt(t)));
        }
    });

    estilo.addActionListener(e -> {
        String op = JOptionPane.showInputDialog("normal, negrita, italica");
        if (op != null) {
            int estiloFuente = java.awt.Font.PLAIN;
            if (op.equalsIgnoreCase("negrita")) {
                estiloFuente = java.awt.Font.BOLD;
            } else if (op.equalsIgnoreCase("italica")) {
                estiloFuente = java.awt.Font.ITALIC;
            }
            figura.setFont(new java.awt.Font("Arial", estiloFuente, figura.getFont().getSize()));
        }
    });

    fuente.addActionListener(e -> {
        String f = JOptionPane.showInputDialog("Arial, Serif, Monospaced");
        if (f != null) {
            figura.setFont(new java.awt.Font(f, figura.getFont().getStyle(), figura.getFont().getSize()));
        }
    });

    copiar.addActionListener(e -> {
        figuraCopiada = figura;
        textoCopiado = figura.getText();
    });

    eliminar.addActionListener(e -> {
        jPanel1.remove(figura);
        jPanel1.repaint();
    });

    menu.add(editar);
    menu.add(colorFondo);
    menu.add(colorLetra);
    menu.add(tamano);
    menu.add(estilo);
    menu.add(fuente);
    menu.add(copiar);
    menu.add(eliminar);

    figura.setComponentPopupMenu(menu);
    
    }




    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btn_agregar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_codigo = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        pn_izquierdo = new javax.swing.JPanel();
        lbl_inicio = new javax.swing.JLabel();
        lbl_if = new javax.swing.JLabel();
        lbl_for = new javax.swing.JLabel();
        lbl_while = new javax.swing.JLabel();
        lbl_operacion = new javax.swing.JLabel();
        lbl_sout = new javax.swing.JLabel();
        lbl_base = new javax.swing.JLabel();
        lb_fin = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pn_variable = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_variables = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menu_guardar = new javax.swing.JMenuItem();
        menu_abrir = new javax.swing.JMenuItem();
        menu_nuevo = new javax.swing.JMenuItem();
        menu_guardar_proyecto = new javax.swing.JMenuItem();
        menu_abrir_proyecto = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menu_exportar_codigo = new javax.swing.JMenuItem();
        menu_exportar_pdf = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 32)); // NOI18N
        jLabel1.setText("Variables");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        btn_agregar.setText("Agregar");
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jTabbedPane1.addTab("Diagrama", jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt_codigo.setColumns(20);
        txt_codigo.setRows(5);
        jScrollPane1.setViewportView(txt_codigo);

        jScrollPane2.setViewportView(jScrollPane1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Codigo", jPanel2);

        jButton1.setText("Pegar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Generar Codigo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 32)); // NOI18N
        jLabel2.setText("Opciones");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        pn_izquierdo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pn_izquierdo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pn_izquierdoMouseClicked(evt);
            }
        });

        lbl_inicio.setText("Inicio");
        lbl_inicio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        lbl_inicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_inicioMouseClicked(evt);
            }
        });

        lbl_if.setText("If");
        lbl_if.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        lbl_if.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_ifMouseClicked(evt);
            }
        });

        lbl_for.setText("For");
        lbl_for.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        lbl_for.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_forMouseClicked(evt);
            }
        });

        lbl_while.setText("While");
        lbl_while.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        lbl_while.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_whileMouseClicked(evt);
            }
        });

        lbl_operacion.setText("Operacion");
        lbl_operacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        lbl_operacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_operacionMouseClicked(evt);
            }
        });

        lbl_sout.setText("Sout");
        lbl_sout.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        lbl_sout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_soutMouseClicked(evt);
            }
        });

        lbl_base.setBackground(new java.awt.Color(255, 255, 255));
        lbl_base.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_base.setText("Figura");
        lbl_base.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        lbl_base.setOpaque(true);

        lb_fin.setText("Fin");
        lb_fin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        lb_fin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_finMouseClicked(evt);
            }
        });

        jLabel3.setText("Clase");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pn_izquierdoLayout = new javax.swing.GroupLayout(pn_izquierdo);
        pn_izquierdo.setLayout(pn_izquierdoLayout);
        pn_izquierdoLayout.setHorizontalGroup(
            pn_izquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_izquierdoLayout.createSequentialGroup()
                .addGroup(pn_izquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pn_izquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pn_izquierdoLayout.createSequentialGroup()
                            .addGap(154, 154, 154)
                            .addGroup(pn_izquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lbl_while, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_for, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_if, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(pn_izquierdoLayout.createSequentialGroup()
                            .addGap(138, 138, 138)
                            .addGroup(pn_izquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbl_sout, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_operacion, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pn_izquierdoLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(pn_izquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pn_izquierdoLayout.createSequentialGroup()
                                .addComponent(lbl_base, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78)
                                .addComponent(lb_fin, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_izquierdoLayout.setVerticalGroup(
            pn_izquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_izquierdoLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(pn_izquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_inicio)
                    .addComponent(jLabel3))
                .addGap(43, 43, 43)
                .addGroup(pn_izquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_base)
                    .addComponent(lb_fin))
                .addGap(71, 71, 71)
                .addComponent(lbl_if)
                .addGap(56, 56, 56)
                .addComponent(lbl_for)
                .addGap(64, 64, 64)
                .addComponent(lbl_while)
                .addGap(62, 62, 62)
                .addComponent(lbl_operacion)
                .addGap(51, 51, 51)
                .addComponent(lbl_sout)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        txt_variables.setColumns(20);
        txt_variables.setRows(5);
        jScrollPane3.setViewportView(txt_variables);

        javax.swing.GroupLayout pn_variableLayout = new javax.swing.GroupLayout(pn_variable);
        pn_variable.setLayout(pn_variableLayout);
        pn_variableLayout.setHorizontalGroup(
            pn_variableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_variableLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        pn_variableLayout.setVerticalGroup(
            pn_variableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_variableLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jMenu1.setText("Archivo");

        menu_guardar.setText("Guardar Codigo");
        menu_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_guardarActionPerformed(evt);
            }
        });
        jMenu1.add(menu_guardar);

        menu_abrir.setText("Abrir Archivos");
        menu_abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_abrirActionPerformed(evt);
            }
        });
        jMenu1.add(menu_abrir);

        menu_nuevo.setText("Nuevo Archivo");
        menu_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_nuevoActionPerformed(evt);
            }
        });
        jMenu1.add(menu_nuevo);

        menu_guardar_proyecto.setText("Guardar Proyecto");
        menu_guardar_proyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_guardar_proyectoActionPerformed(evt);
            }
        });
        jMenu1.add(menu_guardar_proyecto);

        menu_abrir_proyecto.setText("Abrir Proyecto");
        menu_abrir_proyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_abrir_proyectoActionPerformed(evt);
            }
        });
        jMenu1.add(menu_abrir_proyecto);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Exportar");

        menu_exportar_codigo.setText("Exportar Codigo");
        menu_exportar_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_exportar_codigoActionPerformed(evt);
            }
        });
        jMenu2.add(menu_exportar_codigo);

        menu_exportar_pdf.setText("Exportar PDF");
        menu_exportar_pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_exportar_pdfActionPerformed(evt);
            }
        });
        jMenu2.add(menu_exportar_pdf);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jLabel2)
                        .addGap(0, 143, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(pn_izquierdo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(226, 226, 226)
                                        .addComponent(btn_agregar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(92, 92, 92)
                                        .addComponent(pn_variable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(21, 21, 21))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(193, 193, 193)
                                .addComponent(jLabel1)
                                .addGap(94, 94, 94))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_variable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_agregar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(pn_izquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pn_izquierdo.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pn_izquierdoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_izquierdoMouseClicked
   if (evt.getButton() != java.awt.event.MouseEvent.BUTTON1) {
        return;
    }

    JLabel figura = new JLabel("Fin", JLabel.CENTER);
    figura.setBounds(50, yInicial, 120, 50);

    figura.setOpaque(true);
    figura.setBackground(lbl_base.getBackground());
    figura.setBorder(lbl_base.getBorder());

    jPanel1.add(figura);
    jPanel1.repaint();

    yInicial += 60;

    figura.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            if (evt.getClickCount() == 2) {
                String nuevo = javax.swing.JOptionPane.showInputDialog("Nuevo texto:");
                if (nuevo != null && !nuevo.trim().isEmpty()) {
                    figura.setText(nuevo);
                }
            }
        }
    });

    }//GEN-LAST:event_pn_izquierdoMouseClicked

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseClicked

    private void lbl_inicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_inicioMouseClicked
        // TODO add your handling code here:
     JLabel figura = new JLabel();
    figura.setText("Inicio");
    figura.setBounds(50, yInicial, 120, 50);
    figura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    figura.setOpaque(true);
    figura.setBackground(lbl_base.getBackground());
    figura.setBorder(lbl_base.getBorder());

    figura.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
        @Override
        public void mouseDragged(java.awt.event.MouseEvent evt) {
            figura.setLocation(
                figura.getX() + evt.getX(),
                figura.getY() + evt.getY()
            );
        }
    });

    figura.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            if (evt.getClickCount() == 2) {
                String nuevo = javax.swing.JOptionPane.showInputDialog("Nuevo texto:");
                if (nuevo != null && !nuevo.trim().isEmpty()) {
                    figura.setText(nuevo);
                }
            }
        }
    });

    popupFigura(figura);

    jPanel1.add(figura);
    jPanel1.repaint();

    figuras.add(new Figuras("Inicio", 50, yInicial, "Inicio"));
    yInicial += 60;
    }//GEN-LAST:event_lbl_inicioMouseClicked

    private void lbl_ifMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ifMouseClicked
        // TODO add your handling code here:
    JLabel figura = new JLabel();
    figura.setText("If");
    figura.setBounds(50, yInicial, 120, 50);
    figura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    figura.setOpaque(true);
    figura.setBackground(lbl_base.getBackground());
    figura.setBorder(lbl_base.getBorder());

    figura.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
        @Override
        public void mouseDragged(java.awt.event.MouseEvent evt) {
            figura.setLocation(
                figura.getX() + evt.getX(),
                figura.getY() + evt.getY()
            );
        }
    });

    popupFigura(figura);

    jPanel1.add(figura);
    jPanel1.repaint();

    figuras.add(new Figuras("If", 50, yInicial, "If"));
    yInicial += 60;
    }//GEN-LAST:event_lbl_ifMouseClicked

    private void lbl_forMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_forMouseClicked
        // TODO add your handling code here:
      JLabel figura = new JLabel();
    figura.setText("For");
    figura.setBounds(50, yInicial, 120, 50);
    figura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    figura.setOpaque(true);
    figura.setBackground(lbl_base.getBackground());
    figura.setBorder(lbl_base.getBorder());

    figura.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
        @Override
        public void mouseDragged(java.awt.event.MouseEvent evt) {
            figura.setLocation(
                figura.getX() + evt.getX(),
                figura.getY() + evt.getY()
            );
        }
    });

    figura.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            if (evt.getClickCount() == 2) {
                String nuevo = javax.swing.JOptionPane.showInputDialog("Nuevo for:");
                if (nuevo != null && !nuevo.trim().isEmpty()) {
                    figura.setText(nuevo);
                }
            }
        }
    });

    popupFigura(figura);

    jPanel1.add(figura);
    jPanel1.repaint();

    figuras.add(new Figuras("For", 50, yInicial, "For"));
    yInicial += 60;

    }//GEN-LAST:event_lbl_forMouseClicked

    private void lbl_whileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_whileMouseClicked
        // TODO add your handling code here:
        JLabel figura = new JLabel();
    figura.setText("While");
    figura.setBounds(50, yInicial, 120, 50);
    figura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    figura.setOpaque(true);
    figura.setBackground(lbl_base.getBackground());
    figura.setBorder(lbl_base.getBorder());

    figura.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
        @Override
        public void mouseDragged(java.awt.event.MouseEvent evt) {
            figura.setLocation(
                figura.getX() + evt.getX(),
                figura.getY() + evt.getY()
            );
        }
    });

    figura.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            if (evt.getClickCount() == 2) {
                String nuevo = javax.swing.JOptionPane.showInputDialog("Nuevo while:");
                if (nuevo != null && !nuevo.trim().isEmpty()) {
                    figura.setText(nuevo);
                }
            }
        }
    });

    popupFigura(figura);

    jPanel1.add(figura);
    jPanel1.repaint();

    figuras.add(new Figuras("While", 50, yInicial, "While"));
    yInicial += 60;

    }//GEN-LAST:event_lbl_whileMouseClicked

    private void lbl_operacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_operacionMouseClicked
        // TODO add your handling code here:
       String var1 = JOptionPane.showInputDialog("Primera variable:");
    String operador = JOptionPane.showInputDialog("Operador (+,-,*,/):");
    String var2 = JOptionPane.showInputDialog("Segunda variable:");
    String resultado = JOptionPane.showInputDialog("Variable donde guardar:");

    if (var1 == null || operador == null || var2 == null || resultado == null) {
        return;
    }

    if (var1.trim().isEmpty() || operador.trim().isEmpty() || var2.trim().isEmpty() || resultado.trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "No deje espacios vacios");
        return;
    }

    if (!operador.equals("+") && !operador.equals("-") && !operador.equals("*") && !operador.equals("/")) {
        JOptionPane.showMessageDialog(this, "Operador invalido");
        return;
    }

    String operacion = resultado + " = " + var1 + " " + operador + " " + var2;

    JLabel figura = new JLabel(operacion, JLabel.CENTER);
    figura.setBounds(50, yInicial, 160, 50);
    figura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    figura.setOpaque(true);
    figura.setBackground(lbl_base.getBackground());
    figura.setBorder(lbl_base.getBorder());

    figura.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
        @Override
        public void mouseDragged(java.awt.event.MouseEvent evt) {
            figura.setLocation(
                figura.getX() + evt.getX(),
                figura.getY() + evt.getY()
            );
        }
    });

    popupFigura(figura);

    jPanel1.add(figura);
    jPanel1.repaint();

    figuras.add(new Figuras("Operacion", figura.getX(), figura.getY(), operacion));
    yInicial += 60;

    }//GEN-LAST:event_lbl_operacionMouseClicked

    private void lbl_soutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_soutMouseClicked
        // TODO add your handling code here:
                JLabel figura = new JLabel();
    figura.setText("sout");
    figura.setBounds(50, yInicial, 120, 50);
    figura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    figura.setOpaque(true);
    figura.setBackground(lbl_base.getBackground());
    figura.setBorder(lbl_base.getBorder());

    figura.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
        @Override
        public void mouseDragged(java.awt.event.MouseEvent evt) {
            figura.setLocation(
                figura.getX() + evt.getX(),
                figura.getY() + evt.getY()
            );
        }
    });

    figura.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            if (evt.getClickCount() == 2) {
                String nuevo = javax.swing.JOptionPane.showInputDialog("Nuevo sout:");
                if (nuevo != null && !nuevo.trim().isEmpty()) {
                    figura.setText(nuevo);
                }
            }
        }
    });

    popupFigura(figura);

    jPanel1.add(figura);
    jPanel1.repaint();

    figuras.add(new Figuras("sout", 50, yInicial, "sout"));
    yInicial += 60;
    }//GEN-LAST:event_lbl_soutMouseClicked

    private void lb_finMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_finMouseClicked
        // TODO add your handling code here:
            JLabel figura = new JLabel("Fin", JLabel.CENTER);
    figura.setBounds(50, yInicial, 120, 50);

    figura.setOpaque(true);
    figura.setBackground(lbl_base.getBackground());
    figura.setBorder(lbl_base.getBorder());

    figura.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
        @Override
        public void mouseDragged(java.awt.event.MouseEvent evt) {
            figura.setLocation(
                figura.getX() + evt.getX(),
                figura.getY() + evt.getY()
            );
        }
    });

    popupFigura(figura);

    jPanel1.add(figura);
    jPanel1.repaint();

    figuras.add(new Figuras("Fin", 50, yInicial, "Fin"));
    yInicial += 60;
    }//GEN-LAST:event_lb_finMouseClicked

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        // TODO add your handling code here:

    String tipo = JOptionPane.showInputDialog("Ingrese el tipo de variable:");
    String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la variable:");

    if (tipo == null || nombre == null || tipo.trim().isEmpty() || nombre.trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Datos vacios");
        return;
    }

    // 🔽 VALIDAR REPETIDOS (ahora sí funciona)
    for (Variable var : variables) {
        if (var.getNombre().equals(nombre)) {
            JOptionPane.showMessageDialog(this, "Variable ya existe");
            return;
        }
    }

    Variable v = new Variable(tipo, nombre);
    variables.add(v);

    txt_variables.append(v.toString() + "\n");

    }//GEN-LAST:event_btn_agregarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

       String codigo = "";

    codigo += "public class Prueba {\n";
    codigo += "    public static void main(String[] args) {\n";

    for (java.awt.Component c : jPanel1.getComponents()) {
        if (c instanceof JLabel) {
            JLabel figura = (JLabel) c;
            String texto = figura.getText().trim();

            if (texto.equalsIgnoreCase("Inicio") || texto.equalsIgnoreCase("Fin")) {
                
            } else if (texto.startsWith("sout")) {
                String contenido = texto.replaceFirst("sout", "").trim();
                codigo += "        System.out.println(" + contenido + ");\n";

            } else if (texto.startsWith("If")) {
                String condicion = texto.replaceFirst("If", "").trim();
                codigo += "        if (" + condicion + ") {\n";
                codigo += "        }\n";

            } else if (texto.startsWith("While")) {
                String condicion = texto.replaceFirst("While", "").trim();
                codigo += "        while (" + condicion + ") {\n";
                codigo += "        }\n";

            } else if (texto.startsWith("For")) {
                String condicion = texto.replaceFirst("For", "").trim();
                codigo += "        for (" + condicion + ") {\n";
                codigo += "        }\n";

            } else {
                codigo += "        " + texto + ";\n";
            }
        }
    }

    codigo += "    }\n";
    codigo += "}\n";
    for (java.awt.Component c : jPanel1.getComponents()) {
    if (c instanceof JLabel) {
        JLabel lbl = (JLabel) c;

        String texto = lbl.getText();

        if (texto.contains("<html>")) {

            String limpio = texto.replaceAll("<[^>]*>", "");
            String[] lineas = limpio.split("\n");

            if (lineas.length > 0) {

                String nombreClase = lineas[0].trim();

                if (nombreClase.contains("<-")) {
                    String[] partes = nombreClase.split("<-");
                    nombreClase = partes[1].trim();
                }

                codigo += "\nclass " + nombreClase + " {\n";

                for (int i = 1; i < lineas.length; i++) {
                    String linea = lineas[i].trim();

                    if (linea.isEmpty() || linea.equals("-----")) continue;

                    if (linea.contains("(")) {
                        codigo += "    " + linea + " {\n\n    }\n";
                    } else {
                        codigo += "    " + linea + ";\n";
                    }
                }

                codigo += "}\n";
            }
        }
    }
}

    txt_codigo.setText(codigo);
    jTabbedPane1.setSelectedIndex(1);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void menu_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_guardarActionPerformed
        // TODO add your handling code here:
         if (txt_codigo.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "No hay codigo para guardar");
        return;
    }

    JFileChooser filechooser = new JFileChooser();
    int resultado = filechooser.showSaveDialog(this);

    if (resultado == JFileChooser.APPROVE_OPTION) {
        File archivoSeleccionado = filechooser.getSelectedFile();

        try {
            FileWriter fw = new FileWriter(archivoSeleccionado + ".java");
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(txt_codigo.getText());

            bw.close();

            JOptionPane.showMessageDialog(this, "Archivo guardado exitosamente!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Algo salio mal.");
        }
    }
    }//GEN-LAST:event_menu_guardarActionPerformed

    private void menu_exportar_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_exportar_codigoActionPerformed
        // TODO add your handling code here:
          if (txt_codigo.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "No hay codigo para exportar");
        return;
    }

    JFileChooser filechooser = new JFileChooser();
    int resultado = filechooser.showSaveDialog(this);

    if (resultado == JFileChooser.APPROVE_OPTION) {
        File archivo = filechooser.getSelectedFile();

        try {
            FileWriter fw = new FileWriter(archivo + ".java");
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(txt_codigo.getText());

            bw.close();

            JOptionPane.showMessageDialog(this, "Archivo .java guardado");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar");
        }
    }
    }//GEN-LAST:event_menu_exportar_codigoActionPerformed

    private void menu_exportar_pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_exportar_pdfActionPerformed
        // TODO add your handling code here:
     if (txt_codigo.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "No hay codigo para exportar");
        return;
    }

    JFileChooser fileChooser = new JFileChooser();
    int opcion = fileChooser.showSaveDialog(this);

    if (opcion == JFileChooser.APPROVE_OPTION) {
        File archivo = fileChooser.getSelectedFile();

        try {
            Document documento = new Document();
            PdfWriter.getInstance(documento, new FileOutputStream(archivo + ".pdf"));

            documento.open();
            documento.add(new Paragraph(txt_codigo.getText()));
            documento.close();

            JOptionPane.showMessageDialog(this, "PDF exportado correctamente");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al exportar PDF");
        }
    }
    }//GEN-LAST:event_menu_exportar_pdfActionPerformed

    private void menu_abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_abrirActionPerformed
        // TODO add your handling code here:
         JFileChooser fileChooser = new JFileChooser();
    int opcion = fileChooser.showOpenDialog(this);

    if (opcion == JFileChooser.APPROVE_OPTION) {

        File archivo = fileChooser.getSelectedFile();

        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));

            String linea;
            String contenido = "";

            while ((linea = br.readLine()) != null) {
                contenido += linea + "\n";
                    }

            txt_codigo.setText(contenido);

            br.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al abrir archivo");
        }
    }
        
    }//GEN-LAST:event_menu_abrirActionPerformed

    private void menu_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_nuevoActionPerformed
        // TODO add your handling code here:
        jPanel1.removeAll();
jPanel1.repaint();

txt_codigo.setText("");
txt_variables.setText("");

figuras.clear();
variables.clear();

xInicial = 30;
yInicial = 30;

JOptionPane.showMessageDialog(this, "Nuevo proyecto creado");
    }//GEN-LAST:event_menu_nuevoActionPerformed

    private void menu_guardar_proyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_guardar_proyectoActionPerformed
        // TODO add your handling code here:
    JFileChooser fileChooser = new JFileChooser();
    int opcion = fileChooser.showSaveDialog(this);

    if (opcion == JFileChooser.APPROVE_OPTION) {
        File archivo = fileChooser.getSelectedFile();

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo + ".txt"));

            for (java.awt.Component c : jPanel1.getComponents()) {
                if (c instanceof JLabel) {
                    JLabel figura = (JLabel) c;
                    bw.write(figura.getText() + "," + figura.getX() + "," + figura.getY());
                    bw.newLine();
                }
            }

            bw.write("VARIABLES");
            bw.newLine();

            for (Variable v : variables) {
                bw.write(v.getTipo() + "," + v.getNombre());
                bw.newLine();
            }

            bw.close();
            JOptionPane.showMessageDialog(this, "Proyecto guardado");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar proyecto");
        }
    
    }
    }//GEN-LAST:event_menu_guardar_proyectoActionPerformed

    private void menu_abrir_proyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_abrir_proyectoActionPerformed
        // TODO add your handling code here:
            JFileChooser fileChooser = new JFileChooser();
    int opcion = fileChooser.showOpenDialog(this);

    if (opcion == JFileChooser.APPROVE_OPTION) {
        File archivo = fileChooser.getSelectedFile();

        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));

            // limpiar todo primero
            jPanel1.removeAll();
            jPanel1.repaint();
            txt_variables.setText("");
            variables.clear();

            String linea;
            boolean leyendoVariables = false;

            while ((linea = br.readLine()) != null) {

                if (linea.equals("VARIABLES")) {
                    leyendoVariables = true;
                    continue;
                }

                if (!leyendoVariables) {
                    // FIGURAS
                    String[] partes = linea.split(",");

                    String texto = partes[0];
                    int x = Integer.parseInt(partes[1]);
                    int y = Integer.parseInt(partes[2]);

                    JLabel figura = new JLabel(texto, JLabel.CENTER);
                    figura.setBounds(x, y, 120, 50);
                    figura.setOpaque(true);
                    figura.setBackground(Color.WHITE);
                    figura.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

                    // mover con drag
                    figura.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                        @Override
                        public void mouseDragged(java.awt.event.MouseEvent evt) {
                            figura.setLocation(
                                figura.getX() + evt.getX(),
                                figura.getY() + evt.getY()
                            );
                        }
                    });

                    popupFigura(figura);
                    jPanel1.add(figura);

                } else {
                    // VARIABLES
                    String[] partes = linea.split(",");
                    Variable v = new Variable(partes[0], partes[1]);
                    variables.add(v);
                    txt_variables.append(v.toString() + "\n");
                }
            }

            br.close();
            jPanel1.repaint();

            JOptionPane.showMessageDialog(this, "Proyecto cargado");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al abrir archivo");
        }
    }
    }//GEN-LAST:event_menu_abrir_proyectoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
           if (figuraCopiada == null) {
        JOptionPane.showMessageDialog(this, "No hay figura copiada");
        return;
    }

    JLabel nueva = new JLabel(textoCopiado, JLabel.CENTER);
    nueva.setBounds(figuraCopiada.getX() + 20, figuraCopiada.getY() + 20,
                    figuraCopiada.getWidth(), figuraCopiada.getHeight());
    nueva.setOpaque(true);
    nueva.setBackground(figuraCopiada.getBackground());
    nueva.setForeground(figuraCopiada.getForeground());
    nueva.setBorder(figuraCopiada.getBorder());
    nueva.setFont(figuraCopiada.getFont());

    nueva.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
        @Override
        public void mouseDragged(java.awt.event.MouseEvent evt) {
            nueva.setLocation(
                nueva.getX() + evt.getX(),
                nueva.getY() + evt.getY()
            );
        }
    });

    popupFigura(nueva);

    jPanel1.add(nueva);
    jPanel1.repaint();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
 String nombre = JOptionPane.showInputDialog("Nombre de la clase:");

    if (nombre == null || nombre.trim().isEmpty()) {
        return;
    }

    JLabel clase = new JLabel("<html><b>" + nombre + "</b><br>-----<br></html>", JLabel.CENTER);
    clase.setBounds(50, yInicial, 180, 100);
    clase.setOpaque(true);
    clase.setBackground(Color.WHITE);
    clase.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

    clase.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
        @Override
        public void mouseDragged(java.awt.event.MouseEvent evt) {
            clase.setLocation(
                clase.getX() + evt.getX(),
                clase.getY() + evt.getY()
            );
        }
    });

    popupClase(clase);

    clase.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            if (javax.swing.SwingUtilities.isRightMouseButton(evt)) {
                clase.getComponentPopupMenu().show(clase, evt.getX(), evt.getY());
            }
        }
    });

    jPanel1.add(clase);
    jPanel1.repaint();

    yInicial += 110;
    }//GEN-LAST:event_jLabel3MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Principal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lb_fin;
    private javax.swing.JLabel lbl_base;
    private javax.swing.JLabel lbl_for;
    private javax.swing.JLabel lbl_if;
    private javax.swing.JLabel lbl_inicio;
    private javax.swing.JLabel lbl_operacion;
    private javax.swing.JLabel lbl_sout;
    private javax.swing.JLabel lbl_while;
    private javax.swing.JMenuItem menu_abrir;
    private javax.swing.JMenuItem menu_abrir_proyecto;
    private javax.swing.JMenuItem menu_exportar_codigo;
    private javax.swing.JMenu menu_exportar_pdf;
    private javax.swing.JMenuItem menu_guardar;
    private javax.swing.JMenuItem menu_guardar_proyecto;
    private javax.swing.JMenuItem menu_nuevo;
    private javax.swing.JPanel pn_izquierdo;
    private javax.swing.JPanel pn_variable;
    private javax.swing.JTextArea txt_codigo;
    private javax.swing.JTextArea txt_variables;
    // End of variables declaration//GEN-END:variables
}
