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
 * @author frenn
 */
public class Hexagono extends FiguraRellenable{
    
    int x;
    int y;
    int anchura;
    int altura;
    
    public Hexagono( Color colorDeFondo, Color colorDeContorno, Boolean relleno, Point puntoActual ) {
        super(colorDeFondo, colorDeContorno, relleno);
        this.x = puntoActual.x;
        this.y = puntoActual.y;
        this.anchura = 1;
        this.altura = 1;
    }

    @Override
    public void dibujar(Graphics g) {
        int x = this.anchura < 0 ? this.x + this.anchura : this.x;
        int y = this.altura < 0 ? this.y + this.altura : this.y;
        int anchura = Math.abs(this.anchura);
        int altura = Math.abs(this.altura);

        Point punto1 = new Point(x, (int) (y + altura * 0.30));
        Point punto2 = new Point((int) (x + (anchura * 0.50)), y);
        Point punto3 = new Point(x + anchura, (int) (y + altura * 0.30));
        Point punto4 = new Point(x + anchura, (int) (y + (altura * 0.70)));
        Point punto5 = new Point((int) (x + (anchura / 2)), y + altura);
        Point punto6 = new Point(x, (int) (y + (altura * 0.70)));
    
        if(relleno) {
            g.setColor(colorDeFondo);
            g.fillPolygon(new int[]{punto1.x, punto2.x, punto3.x, punto4.x, punto5.x, punto6.x}, new int[]{punto1.y, punto2.y, punto3.y, punto4.y, punto5.y, punto6.y}, 6);
        }
        
        g.setColor(colorDeContorno);
        g.drawPolygon(new int[]{punto1.x, punto2.x, punto3.x, punto4.x, punto5.x, punto6.x}, new int[]{punto1.y, punto2.y, punto3.y, punto4.y, punto5.y, punto6.y}, 6);
            
    }

    @Override
    public void actualizar(Point puntoActual) {
        this.anchura = puntoActual.x - x;
        this.altura = puntoActual.y - y;
    }
    
}
