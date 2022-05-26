package figuras;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class DibujoLibre extends Figura {

    ArrayList<Point> puntos;
    boolean terminado;

    public DibujoLibre(Point puntoActual) {
        puntos = new ArrayList<>();
        puntos.add(puntoActual);
        terminado = false;
    }

    @Override
    public void dibujar(Graphics g) {

        for (int i = 1; i < puntos.size(); i++) {
            g.setColor(Color.BLACK);
            g.drawLine(puntos.get(i - 1).x, puntos.get(i - 1).y, puntos.get(i).x, puntos.get(i).y);
        }
    }

    @Override
    public void actualizar(Point puntoActual) {
        puntos.add(puntoActual);
    }

    public boolean estaTerminado() {
        return terminado;
    }

    public void terminar() {
        terminado = true;
    }
}
