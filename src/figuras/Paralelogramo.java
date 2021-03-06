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
 * @author Studio
 */
public class Paralelogramo extends FiguraRellenable {

    int x;
    int y;
    int anchura;
    int altura;
    boolean terminado;
    int[] coordenadasParalelogramoX;
    int[] coordenadasParalelogramoY;

    public Paralelogramo( Color colorDeFondo, Color colorDeContorno, Boolean relleno, Point puntoActual ) {
        super(colorDeFondo, colorDeContorno, relleno, puntoActual);
        this.x = puntoActual.x;
        this.y = puntoActual.y;
        this.anchura = 1;
        this.altura = 1;
        terminado = false;
    }

    @Override
    public void dibujar(Graphics g
    ) {

        Point punto1 = new Point(x, y);
        Point punto2 = new Point((int) (x - (anchura * 0.40)), y + altura);
        Point punto3 = new Point((int) (x + anchura - (anchura * 0.40)), y + altura);
        Point punto4 = new Point(x + anchura, y);

        coordenadasParalelogramoX = new int[]{punto1.x, punto2.x, punto3.x, punto4.x};
        coordenadasParalelogramoY = new int[]{punto1.y, punto2.y, punto3.y, punto4.y};

        if(relleno) {
            g.setColor(colorDeFondo);
            g.fillPolygon(coordenadasParalelogramoX, coordenadasParalelogramoY, 4);
        }
        
        g.setColor(colorDeContorno);
        g.drawPolygon(coordenadasParalelogramoX, coordenadasParalelogramoY, 4);
        
        this.setContorno(new Rectangle(punto2.x, y, (int)(anchura * 1.40), altura));

    }

    @Override
    public void actualizar(Point puntoActual
    ) {
        this.anchura = puntoActual.x - x;
        this.altura = puntoActual.y - y;
        int x = anchura < 0 ? this.x + anchura : this.x;
        int y = altura < 0 ? this.y + altura : this.y;
        int anchura = Math.abs(this.anchura);
        int altura = Math.abs(this.altura);

    }

    public boolean estaTerminado() {
        return terminado;
    }

    public void terminar() {
        terminado = true;
    }
}
