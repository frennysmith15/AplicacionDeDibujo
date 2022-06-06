/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicaciondedibujo;

import figuras.Anillo;
import figuras.Escaleno;
import figuras.Figura;
import figuras.Hexagono;
import figuras.Linea;
import figuras.Pentagono;
import figuras.Poligono;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPanel;

import figuras.Rectangulo;
import figuras.Triangulo;
import figuras.TrianguloRectangulo;
import java.awt.Color;
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
        JToggleButton botonTriangulo = new JToggleButton("Triangulo");
        JToggleButton botonPentagono = new JToggleButton("Pentagono");
        JToggleButton botonHexagono = new JToggleButton("Hexagono");
        JToggleButton botonEscaleno = new JToggleButton("Escaleno");
        JToggleButton botonTrianguloRectangulo = new JToggleButton("Triangulo Rectangulo");
        JToggleButton botonAnillo = new JToggleButton("Anillo");

        barraDeHerramientas.add(botonLinea);
        barraDeHerramientas.add(botonRectangulo);
        barraDeHerramientas.add(botonTriangulo);
        barraDeHerramientas.add(botonPentagono);
        barraDeHerramientas.add(botonHexagono);
        barraDeHerramientas.add(botonEscaleno);
        barraDeHerramientas.add(botonTrianguloRectangulo);
        barraDeHerramientas.add(botonAnillo);
        
        ButtonGroup grupoBotones = new ButtonGroup();
        grupoBotones.add(botonLinea);
        grupoBotones.add(botonRectangulo);
        grupoBotones.add(botonTriangulo);
        grupoBotones.add(botonPentagono);
        grupoBotones.add(botonHexagono);
        grupoBotones.add(botonEscaleno);
        grupoBotones.add(botonTrianguloRectangulo);
        grupoBotones.add(botonAnillo);

        Color colorDeContorno = Color.red;
        Color colorDeFondo = Color.black;

        
        
        addMouseListener( new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point puntoActual = e.getPoint();
                
                
                //decidir la figura que se va a dibujar
                if( botonLinea.isSelected() ) {
                    figuraActual = new Linea( puntoActual );
                }
                else if( botonRectangulo.isSelected() ) {
                    figuraActual = new Rectangulo(colorDeFondo, colorDeContorno, Boolean.TRUE, puntoActual);
                }
                else if(botonTriangulo.isSelected() ) {
                    figuraActual = new Triangulo(colorDeFondo, colorDeContorno, Boolean.TRUE, puntoActual);
                }
                else if( botonPentagono.isSelected() ) {
                   figuraActual = new Pentagono(colorDeFondo, colorDeContorno, Boolean.TRUE, puntoActual);
                }
                else if( botonHexagono.isSelected() ) {
                   figuraActual = new Hexagono(colorDeFondo, colorDeContorno, Boolean.TRUE, puntoActual);
                }
                else if( botonEscaleno.isSelected() ) {
                   figuraActual = new Escaleno(colorDeFondo, colorDeContorno, Boolean.TRUE, puntoActual);
                }
                else if( botonTrianguloRectangulo.isSelected() ) {
                   figuraActual = new TrianguloRectangulo(colorDeFondo, colorDeContorno, Boolean.TRUE, puntoActual);
                }
                else if( botonAnillo.isSelected() ) {
                   figuraActual = new Anillo(puntoActual);
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
