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
 * @author Luyggens
 */
public class Estrella extends FiguraRellenable{
    int x;
    int y;
    int anchura;
    int altura;
  
  public Estrella ( Color colorDeFondo, Color colorDeContorno, Boolean relleno, Point puntoActual ) {
        super(colorDeFondo, colorDeContorno, relleno);
        this.x = puntoActual.x;
        this.y = puntoActual.y;
        this.anchura = 1;
        this.altura = 1;
    }
  
  @Override
    public void dibujar(Graphics g) {

      int[] estrellaX = {x + anchura*100/200,x+anchura*3/8 ,x,x+anchura*100/300,x+anchura*3/13,x + anchura*100/200,x + anchura*100/130,x + anchura*100/150,x + anchura,x + anchura*100/160};
      int[] estrellaY = {y, y+altura*100/250 ,y+altura*100/250,y+altura*100/170,y+altura,y+altura*100/150,y+altura,y+altura*100/170,y+altura*100/250,y+altura*100/250};
      
      
      g.setColor(colorDeContorno);
      g.drawPolygon(estrellaX, estrellaY, estrellaX.length);

        if(relleno) {
            g.setColor(colorDeFondo);
            g.fillPolygon(estrellaX, estrellaY, estrellaX.length);
        }
        this.setContorno(new Rectangle(x, y, anchura, altura));
        super.dibujar(g);
    }

    @Override
    public void actualizar(Point puntoActual) {
        this.anchura = puntoActual.x - x;
        this.altura = puntoActual.y - y;
    }
}
