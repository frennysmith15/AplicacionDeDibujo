/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicaciondedibujo;

import figuras.Figura;
import figuras.Linea;
import figuras.Poligono;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.JPanel;

import figuras.Rectangulo;
import figuras.Triangulo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 *
 * @author josearielpereyra
 */
public class PanelDeDibujo extends JPanel {

    Figura figuraActual;
    ArrayList<Figura> figuras = new ArrayList<>();
    JPanel barraDeHerramientas;
    public Color colorDePrimerPlano;
    public Color colorDeSegundoPlano;

    public PanelDeDibujo() {

        barraDeHerramientas = new JPanel();
        barraDeHerramientas.setLayout(new FlowLayout(FlowLayout.LEFT));

        JToggleButton botonLinea = new JToggleButton("Linea");
        JToggleButton botonRectangulo = new JToggleButton("Rectangulo");
        JToggleButton botonTriangulo = new JToggleButton("Triangulo");
        JToggleButton botonSelecionarColor = new JToggleButton("SelecionarColor");

        barraDeHerramientas.add(botonLinea);
        barraDeHerramientas.add(botonRectangulo);
        barraDeHerramientas.add(botonTriangulo);
        barraDeHerramientas.add(botonSelecionarColor);

        ButtonGroup grupoBotones = new ButtonGroup();
        grupoBotones.add(botonLinea);
        grupoBotones.add(botonRectangulo);
        grupoBotones.add(botonTriangulo);
        grupoBotones.add(botonSelecionarColor);
        
        //Evento de button selecionar colores
        ActionListener ActionButoon = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
            colorDePrimerPlano = JColorChooser.showDialog(null, "Seleccione el color del contorno", colorDePrimerPlano);
            colorDeSegundoPlano = JColorChooser.showDialog(null, "Seleccione el color del interior", colorDeSegundoPlano);

            }
        };
        botonSelecionarColor.addActionListener(ActionButoon);

        addMouseListener(
                new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point puntoActual = e.getPoint();

                //decidir la figura que se va a dibujar
                if (botonLinea.isSelected()) {
                    figuraActual = new Linea(puntoActual ,colorDePrimerPlano);
                } else if (botonRectangulo.isSelected()) {
                    figuraActual = new Rectangulo(puntoActual,colorDePrimerPlano, colorDeSegundoPlano);
                } else if (botonTriangulo.isSelected()) {
                    figuraActual = new Triangulo(puntoActual,colorDePrimerPlano, colorDeSegundoPlano);
                }else {
                    figuraActual = new Linea(puntoActual,colorDePrimerPlano);
                }
                figuras.add(figuraActual);
                repaint();

            }
        }
        );

        addMouseMotionListener(
                new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e
            ) {
                Point puntoActual = e.getPoint();
                figuraActual.actualizar(puntoActual);

                repaint();
            }
        }
        );
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
