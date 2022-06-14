package figuras;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;


public class Poligono_ extends Figura {

    int x;
    int y;
    int anchura;
    int altura;
    boolean terminado;
    public int[] coordenadasPoligonoX;
    public int[] coordenadasPoligonoY;

    public Poligono_(Point puntoInicial) {
        this.x = puntoInicial.x;
        this.y = puntoInicial.y;
        this.anchura = 1;
        this.altura = 1;
        terminado = false;
    }

    Poligono_() {
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

        g.setColor(Color.GREEN);
        g.drawPolygon(coordenadasPoligonoX, coordenadasPoligonoY, 7);
    

        g.setColor(Color.RED);
        g.fillPolygon(coordenadasPoligonoX, coordenadasPoligonoY, 7);

        // Codigo para marco de poligono
        for (int n = coordenadasPoligonoX[6]; n <= coordenadasPoligonoX[2]; n += 10) {
            g.setColor(Color.BLACK);
            g.drawString("-", n + 1, coordenadasPoligonoY[1]);
        }
        for (int N = coordenadasPoligonoY[1]; N <= coordenadasPoligonoY[5] + 2; N += 10) {
             g.setColor(Color.BLACK);
            g.drawString("'", coordenadasPoligonoX[2], N + 5);
        }
        for (int m = coordenadasPoligonoX[6]; m <= coordenadasPoligonoX[2]; m += 10) {
             g.setColor(Color.BLACK);
            g.drawString("-", m, coordenadasPoligonoY[5] + 5);
        }
        for (int M = coordenadasPoligonoY[1]; M <= coordenadasPoligonoY[5] + 2; M += 10) {
             g.setColor(Color.BLACK);
            g.drawString("'", coordenadasPoligonoX[6], M + 5);
        }

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
