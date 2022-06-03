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
public class MediaLuna extends Figura {
 Point puntoInicial;
    Point puntoFinal;
    int x;
    int y;
    int anchura;
    int altura;

    public MediaLuna( Point puntoInicial, Point puntoFinal) {
        this.puntoInicial = puntoInicial;
        this.puntoFinal = puntoFinal;
        this.x = puntoInicial.x;
        this.y = puntoInicial.y;
        this.anchura = 1;
        this.altura = 1;
    }

    public MediaLuna(Point puntoInicial) {
        this( puntoInicial, puntoInicial);
    }

    public void actualizar(Point puntoFinal) {
        this.puntoFinal = puntoFinal;
        this.anchura = puntoFinal.x - x;
        this.altura = puntoFinal.y - y;
    }

    public void dibujar(Graphics g) {
       
            g.setColor(Color.BLACK);
            g.drawArc(puntoInicial.x, (int) (puntoFinal.y * 0.99), anchura, (int) (altura * 0.76), -170, 160);
            g.setColor(Color.BLACK);
            g.drawArc(puntoInicial.x, puntoFinal.y, anchura, altura, -190, 200);
            
        
    }
}
