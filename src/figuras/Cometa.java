
package figuras;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;


public class Cometa extends Rectangulo {

    public Cometa(Point puntoActual ) {
        super(puntoActual);
    }
   

    @Override
    public void dibujar(Graphics g) {
        
        int x = rectangulo.x;
        int y = rectangulo.y;
        int anchura = rectangulo.width;
        int altura = rectangulo.height;
         
    Polygon poligono=new Polygon();
    
     poligono.addPoint(x, (int) (y - altura * 0.35));
     poligono.addPoint((int) (x + (anchura / 2)), (int) (y - altura));
     
     poligono.addPoint(x + anchura, (int) (y - altura * 0.35));
     poligono.addPoint((int) (x + (anchura / 2)), (int) (y + altura));
      
     g.setColor(Color.red);
    g.fillPolygon(poligono);
    }
        
    }
    