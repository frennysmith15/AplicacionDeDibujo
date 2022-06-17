
package figuras;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author gmartinez
 */
public class Corazon extends Figura {
 
    int x;
    int y;
    int anchura;
    int altura;
    protected Rectangle corazon;
    
public Corazon(Point ubicacion) {
        this.x = ubicacion.x;
        this.y = ubicacion.y;
        this.anchura = 1;
        this.altura = 1;
        
        corazon = new Rectangle(x, y, anchura, altura);
    }
    @Override
    public void dibujar(Graphics g) {
      int x = corazon.x;
        int y = corazon.y;
        int anchura = corazon.width;
        int altura = corazon.height;

        //Puntos de las lineas
        Point punto1 = new Point((int) (x + anchura / 6.64516129), y + (int) (altura / 1.9047619));
        Point punto2 = new Point(x + anchura / 2, y + altura);
        Point punto3 = new Point((int) (x + anchura - anchura / 6.64516129), y + (int) (altura / 1.9047619));
        Point punto4 = new Point(x + anchura / 2, y + altura);
        Point punto5 = new Point((int) (x + anchura / 2), (int) (y + altura * 0.18));
   
        g.setColor(Color.RED);
        g.fillPolygon(new int[]{punto1.x, punto2.x, punto3.x, punto3.x, punto5.x}, new int[]{punto1.y, punto2.y, punto3.y, punto3.y, punto5.y}, 5);
        g.fillArc(x + anchura / 12, y + altura / 10, anchura / 2, altura / 2, 45, 180);
        g.fillArc(x - anchura / 12 + anchura / 2, y + altura / 10, anchura / 2, altura / 2, -45, 180);
        g.fillArc(x+anchura-20, y+anchura/4, anchura/2, altura/-2, 0, 180);
        g.fillArc(x+anchura/2, y+anchura/4, anchura/2, altura/-5, 0, 180);
   
        //Arcos  
        g.drawArc(x + anchura / 12, y + altura / 10, anchura / 2, altura / 2, 45, 180);
        g.drawArc(x - anchura / 12 + anchura / 2, y + altura / 10, anchura / 2, altura / 2, -45, 180);
        
    }

    @Override
    public void actualizar(Point puntoActual) {
        this.anchura = puntoActual.x - x;
        this.altura = puntoActual.y - y; 

        int x = anchura < 0 ? this.x + anchura : this.x;
        int y = altura < 0 ? this.y + altura : this.y;
        corazon = new Rectangle(Math.abs(x), Math.abs(y), Math.abs(anchura), Math.abs(altura));

    }
}
