/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectcomponentecandado;

import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Dorian Barboza
 */
public class ventanaPrincipal extends JFrame implements ActionListener{
    Button btnAceptar;
    public ventanaPrincipal(){
        
//JFrame
        this.setSize(300, 500);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        

        btnAceptar = new Button("botonAceptarEquiqueta");
        btnAceptar.setBounds(50, 350, 200, 60);
        btnAceptar.setActionCommand("botonAceptarEquiqueta");
        btnAceptar.addActionListener(this);
        this.add(btnAceptar);
        this.setVisible(true);
    }

    

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("botonAceptarEquiqueta")){
           hiloFuncionCandado hilo = new hiloFuncionCandado(btnAceptar);
           add(hilo);
           hilo.start();
           btnAceptar.setVisible(false);
           repaint();
        }
    }
    
}
