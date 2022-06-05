/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package figuras;

import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author frenn
 */
public class TrianguloRectangulo extends Figura{
    int x;
    int y;
    int anchura;
    int altura;

    public TrianguloRectangulo(Point ubicacion) {
        this.x = ubicacion.x;
        this.y = ubicacion.y;
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

        Point punto1 = new Point(x, y + altura);
        Point punto2 = new Point(x, y);
        Point punto3 = new Point(x + anchura, y + altura);

        g.drawPolygon(new int[]{punto1.x, punto2.x, punto3.x}, new int[]{punto1.y, punto2.y, punto3.y}, 3);
    }
}
