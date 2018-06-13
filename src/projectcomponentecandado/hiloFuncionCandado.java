/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectcomponentecandado;

import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Dorian Barboza
 */
public class hiloFuncionCandado extends JPanel implements Runnable,ActionListener{
    
    boolean valorBanderaCorrecta = true;
    boolean valorBanderaErronea = false;
    Button btnHabilitado;
    TextField txtPassword;
    //TextField txtUser;
    Thread hiloAccion;
    Crud buscarRegistros;
    
    public hiloFuncionCandado(Button btnAceptar){
       buscarRegistros = new Crud();
       setSize(500,500);
       setLayout(null);
       //txtUser = new TextField();
       txtPassword = new TextField();
       btnHabilitado = btnAceptar;
    }

    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.darkGray);
        g.fillRect(0,0,300,800);
    }
   
    public void start(){
        
        if(hiloAccion == null){
            hiloAccion = new Thread(this,"hiloEtiqueta");
            hiloAccion.start();
        }
    }
    
    @Override
    public void run() {
        Label lbMensaje = new Label("Escribir contraseña para desbloquear");
        lbMensaje.setBounds(20, 10, 210, 25);
        lbMensaje.setForeground(Color.WHITE);
        lbMensaje.setBackground(Color.darkGray);
        txtPassword.setBounds(80, 40, 90, 25);
        //txtUser.setBounds(80, 70, 90, 25);
        
        Button btnAceptar = new Button("Desbloquear");
        btnAceptar.setBounds(50, 350, 200, 60);
        this.add(btnAceptar);
        this.add(txtPassword);
        //this.add(txtUser);
        this.add(lbMensaje);
        btnAceptar.setActionCommand("desbloquear");
        btnAceptar.addActionListener(this);
        
        //Ciclo infinito hasta que se ponga la contraseña correcta
        while(valorBanderaCorrecta){
            
            //Comparamos la bandera, si es true es que se puso la contraseña correcta
            if(valorBanderaErronea){
                //Terminamos el ciclo
                valorBanderaCorrecta = false;
                //Ponemos visible el botón principal (El que nos ayuda a bloquear la pantalla)
                btnHabilitado.setVisible(true);
                ventanaSecundaria vtnSec = new ventanaSecundaria();
                vtnSec.start();
                vtnSec.setVisible(true);
                JPanel ventanaSecundaria = new JPanel();
                ventanaSecundaria.setVisible(true);
                //Ponemos invisible este jpanel
                this.setVisible(false);
                
            }
            //Dormimos al hilo
            try {
                hiloAccion.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(hiloFuncionCandado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //Imprimimos un mensaje para dar a entender que el hilo se terminó
        System.out.println("Desbloqueado");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //Comparamos el tag de los botones que hayan sido presionados
        if(ae.getActionCommand().equals("desbloquear")){
            //Comparamos el valor que puso el usuario con la contraseña correcta
            if(buscarRegistros.passwordIngresados(txtPassword.getText())){
                //Volvemos true la bandera para terminar el hilo y desbloquear la pantalla
                valorBanderaErronea = true;
                JOptionPane.showMessageDialog(this, "Acceso concedido","Proceso exitoso.",JOptionPane.INFORMATION_MESSAGE);
                /*
                JPanel ventanaSecundaria = new JPanel();
                ventanaSecundaria.s*/
                
                

            }else{
                buscarRegistros.passwordErroneosIngresados(txtPassword.getText());
                JOptionPane.showMessageDialog(this, "Contraseña erronea.","Error",JOptionPane.ERROR_MESSAGE);
            }  
        }
    }
}
