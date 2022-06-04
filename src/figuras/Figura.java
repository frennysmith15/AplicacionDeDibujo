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
 * @author josearielpereyra
 */
public abstract class Figura {

    //public static Marco marco;

    public abstract void dibujar(Graphics g);

    public abstract void actualizar(Point puntoActual);

    //color actracto 
    private Color colorDePrimerPlano;
    private Color colorDeSegundoPlano;

    public Figura(Color colorDePrimerPlano, Color colorDeSegundoPlano) {
        this.colorDePrimerPlano = colorDePrimerPlano;
        this.colorDeSegundoPlano = colorDeSegundoPlano;
    }

    public Color getColorDePrimerPlano() {
        return colorDePrimerPlano;
    }

    public Color getColorDeSegundoPlano() {
        return colorDeSegundoPlano;
    }

    public void setColorDePrimerPlano(Color colorDePrimerPlano) {
        this.colorDePrimerPlano = colorDePrimerPlano;
    }

    public void setColorDeSegundoPlano(Color colorDeSegundoPlano) {
        this.colorDeSegundoPlano = colorDeSegundoPlano;
    }

}
