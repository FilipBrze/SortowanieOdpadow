
package sortowanie_odpadow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Przegrana extends JPanel{
    Color b = new Color(103,202,149);

    
    Przegrana() throws IOException{
     JButton przycisk1 = new JButton("WRÓĆ DO MENU");
     JButton przycisk2 = new JButton("WYŚWIETL RANKING");
     przycisk1.setBackground(b);
     przycisk2.setBackground(b);
     setLayout(new BorderLayout());
     add(przycisk1, BorderLayout.NORTH);
     add(przycisk2, BorderLayout.SOUTH);
     przycisk1.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e) {
               Okno.karty.show(Okno.okna,"MENU");
          }
      } );
     przycisk2.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e) {
               Okno.karty.show(Okno.okna,"RANK");
          }
      } );

     
    }

    
     public void paintComponent(Graphics gs){
        Graphics2D g = (Graphics2D)gs;
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Okno.szerokosc, Okno.wysokosc);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
        g.setColor(Color.RED);
        int dl1 = g.getFontMetrics().stringWidth("KONIEC GRY");
        g.drawString("KONIEC GRY",(Okno.szerokosc - dl1)/2,200);
        dl1 = g.getFontMetrics().stringWidth("UZYSKANE PUNKTY: "+Stan.punkty);
        g.drawString("UZYSKANE PUNKTY: "+Stan.punkty,(Okno.szerokosc - dl1)/2,250);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));

            if(Stan.top10){
                g.setColor(Color.GREEN);
                int dl2 = g.getFontMetrics().stringWidth("GRATULACJE! TWÓJ WYNIK MIEŚCI SIĘ W 10 NAJLEPSZYCH");
                g.drawString("GRATULACJE! TWÓJ WYNIK MIEŚCI SIĘ W 10 NAJLEPSZYCH",(Okno.szerokosc - dl2)/2,500);
                dl2 = g.getFontMetrics().stringWidth("POZYCJA: "+Stan.miejsce);
                g.drawString("POZYCJA: "+Stan.miejsce,(Okno.szerokosc - dl2)/2,530);
            }
            else {
                g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
                int dl2 = g.getFontMetrics().stringWidth("NIESTETY TYM RAZEM NIE UDAŁO SIĘ DOSTAĆ DO 10 NAJLEPSZYCH WYNIKÓW");
                g.drawString("NIESTETY TYM RAZEM NIE UDAŁO SIĘ DOSTAĆ DO 10 NAJLEPSZYCH WYNIKÓW",(Okno.szerokosc - dl2)/2,500);
            }
    }
    
         
    
    public static void wywolajRanking() throws IOException{

     if(Ranking.dodajDoListy(Stan.punkty)){
         Stan.top10 = true;
     }
     else
         Stan.top10 = false;

    } 
     
}
