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
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;
import javax.swing.JFileChooser;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.EventHandler;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author josearielpereyra
 */
public class PanelDeDibujo extends JPanel {

    public static PanelDeDibujo panel;
    Figura figuraActual;
    ArrayList<Figura> figuras = new ArrayList<>();
    Stack<Figura> figurasDeshacer = new Stack<>();
    JPanel barraDeHerramientas;
    JPanel seleccionDeColores;

    Color colorDeContorno;
    Color colorDeFondo;
    Boolean relleno;

    File archivo;

    public void rehacer() {
        if (!figurasDeshacer.isEmpty()) {
            figuras.add(figurasDeshacer.pop());

            repaint();
        }
    }

    public void deshacer() {
        if (!figuras.isEmpty()) {
            figurasDeshacer.push(figuras.remove(figuras.size() - 1));

            repaint();
        }
    }

    public void guardar() {
        try {
            if (archivo != null) {
                BufferedImage imagen = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics2D grafico = imagen.createGraphics();
                this.paint(grafico);
                grafico.dispose();

                String ruta = archivo.getPath();
                String extension = ruta.substring(ruta.lastIndexOf(".") + 1);
                ImageIO.write(imagen, extension, archivo);
            } else {
                guardarComo();
            }
        } catch (Exception ex) {
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
        seleccionDeColores = new JPanel();
        barraDeHerramientas.setLayout(new GridLayout(2, 10));
        seleccionDeColores.setLayout(new GridLayout(2, 1));
        JCheckBox CBrelleno = new JCheckBox("Rellenar");
        relleno = false;

        JButton botonSelecionarColor = new JButton("SelecionarColor");
        seleccionDeColores.add(botonSelecionarColor);
        seleccionDeColores.add(CBrelleno);

        JToggleButton botonLinea = new JToggleButton();
        JToggleButton botonDibujoLibre = new JToggleButton();
        JToggleButton botonSemiCirculo = new JToggleButton();
        JToggleButton botonPacman = new JToggleButton();
        JToggleButton botonRombo = new JToggleButton();
        JToggleButton botonPoligono = new JToggleButton();
        JToggleButton botonTrapecio = new JToggleButton();
        JToggleButton botonCirculo = new JToggleButton();
        JToggleButton botonMediaLuna = new JToggleButton();
        JToggleButton botonCruz = new JToggleButton();
        JToggleButton botonTrevor = new JToggleButton();
        JToggleButton botonEstrella = new JToggleButton();
        JToggleButton botonRectangulo = new JToggleButton();
        JToggleButton botonCuadrado = new JToggleButton();
        JToggleButton botonTriangulo = new JToggleButton();
        JToggleButton botonPentagono = new JToggleButton();
        JToggleButton botonHexagono = new JToggleButton();
        JToggleButton botonEscaleno = new JToggleButton();
        JToggleButton botonTrianguloRectangulo = new JToggleButton();
        JToggleButton botonElipse = new JToggleButton();
        JToggleButton botonAnillo = new JToggleButton();
        JToggleButton botonBorrador = new JToggleButton();
        JToggleButton botonParalelogramo = new JToggleButton();
        JToggleButton botonBaldeDePintura = new JToggleButton();
        JToggleButton botonFlecha = new JToggleButton();
        JToggleButton botonCometa = new JToggleButton();
        JToggleButton botonOctagono = new JToggleButton();
        JToggleButton botonCorazon = new JToggleButton();
        
//------Iconos de los botones 
        botonLinea.setIcon(setIcono("/imagenes/linea.png"));
        botonDibujoLibre.setIcon(setIcono("/imagenes/dibujolibreIcon.png"));
        botonSemiCirculo.setIcon(setIcono("/imagenes/semiCirculo.png"));
        botonPacman.setIcon(setIcono("/imagenes/pic.png"));
        botonRombo.setIcon(setIcono("/imagenes/rombo.png"));
        botonPoligono.setIcon(setIcono("/imagenes/poligono.png"));
        botonTrapecio.setIcon(setIcono("/imagenes/trapecio.png"));
        botonSelecionarColor.setIcon(setIcono("/imagenes/selectorIcon.png"));
        botonMediaLuna.setIcon(setIcono("/imagenes/creciente.png"));
        botonEstrella.setIcon(setIcono("/imagenes/estrella.png"));
        botonTrevor.setIcon(setIcono("/imagenes/quatrebol.png"));
        botonRectangulo.setIcon(setIcono("/imagenes/rectangulo.png"));
        botonCuadrado.setIcon(setIcono("/imagenes/cuadrado.png"));
        botonTriangulo.setIcon(setIcono("/imagenes/triangulo.png"));
        botonPentagono.setIcon(setIcono("/imagenes/pentagono.png"));
        botonHexagono.setIcon(setIcono("/imagenes/hexagono.png"));
        botonEscaleno.setIcon(setIcono("/imagenes/trianguloEscaleno.png"));
        botonTrianguloRectangulo.setIcon(setIcono("/imagenes/trianguloRectangulo.png"));
        botonElipse.setIcon(setIcono("/imagenes/elipse.png"));
        botonAnillo.setIcon(setIcono("/imagenes/ring.png"));
        botonBorrador.setIcon(setIcono("/imagenes/borradorIcon.png"));
        botonParalelogramo.setIcon(setIcono("/imagenes/paralelogramo.png"));
        botonBaldeDePintura.setIcon(setIcono("/imagenes/baldePinturaIcon.png"));
        botonFlecha.setIcon(setIcono("/imagenes/flecha.png"));
        botonCometa.setIcon(setIcono("/imagenes/cometa.png"));
        botonOctagono.setIcon(setIcono("/imagenes/octagono.png"));
        botonCorazon.setIcon(setIcono("/imagenes/corazon.png"));
        botonCirculo.setIcon(setIcono("/imagenes/circulo.png"));
        botonCruz.setIcon(setIcono("/imagenes/cruz.png"));
        
        barraDeHerramientas.add(botonLinea);
        barraDeHerramientas.add(botonRombo);
        barraDeHerramientas.add(botonPoligono);
        barraDeHerramientas.add(botonCirculo);
        barraDeHerramientas.add(botonMediaLuna);
        barraDeHerramientas.add(botonCruz);
        barraDeHerramientas.add(botonTrevor);
        barraDeHerramientas.add(botonEstrella);
        barraDeHerramientas.add(botonCuadrado);
        barraDeHerramientas.add(botonTrapecio);
        barraDeHerramientas.add(botonRectangulo);
        barraDeHerramientas.add(botonTriangulo);
        barraDeHerramientas.add(botonPentagono);
        barraDeHerramientas.add(botonHexagono);
        barraDeHerramientas.add(botonEscaleno);
        barraDeHerramientas.add(botonTrianguloRectangulo);
        barraDeHerramientas.add(botonElipse);
        barraDeHerramientas.add(botonAnillo);
        barraDeHerramientas.add(botonParalelogramo);
        barraDeHerramientas.add(botonPacman);
        barraDeHerramientas.add(botonFlecha);
        barraDeHerramientas.add(botonOctagono);
        barraDeHerramientas.add(botonCometa);
        barraDeHerramientas.add(botonSemiCirculo);
        barraDeHerramientas.add(botonCorazon);
        barraDeHerramientas.add(botonDibujoLibre);
        barraDeHerramientas.add(botonBorrador);
        barraDeHerramientas.add(botonBaldeDePintura);

        ButtonGroup grupoBotones = new ButtonGroup();
        grupoBotones.add(botonLinea);
        grupoBotones.add(botonPoligono);
        grupoBotones.add(botonCirculo);
        grupoBotones.add(botonMediaLuna);
        grupoBotones.add(botonCruz);
        grupoBotones.add(botonTrevor);
        grupoBotones.add(botonEstrella);
        grupoBotones.add(botonRectangulo);
        grupoBotones.add(botonCuadrado);
        grupoBotones.add(botonTriangulo);
        grupoBotones.add(botonPentagono);
        grupoBotones.add(botonHexagono);
        grupoBotones.add(botonEscaleno);
        grupoBotones.add(botonTrianguloRectangulo);
        grupoBotones.add(botonElipse);
        grupoBotones.add(botonSelecionarColor);
        grupoBotones.add(botonAnillo);
        grupoBotones.add(botonCometa);
        grupoBotones.add(botonOctagono);
        grupoBotones.add(botonBorrador);
        grupoBotones.add(botonParalelogramo);
        grupoBotones.add(botonRombo);
        grupoBotones.add(botonPacman);
        grupoBotones.add(botonBaldeDePintura);
        grupoBotones.add(botonFlecha);
        grupoBotones.add(botonDibujoLibre);
        grupoBotones.add(botonSemiCirculo);
        grupoBotones.add(botonTrapecio);
        grupoBotones.add(botonCorazon);
        
        botonDibujoLibre.setSelected(true);

        colorDeContorno = Color.BLACK;
        colorDeFondo = Color.WHITE;

        //Evento de button selecionar colores
        ActionListener ActionButoon = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                colorDeContorno = JColorChooser.showDialog(null, "Seleccione el color del contorno", colorDeContorno);
                colorDeFondo = JColorChooser.showDialog(null, "Seleccione el color del interior", colorDeFondo);

            }
        };
        botonSelecionarColor.addActionListener(ActionButoon);

        CBrelleno.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                relleno = e.getStateChange() == 1 ? true : false;
            }
        });
        
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                Point puntoActual = e.getPoint();

                //decidir la figura que se va a dibujar
                if (botonLinea.isSelected()) {
                    figuraActual = new Linea(puntoActual, colorDeContorno);
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/linea.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("ERROR no se puedo cargar el ICON");
                        excepcion.printStackTrace();
                    }
                } else if (botonPoligono.isSelected()) {
                    figuraActual = new Poligono(colorDeFondo, colorDeContorno, relleno, puntoActual);
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/poligono.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("ERROR no se puedo cargar el ICON");
                        excepcion.printStackTrace();
                    }
                } else if (botonFlecha.isSelected()) {
                    figuraActual = new Flecha(colorDeFondo, colorDeContorno, relleno, puntoActual);
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/flecha.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("ERROR no se puedo cargar el ICON");
                        excepcion.printStackTrace();
                    }
                } else if (botonRectangulo.isSelected()) {
                    figuraActual = new Rectangulo(colorDeFondo, colorDeContorno, relleno, puntoActual);
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/rectangulo.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("ERROR no se puedo cargar el ICON");
                        excepcion.printStackTrace();
                    }
                } else if (botonDibujoLibre.isSelected()) {
                    figuraActual = new DibujoLibre(puntoActual, colorDeContorno);
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/pencil.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("ERROR no se puedo cargar el ICON");
                        excepcion.printStackTrace();
                    }
                } else if (botonSemiCirculo.isSelected()) {
                    figuraActual = new SemiCirculo(colorDeFondo, colorDeContorno, relleno, puntoActual);
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/semiCirculo.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("ERROR no se puedo cargar el ICON");
                        excepcion.printStackTrace();
                    }
                } else if (botonPacman.isSelected()) {
                    figuraActual = new Pacman(colorDeFondo, colorDeContorno, relleno, puntoActual);
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/pic.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("ERROR no se puedo cargar el ICON");
                        excepcion.printStackTrace();
                    }
                } else if (botonCruz.isSelected()) {
                    figuraActual = new Cruz(colorDeFondo, colorDeContorno, relleno, puntoActual);
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/cruz.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("ERROR no se puedo cargar el ICON");
                        excepcion.printStackTrace();
                    }
                } else if (botonRombo.isSelected()) {
                    figuraActual = new Rombo(colorDeFondo, colorDeContorno, relleno, puntoActual);
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/rombo.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("ERROR no se puedo cargar el ICON");
                        excepcion.printStackTrace();
                    }
                } else if (botonEstrella.isSelected()) {
                    figuraActual = new Estrella(colorDeFondo, colorDeContorno, relleno, puntoActual);
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/estrella.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("ERROR no se puedo cargar el ICON");
                        excepcion.printStackTrace();
                    }
                } else if (botonTriangulo.isSelected()) {
                    figuraActual = new Triangulo(colorDeFondo, colorDeContorno, relleno, puntoActual);
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/triangulo.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("ERROR no se puedo cargar el ICON");
                        excepcion.printStackTrace();
                    }
                } else if (botonPentagono.isSelected()) {
                    figuraActual = new Pentagono(colorDeFondo, colorDeContorno, relleno, puntoActual);
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/pentagono.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("ERROR no se puedo cargar el ICON");
                        excepcion.printStackTrace();
                    }
                } else if (botonHexagono.isSelected()) {
                    figuraActual = new Hexagono(colorDeFondo, colorDeContorno, relleno, puntoActual);
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/hexagono.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("ERROR no se puedo cargar el ICON");
                        excepcion.printStackTrace();
                    }
                } else if (botonEscaleno.isSelected()) {
                    figuraActual = new Escaleno(colorDeFondo, colorDeContorno, relleno, puntoActual);
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/trianguloEscaleno.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("ERROR no se puedo cargar el ICON");
                        excepcion.printStackTrace();
                    }
                } else if (botonTrianguloRectangulo.isSelected()) {
                    figuraActual = new TrianguloRectangulo(colorDeFondo, colorDeContorno, relleno, puntoActual);
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/trianguloRectangulo.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("ERROR no se puedo cargar el ICON");
                        excepcion.printStackTrace();
                    }
                } else if (botonElipse.isSelected()) {
                    figuraActual = new Elipse(colorDeFondo, colorDeContorno, relleno, puntoActual);
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/elipse.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("ERROR no se puedo cargar el ICON");
                        excepcion.printStackTrace();
                    }
                } else if (botonAnillo.isSelected()) {
                    figuraActual = new Anillo(colorDeFondo, colorDeContorno, relleno, puntoActual);
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/ring.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("ERROR no se puedo cargar el ICON");
                        excepcion.printStackTrace();
                    }
                } else if (botonOctagono.isSelected()) {
                    figuraActual = new Octagono(colorDeFondo, colorDeContorno, relleno, puntoActual);
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/octagono.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("ERROR no se puedo cargar el ICON");
                        excepcion.printStackTrace();
                    }
                } else if (botonCometa.isSelected()) {
                    figuraActual = new Cometa(colorDeFondo, colorDeContorno, relleno, puntoActual);
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/cometa.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("ERROR no se puedo cargar el ICON");
                        excepcion.printStackTrace();
                    }
                } else if (botonBorrador.isSelected()) {
                    figuraActual = new Borrador(puntoActual);
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/borrador.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("ERROR no se puedo cargar el ICON");
                        excepcion.printStackTrace();
                    }
                } else if (botonParalelogramo.isSelected()) {
                    figuraActual = new Paralelogramo(colorDeFondo, colorDeContorno, relleno, puntoActual);
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/paralelogramo.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("ERROR no se puedo cargar el ICON");
                        excepcion.printStackTrace();
                    }
                } else if (botonBaldeDePintura.isSelected()) {
                    if (Marco.paneles != null) {
                        for (JPanel marcos : Marco.paneles) {
                            marcos.setVisible(false);
                        }
                    }
                    figuraActual = new BaldeDePintura(PanelDeDibujo.this, colorDeContorno);
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/botePintura.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("ERROR no se puedo cargar el ICON");
                        excepcion.printStackTrace();
                    }
                    figuraActual.actualizar(puntoActual);
                } else if (botonTrevor.isSelected()) {
                    figuraActual = new TrevorDeCuatroHojas(colorDeFondo, colorDeContorno, relleno, puntoActual);
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/quatrebol.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("ERROR no se puedo cargar el ICON");
                        excepcion.printStackTrace();
                    }
                } else if (botonMediaLuna.isSelected()) {
                    figuraActual = new MediaLuna(colorDeFondo, colorDeContorno, relleno, puntoActual);
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/creciente.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("ERROR no se puedo cargar el ICON");
                        excepcion.printStackTrace();
                    }
                } else if (botonCirculo.isSelected()) {
                    figuraActual = new Circulo(colorDeFondo, colorDeContorno, relleno, puntoActual);
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/circulo.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("ERROR no se puedo cargar el ICON");
                        excepcion.printStackTrace();
                    }
                } else if (botonCuadrado.isSelected()) {
                    figuraActual = new Cuadrado(colorDeFondo, colorDeContorno, relleno, puntoActual);
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/cuadrado.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("ERROR no se puedo cargar el ICON");
                        excepcion.printStackTrace();
                    }
                } else if (botonTrapecio.isSelected()) {
                    figuraActual = new Trapecio(colorDeFondo, colorDeContorno, relleno, puntoActual);
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/trapecio.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("ERROR no se puedo cargar el ICON");
                        excepcion.printStackTrace();
                    }
                } else if (botonCorazon.isSelected()) {
                    figuraActual = new Corazon(colorDeFondo, colorDeContorno, relleno, puntoActual);
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/corazon.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("ERROR no se puedo cargar el ICON");
                        excepcion.printStackTrace();
                    }
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

                if (figuraActual instanceof FiguraRellenable) {
                    Marco marco = Marco.obtenerInstancia(PanelDeDibujo.panel, puntoActual, null);
                    marco.actualizar(puntoActual);
                    JPanel[] panelesDelMarco = Marco.paneles;
                    for (JPanel marcos : panelesDelMarco) {
                        marcos.setVisible(true);
                    }
                } else {
                    if (Marco.paneles != null) {
                        JPanel[] panelesDelMarco = Marco.paneles;
                        for (JPanel marcos : panelesDelMarco) {
                            marcos.setVisible(false);
                        }
                    }

                }

                repaint();

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                panel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
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
        if (figuraActual instanceof FiguraRellenable) {
            ((FiguraRellenable) figuraActual).dibujarMarco(g);

        }

    }

    public Icon setIcono(String url) {
        ImageIcon icon = new ImageIcon(getClass().getResource(url));
        int ancho = 35;
        int alto = 35;
        ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        return icono;
    }
    public JPanel getBaraDeHerramientas() {
        return barraDeHerramientas;
    }

    public JPanel getSeleccionDeColores() {
        return seleccionDeColores;
    }

}
