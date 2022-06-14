package figuras;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;


public class Poligono extends FiguraRellenable{

    int x;
    int y;
    int anchura;
    int altura;
    boolean terminado;
    public int[] coordenadasPoligonoX;
    public int[] coordenadasPoligonoY;

    public Poligono( Color colorDeFondo, Color colorDeContorno, Boolean relleno, Point puntoActual ) {
        super(colorDeFondo, colorDeContorno, relleno, puntoActual);
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

        Point punto1 = new Point(x, (int) (y - altura * 0.65));
        Point punto2 = new Point((int) (x + (anchura / 1.5)), y - altura);
        Point punto3 = new Point(x + anchura, (int) (y - altura * 0.50));
        Point punto4 = new Point((int) (x + (anchura / 1.35)), (int) (y + (altura / 10)));
        Point punto5 = new Point(x + anchura, (int) (y + (altura * 0.80)));
        Point punto6 = new Point((int) (x + (anchura / 3)), y + altura);
        Point punto7 = new Point((int) (x - (anchura / 7)), (int) (y + (altura * 0.60)));

        coordenadasPoligonoX = new int[]{punto1.x, punto2.x, punto3.x, punto4.x, punto5.x, punto6.x, punto7.x};
        coordenadasPoligonoY = new int[]{punto1.y, punto2.y, punto3.y, punto4.y, punto5.y, punto6.y, punto7.y};

        if(relleno) {
            g.setColor(colorDeFondo);
            g.fillPolygon(coordenadasPoligonoX, coordenadasPoligonoY, 7);
        }
        g.setColor(colorDeContorno);
        g.drawPolygon(coordenadasPoligonoX, coordenadasPoligonoY, 7);
    

        
        this.setContorno(new Rectangle(x,(int) (y - altura), anchura, altura *2));

        /*  
        g.drawLine(coordenadasPoligonoX[6], coordenadasPoligonoY[1], coordenadasPoligonoX[2], coordenadasPoligonoY[1]);
        g.drawLine(coordenadasPoligonoX[2], coordenadasPoligonoY[1], coordenadasPoligonoX[2], coordenadasPoligonoY[5]);
        g.drawLine(coordenadasPoligonoX[6], coordenadasPoligonoY[5], coordenadasPoligonoX[2], coordenadasPoligonoY[5]);
        g.drawLine(coordenadasPoligonoX[6], coordenadasPoligonoY[1], coordenadasPoligonoX[6], coordenadasPoligonoY[5]);
         */
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