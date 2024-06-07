package com.mycompany.examen;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Examen extends JFrame {
        private JPanel panel1;
        private JPanel panel2;
        private JPanel panel3;
        private JLabel etiqueta1;
        private JLabel etiqueta2;
        private JLabel texto1;
        private JLabel texto2;
        private JRadioButton opcion1;
        private JRadioButton opcion2;
        private JRadioButton opcion3;
        private JComboBox elegir;
        private GridBagConstraints gbc;
        private JLabel labelOpcion1;
        private JLabel labelOpcion2;
        private JLabel labelOpcion3;
        private JCheckBox btn;
        Font font1 = new Font("Montserrat", Font.BOLD,40);
        Font font2 = new Font("Serif", Font.BOLD, 14);
        
    public Examen(){
        setTitle("Examen final de programación");
        setMinimumSize(new Dimension(600,700));
        setLocationRelativeTo(null);
        iniciarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);  
    }
    
    private void iniciarComponentes(){
    
    colocarPanel();
    colocarEtiqueta();
    colocarRadioButton();
    colocarCheckBox();
    colocarJComboBox();
    }
    
    private void colocarPanel(){
        Color colorDeFondo = Color.decode("#CB6CE6");
        
        panel1 = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        panel1.setBackground(colorDeFondo);
        panel1.setPreferredSize(new Dimension(600,180));
        this.getContentPane().add(panel1,BorderLayout.NORTH);
        
        panel2 = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        panel2.setBackground(Color.WHITE);
        panel2.setPreferredSize(new Dimension(600,420));
        this.getContentPane().add(panel2,BorderLayout.CENTER);
        
        panel3 = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        panel3.setBackground(colorDeFondo);
        panel3.setPreferredSize(new Dimension(500,100));
        this.getContentPane().add(panel3,BorderLayout.SOUTH);
        
        
        labelOpcion1= new JLabel();
        labelOpcion2= new JLabel();
        labelOpcion3 = new JLabel();
    }
    
    private void colocarEtiqueta(){
        ImageIcon iconoOriginal = new ImageIcon("src/main/java/images/taconcito.png");
        Image imagenOriginal = iconoOriginal.getImage();
        int nuevoAncho = 130;
        int nuevoAlto = 110; 
        gbc.gridx=1;
        gbc.gridy=0;
        Image imagenRedimensionada = imagenOriginal.getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_DEFAULT);
        ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
        JLabel img = new JLabel(iconoRedimensionado);
        panel1.add(img,gbc);
        
        
        etiqueta1 = new JLabel("<html>ZAPATERÍA<br>CITLALY</html>");
        etiqueta1.setFont(font1);
        gbc.gridx=0;
        gbc.gridy=0;
        panel1.add(etiqueta1,gbc);
        
        etiqueta2 = new JLabel("¡LOS MEJORES ZAPATOS ESTÁN AQUÍ!");
        etiqueta2.setFont(font2);
        gbc.gridx=0;
        gbc.gridy=1;
        panel1.add(etiqueta2,gbc);        
}
    
    private void colocarRadioButton(){
        texto1 = new JLabel("¿Qué tipo de zapatos desea?");
        gbc.gridx=0;
        gbc.gridy=0;
        texto1.setForeground(Color.decode("#7D049F"));
        panel2.add(texto1,gbc);

        opcion1 = new JRadioButton("Casual");
        opcion1.setBorderPainted(Boolean.FALSE);
        opcion1.setContentAreaFilled(false);
        opcion1.setFocusPainted(false);
        
        opcion2 = new JRadioButton("Deportivo");
        opcion2.setBorderPainted(Boolean.FALSE);
        opcion2.setContentAreaFilled(false);
        opcion2.setFocusPainted(false);
        
        opcion3 = new JRadioButton("Formal");
        opcion3.setBorderPainted(Boolean.FALSE);
        opcion3.setContentAreaFilled(false);
        opcion3.setFocusPainted(false);

        
        ButtonGroup opcionesButtonGroup = new ButtonGroup();
        opcionesButtonGroup.add(opcion1);
        opcionesButtonGroup.add(opcion2);
        opcionesButtonGroup.add(opcion3);
        
        gbc.insets = new Insets(11, 10, 11, 10); // Relleno a la izquierda
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx=0;
        gbc.gridy=1;
        panel2.add(opcion1,gbc);
        gbc.gridx=1;
        gbc.gridy=1;
        panel2.add(opcion2,gbc);
        gbc.gridx=2;
        gbc.gridy=1;
        panel2.add(opcion3,gbc);
        
        // listener del radioButon
        opcion1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            String txtTipo = opcion1.getText();
            
            labelOpcion1.setText("El tipo de zapatos seleccionado es: " + txtTipo);
            gbc.gridx=0;
            gbc.gridy=0;
            panel3.add(labelOpcion1, gbc);
                    
                    panel3.updateUI();
            }});
        opcion2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            String txtTipo = opcion2.getText();
            
            labelOpcion1.setText("El tipo de zapatos seleccionado es: " + txtTipo);
            gbc.gridx=0;
            gbc.gridy=0;
            gbc.insets = new Insets(0,0,0,0); // Relleno a la izquierda
            gbc.anchor = GridBagConstraints.WEST;
            panel3.add(labelOpcion1, gbc);
                    panel3.updateUI();
            }});
        
            opcion3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            String txtTipo = opcion3.getText();
            
            labelOpcion1.setText("El tipo de zapatos seleccionado es: " + txtTipo);
            gbc.gridx=0;
            gbc.gridy=0;
            panel3.add(labelOpcion1, gbc);
                    panel3.updateUI();
            }});
        
    }
    
    private void colocarJComboBox(){
        texto2 = new JLabel("¿Que numero de talla es?");
        texto2.setBounds(20,60,100,100);
        gbc.gridx=0;
        gbc.gridy=2;
        texto2.setForeground(Color.decode("#7D049F"));
        panel2.add(texto2,gbc);
        
        String [] datos ={"3","4","5"};
        elegir = new JComboBox(datos);
        elegir.setBounds(40,60,60,60);
        gbc.gridx=2;
        gbc.gridy=2;
        panel2.add(elegir,gbc);
        
        elegir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String XString = elegir.getSelectedItem().toString();
                
                if(XString=="3"){
            labelOpcion2.setText("La talla seleccionada es: " + XString);
            gbc.gridx=0;
            gbc.gridy=1;
            panel3.add(labelOpcion2, gbc);
            panel3.updateUI();
                }
                if(XString=="4"){
            labelOpcion2.setText("La talla seleccionada es: " + XString);
            gbc.gridx=0;
            gbc.gridy=1;
            panel3.add(labelOpcion2, gbc);
            panel3.updateUI();
                }
            if(XString=="5"){
            labelOpcion2.setText("La talla seleccionada es: " + XString);
            gbc.gridx=0;
            gbc.gridy=1;
            panel3.add(labelOpcion2, gbc);
            panel3.updateUI();
                }

            }});
        
}
    
    private void colocarCheckBox(){
        btn = new JCheckBox("<html>Marque aquí si desea<br>agregar un kit de limpieza<br>para sus zapatos.</html>");
        btn.setBounds(20,150,100,40);
        gbc.gridx=0;
        gbc.gridy=3;
        gbc.anchor = GridBagConstraints.WEST;
        btn.setBackground(Color.decode("#EEB3FF"));
        btn.setForeground(Color.decode("#7D049F"));
        btn.setBorderPainted(Boolean.FALSE);
        btn.setFocusPainted(false);
        panel2.add(btn,gbc);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btn.isSelected()) {
            labelOpcion3.setText("Seleccionaste agregar un kit de limpieza");
            gbc.gridx=0;
            gbc.gridy=3;
            panel3.add(labelOpcion3, gbc);
                    
                    panel3.updateUI();   
                }
                else{
                    labelOpcion3.setText("No haz seleccionado el kit de limpieza");
                }

            }});
        
    }
}


