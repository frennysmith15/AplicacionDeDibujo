/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package figuras;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
/**
 *
 * @author frenn
 */
public class Octagono extends Rectangulo {

    public Octagono( Color colorDeFondo, Color colorDeContorno, Boolean relleno, Point puntoActual ) {
        super(colorDeFondo, colorDeContorno, relleno, puntoActual);
        this.x = puntoActual.x;
        this.y = puntoActual.y;
    }

    @Override
    public void dibujar(Graphics g) {

        int x = rectangulo.x;
        int y = rectangulo.y;
        int anchura = rectangulo.width;
        int altura = rectangulo.height;

        Polygon poligono = new Polygon();

        poligono.addPoint(x, (int) (y - altura * 0.50));
        poligono.addPoint((int) (x + (anchura * 0.25)), y - altura);
        poligono.addPoint((int) (x + (anchura * 0.75)), y - altura);
        poligono.addPoint(x + anchura, (int) (y - altura * 0.50));
        poligono.addPoint(x + anchura, (int) (y + (altura * 0.50)));
        poligono.addPoint((int) (x + (anchura * 0.75)), y + altura);
        poligono.addPoint((int) (x + (anchura * 0.25)), y + altura);
        poligono.addPoint(x, (int) (y + (altura * 0.50)));

        if(relleno) {
            g.setColor(colorDeFondo);
            g.fillPolygon(poligono);
        }
        
        g.setColor(colorDeContorno);
        g.drawPolygon(poligono);
        
        
        this.setContorno(new Rectangle(x, y - altura, anchura, altura*2));

    }

}
