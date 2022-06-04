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
public class Linea extends Figura {
    Point puntoInicial;
    Point puntoFinal;

    public Linea(Point puntoInicial, Point puntoFinal,Color colorDePrimerPlano) {
        super(colorDePrimerPlano, colorDePrimerPlano);
        this.puntoInicial = puntoInicial;
        this.puntoFinal = puntoFinal;
    }

    public Linea( Point puntoInicial , Color colorDePrimerPlano) {
        this( puntoInicial, puntoInicial,colorDePrimerPlano);
    }

    public void dibujar(Graphics g) {
       
            g.setColor(getColorDePrimerPlano());
            g.drawLine(puntoInicial.x, puntoInicial.y, puntoFinal.x, puntoFinal.y);
    }
        
    public void actualizar(Point puntoActual) {
        this.puntoFinal = puntoActual;
    }
}
