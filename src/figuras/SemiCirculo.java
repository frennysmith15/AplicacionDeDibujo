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
    }
 
    public void dibujar(Graphics g) {
        if (puntoInicial != null && puntoFinal != null) {

        if (relleno) {
            g.setColor(colorDeFondo);
            g.fillArc(x, y, anchura, puntoFinal.y, 0, 180);
        }
        g.setColor(colorDeContorno);
        g.drawLine(puntoInicial.x, ((int) (puntoFinal.y * 0.50) + y), puntoFinal.x, ((int) (puntoFinal.y * 0.50) + y));
        g.drawArc(x, Math.abs(y), anchura, Math.abs(puntoFinal.y), 0, 180);

        this.setContorno(new Rectangle(x, y, anchura, altura));

        }

    }
}
