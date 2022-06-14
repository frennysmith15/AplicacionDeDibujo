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
 * @author yordn
 */
public class SemiCirculo extends FiguraRellenable {

    Point puntoInicial;
    Point puntoFinal;
    int x;
    int y;
    int anchura;
    int altura;

    public SemiCirculo(Color colorDeFondo, Color colorDeContorno, Boolean relleno, Point puntoActual) {
        super(colorDeFondo, colorDeContorno, relleno, puntoActual);
        this.x = puntoActual.x;
        this.y = puntoActual.y;
        this.puntoInicial = puntoActual;
        this.anchura = 1;
        this.altura = 1;
    }

    public void actualizar(Point puntoFinal) {
        this.puntoFinal = puntoFinal;
        this.anchura = puntoFinal.x - x;
        this.altura = puntoFinal.y - y;
        this.anchura = puntoFinal.x - x;
        this.altura = puntoFinal.y - y;
    }

    @Override
    public void dibujar(Graphics g) {
        int anchuras = Math.abs(this.anchura);
        int alturas = Math.abs(this.altura);
        int x = anchura < 0 ? this.x + anchura : this.x;
        int y = altura < 0 ? this.y + altura : this.y;

        if (relleno) {
            g.setColor(colorDeFondo);
            g.fillArc(x, y, anchuras, alturas, 0, +180);
        }
        g.setColor(colorDeContorno);
        g.drawArc(x, y, anchuras, alturas, 0, +180);

        this.setContorno(new Rectangle(x, y, anchura, altura));

    }
}
