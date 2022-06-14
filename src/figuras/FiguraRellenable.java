/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package figuras;

import aplicaciondedibujo.PanelDeDibujo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author frenn
 */
public abstract class FiguraRellenable extends Figura{
    protected Rectangle contorno;
    protected Color colorDeFondo;
    protected Boolean relleno;
    protected Point puntoActual;
    
    public FiguraRellenable(Color colorDeFondo, Color colorDeContorno, Boolean relleno, Point puntoActual){
        super.colorDeContorno = colorDeContorno;
        this.colorDeFondo = colorDeFondo;
        this.relleno = relleno;
        this.puntoActual = puntoActual;
    }
    
    public Rectangle getContorno() {
        return contorno;
    }
    
    public void setContorno(Rectangle contorno) {
        this.contorno = contorno;
    }
    
    public void dibujarMarco(Graphics g) {
        Marco marco = Marco.obtenerInstancia(PanelDeDibujo.panel, puntoActual, getContorno());       
        marco.dibujar(g);
    }
}
