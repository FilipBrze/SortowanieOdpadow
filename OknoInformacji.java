//klasa rysujaca okno zakladki "informacje o grze" i jej elementy, oraz 
//obslugujaca dzialanie okna 

package sortowanie_odpadow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;


public class OknoInformacji extends JPanel {
    
    OknoInformacji(){
      JButton przycisk = new JButton("WRÓĆ DO MENU");
      Informacje tekst = new Informacje(); //stworzenie klasy zawierajacej indormacje do wyswietlenia
      JScrollPane area = new JScrollPane();
      Color b = new Color(103,202,149);
      przycisk.setBackground(b);
      area.setViewportView(tekst);
      tekst.setPreferredSize(new Dimension(tekst.getWidth(), 1460 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*12 ));
      setLayout(new BorderLayout());
      add(przycisk, BorderLayout.NORTH); //dodanie do okna przycisku powrotu do menu
      add(area ,BorderLayout.CENTER); // dodanie do okna pola zawierajacego informacje
      przycisk.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e) {
               Okno.karty.show(Okno.okna,"MENU");
          }
      } );
      repaint();
    }
    
    public void paintComponent(Graphics gs){ //rysowanie tla
        Graphics2D g = (Graphics2D)gs;
        Color a = new Color(76, 187, 228);
        GradientPaint kolor_tla = new GradientPaint(Okno.szerokosc, Okno.wysokosc, a, 0,0, Color.LIGHT_GRAY);
        g.setPaint(kolor_tla);
        g.fillRect(0, 0,Okno.szerokosc, Okno.wysokosc);
        }
    }
        
    
    
    

