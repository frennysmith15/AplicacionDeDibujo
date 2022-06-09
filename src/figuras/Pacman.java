/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuras;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Arc2D;
/**
 *
 * @author JAVIER
 */
public class Pacman extends FiguraRellenable{
    int x;
    int y;
    int anchura;
    int altura;
    
    
    protected Rectangle pacman;
  
    public Pacman( Color colorDeFondo, Color colorDeContorno, Boolean relleno, Point puntoActual ) {
        super(colorDeFondo, colorDeContorno, relleno);
        this.x = puntoActual.x;
        this.y = puntoActual.y;
        this.anchura = 1;
        this.altura = 1;
        
       pacman = new Rectangle(x, y, anchura, altura);
    }

    @Override
    public void dibujar(Graphics g) {
        
        int x = pacman.x;
        int y = pacman.y;
        int anchura = pacman.width;
        int altura = pacman.height;
       
        if(relleno) {
            g.setColor(colorDeFondo);
            g.fillArc(x, y, anchura, altura, 30, 305);
        }
        
        g.setColor(colorDeContorno);
        Graphics2D g2d=(Graphics2D)g;
        g2d.draw(new Arc2D.Double(x, y, anchura, altura, 30, 305, Arc2D.PIE));
        
        this.setContorno(new Rectangle(x, y, anchura, altura));
        super.dibujar(g);
    }

    @Override
    public void actualizar(Point puntoActual) {
        this.anchura = puntoActual.x - x;
        this.altura = puntoActual.y - y; 
        
        int x = anchura < 0 ? this.x + anchura : this.x;
        int y = altura < 0 ? this.y + altura : this.y;
        pacman = new Rectangle(x, y, Math.abs(anchura), Math.abs(altura));
    }
    
}