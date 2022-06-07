/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicaciondedibujo;

import aplicaciondedibujo.PanelDeDibujo;
import figuras.Figura;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author frenn
 */
public class BarraMenu extends JMenuBar{
    private final PanelDeDibujo panelDeDibujo = AplicacionDeDibujo.panelDeDibujo;
    
    JMenu menuArchivo;
    JMenu menuEdicion;
    
    JMenuItem abrir, cerrar, rehacer, deshacer, guardar, guardarComo;
    JMenuItem copiar, cortar, pegar, eliminar;
    
    public BarraMenu() {
        
        menuArchivo = new JMenu("Archivo");
        menuEdicion = new JMenu("Edicion");
        
        abrir = new JMenuItem("Abrir");
        cerrar = new JMenuItem("Cerrar");
        guardar = new JMenuItem("Guardar");
        guardarComo = new JMenuItem("Guardar Como");
        rehacer = new JMenuItem("Rehacer");
        deshacer = new JMenuItem("Deshacer");
        
        copiar = new JMenuItem("Copiar");
        cortar = new JMenuItem("Cortar");
        pegar = new JMenuItem("Pegar");
        eliminar = new JMenuItem("Eliminar");
        
        //mAopcSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        
        menuArchivo.add(abrir);
        menuArchivo.add(cerrar);
        menuArchivo.add(guardar);
        menuArchivo.add(guardarComo);
        
        menuEdicion.add(copiar);
        menuEdicion.add(cortar);
        menuEdicion.add(pegar);
        menuEdicion.add(rehacer);
        menuEdicion.add(deshacer);
        menuEdicion.add(eliminar);
        
        this.add(menuArchivo);
        this.add(menuEdicion);
        
        guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelDeDibujo.guardar();
            }
        });
        
        guardarComo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelDeDibujo.guardarComo();
            }
        });
        
        rehacer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelDeDibujo.rehacer();
            }
        });
        
        deshacer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelDeDibujo.deshacer();
            }
        });
                
    }
    
    
}
