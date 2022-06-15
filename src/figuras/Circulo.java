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
 * @author Angel Fernandez
 */
public class Circulo extends Figura {

    int x;
    int y;
    int anchura;
    int altura;

    public Circulo(Point puntoInicial) {
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

        int x = (this.anchura < 0) ? this.x + anchura : this.x;
        int y = (this.altura < 0) ? this.y + altura : this.y;

        g.setColor(Color.RED);
        g.fillOval(x, y, Math.abs(anchura), Math.abs(altura));
        g.setColor(Color.GREEN);
        g.drawOval(x, y, Math.abs(anchura), Math.abs(altura));
    }

}
