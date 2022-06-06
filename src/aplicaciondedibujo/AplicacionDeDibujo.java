/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aplicaciondedibujo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author josearielpereyra
 */
public class AplicacionDeDibujo extends JFrame{
    
    PanelDeDibujo panelDeDibujo;
    BarraMenu barraDeMenu;
    
    public AplicacionDeDibujo() throws HeadlessException {
        setTitle("Aplicacion de Dibujo");
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setSize(800, 600);
        setLocationRelativeTo(null);
        
        panelDeDibujo = new PanelDeDibujo();
        panelDeDibujo.setBackground(Color.WHITE);
        barraDeMenu = new BarraMenu();
        
        this.add(panelDeDibujo.getBaraDeHerramientas(), BorderLayout.NORTH);
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
}
