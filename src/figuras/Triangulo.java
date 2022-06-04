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
 * @author josearielpereyra
 */
public class Triangulo extends Rectangulo {

    public Triangulo(Point puntoActual, Color colorDePrimerPlano, Color colorDeSegundoPlano) {
        super(puntoActual, colorDePrimerPlano, colorDeSegundoPlano);
    }


    @Override
    public void dibujar(Graphics g) {
        int x = rectangulo.x;
        int y = rectangulo.y;
        int anchura = rectangulo.width;
        int altura = rectangulo.height;
        
       int[] coordenadasX = {x, x + anchura/2, x + anchura};
       int[] coordenadasY = {y + altura, y, y + altura};
       
        
        g.setColor(getColorDePrimerPlano());
        g.drawPolygon(coordenadasX, coordenadasY, 3);

        g.setColor(getColorDeSegundoPlano());
        g.fillPolygon(coordenadasX, coordenadasY, 3);
    }
    
}
