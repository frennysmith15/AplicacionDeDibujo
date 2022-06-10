
package figuras;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
/**
 *
 * @author JAVIER
 */
public class TrevorDeCuatroHojas extends Figura{
    int x;
    int y;
    int anchura;
    int altura;
    protected Rectangle trevor;
    
  
    public TrevorDeCuatroHojas(Point ubicacion) {
        this.x = ubicacion.x;
        this.y = ubicacion.y;
        this.anchura = 1;
        this.altura = 1;
       
       trevor = new Rectangle(x, y, anchura, altura);
    }

    @Override
    public void dibujar(Graphics g) { 
        
        int x = trevor.x;
        int y = trevor.y;
        int anchura = trevor.width;
        int altura = trevor.height;


   g.setColor(Color.YELLOW);
   g.fillArc(x+20, y+anchura/4, anchura/2, altura/2, 0, 360);
   g.fillArc(x+anchura/2, y, anchura/2, altura/2, 0, 360);
   g.fillArc(x+anchura/2, y+anchura/2, anchura/2, altura/2, 0, 360);
   g.fillArc(x+anchura-20, y+anchura/4, anchura/2, altura/2, 0, 360);
   g.fillArc(x+anchura/2, y+anchura/4, anchura/2, altura/2, 0, 360);
   
//   g.setColor(Color.RED);
//   g.drawArc(x+20, y+anchura/4, anchura/2, altura/2, 0, 360);
//   g.drawArc(x+anchura/2, y, anchura/2, altura/2, 0, 360);
//   g.drawArc(x+anchura/2, y+anchura/2, anchura/2, altura/2, 0, 360);
//   g.drawArc(x+anchura-20, y+anchura/4, anchura/2, altura/2, 0, 360); 
//   g.drawArc(x+anchura/2, y+anchura/4, anchura/2, altura/2, 0, 360);
   

}
    @Override
    public void actualizar(Point puntoActual) {
        this.anchura = puntoActual.x - x;
        this.altura = puntoActual.y - y; 
        
        int x = anchura < 0 ? this.x + anchura : this.x;
        int y = altura < 0 ? this.y + altura : this.y;
        trevor = new Rectangle(Math.abs(x), Math.abs(y), Math.abs(anchura), Math.abs(altura));
        
    }
    
}
