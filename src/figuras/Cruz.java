package figuras;

import java.awt.*;

public class Cruz extends FiguraRellenable {

    int x;
    int y;
    int anchura;
    int altura;

    public Cruz( Color colorDeFondo, Color colorDeContorno, Boolean relleno, Point puntoActual ) {
        super(colorDeFondo, colorDeContorno, relleno, puntoActual);
        this.x = puntoActual.x;
        this.y = puntoActual.y;
        this.anchura = 1;
        this.altura = 1;
    }

    public void actualizar(Point puntoActual) {
        this.anchura = puntoActual.x - x;
        this.altura = puntoActual.y - y;
    }

    public void dibujar(Graphics g) {
        int x = this.anchura < 0 ? this.x + this.anchura : this.x;
        int y = this.altura < 0 ? this.y + this.altura : this.y;
        int anchura = Math.abs(this.anchura);
        int altura = Math.abs(this.altura);

        Point punto1 = new Point(x, y);
        Point punto2 = new Point((int) (x + (anchura * 0.33)), y);
        Point punto3 = new Point((int) (x + (anchura * 0.33)), (int) (y - altura));
        Point punto4 = new Point((int) (x + anchura * 0.66), (int) (y - altura));
        Point punto5 = new Point((int) (x + anchura * 0.66), y);
        Point punto6 = new Point((int) (x + anchura), y);
        Point punto7 = new Point((int) (x + anchura), (int) (y + altura * 0.66));
        Point punto8 = new Point((int) (x + anchura * 0.66), (int) (y + altura * 0.66));
        Point punto9 = new Point((int) (x + anchura * 0.66), (int) (y + altura * 1.70));
        Point punto10 = new Point((int) (x + anchura * 0.33), (int) (y + altura * 1.70));
        Point punto11 = new Point((int) (x + anchura * 0.33), (int) (y + altura * 0.66));
        Point punto12 = new Point(x, (int) (y + altura * 0.66));
        
        if(relleno) {
        g.setColor(colorDeFondo);
        g.fillPolygon(new int[]{punto1.x, punto2.x, punto3.x, punto4.x, punto5.x, punto6.x, punto7.x, punto8.x, punto9.x, punto10.x, punto11.x, punto12.x}, 
                new int[]{punto1.y, punto2.y, punto3.y, punto4.y, punto5.y, punto6.y, punto7.y, punto8.y, punto9.y, punto10.y, punto11.y, punto12.y}, 12);
        }
        
        g.setColor(colorDeContorno);
        g.drawPolygon(new int[]{punto1.x, punto2.x, punto3.x, punto4.x, punto5.x, punto6.x, punto7.x, punto8.x, punto9.x, punto10.x, punto11.x, punto12.x}, 
                new int[]{punto1.y, punto2.y, punto3.y, punto4.y, punto5.y, punto6.y, punto7.y, punto8.y, punto9.y, punto10.y, punto11.y, punto12.y}, 12);
        
        this.setContorno(new Rectangle(x, (int) (y - altura), anchura, (int) (altura * 2.7)));
        
    }
}