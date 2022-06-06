/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicaciondedibujo;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author frenn
 */
public class BarraMenu extends JMenuBar{
    JMenu menuArchivo;
    JMenu menuEdicion;
    
    JMenuItem abrir, cerrar, rehacer, deshacer, guardar;
    JMenuItem copiar, pegar, eliminar;
    
    public BarraMenu() {
        JMenu menuArchivo = new JMenu("Archivo");
        JMenu menuEdicion = new JMenu("Edicion");
        
        abrir = new JMenuItem("Abrir");
        cerrar = new JMenuItem("Cerrar");
        rehacer = new JMenuItem("Rehacer");
        deshacer = new JMenuItem("Deshacer");
        
        copiar = new JMenuItem("Copiar");
        pegar = new JMenuItem("Pegar");
        eliminar = new JMenuItem("Eliminar");
        
        menuArchivo.add(abrir);
        menuArchivo.add(cerrar);
        menuArchivo.add(deshacer);
        menuArchivo.add(rehacer);
        
        menuEdicion.add(copiar);
        menuEdicion.add(pegar);
        menuEdicion.add(eliminar);
        
        this.add(menuArchivo);
        this.add(menuEdicion);
        
    }
    
    
    
}
