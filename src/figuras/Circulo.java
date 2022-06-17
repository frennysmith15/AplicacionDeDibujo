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
 * @author Angel Fernandez
 */
public class Circulo extends FiguraRellenable {

    int x;
    int y;
    int anchura;
    int altura;

    public Circulo(Color colorDeFondo, Color colorDeContorno, Boolean relleno, Point puntoActual) {
        super(colorDeFondo, colorDeContorno, relleno, puntoActual);
        this.x = puntoActual.x;
        this.y = puntoActual.y;
        this.anchura = 1;
        this.altura = 1;
    }

    public void actualizar(Point puntoActual) {
        this.anchura = puntoActual.x - x;
        this.altura = puntoActual.y - y;
    }

    public void dibujar(Graphics g) {

        int x = (this.anchura < 0) ? this.x + anchura : this.x;
        int y = (this.altura < 0) ? this.y + altura : this.y;

        if (relleno) {
            g.setColor(colorDeFondo);
            g.fillOval(x, y, Math.abs(anchura), Math.abs(altura));
        }
        g.setColor(colorDeContorno);
        g.drawOval(x, y, Math.abs(anchura), Math.abs(altura));
        
        
        this.setContorno(new Rectangle(x, y, anchura, altura));
    }

}
