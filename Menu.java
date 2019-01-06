//klasa rysujaca menu gry i obslugujaca jego dzialanie

package sortowanie_odpadow;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Menu extends JPanel{
    
        //ustawienie wierzcholkow 4 trojkatow, z ktorych sklada sie menu (kazdy trojkat to inny przycisk)
        int [] x1 = {0,0,Okno.szerokosc/2};
        int [] x2 = {0,Okno.szerokosc,Okno.szerokosc/2};
        int [] x3 = {0,Okno.szerokosc,Okno.szerokosc/2};
        int [] x4 = {Okno.szerokosc,Okno.szerokosc,Okno.szerokosc/2};
        int [] y1 = {0,Okno.wysokosc, Okno.wysokosc/2};
        int [] y2 = {0,0, Okno.wysokosc/2};
        int [] y3 = {Okno.wysokosc,Okno.wysokosc, Okno.wysokosc/2};
        int [] y4 = {0,Okno.wysokosc, Okno.wysokosc/2};
        boolean w1 = false;
        boolean w2 = false;
        boolean w3 = false;
        boolean w4 = false;
    
    Menu(){
        super();
        Stan.rozpocznij = false;
        Stan.uspij = 0;
        addMouseMotionListener(new MouseAdapter(){
            @Override
          public void mouseMoved(MouseEvent me){ // funkcja sprawdzajaca w obrebie ktorego przycisku znajduje sie myszka (przycisk zostaje wtedy podswietlony)
              if(new Polygon(x1,y1, 3).contains(new Point(me.getX(),me.getY())) ){
                  w1 = true;
                  w2 = false;
                  w3 = false;
                  w4 = false;
              }
              else if (new Polygon(x2,y2, 3).contains(new Point(me.getX(),me.getY()))){
                  w2 = true;
                  w1 = false;
                  w3 = false;
                  w4 = false;
              }
              else if (new Polygon(x3,y3, 3).contains(new Point(me.getX(),me.getY()))){
                  w3 = true;
                  w1 = false;
                  w2 = false;
                  w4 = false;
              }
              else if (new Polygon(x4,y4, 3).contains(new Point(me.getX(),me.getY()))){
                  w4 = true;
                  w1 = false;
                  w2 = false;
                  w3 = false;
              }
                  
          
               } 
       } );
        
        addMouseListener(new MouseAdapter(){  // czytanie klikniecia myszki i jego obsluga
            @Override
          public void mouseClicked(MouseEvent me){
            if (new Polygon(x3,y3, 3).contains(new Point(me.getX(),me.getY())))
                  System.exit(0);
            else if (new Polygon(x2,y2, 3).contains(new Point(me.getX(),me.getY()))){
               RysujGre.stanPoczatkowy();
               Okno.karty.show(Okno.okna,"GRA");
            }
              
            else if (new Polygon(x1,y1, 3).contains(new Point(me.getX(),me.getY()))){
               Okno.karty.show(Okno.okna,"INFO");
            }
            else if (new Polygon(x4,y4, 3).contains(new Point(me.getX(),me.getY()))){
               Okno.karty.show(Okno.okna,"RANK");
            }
            
               }
       } );  
    }
  @Override
    public void paintComponent(Graphics gs){ //rysowanie menu
        Graphics2D g = (Graphics2D)gs;
        Color a = new Color(76, 187, 228);
        Color b = new Color(103,202,149);
        Color c = new Color (68,189,125);
        GradientPaint kolor_tla = new GradientPaint(Okno.szerokosc, Okno.wysokosc, a, 0,0, Color.LIGHT_GRAY);
        GradientPaint podswietlenie = new GradientPaint(Okno.szerokosc, Okno.wysokosc,b,0,0,c);
        g.setPaint(kolor_tla);
        g.fillRect(0, 0,Okno.szerokosc, Okno.wysokosc);
        g.setColor(Color.BLACK);
        g.drawLine(0, 0, Okno.szerokosc, Okno.wysokosc);
        g.drawLine(0,Okno.wysokosc,Okno.szerokosc,0);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g.drawString("NOWA GRA", Okno.szerokosc/2 - 70, Okno.wysokosc/4);
        g.drawString("WYJDŹ", Okno.szerokosc/2 - 70 , 3*Okno.wysokosc/4);
        g.drawString("INFORMACJE", Okno.szerokosc/4 - 70, Okno.wysokosc/2);
        g.drawString("NAJLEPSZE WYNIKI", 3*Okno.szerokosc/4 - 140, Okno.wysokosc/2);
        if(w1){   //tutaj sprawdzane jest ktory trojkat nalezy podswietlic (ten w obrebie ktorego znajduje sie myszka -> wtedy odopwiednie wx = true)
        g.setPaint(podswietlenie);
        g.fillPolygon(x1,y1, 3);
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g.drawString("INFORMACJE", Okno.szerokosc/4 - 70, Okno.wysokosc/2);
        }
        else if(w2){
        g.setPaint(podswietlenie);
        g.fillPolygon(x2,y2, 3);
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g.drawString("NOWA GRA", Okno.szerokosc/2 - 70, Okno.wysokosc/4);
        }
        else if(w3){
         g.setPaint(podswietlenie);
        g.fillPolygon(x3,y3, 3);
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g.drawString("WYJDŹ", Okno.szerokosc/2 - 70 , 3*Okno.wysokosc/4);
        }
        else if(w4){
        g.setPaint(podswietlenie);
        g.fillPolygon(x4,y4, 3);
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g.drawString("NAJLEPSZE WYNIKI", 3*Okno.szerokosc/4 - 140, Okno.wysokosc/2);
        }
        
    }
    
}
