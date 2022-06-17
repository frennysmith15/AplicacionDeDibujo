/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package figuras;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author tlr16
 */
public class Trapecio extends Figura {

    Point puntoInicial;
    Point puntoFinal;
    int x;
    int y;
    int anchura;
    int altura;

    public Trapecio(Point puntoActual) {
        this.puntoInicial = puntoActual;
        this.x = puntoInicial.x;
        this.y = puntoInicial.y;
        this.anchura = 1;
        this.altura = 1;
    }

    public void actualizar(Point puntoActual) {
        this.anchura = puntoActual.x - x;
        this.altura = puntoActual.y - y;
    }

    public void dibujar(Graphics g) {
        int x = this.anchura < 0 ? this.x + this.anchura : this.x;
        int y = this.altura < 0 ? this.y + this.altura : this.y;
        int anchura = Math.abs(this.anchura);
        int altura = Math.abs(this.altura);

        Point punto1 = new Point(x, y);
        Point punto2 = new Point((int) (x - (anchura * 0.40)), y + altura);
        Point punto3 = new Point(x + anchura, y + altura);
        Point punto4 = new Point((int) (x + anchura - (anchura * 0.40)), y);

        g.setColor(Color.RED);
        g.fillPolygon(new int[]{punto1.x, punto2.x, punto3.x, punto4.x}, new int[]{punto1.y, punto2.y, punto3.y, punto4.y}, 4);
        g.setColor(Color.GREEN);
        g.drawPolygon(new int[]{punto1.x, punto2.x, punto3.x, punto4.x}, new int[]{punto1.y, punto2.y, punto3.y, punto4.y}, 4);
      }
    }    
