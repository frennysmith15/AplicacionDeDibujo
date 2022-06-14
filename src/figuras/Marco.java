/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package figuras;

import figuras.FiguraRellenable;
import aplicaciondedibujo.PanelDeDibujo;
import static figuras.Marco.paneles;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author josearielpereyra
 */
public class Marco extends Rectangulo {
    private boolean visible;
    
    JPanel panelE;
    JPanel panelO;
    JPanel panelN;
    JPanel panelS;
    JPanel panelNE;
    JPanel panelNO;
    JPanel panelSE;
    JPanel panelSO;
    
    public static JPanel[] paneles;
    
    private static Marco instancia;
    public static Rectangle contorno;
    
    public static Marco obtenerInstancia(PanelDeDibujo panel, Point puntoActual, Rectangle borde) {
       contorno = borde;
        
        if (instancia == null) {
            instancia = new Marco(panel, puntoActual);
        }
        return instancia;
    }

    private Marco(PanelDeDibujo panelDibujo, Point puntoActual) {
        super(Color.white, Color.BLACK, false, puntoActual);
        
        panelE = new JPanel();
        panelO = new JPanel();
        panelN = new JPanel();
        panelS = new JPanel();
        panelNE = new JPanel();
        panelNO = new JPanel();
        panelSE = new JPanel();
        panelSO = new JPanel();
        
        paneles = new JPanel[]{panelE, panelN, panelNE, panelNO, panelO, panelS, panelSE, panelSO};
    
        
        panelE.setBorder(new LineBorder(Color.BLACK, 1));
        panelO.setBorder(new LineBorder(Color.BLACK, 1));
        panelN.setBorder(new LineBorder(Color.BLACK, 1));
        panelS.setBorder(new LineBorder(Color.BLACK, 1));
        panelNE.setBorder(new LineBorder(Color.BLACK, 1));
        panelNO.setBorder(new LineBorder(Color.BLACK, 1));
        panelSE.setBorder(new LineBorder(Color.BLACK, 1));
        panelSO.setBorder(new LineBorder(Color.BLACK, 1));
        
        panelE.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                panelDibujo.setCursor(new Cursor(Cursor.E_RESIZE_CURSOR));
            }
        });
        
        panelO.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                panelDibujo.setCursor(new Cursor(Cursor.W_RESIZE_CURSOR));
            }
        });
        
        panelN.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                panelDibujo.setCursor(new Cursor(Cursor.N_RESIZE_CURSOR));
            }
        });
        
        panelS.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                panelDibujo.setCursor(new Cursor(Cursor.S_RESIZE_CURSOR));
            }
        });
        
        panelNE.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                panelDibujo.setCursor(new Cursor(Cursor.NE_RESIZE_CURSOR));
            }
        });
        
        panelNO.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                panelDibujo.setCursor(new Cursor(Cursor.NW_RESIZE_CURSOR));
            }
        });
        
        panelSE.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                panelDibujo.setCursor(new Cursor(Cursor.SE_RESIZE_CURSOR));
            }
        });
        
        panelSO.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                panelDibujo.setCursor(new Cursor(Cursor.SW_RESIZE_CURSOR));
            }
        });
        
        panelDibujo.add(panelN);
        panelDibujo.add(panelS);
        panelDibujo.add(panelE);
        panelDibujo.add(panelO);
        panelDibujo.add(panelNE);
        panelDibujo.add(panelNO);
        panelDibujo.add(panelSE);
        panelDibujo.add(panelSO);
    }
    
    public void mostrar(boolean visible) {
        this.visible = visible;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    @Override
    public void dibujar(Graphics g) {
        int x = contorno.x;
        int y = contorno.y;
        int anchura = contorno.width;
        int altura = contorno.height;
        int punteado = 5;
        
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

        panelNO.setLocation(x - punteado / 2, y - punteado / 2);
        panelN.setLocation(x - punteado / 2 + anchura / 2, y - punteado / 2);
        panelNE.setLocation(x - punteado / 2 + anchura, y - punteado / 2);
        panelO.setLocation(x - punteado / 2, y - punteado / 2 + altura / 2);
        panelE.setLocation(x - punteado / 2 + anchura, y - punteado / 2 + altura / 2);
        panelSO.setLocation(x - punteado / 2, y - punteado / 2 + altura);
        panelS.setLocation(x - punteado / 2 + anchura / 2, y - punteado / 2 + altura);
        panelSE.setLocation(x - punteado / 2 + anchura, y - punteado / 2 + altura);
        
        panelNO.setSize(punteado,punteado);
        panelN.setSize(punteado,punteado);
        panelNE.setSize(punteado,punteado);
        panelO.setSize(punteado,punteado);
        panelE.setSize(punteado,punteado);
        panelSO.setSize(punteado,punteado);
        panelS.setSize(punteado,punteado);
        panelSE.setSize(punteado,punteado);
        
        this.setContorno(new Rectangle(x, y, anchura, altura));
    }
}
