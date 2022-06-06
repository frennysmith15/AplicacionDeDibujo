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
public class Triangulo extends FiguraRellenable{
    
    int x;
    int y;
    int anchura;
    int altura;

    public Triangulo( Color colorDeFondo, Color colorDeContorno, Boolean relleno, Point puntoActual ) {
        super(colorDeFondo, colorDeContorno, relleno);
        this.x = puntoActual.x;
        this.y = puntoActual.y;
        this.anchura = 1;
        this.altura = 1;
        
    }
   

    @Override
    public void dibujar(Graphics g) {
        
       int[] coordenadasX = {x, x + anchura/2, x + anchura};
       int[] coordenadasY = {y + altura, y, y + altura};
       
        if(relleno) {
            g.setColor(colorDeFondo);
            g.fillPolygon(coordenadasX, coordenadasY, 3);
        }
        
        g.setColor(colorDeContorno);
        g.drawPolygon(coordenadasX, coordenadasY, 3);

        
    }
    
    @Override
    public void actualizar(Point puntoActual) {
        this.anchura = puntoActual.x - x;
        this.altura = puntoActual.y - y;
        
        int x = anchura < 0 ? this.x + anchura : this.x;
        int y = altura < 0 ? this.y + altura : this.y;

    }
    
}
