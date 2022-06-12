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
public class Flecha extends Rectangulo {

    public Flecha(Color colorDeFondo, Color colorDeContorno, Boolean relleno, Point puntoActual) {
        super(colorDeFondo, colorDeContorno, relleno, puntoActual);
        this.x = puntoActual.x;
        this.y = puntoActual.y;
    }

    @Override
    public void dibujar(Graphics g) {

        int x = rectangulo.x;
        int y = rectangulo.y;
        int alturaFlecha = rectangulo.height;
        int anchuraFlecha = rectangulo.width;
        int[] estrellaX = {x + anchuraFlecha / 2, x + anchuraFlecha / 2, x, x, x + anchuraFlecha / 2, x + anchuraFlecha / 2, x + anchuraFlecha};
        int[] estrellaY = {y, y + alturaFlecha * 3 / 10, y + alturaFlecha * 3 / 10, y + alturaFlecha * 7 / 10, y + alturaFlecha * 7 / 10, y + alturaFlecha, y + alturaFlecha / 2};

        if (relleno) {
            g.setColor(Color.RED);
            g.fillPolygon(estrellaX, estrellaY, estrellaX.length);
        }
        g.setColor(Color.GREEN);
        g.drawPolygon(estrellaX, estrellaY, estrellaX.length);

        this.setContorno(new Rectangle(x, y, anchura, altura));
    }
}
