/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicaciondedibujo;

import figuras.Figura;
import figuras.Linea;
import figuras.Poligono;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import figuras.TrianguloRectangulo;
import figuras.Rectangulo;
import figuras.Triangulo;
import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JToggleButton;

/**
 *
 * @author josearielpereyra
 */
public class PanelDeDibujo extends JPanel {

    Figura figuraActual;
    ArrayList<Figura> figuras = new ArrayList<>();
    JPanel barraDeHerramientas;
    
    public PanelDeDibujo() {
        
        barraDeHerramientas = new JPanel();
        barraDeHerramientas.setLayout(new FlowLayout( FlowLayout.LEFT));
        
        JToggleButton botonLinea = new JToggleButton("Linea");
        JToggleButton botonRectangulo = new JToggleButton("Rectangulo");
        JToggleButton botonPoligono = new JToggleButton("Poligono");
        JToggleButton botonTrianguloRectangulo = new JToggleButton("TrianguloRectangulo");
        
        barraDeHerramientas.add(botonLinea);
        barraDeHerramientas.add(botonRectangulo);
        barraDeHerramientas.add(botonPoligono);
        barraDeHerramientas.add(botonTrianguloRectangulo);
        
        ButtonGroup grupoBotones = new ButtonGroup();
        grupoBotones.add(botonLinea);
        grupoBotones.add(botonRectangulo);
        grupoBotones.add(botonPoligono);
        grupoBotones.add(botonTrianguloRectangulo);
        
        addMouseListener( new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point puntoActual = e.getPoint();
                //decidir la figura que se va a dibujar
                if( botonLinea.isSelected() ) {
                    figuraActual = new Linea( puntoActual );
                }
                else if( botonRectangulo.isSelected() ) {
                    figuraActual = new Rectangulo( puntoActual );
                }
                else if( botonPoligono.isSelected() ) {
                    figuraActual = new Triangulo( puntoActual );
                }
                else if( botonTrianguloRectangulo.isSelected() ) {
                    figuraActual = new TrianguloRectangulo( puntoActual );
                }

                figuras.add(figuraActual);

                repaint(); 
            }
        });
        
        addMouseMotionListener( new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point puntoActual = e.getPoint();
                figuraActual.actualizar( puntoActual );
                
                repaint();
            }
        });
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Figura figura : figuras) {
            figura.dibujar(g);
        }
    }
    
    public JPanel getBaraDeHerramientas() {
        return barraDeHerramientas;
    }
}
