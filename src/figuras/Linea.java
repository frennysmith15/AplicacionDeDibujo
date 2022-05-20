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
public class Linea extends FiguraRellenable {
    Point puntoInicial;
    Point puntoFinal;

    public Linea( Point puntoInicial, Point puntoFinal ) {
        this.puntoInicial = puntoInicial;
        this.puntoFinal = puntoFinal;
    }

    public Linea( Point puntoInicial ) {
        this(puntoInicial, puntoInicial);
    }

    public void dibujar(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(puntoInicial.x, puntoInicial.y, puntoFinal.x, puntoFinal.y);
    }

    public void actualizar(Point puntoActual) {
        this.puntoFinal = puntoActual;
    }
}
