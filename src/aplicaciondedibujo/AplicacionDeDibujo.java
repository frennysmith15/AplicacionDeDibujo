/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aplicaciondedibujo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author josearielpereyra
 */
public class AplicacionDeDibujo extends JFrame{
    
    PanelDeDibujo panelDeDibujo;
    
    public AplicacionDeDibujo() throws HeadlessException {
        setTitle("Aplicacion de Dibujo");
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setSize(800, 600);
        setLocationRelativeTo(null);
        
        panelDeDibujo = new PanelDeDibujo();
        panelDeDibujo.setBackground(Color.WHITE);
        
        this.add(panelDeDibujo.getBaraDeHerramientas(), BorderLayout.NORTH);
        this.add(panelDeDibujo, BorderLayout.CENTER);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AplicacionDeDibujo aplicacionDeDibujo = new AplicacionDeDibujo();
        aplicacionDeDibujo.setVisible(true);
        
    }
}
