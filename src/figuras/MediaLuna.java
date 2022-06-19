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
public class MediaLuna extends FiguraRellenable {

    Point puntoInicial;
    Point puntoFinal;
    int x;
    int y;
    int anchura;
    int altura;

    public MediaLuna(Color colorDeFondo, Color colorDeContorno, Boolean relleno, Point puntoActual) {
        super(colorDeFondo, colorDeContorno, relleno, puntoActual);
        this.x = puntoActual.x;
        this.y = puntoActual.y;
        this.puntoInicial = puntoActual;
        this.puntoFinal = puntoActual;
        this.anchura = 1;
        this.altura = 1;
    }

    public void actualizar(Point puntoFinal) {
        this.anchura = puntoFinal.x - x;
        this.altura = puntoFinal.y - y;
    }

    public void dibujar(Graphics g) {
        if (puntoInicial != null && puntoFinal != null) {
        }
        
        g.setColor(colorDeContorno);
        g.drawArc(puntoInicial.x, (int) (puntoFinal.y * 0.99), anchura, (int) (altura * 0.8), -170, 160);
        g.drawArc(puntoInicial.x, puntoFinal.y, anchura, altura, -190, 200);
        
        this.setContorno(new Rectangle(puntoInicial.x, puntoFinal.y, anchura, altura));

    }
}
