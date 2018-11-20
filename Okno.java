package sortowanie_odpadow ;

import java.awt.GridLayout;
import static java.lang.Thread.sleep;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Okno extends JFrame {
    
    public static int wysokosc  ;
    public static int szerokosc;
    int x_srodka;
    int y_srodka;

    
    Okno(int szerokosc, int wysokosc, int x_srodka, int y_srodka) throws InterruptedException{
        super ();
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
        this.x_srodka = x_srodka;
        this.y_srodka = y_srodka;
        setSize(szerokosc, wysokosc);
        setLocation(x_srodka,y_srodka);
       setResizable(false); 
        setUndecorated(true); 
         initGUI();
        setVisible(true); 
        
       animationLoop();
        
        
    }
    
   
    
    public void initGUI() throws InterruptedException {
      
       // JPanel obrazPanel = new RysujGre();
        Pliki.LadujObrazki();
        add(new RysujGre());
    }
    
    private void animationLoop() {
        
        while (Stan.graj) {
         
          repaint();
        
          try {
            Thread.sleep(Stan.uspij);
          } catch (InterruptedException ex) {System.out.println("Wyjątek: "+ex);      }
        }
    }
    
    
    
    
}