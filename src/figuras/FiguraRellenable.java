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
 * @author frenn
 */
public abstract class FiguraRellenable extends Figura{
    protected Rectangle contorno;
    protected Color colorDeFondo;
    protected Boolean relleno;
    private boolean figuraActual;

    FiguraRellenable() {
        contorno = new Rectangle();
        figuraActual = true;
    }
    
    public FiguraRellenable(Color colorDeFondo, Color colorDeContorno, Boolean relleno){
        super.colorDeContorno = colorDeContorno;
        this.colorDeFondo = colorDeFondo;
        this.relleno = relleno;
    }
    
    public Rectangle getContorno() {
        return contorno;
    }
    
    public void setContorno(Rectangle contorno) {
        this.contorno = contorno;
    }
    
    public boolean isFiguraActual() {
        return figuraActual;
    }

    public void setFiguraActual(boolean figuraActual) {
        this.figuraActual = figuraActual;
    }
    
    public void dibujar(Graphics g) {
        int anchura = contorno.width;
        int altura = contorno.height;
        int x = contorno.x;
        int y = contorno.y;
        int punteado = 5;
        
        if(figuraActual) {
            g.setColor(Color.black);
            x = anchura < 0 ? x + anchura : x;
            y = altura < 0 ? y + altura : y;
            anchura = Math.abs(anchura);
            altura = Math.abs(altura);
            g.drawRect(x, y, anchura, altura);

            g.setColor(Color.white);
            for(int i = x; i < x + anchura; i += punteado * 2) {
                g.setColor(Color.white);
                g.drawLine(i, y, i + punteado, y);
                g.drawLine(i, y + altura, i + punteado, y + altura);
            }

            for (int i = y; i < y + altura; i += punteado * 2) {
                g.setColor(Color.white);
                g.drawLine(x, i, x, i + punteado);
                g.drawLine(x + anchura, i, x + anchura, i + punteado);
            }

            g.setColor(Color.black);
            g.drawRect(x - punteado / 2, y - punteado / 2, punteado, punteado);
            g.drawRect(x - punteado / 2 + anchura / 2, y - punteado / 2, punteado, punteado);
            g.drawRect(x - punteado / 2 + anchura, y - punteado / 2, punteado, punteado);

            g.drawRect(x - punteado / 2, y - punteado / 2 + altura / 2, punteado, punteado);
            g.drawRect(x - punteado / 2 + anchura, y - punteado / 2 + altura / 2, punteado, punteado);

            g.drawRect(x - punteado / 2, y - punteado / 2 + altura, punteado, punteado);
            g.drawRect(x - punteado / 2 + anchura / 2, y - punteado / 2 + altura, punteado, punteado);
            g.drawRect(x - punteado / 2 + anchura, y - punteado / 2 + altura, punteado, punteado);
        }
    }
}
