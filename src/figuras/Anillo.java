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
 * @author JanCarlosDM
 */
public class Anillo extends FiguraRellenable {

    int x;
    int y;
    int anchura;
    int altura;

    public Anillo( Color colorDeFondo, Color colorDeContorno, Boolean relleno, Point puntoActual ) {
        super(colorDeFondo, colorDeContorno, relleno, puntoActual);
        this.x = puntoActual.x;
        this.y = puntoActual.y;
        this.anchura = 1;
        this.altura = 1;
    }

    public void actualizar(Point puntoActual) {
        this.anchura = puntoActual.x - x;
        this.altura = puntoActual.y - y;

        System.out.println(this.toString());
    }

    public void dibujar(Graphics g) {

        int x = 0, y = 0;
        if (this.anchura < 0) {
            x = this.x + anchura;
            y = this.y + altura;
        } else {
            x = this.x;
            y = this.y;
        }

        if(relleno) {
            g.setColor(colorDeFondo);
            g.fillOval(x, y, Math.abs(anchura), Math.abs(altura));
            g.setColor(Color.WHITE);
            if (anchura > 0 && altura > 0) {
                g.fillOval(x + anchura / 4, y + altura / 4, Math.abs(anchura / 2), Math.abs(altura / 2));
            } else if (anchura < 0 && altura > 0) {
                g.fillOval((int) (x - (anchura * 0.25)), y + altura / 4, Math.abs((int) (anchura * 0.50)), Math.abs(altura / 2));
            } else if (anchura > 0 && altura < 0) {
                g.fillOval((int) (x + (anchura * 0.25)), y - altura / 4, Math.abs((int) (anchura * 0.50)), Math.abs(altura / 2));
            } else if (anchura > 0 && altura < 0) {
                g.fillOval((int) (x + (anchura * 0.25)), y - altura / 4, Math.abs((int) (anchura * 0.50)), Math.abs(altura / 2));
            } else if (anchura < 0 && altura < 0) {
                g.fillOval((int) (x - (anchura * 0.25)), y - altura / 4, Math.abs((int) (anchura * 0.50)), Math.abs(altura / 2));
            }
        }

        g.setColor(colorDeContorno);
        g.drawOval(x, y, Math.abs(anchura), Math.abs(altura));
        if (anchura > 0 && altura > 0) {
            g.drawOval(x + anchura / 4, y + altura / 4, Math.abs(anchura / 2), Math.abs(altura / 2));
        } else if (anchura < 0 && altura > 0) {
            g.drawOval((int) (x - (anchura * 0.25)), y + altura / 4, Math.abs((int) (anchura * 0.50)), Math.abs(altura / 2));
        } else if (anchura > 0 && altura < 0) {
            g.drawOval((int) (x + (anchura * 0.25)), y - altura / 4, Math.abs((int) (anchura * 0.50)), Math.abs(altura / 2));
        } else if (anchura > 0 && altura < 0) {
            g.drawOval((int) (x + (anchura * 0.25)), y - altura / 4, Math.abs((int) (anchura * 0.50)), Math.abs(altura / 2));
        } else if (anchura < 0 && altura < 0) {
            g.drawOval((int) (x - (anchura * 0.25)), y - altura / 4, Math.abs((int) (anchura * 0.50)), Math.abs(altura / 2));
        }
        
        this.setContorno(new Rectangle(x, y, anchura, altura));
    }

    @Override
    public String toString() {
        return String.format("x: %d, y: %d, anchura: %d, altura: %d\n", x, y, anchura, altura);
    }
}
