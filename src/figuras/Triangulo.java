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
public abstract class Triangulo extends Rectangulo{

    public Triangulo(Point puntoActual ) {
        super(puntoActual);
    }
   

    @Override
    public void dibujar(Graphics g) {
        int x = rectangulo.x;
        int y = rectangulo.y;
        int anchura = rectangulo.width;
        int altura = rectangulo.height;
        
       int[] coordenadasX = {x, x + anchura/2, x + anchura};
       int[] coordenadasY = {y + altura, y, y + altura};
       
        
        g.setColor(Color.GREEN);
        g.drawPolygon(coordenadasX, coordenadasY, 3);

        g.setColor(Color.RED);
        g.drawPolygon(coordenadasX, coordenadasY, 3);
        
        this.setContorno(new Rectangle(x, y, anchura, altura));
        super.dibujar(g);
    }
    
}
