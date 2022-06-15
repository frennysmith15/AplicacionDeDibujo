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
public class Elipse extends Figura {

    int x;
    int y;
    int anchura;
    int altura;

    public Elipse(Color color, Color color2, Boolean relleno, Point ubicacion) {
        //super(color, color2, relleno);
        this.x = ubicacion.x;
        this.y = ubicacion.y;
        this.anchura = 1;
        this.altura = 1;

    }

    public Elipse(Boolean relleno, Point ubicacion) {

        this.x = ubicacion.x;
        this.y = ubicacion.y;
        this.anchura = 1;
        this.altura = 1;

    }

    public Elipse(Point ubicacion) {
        this.x = ubicacion.x;
        this.y = ubicacion.y;
        this.anchura = 1;
        this.altura = 1;

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

        g.setColor(Color.GREEN);
        g.drawOval(x, y, Math.abs(anchura / 6), (int) Math.abs(altura / 0.9));

        g.setColor(Color.RED);
        g.fillOval(x, y, Math.abs(anchura / 6), (int) Math.abs(altura / 0.9));
    }

    public void actualizar(Point puntoActual) {
        this.anchura = puntoActual.x - x;
        this.altura = puntoActual.y - y;

        System.out.println(this.toString());

    }

    @Override
    public String toString() {
        return String.format("x: %d, y: %d, anchura: %d, altura: %d\n", x, y, anchura, altura);
    }

}
