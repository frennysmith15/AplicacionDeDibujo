/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package figuras;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author yordn
 */
public class DibujoLibre extends Figura {

    ArrayList<Point> puntos;
    boolean terminado;

    public DibujoLibre(Point puntoActual, Color colorDeContorno) {
        puntos = new ArrayList<>();
        puntos.add(puntoActual);
        terminado = false;
        this.colorDeContorno = colorDeContorno;
    }

    public DibujoLibre(Point puntoActual) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public DibujoLibre(Color colorDeContorno, Point puntoActual) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void dibujar(Graphics g) {

        for (int i = 1; i < puntos.size(); i++) {
            g.setColor(colorDeContorno);
            g.drawLine(puntos.get(i - 1).x, puntos.get(i - 1).y, puntos.get(i).x, puntos.get(i).y);
        }
    }

    @Override
    public void actualizar(Point puntoActual) {
        puntos.add(puntoActual);
    }

    public boolean estaTerminado() {
        return terminado;
    }

    public void terminar() {
        terminado = true;
    }
}

