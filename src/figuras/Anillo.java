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
 * @author JanCarlosDM
 */
public class Anillo extends Figura {

    int x;
    int y;
    int anchura;
    int altura;

    public Anillo(Point puntoInicial) {
        this.x = puntoInicial.x;
        this.y = puntoInicial.y;
        this.anchura = 1;
        this.altura = 1;
    }

    public Anillo(Color colorDeFondo, Color colorDeContorno, Boolean TRUE, Point puntoActual) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

        g.setColor(Color.RED);
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

        g.setColor(Color.BLUE);
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

    }

    @Override
    public String toString() {
        return String.format("x: %d, y: %d, anchura: %d, altura: %d\n", x, y, anchura, altura);
    }
}
