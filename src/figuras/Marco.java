/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package figuras;

import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author josearielpereyra
 */
class Marco extends Figura{
    private Rectangulo contorno;
    private boolean visible;
    
    public void mostrar(boolean visible) {
        this.visible = visible;
    }
    
    @Override
    public void dibujar(Graphics g) {
        
    }

    @Override
    public void actualizar(Point puntoActual) {
        
    }
    
}
