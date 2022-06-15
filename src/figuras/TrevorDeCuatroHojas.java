package figuras;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author JAVIER
 */
public class TrevorDeCuatroHojas extends FiguraRellenable {

    int x;
    int y;
    int anchura;
    int altura;
    protected Rectangle trevor;

    public TrevorDeCuatroHojas(Color colorDeFondo, Color colorDeContorno, Boolean relleno, Point puntoActual) {
        super(colorDeFondo, colorDeContorno, relleno, puntoActual);
        this.x = puntoActual.x;
        this.y = puntoActual.y;
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

        if(relleno) {
            g.setColor(colorDeFondo);
            g.fillArc(x + 20, y + anchura / 4, anchura / 2, altura / 2, 0, 360);
            g.fillArc(x + anchura / 2, y, anchura / 2, altura / 2, 0, 360);
            g.fillArc(x + anchura / 2, y + anchura / 2, anchura / 2, altura / 2, 0, 360);
            g.fillArc(x + anchura - 20, y + anchura / 4, anchura / 2, altura / 2, 0, 360);
            g.fillArc(x + anchura / 2, y + anchura / 4, anchura / 2, altura / 2, 0, 360);
        }
            
        g.setColor(colorDeContorno);
        g.drawArc(x + 20, y + anchura / 4, anchura / 2, altura / 2, 0, 360);
        g.drawArc(x + anchura / 2, y, anchura / 2, altura / 2, 0, 360);
        g.drawArc(x + anchura / 2, y + anchura / 2, anchura / 2, altura / 2, 0, 360);
        g.drawArc(x + anchura - 20, y + anchura / 4, anchura / 2, altura / 2, 0, 360);
        g.drawArc(x + anchura / 2, y + anchura / 4, anchura / 2, altura / 2, 0, 360);
        
        this.setContorno(new Rectangle(x, y, (int) (anchura * 1.50), altura));
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
