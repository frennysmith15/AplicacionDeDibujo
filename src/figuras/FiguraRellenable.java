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
 * @author frenn
 */
public class FiguraRellenable extends Figura{
    
    protected Color colorDeFondo;
    protected Boolean relleno;

    public FiguraRellenable(Color colorDeFondo, Color colorDeContorno, Boolean relleno){
        super.colorDeContorno = colorDeContorno;
        this.colorDeFondo = colorDeFondo;
        this.relleno = relleno;
    }
    
    
    
    @Override
    public void dibujar(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizar(Point puntoActual) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
