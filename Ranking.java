// klasa obslugujaca ranking, czyli 10 najlepszych wynikow uzyskanych przez gracza
// 10 najlepszych wynikow jest przechowywanych w osobnym pliku tekstowym
// klasa sprawdza czy uzyskany wynik miesci sie w top 10 oraz tworzy plik tekstowy z rankingiem 
//jezeli nie istnieje, odczytuje i wyswietla dane z istniejacego pliku z rankingiem
//w tej klasie sprawdzane sa takze wyniki - czy mieszcza sie w 10 najlepszych i jezeli tak, to sa 
//do tego rankingu zapisywane


package sortowanie_odpadow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Ranking extends JPanel{
    
    static String l = null;
    static ArrayList<String> lista = new ArrayList<String>(); //lista przechowujaca dane odczytane z rankingu
    Color b = new Color(103,202,149);
    static File plik = new File("ranking.txt");
    static int [] top10 = new int[10];
    
    Ranking() throws IOException{
     JButton przycisk = new JButton("WRÓĆ DO MENU");
     przycisk.setBackground(b);
     setLayout(new BorderLayout());
     add(przycisk, BorderLayout.NORTH);

     przycisk.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e) {
               Okno.karty.show(Okno.okna,"MENU");
          }
      } );
     odczytajRanking();
     repaint();
     
}
    
    @Override
    public void paintComponent(Graphics gs){
        Graphics2D g = (Graphics2D)gs;
        g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
        g.setColor(Color.BLACK);
        int dl1 = g.getFontMetrics().stringWidth("RANKING 10 NAJLEPSZYCH WYNIKÓW");
        g.drawString("RANKING 10 NAJLEPSZYCH WYNIKÓW",(Okno.szerokosc - dl1)/2,100);

        try {
            if(odczytajRanking()){
                g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
                int przesuniecie = 200;
                int i =0;
                for(String l:lista){
                    g.setColor(Color.BLACK);
                    int dl2 = g.getFontMetrics().stringWidth(10+". ");
                    g.drawString((i+1)+". ",(Okno.szerokosc - dl2)/2,przesuniecie + 50*(i+1));
                    g.setColor(b);
                    g.drawString(l,(Okno.szerokosc - dl2)/2+dl2 ,przesuniecie + 50*(i+1));
                    i++;
                }
                
            }
            else{
                g.setColor(Color.RED);
                g.drawString("BRAK WYNIKÓW DO WYŚWIETLENIA",(Okno.szerokosc - dl1)/2,Okno.wysokosc/2);
            }
        } catch (IOException ex) {
            Logger.getLogger(Ranking.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private boolean odczytajRanking() throws IOException{  //funckja odczytujaca ranking z pliku tekstowego
          boolean istnieje; // zmienna informujaca czy plik z rankingiem istnieje
         try {
 
            FileReader fr = new FileReader("ranking.txt");

            BufferedReader br = new BufferedReader(fr);
            istnieje = true;
            lista.clear();
            while((l = br.readLine()) != null) {
              lista.add(l);
            }   

            br.close();         
        }
     catch(FileNotFoundException ex) {  // jezeli nie znaleziono pliku
            istnieje = false;       // wtedy oznacza to ze nie istnieje
        }
         return istnieje;
     }
    
         
    public static boolean dodajDoListy(int wynik) throws IOException{
        boolean wynik_dodany_do_top10 = false; // zmienna informujaca czy wynik zostal dodany do top 10 (true - tak, false - nie)
        try {
 
            FileReader fr = new FileReader("ranking.txt");

            BufferedReader br = new BufferedReader(fr);

            lista.clear();
            while(( l = br.readLine()) != null) {
              lista.add(l);
            }   

            br.close();   
            
           if(lista.size() < 10){
               String bufor1 = null;
               String bufor2;
               int poz =-1;
               lista.add("0");
               for(int i=0;i<lista.size();i++){
                   if(wynik >= Integer.parseInt(lista.get(i))){
                       if(wynik_dodany_do_top10 == false){
                       bufor1 =  lista.get(i);
                       poz = i;
                       lista.set(i,Integer.toString(wynik));
                       wynik_dodany_do_top10 = true;
                       }
                   }
               }
               
               if(poz>-1){
                   for (int j=poz+1;j<lista.size();j++){
                   bufor2=lista.get(j);
                   lista.set(j,bufor1);
                   bufor1 = bufor2;
               }
               }
               Stan.miejsce = poz+1;
           }
           else{
               int poz = 0;
               String bufor1 = null;
               for(int i=0;i<lista.size();i++){
                   if(wynik >= Integer.parseInt(lista.get(i))){
                       if(wynik_dodany_do_top10 == false){
                       bufor1 = lista.get(i);
                       poz = i;
                       lista.set(i,Integer.toString(wynik));
                       wynik_dodany_do_top10 = true;
                       }
                   }
               }
               if(wynik_dodany_do_top10){
               String bufor2;
               for (int j=poz+1;j<lista.size();j++){
                   bufor2=lista.get(j);
                   lista.set(j,bufor1);
                   bufor1 = bufor2;
                   
               }
               }
               
               Stan.miejsce = poz+1;
           }
               
            
        }
        catch(FileNotFoundException ex) {
            plik.createNewFile();
            lista.clear();
            lista.add(Integer.toString(wynik));
            wynik_dodany_do_top10 = true;
            Stan.miejsce = 1;
        }
        
        PrintWriter w = new PrintWriter(plik, "UTF-8");
        for(String l:lista){
        w.println(l);
        }
        w.close();
        return wynik_dodany_do_top10;
    }
}
