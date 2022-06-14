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
 * @author yordn
 */
public class SemiCirculo extends Figura {

    Point puntoInicial;
    Point puntoFinal;
    int x;
    int y;
    int anchura;
    int altura;

    public SemiCirculo(Point puntoActual) {
        this.puntoInicial = puntoActual;
        this.x = puntoInicial.x;
        this.y = puntoInicial.y;
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
        if (puntoInicial != null && puntoFinal != null) {

            g.setColor(Color.RED);
            g.fillArc(x,y, anchuras, alturas, 0, +180);
            g.setColor(Color.GREEN);
            g.drawArc(x,y, anchuras, alturas, 0, +180);
            //g.drawLine(puntoInicial.x, ((int) (puntoFinal.y * 0.50) + y), puntoFinal.x, ((int) (puntoFinal.y * 0.50) + y));
            

        }
    }
}
