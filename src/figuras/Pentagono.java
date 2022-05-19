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
public class Pentagono extends Figura{
    
    int x;
    int y;
    int anchura;
    int altura;
    Marco marco;
    
    public Pentagono(Point ubicacion) {
        this.x = ubicacion.x;
        this.y = ubicacion.y;
        this.anchura = 1;
        this.altura = 1;
    }

    @Override
    public void dibujar(Graphics g) {
        int x = this.anchura < 0 ? this.x + this.anchura : this.x;
        int y = this.altura < 0 ? this.y + this.altura : this.y;
        int anchura = Math.abs(this.anchura);
        int altura = Math.abs(this.altura);

        Point punto1 = new Point(x, y + altura / 2);
        Point punto2 = new Point(x + anchura / 2, y);
        Point punto3 = new Point(x + anchura, y + altura / 2);
        Point punto4 = new Point((int) (x + anchura * 0.8), y + altura);
        Point punto5 = new Point((int) (x + anchura * 0.2), y + altura);

        g.drawPolygon(new int[]{punto1.x, punto2.x, punto3.x, punto4.x, punto5.x}, new int[]{punto1.y, punto2.y, punto3.y, punto4.y, punto5.y}, 5);

    }

    @Override
    public void actualizar(Point puntoActual) {
        this.anchura = puntoActual.x - x;
        this.altura = puntoActual.y - y;
    }
}
