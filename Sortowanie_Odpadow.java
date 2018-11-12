
package sortowanie_odpadow;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.lang.Thread.sleep;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Sortowanie_Odpadow {

    
    public static void main(String[] args) throws InterruptedException {
      int szerokosc = 1024;
      int wysokosc = 768;
      
      int szerokosc_ekranu = Toolkit.getDefaultToolkit().getScreenSize().width;
      int wysokosc_ekranu = Toolkit.getDefaultToolkit().getScreenSize().height;
      int x_srodka = (szerokosc_ekranu - szerokosc)/2;
      int y_srodka = (wysokosc_ekranu - wysokosc)/2;
      

      JFrame okno_gry = new Okno(szerokosc, wysokosc, x_srodka, y_srodka);
      
      
   

}; 

}