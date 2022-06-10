/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package figuras;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Canvas;
/**
 *
 * @author josearielpereyra
 */
public abstract class Figura {
    public static Marco marco;
  
    public abstract void dibujar(Graphics g);

    public abstract void actualizar(Point puntoActual);
}
