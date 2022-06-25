/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package figuras;

import java.awt.*;

/**
 *
 * @author josearielpereyra
 */
public class Linea extends Figura{
    Point puntoInicial;
    Point puntoFinal;

    public Linea( Point puntoInicial, Point puntoFinal, Color colorDeContorno ) {

        this.puntoInicial = puntoInicial;
        this.puntoFinal = puntoFinal;
    }


    public Linea( Point puntoInicial, Color colorDeContorno) {
        this(puntoInicial, puntoInicial, colorDeContorno);
    }

    public void dibujar(Graphics g) {
        g.setColor(colorDeContorno);
        g.drawLine(puntoInicial.x, puntoInicial.y, puntoFinal.x, puntoFinal.y);
    }
        
    public void actualizar(Point puntoActual) {
        this.puntoFinal = puntoActual;
    }
}
