/*
 PLANTILLA BASE PARA CREACION DE ESCENARIOS.
 */
package Ejercicio0;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private int a;
    private int c;
    public Board() {
        this.a = 0;
        this.c=0;
        this.timer = new Timer(25, this);
        this.timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        int b=200;
        g.drawOval(a + 10, b + 40, 10, 10);
        g.drawOval(a + 30, b + 40, 10, 10);
        g.drawRect(a + 0, b + 30, 50, 10);
        int x[] = {a + 10, a + 20, a + 20};
        int y[] = {b + 30, b + 20, b + 30};
        g.drawPolygon(x, y, 3);
        g.drawRect(a + 20, b + 20, 10, 10);
        int z[] = {a + 30, a + 30, a + 40};
        int w[] = {b + 30, b + 20, b + 30};
        g.drawPolygon(z, w, 3);
        g.drawLine(0, 250, 1000, 250);
        g.drawRect(a+0, b+20, 50, 30);
        
        Rectangle carro=new Rectangle(this.a,b+20,50,30);
        //rectangulo
        g.drawRect(150, c+40, 40, 40);
        g.drawOval(150, c+40, 40, 40);
        Rectangle oval = new Rectangle(150, this.c+40,40,40);
        if(carro.intersects(oval)){
            this.timer.stop();
        }
    }

    private void dibujarEscenario(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        //the first two parameters are the position (x,y) and after comes the width and the height
        g2d.fillOval(0, 0, 30, 30);
        g2d.drawOval(0, 50, 30, 30);

        g2d.fillRect(50, 0, 30, 30);
        g2d.drawRect(50, 50, 30, 30);

        g2d.drawString("Puntaje del Juego", 100, 100);

    }

    @Override

    public void actionPerformed(ActionEvent e) {
        if (a < 1000) {
            a++;
            c++;
        }
        repaint();

    }
}
