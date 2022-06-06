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
 * @author josearielpereyra
 */
public class Rectangulo extends FiguraRellenable {

    int x;
    int y;
    int anchura;
    int altura;
    
    protected Rectangle rectangulo;

    public Rectangulo( Color colorDeFondo, Color colorDeContorno, Boolean relleno, Point puntoActual ) {
        super(colorDeFondo, colorDeContorno, relleno);
        this.x = puntoActual.x;
        this.y = puntoActual.y;
        this.anchura = 1;
        this.altura = 1;
        rectangulo = new Rectangle(x, y, anchura, altura);
    }

    public void dibujar(Graphics g) {
        int x = rectangulo.x;
        int y = rectangulo.y;
        int anchura = rectangulo.width;
        int altura = rectangulo.height;

        if(relleno) {
            g.setColor(colorDeFondo);
            g.fillRect(x, y, anchura, altura);
        }
        
        g.setColor(colorDeContorno);
        g.drawRect(x, y, anchura, altura);

        
    }

    public void actualizar(Point puntoActual) {
        this.anchura = puntoActual.x - x;
        this.altura = puntoActual.y - y;
        
        int x = anchura < 0 ? this.x + anchura : this.x;
        int y = altura < 0 ? this.y + altura : this.y;
        rectangulo = new Rectangle(x, y, Math.abs(anchura), Math.abs(altura));

        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return String.format("x: %d, y: %d, anchura: %d, altura: %d\n", x, y, anchura, altura);
    }
}
