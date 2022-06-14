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
 * @author frenn
 */
public class Borrador extends Figura{
    
    ArrayList<Point> puntos;
    int x;
    int y; 
    int altura;
    int anchura;

    public Borrador(Point ubicacion) {
        
        puntos = new ArrayList();
        this.x = ubicacion.x;
        this.y = ubicacion.y;
        puntos.add(ubicacion);
    }
    
    @Override
    public void dibujar(Graphics g) {

        g.setColor(Color.WHITE);
        int anchura = 20;
        
        if (!puntos.isEmpty()) {
            if (puntos.size() == 1) {
                g.fillRect(puntos.get(0).x - anchura / 2, puntos.get(0).y - anchura / 2, anchura, anchura);
            } else {
                for (int i = 1; i < puntos.size(); i++) {
                    Point punto1 = new Point(puntos.get(i - 1).x - anchura / 2, puntos.get(i - 1).y - anchura / 2);
                    Point punto2 = new Point(puntos.get(i).x - anchura / 2, puntos.get(i).y - anchura / 2);
                    Point punto3 = new Point(punto2.x + anchura, punto2.y + anchura);
                    Point punto4 = new Point(punto1.x + anchura, punto1.y + anchura);
                    Point punto5 = new Point(punto1.x, punto1.y + anchura);
                    Point punto6 = new Point(punto2.x, punto2.y + anchura);
                    Point punto7 = new Point(punto2.x + anchura, punto2.y);
                    Point punto8 = new Point(punto1.x + anchura, punto1.y);

                    g.fillRect(punto1.x, punto1.y, anchura, anchura);
                    int[] puntosX = {punto1.x, punto2.x, punto3.x, punto4.x};
                    int[] puntosY = {punto1.y, punto2.y, punto3.y, punto4.y};
                    g.fillPolygon(puntosX, puntosY, 4);

                    puntosX = new int[]{punto5.x, punto6.x, punto7.x, punto8.x};
                    puntosY = new int[]{punto5.y, punto6.y, punto7.y, punto8.y};
                    g.fillPolygon(puntosX, puntosY, 4);

                    g.fillRect(punto2.x, punto2.y, anchura, anchura);
                }
            }
        }
    }

    @Override
    public void actualizar(Point puntoActual) {
        puntos.add(puntoActual);
    }
    
           
}
