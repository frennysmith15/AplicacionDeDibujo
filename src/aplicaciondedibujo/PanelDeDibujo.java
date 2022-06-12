/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicaciondedibujo;

import figuras.*;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import java.awt.Color;
import java.awt.FlowLayout;
import java.io.File;
import javax.swing.JFileChooser;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 * @author josearielpereyra
 */
public class PanelDeDibujo extends JPanel {

    public static PanelDeDibujo panel;
    Figura figuraActual;
    ArrayList<Figura> figuras = new ArrayList<>();
    Stack<Figura> figurasDeshacer = new Stack<>();;
    JPanel barraDeHerramientas;
    File archivo;
    
    public void rehacer() {
        if(!figurasDeshacer.isEmpty()) {
            figuras.add(figurasDeshacer.pop());

            repaint();
        }
    }
    
    public void deshacer() {
        if(!figuras.isEmpty()) {
            figurasDeshacer.push(figuras.remove(figuras.size() - 1));

            repaint();
        }
    }
    
    public void guardar() {
        try {
            if(archivo != null) {
                BufferedImage imagen = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics2D grafico = imagen.createGraphics();
                this.paint(grafico);
                grafico.dispose();
                
                String ruta = archivo.getPath();
                String extension = ruta.substring(ruta.lastIndexOf(".") + 1);
                ImageIO.write(imagen, extension, archivo);
            }
            else {
                guardarComo();
            }
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void guardarComo() {
        BufferedImage imagen = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D grafico = imagen.createGraphics();
        this.paint(grafico);
        grafico.dispose();

        System.out.println(imagen);
        JFileChooser seleccion = new JFileChooser();
        seleccion.removeChoosableFileFilter(seleccion.getChoosableFileFilters()[0]);
        seleccion.addChoosableFileFilter(new FileNameExtensionFilter("jpg", "jpg"));
        seleccion.addChoosableFileFilter(new FileNameExtensionFilter("png", "png"));

        int opcion = seleccion.showSaveDialog(this);

        if (opcion == JFileChooser.APPROVE_OPTION) {
            try {
                String ruta = seleccion.getSelectedFile().getPath();
                String extensionSeleccion = seleccion.getFileFilter().getDescription();
                int indice = ruta.lastIndexOf(".");
                String extension = indice < 0 ? "." + extensionSeleccion : ruta.substring(indice);

                if (!extension.equalsIgnoreCase(".jpg") && !extension.equalsIgnoreCase(".png")) {
                    extension = "." + extensionSeleccion;
                    ruta = ruta.substring(0, indice);
                }

                
                archivo = new File(ruta + extension);
                ImageIO.write(imagen, extension.replace(".", ""), archivo);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public PanelDeDibujo() {
        panel = this;
        this.setLayout(null);
        barraDeHerramientas = new JPanel();
        barraDeHerramientas.setLayout(new GridLayout(2, 10));
        
        JToggleButton botonLinea = new JToggleButton("Linea");
        JToggleButton botonPacman = new JToggleButton("Pacman");
        JToggleButton botonRombo = new JToggleButton("Rombo");
        JToggleButton botonPoligono = new JToggleButton("Poligono");
        JToggleButton botonEstrella = new JToggleButton("Estrella");
        JToggleButton botonRectangulo = new JToggleButton("Rectangulo");
        JToggleButton botonTriangulo = new JToggleButton("Triangulo");
        JToggleButton botonPentagono = new JToggleButton("Pentagono");
        JToggleButton botonHexagono = new JToggleButton("Hexagono");
        JToggleButton botonEscaleno = new JToggleButton("Escaleno");
        JToggleButton botonTrianguloRectangulo = new JToggleButton("Triangulo Rectangulo");
        JToggleButton botonBorrador = new JToggleButton("Borrador");
        JToggleButton botonParalelogramo = new JToggleButton("Paralelogramo");

        barraDeHerramientas.add(botonLinea);
        barraDeHerramientas.add(botonRombo);        
        barraDeHerramientas.add(botonPoligono);
        barraDeHerramientas.add(botonEstrella);
        barraDeHerramientas.add(botonRectangulo);
        barraDeHerramientas.add(botonTriangulo);
        barraDeHerramientas.add(botonPentagono);
        barraDeHerramientas.add(botonHexagono);
        barraDeHerramientas.add(botonEscaleno);
        barraDeHerramientas.add(botonTrianguloRectangulo);
        barraDeHerramientas.add(botonBorrador);
        barraDeHerramientas.add(botonParalelogramo);
        barraDeHerramientas.add(botonPacman);
        
        ButtonGroup grupoBotones = new ButtonGroup();
        grupoBotones.add(botonLinea);
        grupoBotones.add(botonPoligono);
        grupoBotones.add(botonEstrella);
        grupoBotones.add(botonRectangulo);
        grupoBotones.add(botonTriangulo);
        grupoBotones.add(botonPentagono);
        grupoBotones.add(botonHexagono);
        grupoBotones.add(botonEscaleno);
        grupoBotones.add(botonTrianguloRectangulo);
        grupoBotones.add(botonBorrador);
        grupoBotones.add(botonParalelogramo);
        grupoBotones.add(botonRombo);
        grupoBotones.add(botonPacman);
        
        Color colorDeContorno = Color.red;
        Color colorDeFondo = Color.black;
        
        botonLinea.setSelected(true);

        addMouseListener( new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point puntoActual = e.getPoint();                

                //decidir la figura que se va a dibujar
                if( botonLinea.isSelected() ) {
                    //figuraActual = new Linea( puntoActual, colorDeContorno );
                    figuraActual = new BaldeDePintura(PanelDeDibujo.this, colorDeContorno);
                    figuraActual.actualizar(puntoActual);
                }
                else if( botonPoligono.isSelected() ) {
                    figuraActual = new Poligono(colorDeFondo, colorDeContorno, Boolean.TRUE, puntoActual);
                }
                else if( botonRectangulo.isSelected() ) {
                    figuraActual = new Rectangulo(colorDeFondo, colorDeContorno, Boolean.TRUE, puntoActual);
                }
                else if( botonPacman.isSelected() ) {
                    figuraActual = new Pacman(colorDeFondo, colorDeContorno, Boolean.TRUE, puntoActual);
                }
                else if( botonRombo.isSelected() ) {
                    figuraActual = new Rombo(colorDeFondo, colorDeContorno, Boolean.TRUE, puntoActual);
                }
                else if( botonEstrella.isSelected() ) {
                    figuraActual = new Estrella(colorDeFondo, colorDeContorno, Boolean.TRUE, puntoActual);
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
                else if( botonBorrador.isSelected() ) {
                   figuraActual = new Borrador( puntoActual);
                }
                else if( botonParalelogramo.isSelected() ) {
                   figuraActual = new Paralelogramo(colorDeFondo, colorDeContorno, Boolean.TRUE, puntoActual);
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
                
                if(figuraActual instanceof FiguraRellenable) {
                    Marco marco = Marco.obtenerInstancia(PanelDeDibujo.panel, puntoActual, null);
                    marco.actualizar(puntoActual);
                }
                                    
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
        if(figuraActual instanceof FiguraRellenable) {
            ((FiguraRellenable) figuraActual).dibujarMarco(g);
        }
    }
    
    public JPanel getBaraDeHerramientas() {
        return barraDeHerramientas;
    }
}
