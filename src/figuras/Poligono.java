/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package figuras;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author josearielpereyra
 */
public class Poligono extends FiguraRellenable{
    ArrayList<Point> puntos;
    boolean terminado;

    public Poligono( Color colorDeFondo, Color colorDeContorno, Boolean relleno, Point puntoActual ) {
        super(colorDeFondo, colorDeContorno, relleno, puntoActual);
        puntos = new ArrayList<>();
        puntos.add(puntoActual);
        terminado = false;
    }
    @Override
    public void dibujar(Graphics g) {
        int totalDePuntos = puntos.size();
        int[] coordenadasX = new int[totalDePuntos];
        int[] coordenadasY = new int[totalDePuntos];
        
        for (int i = 0; i < totalDePuntos; i++) {
            Point punto = puntos.get(i);
            coordenadasX[i] = punto.x;
            coordenadasY[i] = punto.y;
        }
        
        g.setColor(colorDeFondo);
        g.drawPolygon(coordenadasX, coordenadasY, totalDePuntos);
    }

    @Override
    public void actualizar(Point puntoActual) {
        puntos.add( puntoActual );
    }
    
    public boolean estaTerminado() {
        return terminado;
    }
    
    public void terminar() {
        terminado = true;
    }
    
}
