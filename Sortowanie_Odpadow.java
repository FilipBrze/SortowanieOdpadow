//klasa main

package sortowanie_odpadow;

import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.JFrame;


public class Sortowanie_Odpadow {

    
    public static void main(String[] args) throws InterruptedException, IOException {
      int szerokosc = 1024;
      int wysokosc = 768;
      
      int szerokosc_ekranu = Toolkit.getDefaultToolkit().getScreenSize().width;
      int wysokosc_ekranu = Toolkit.getDefaultToolkit().getScreenSize().height;
      int x_srodka = (szerokosc_ekranu - szerokosc)/2;
      int y_srodka = (wysokosc_ekranu - wysokosc)/2;
      

      JFrame okno_gry = new Okno(szerokosc, wysokosc, x_srodka, y_srodka);
      
      
   

}; 

}