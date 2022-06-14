/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package figuras;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author frenn
 */
public class Escaleno extends FiguraRellenable{
    int x;
    int y;
    int altura;
    int anchura;
    
    public Escaleno( Color colorDeFondo, Color colorDeContorno, Boolean relleno, Point puntoActual ) {
        super(colorDeFondo, colorDeContorno, relleno, puntoActual);
        this.x = puntoActual.x;
        this.y = puntoActual.y;
        anchura = 1;
        altura = 1;
    }
        
    
    @Override
    public void dibujar(Graphics g) {
        int x = this.anchura < 0 ? this.x + this.anchura : this.x;
        int y = this.altura < 0 ? this.y + this.altura : this.y;
        int anchura = Math.abs(this.anchura);
        int altura = Math.abs(this.altura);

        Point punto1 = new Point((int) (x + anchura * 0.30), y + altura);
        Point punto2 = new Point(x, y);
        Point punto3 = new Point(x + anchura, y + altura);
        
        if(relleno) {
            g.setColor(colorDeFondo);
            g.fillPolygon(new int[]{punto1.x, punto2.x, punto3.x}, new int[]{punto1.y, punto2.y, punto3.y}, 3);
        }
        
        g.setColor(colorDeContorno);
        g.drawPolygon(new int[]{punto1.x, punto2.x, punto3.x}, new int[]{punto1.y, punto2.y, punto3.y}, 3);
        
        this.setContorno(new Rectangle(x, y, anchura, altura));
    }

    @Override
    public void actualizar(Point puntoActual) {
        this.anchura = puntoActual.x - x;
        this.altura = puntoActual.y - y;
    }
    
}
