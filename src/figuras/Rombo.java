package figuras;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.*;

/**
 * @author gmartinez
 */
public class Rombo extends Figura {
    int anchura;
    int altura;
    boolean terminado;
    int x, y;
    public int[] coordenadasRomboX;
    public int[] coordenadasRomboY;

    public Rombo(Point puntoActual) {
        this.x = puntoActual.x;
        this.y = puntoActual.y;
        this.anchura = 1;
        this.altura = 1;
        terminado = false;
    }

    @Override
    public void dibujar(Graphics g) {
        int x = this.anchura < 0 ? this.x + this.anchura : this.x;
        int y = this.altura < 0 ? this.y + this.altura : this.y;
        int anchura = Math.abs(this.anchura);
        int altura = Math.abs(this.altura);

        Point punto1 = new Point(x, y + altura / 2);
        Point punto2 = new Point(x + anchura / 2, y);
        Point punto3 = new Point(x + anchura, y + altura / 2);
        Point punto4 = new Point(x + anchura / 2, y + altura);

 
        coordenadasRomboX = new int[]{punto1.x, punto2.x, punto3.x, punto4.x};
        coordenadasRomboY = new int[]{punto1.y, punto2.y, punto3.y, punto4.y};

        g.setColor(Color.GREEN);
        g.drawPolygon(new int[]{punto1.x, punto2.x, punto3.x, punto4.x},
                new int[]{punto1.y, punto2.y, punto3.y, punto4.y}, 4);

        g.setColor(Color.red);
        g.fillPolygon(new int[]{punto1.x, punto2.x, punto3.x, punto4.x},
                new int[]{punto1.y, punto2.y, punto3.y, punto4.y}, 4);

    }

    @Override
    public void actualizar(Point puntoActual) {
        this.anchura = puntoActual.x - x;
        this.altura = puntoActual.y - y;
    }

    public boolean estaTerminado() {

        return terminado;
    }

    public void terminar() {
        terminado = true;
    }
}
    