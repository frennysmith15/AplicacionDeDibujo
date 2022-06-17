/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aplicaciondedibujo;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

/**
 *
 * @author josearielpereyra
 */
public class AplicacionDeDibujo extends JFrame{
    
    public static PanelDeDibujo panelDeDibujo;
    BarraMenu barraDeMenu;
    JPanel herramientas;
    
    public AplicacionDeDibujo() throws HeadlessException {
        setTitle("Aplicacion de Dibujo");
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setSize(800, 600);
        setLocationRelativeTo(null);
        
        panelDeDibujo = new PanelDeDibujo();
        panelDeDibujo.setBackground(Color.WHITE);
        barraDeMenu = new BarraMenu();
     
        herramientas = new JPanel();
        herramientas.setLayout(new BorderLayout());
        herramientas.add(panelDeDibujo.getBaraDeHerramientas(), BorderLayout.CENTER);
        herramientas.add(panelDeDibujo.getSeleccionDeColores(), BorderLayout.EAST);
        
         
        
        this.add(herramientas, BorderLayout.NORTH);
        this.add(panelDeDibujo, BorderLayout.CENTER);
        this.setJMenuBar(barraDeMenu);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
          if ( "Nimbus".equals(info.getName())) {
            javax.swing.UIManager.setLookAndFeel(info.getClassName());
          }
        }
      } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "No se pudo cambiar la apariencia visual");
      }
        
        AplicacionDeDibujo aplicacionDeDibujo = new AplicacionDeDibujo();
        aplicacionDeDibujo.setVisible(true);
        
    }
    
    public PanelDeDibujo getPanelDeDibujo(){
        return panelDeDibujo;
    }
}
