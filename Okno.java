package sortowanie_odpadow ;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.io.IOException;
import static java.lang.Thread.sleep;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Okno extends JFrame {
    
    public static int wysokosc  ;
    public static int szerokosc;
    int x_srodka;
    int y_srodka;
    public static CardLayout karty = new CardLayout();
    public static JPanel okna = new JPanel();
    
    Okno(int szerokosc, int wysokosc, int x_srodka, int y_srodka) throws InterruptedException, IOException{
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
    
   
    
    public void initGUI() throws InterruptedException, IOException {
        Pliki.ladujObrazki();
        Menu menu = new Menu();
        RysujGre gra = new RysujGre();
        OknoInformacji info = new OknoInformacji();
        Ranking ranking = new Ranking();
        Przegrana przegrana = new Przegrana();
   
       okna.setLayout(karty);
       okna.add(menu, "MENU");
       okna.add(gra, "GRA");
       okna.add(info, "INFO");
       okna.add(ranking,"RANK");
       okna.add(przegrana,"PRZE");
       add(okna);
    }
    
    private void animationLoop() {
        
        while (true) {
          repaint();
        
          try {
            Thread.sleep(Stan.uspij);
          } catch (InterruptedException ex) {System.out.println("Wyjątek: "+ex);      }
        }
    }
    
    
    
    
}