
package figuras;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;


/*
public class octagono extends Figura {

    int x;
    int y;
    int anchura;
    int altura;
    
    protected Rectangle rectangulo;
    private Object poligono;
    private Object g;

    public octagono(Point ubicacion) {
        this.x = ubicacion.x;
        this.y = ubicacion.y;
        this.anchura = 1;
        this.altura = 1;
        rectangulo = new polygon(x, y, anchura, altura);
    }

    @Override
    public void dibujar(Graphics g) {
        int x = rectangulo.x;
        int y = rectangulo.y;
        int anchura = rectangulo.width;
        int altura = rectangulo.height;
        
        g.setColor(Color.GREEN);
        g.drawRect(x, y, anchura, altura);

        g.setColor(Color.RED);
        g.fillRect(x, y, anchura, altura);
    }

    @Override
    public void actualizar(Point puntoActual) {
        this.anchura = puntoActual.x - x;
        this.altura = puntoActual.y - y;
    }
    
    {
        Polygon poligono=new Polygon();
        
        poligono.addPoint(x, (int) (y - altura * 0.50));
        poligono.addPoint((int) (x + (anchura * 0.25)), y - altura);
        poligono.addPoint((int) (x + (anchura * 0.75)), y - altura);
        poligono.addPoint(x + anchura, (int) (y - altura * 0.50));
        poligono.addPoint(x + anchura, (int) (y + (altura * 0.50)));
        poligono.addPoint((int) (x + (anchura * 0.75)), y + altura);
        poligono.addPoint((int) (x + (anchura * 0.25)), y + altura);
        poligono.addPoint(x, (int) (y + (altura * 0.50)));

        
        
        
       g.setColor(Color.red);
       g.fillPolygon(poligono);
        
        
         
        
    }

    private static class polygon extends Rectangle {

        public polygon(int x, int y, int anchura, int altura) {
        }
    }
}
*/

public class octagono extends Rectangulo {

    public octagono(Point puntoActual ) {
        super(puntoActual);
    }
   

    @Override
    public void dibujar(Graphics g) {
        
        int x = rectangulo.x;
        int y = rectangulo.y;
        int anchura = rectangulo.width;
        int altura = rectangulo.height;
         
    Polygon poligono=new Polygon();
    
        poligono.addPoint(x, (int) (y - altura * 0.50));
        poligono.addPoint((int) (x + (anchura * 0.25)), y - altura);
        poligono.addPoint((int) (x + (anchura * 0.75)), y - altura);
        poligono.addPoint(x + anchura, (int) (y - altura * 0.50));
        poligono.addPoint(x + anchura, (int) (y + (altura * 0.50)));
        poligono.addPoint((int) (x + (anchura * 0.75)), y + altura);
        poligono.addPoint((int) (x + (anchura * 0.25)), y + altura);
        poligono.addPoint(x, (int) (y + (altura * 0.50)));
      
     g.setColor(Color.red);
    g.fillPolygon(poligono);
    }
        
    }
    