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
 * @author Luyggens
 */
public class Estrella extends Rectangulo{
  
  public Estrella (Point puntoActual ) {
        super(puntoActual);
    }
  
  @Override
    public void dibujar(Graphics g) {

      int x = rectangulo.x;
      int y = rectangulo.y;
      int alturaEstrella = rectangulo.height;
      int anchuraEstrella = rectangulo.width;
      int[] estrellaX = {x + anchuraEstrella*100/200,x+anchuraEstrella*3/8 ,x,x+anchuraEstrella*100/300,x+anchuraEstrella*3/13,x + anchuraEstrella*100/200,x + anchuraEstrella*100/130,x + anchuraEstrella*100/150,x + anchuraEstrella,x + anchuraEstrella*100/160};
      int[] estrellaY = {y, y+alturaEstrella*100/250 ,y+alturaEstrella*100/250,y+alturaEstrella*100/170,y+alturaEstrella,y+alturaEstrella*100/150,y+alturaEstrella,y+alturaEstrella*100/170,y+alturaEstrella*100/250,y+alturaEstrella*100/250};
      
      
      g.setColor(Color.GREEN);
      g.drawPolygon(estrellaX, estrellaY, estrellaX.length);

      g.setColor(Color.RED);
      g.fillPolygon(estrellaX, estrellaY, estrellaX.length);
    }
}
