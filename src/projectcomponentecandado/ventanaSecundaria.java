
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectcomponentecandado;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author Dorian Barboza
 */

public class ventanaSecundaria extends JPanel implements Runnable,ActionListener {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(0,0,300,800);
    }
    @Override
    public void run() {
        Label lbMensaje2 = new Label("Pestaña 2");
        lbMensaje2.setBounds(20, 10, 210, 25);
        lbMensaje2.setForeground(Color.BLACK);
        lbMensaje2.setBackground(Color.WHITE);
        
        
        }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void start() {
        }
    
}
