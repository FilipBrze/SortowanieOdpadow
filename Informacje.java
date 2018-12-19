
package sortowanie_odpadow;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class Informacje extends JPanel {
    Informacje(){
       setSize(Okno.szerokosc - 100 ,Okno.wysokosc);
       repaint();
    }
    
        public void paintComponent(Graphics gs){
        Graphics2D g = (Graphics2D)gs;
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
        int dl = g.getFontMetrics().stringWidth("WITAJ W GRZE 'SORTOWANIE ODPADÓW' !");
        
        g.drawString("WITAJ W GRZE 'SORTOWANIE ODPADÓW' !", Okno.szerokosc/2 - dl/2 , 100);
        g.setFont(new Font("TimesRoman", Font.BOLD, 20));
        g.drawString(" Cel gry:",0, 200);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.drawString(" Środowisko, w którym wszyscy razem żyjemy jest naszym wspólnym dobrem i należy o nie dbać." ,0,250);
        g.drawString(" Dużym problemem dzisiejszego świata jest złe gospodarowanie odpadami.",0,270);
        g.drawString(" Gra ma na celu uświadomić jak należy bezpiecznie sortować różne typy odpadów, oraz wyrobić u gracza nawyki",0, 300); 
        g.drawString(" ułatwiające sortowanie. W tej sekcji dowiesz się jakie odpady wystpępują w grze i do jakich pojemników należy je",0,320); 
        g.drawString(" wyrzucać.",0,340);
        g.setFont(new Font("TimesRoman", Font.BOLD, 20));
        g.drawString(" Zasady gry: ",0,440);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.drawString(" Gra rozpoczyna się automatycznie po wybrania z menu opcji 'Nowa gra'.",0,490);
        g.drawString(" Na dole ekranu znajduje się 6 różnych typów pojemników, które można zamieniać miejscami",0,520);
        g.drawString(" klikając myszką najpierw na jeden pojemnik a potem na drugi.",0,540);
        g.drawString(" Z góry ekranu spadają różne odpady. Należy tak zamieniać miejscami pojemniki, aby odpowiedni odpad",0,570);
        g.drawString(" wpadł do odpowiedniego pojemnika.",0,590);
        g.drawString(" Gracz otrzymuje 1 punkt za każdy dobrze posegregowany odpad, natomiast traci jedno życie po złym",0,610);
        g.drawString(" przydzieleniu odpadu. Gra kończy się po utracie 3 żyć.",0,630);
        g.drawString(" Punkty i życia są widoczne na dolnym pasku. Każde życie jest symbolizowane przez zdrowe drzewo, natomiast",0,660);
        g.drawString(" utratę życia symbolizuje drzewo uschnięte",0,680);
        g.drawString(" Po ukończonej grze wyświetlany jest wynik gracza. 10 najlepszych wyników można zobaczyć w rankingu",0,710);
        g.setFont(new Font("TimesRoman", Font.BOLD, 20));
        g.drawString(" Pojemniki występujące w grze:",0,810);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.drawImage(Pliki.zdjecia_pojemnikow[0], 0, 830 ,Okno.szerokosc/Pliki.zdjecia_pojemnikow.length ,Stan.wysokosc_pojemnikow, null);
        g.drawString("- Pojemnik do którego należy wyrzucać odpady z typu metal/plastik",Okno.szerokosc/Pliki.zdjecia_pojemnikow.length+30,830 + Stan.wysokosc_pojemnikow/2);
        g.drawImage(Pliki.zdjecia_pojemnikow[1], 0, 850 + Stan.wysokosc_pojemnikow  ,Okno.szerokosc/Pliki.zdjecia_pojemnikow.length ,Stan.wysokosc_pojemnikow, null);
        g.drawString("- Pojemnik do którego należy wyrzucać odpady szklane",Okno.szerokosc/Pliki.zdjecia_pojemnikow.length+30,850 + Stan.wysokosc_pojemnikow  + Stan.wysokosc_pojemnikow/2);
        g.drawImage(Pliki.zdjecia_pojemnikow[2], 0, 870 + Stan.wysokosc_pojemnikow*2  ,Okno.szerokosc/Pliki.zdjecia_pojemnikow.length ,Stan.wysokosc_pojemnikow, null);
        g.drawString("- Pojemnik do którego należy wyrzucać odpady papierowe/kartony",Okno.szerokosc/Pliki.zdjecia_pojemnikow.length+30,870 + Stan.wysokosc_pojemnikow*2  + Stan.wysokosc_pojemnikow/2);
        g.drawImage(Pliki.zdjecia_pojemnikow[3], 0, 890 + Stan.wysokosc_pojemnikow*3  ,Okno.szerokosc/Pliki.zdjecia_pojemnikow.length ,Stan.wysokosc_pojemnikow, null);
        g.drawString("- Pojemnik na odpady biodegradowalne (inaczej mokre), czyli resztki jedzenia itp.",Okno.szerokosc/Pliki.zdjecia_pojemnikow.length+30,890 + Stan.wysokosc_pojemnikow*3  + Stan.wysokosc_pojemnikow/2);
        g.drawImage(Pliki.zdjecia_pojemnikow[4], 0, 910 + Stan.wysokosc_pojemnikow*4  ,Okno.szerokosc/Pliki.zdjecia_pojemnikow.length ,Stan.wysokosc_pojemnikow, null);
        g.drawString("- Jest to specjalny pojemnik, który można znaleźć w różnych miejscach. Wrzucamy do niego",Okno.szerokosc/Pliki.zdjecia_pojemnikow.length+30,890 + Stan.wysokosc_pojemnikow*4  + Stan.wysokosc_pojemnikow/2);
        g.drawString("odpady niebezpieczne dla środowiska takie jak płyty CD/DVD, baterie, żarówki, elektronika.",Okno.szerokosc/Pliki.zdjecia_pojemnikow.length+30,910 + Stan.wysokosc_pojemnikow*4  + Stan.wysokosc_pojemnikow/2);
        g.drawString(" Na pojemnikach tych jest kilka podpisanych otworów na konkretne odpady.",Okno.szerokosc/Pliki.zdjecia_pojemnikow.length+30,930 + Stan.wysokosc_pojemnikow*4  + Stan.wysokosc_pojemnikow/2);
        g.drawImage(Pliki.zdjecia_pojemnikow[5], 0, 930 + Stan.wysokosc_pojemnikow*5  ,Okno.szerokosc/Pliki.zdjecia_pojemnikow.length ,Stan.wysokosc_pojemnikow, null);
        g.drawString("- Do apteki zanosimy zużyte leki, strzykawki ogólnie wyroby medyczne. Pod żadnym",Okno.szerokosc/Pliki.zdjecia_pojemnikow.length+30,930 + Stan.wysokosc_pojemnikow*5  + Stan.wysokosc_pojemnikow/2);
        g.drawString(" pozorem nie można ich wyrzucać z innymi odpadami ! Mają tragiczny wpływ na środowisko.",Okno.szerokosc/Pliki.zdjecia_pojemnikow.length+30,950 + Stan.wysokosc_pojemnikow*5  + Stan.wysokosc_pojemnikow/2);
        g.setFont(new Font("TimesRoman", Font.BOLD, 20));
        g.drawString(" Odpady występujące w grze:",0,1050 + Stan.wysokosc_pojemnikow*6);
        g.drawString(" * Odpady typu plastik/metal:",0,1100 + Stan.wysokosc_pojemnikow*6);
        g.drawImage(Pliki.zdjecia_odpadow[0], 0, 1120 + Stan.wysokosc_pojemnikow*6  ,Okno.szerokosc/Pliki.zdjecia_pojemnikow.length ,Stan.wysokosc_odpadow, null);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.drawString(" - Plastikowa butelka",Okno.szerokosc/Pliki.zdjecia_pojemnikow.length+30,1120 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow/2);
        g.drawImage(Pliki.zdjecia_odpadow[1], 0, 1140 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow  ,Okno.szerokosc/Pliki.zdjecia_pojemnikow.length ,Stan.wysokosc_odpadow, null);
        g.drawString(" - Puszka",Okno.szerokosc/Pliki.zdjecia_pojemnikow.length+30,1140 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow/2+Stan.wysokosc_odpadow);
        g.drawImage(Pliki.zdjecia_odpadow[13], Okno.szerokosc/Pliki.zdjecia_pojemnikow.length+230, 1140 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow  ,Okno.szerokosc/Pliki.zdjecia_pojemnikow.length ,Stan.wysokosc_odpadow, null);
        g.drawString(" - Papier po czekoladzie/batonie",Okno.szerokosc/Pliki.zdjecia_pojemnikow.length*2+260,1140 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow/2+Stan.wysokosc_odpadow);
        g.drawImage(Pliki.zdjecia_odpadow[19], Okno.szerokosc/Pliki.zdjecia_pojemnikow.length+230, 1120 + Stan.wysokosc_pojemnikow*6  ,Okno.szerokosc/Pliki.zdjecia_pojemnikow.length ,Stan.wysokosc_odpadow, null);
        g.drawString(" - Torba plastikowa",Okno.szerokosc/Pliki.zdjecia_pojemnikow.length*2+260,1120 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow/2);
        g.setFont(new Font("TimesRoman", Font.BOLD, 20));
        g.drawString(" * Odpady typu szklo:",0,1160 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*2);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.drawImage(Pliki.zdjecia_odpadow[2],0, 1180 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*2  ,Okno.szerokosc/Pliki.zdjecia_pojemnikow.length ,Stan.wysokosc_odpadow, null);
        g.drawString(" - Butelka szklana",Okno.szerokosc/Pliki.zdjecia_pojemnikow.length+30, 1180 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*2 +Stan.wysokosc_odpadow/2);
        g.drawImage(Pliki.zdjecia_odpadow[14], Okno.szerokosc/Pliki.zdjecia_pojemnikow.length+230, 1180 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*2  ,Okno.szerokosc/Pliki.zdjecia_pojemnikow.length ,Stan.wysokosc_odpadow, null);
        g.drawString(" - Szklanka",Okno.szerokosc/Pliki.zdjecia_pojemnikow.length*2+260, 1180 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*2 +Stan.wysokosc_odpadow/2);
        
        g.drawImage(Pliki.zdjecia_odpadow[18],0, 1200 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*3  ,Okno.szerokosc/Pliki.zdjecia_pojemnikow.length ,Stan.wysokosc_odpadow, null);
        g.drawString(" - Kieliszek",Okno.szerokosc/Pliki.zdjecia_pojemnikow.length+30, 1200 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*3 +Stan.wysokosc_odpadow/2);
        g.drawImage(Pliki.zdjecia_odpadow[23], Okno.szerokosc/Pliki.zdjecia_pojemnikow.length+230, 1200 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*3  ,Okno.szerokosc/Pliki.zdjecia_pojemnikow.length ,Stan.wysokosc_odpadow, null);
        g.drawString(" - Słoik",Okno.szerokosc/Pliki.zdjecia_pojemnikow.length*2+260, 1200 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*3 +Stan.wysokosc_odpadow/2);
        g.setFont(new Font("TimesRoman", Font.BOLD, 20));
        g.drawString(" * Odpady biodegradowalne:",0,1220 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*4);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        
        g.drawImage(Pliki.zdjecia_odpadow[4],0, 1240 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*4  ,Okno.szerokosc/Pliki.zdjecia_pojemnikow.length ,Stan.wysokosc_odpadow, null);
        g.drawString(" - Ogryzek jabłka",Okno.szerokosc/Pliki.zdjecia_pojemnikow.length+30, 1240 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*4 +Stan.wysokosc_odpadow/2);
        g.drawImage(Pliki.zdjecia_odpadow[16], Okno.szerokosc/Pliki.zdjecia_pojemnikow.length+230, 1240 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*4  ,Okno.szerokosc/Pliki.zdjecia_pojemnikow.length ,Stan.wysokosc_odpadow, null);
        g.drawString(" - Worek po herbacie",Okno.szerokosc/Pliki.zdjecia_pojemnikow.length*2+260, 1240 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*4 +Stan.wysokosc_odpadow/2);
        
        
        g.drawImage(Pliki.zdjecia_odpadow[17],0, 1260 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*5  ,Okno.szerokosc/Pliki.zdjecia_pojemnikow.length ,Stan.wysokosc_odpadow, null);
        g.drawString(" - Skorupka jaja",Okno.szerokosc/Pliki.zdjecia_pojemnikow.length+30, 1260 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*5 +Stan.wysokosc_odpadow/2);
        g.drawImage(Pliki.zdjecia_odpadow[21], Okno.szerokosc/Pliki.zdjecia_pojemnikow.length+230, 1260 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*5 ,Okno.szerokosc/Pliki.zdjecia_pojemnikow.length ,Stan.wysokosc_odpadow, null);
        g.drawString(" - Skórka banana",Okno.szerokosc/Pliki.zdjecia_pojemnikow.length*2+260, 1260 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*5 +Stan.wysokosc_odpadow/2);
        g.setFont(new Font("TimesRoman", Font.BOLD, 20));
        g.drawString(" * Odpady typu papier:",0,1280 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*6);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        
        g.drawImage(Pliki.zdjecia_odpadow[3],0, 1300 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*6  ,Okno.szerokosc/Pliki.zdjecia_pojemnikow.length ,Stan.wysokosc_odpadow, null);
        g.drawString(" - Gazety/makulatura",Okno.szerokosc/Pliki.zdjecia_pojemnikow.length+30, 1300 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*6 +Stan.wysokosc_odpadow/2);
        g.drawImage(Pliki.zdjecia_odpadow[10], Okno.szerokosc/Pliki.zdjecia_pojemnikow.length+230, 1300 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*6  ,Okno.szerokosc/Pliki.zdjecia_pojemnikow.length ,Stan.wysokosc_odpadow, null);
        g.drawString(" - Karton",Okno.szerokosc/Pliki.zdjecia_pojemnikow.length*2+260, 1300 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*6 +Stan.wysokosc_odpadow/2);
        
        
        g.drawImage(Pliki.zdjecia_odpadow[11],0, 1320 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*7  ,Okno.szerokosc/Pliki.zdjecia_pojemnikow.length ,Stan.wysokosc_odpadow, null);
        g.drawString(" - Chusteczki",Okno.szerokosc/Pliki.zdjecia_pojemnikow.length+30, 1320 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*7 +Stan.wysokosc_odpadow/2);
        g.drawImage(Pliki.zdjecia_odpadow[12], Okno.szerokosc/Pliki.zdjecia_pojemnikow.length+230, 1320 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*7  ,Okno.szerokosc/Pliki.zdjecia_pojemnikow.length ,Stan.wysokosc_odpadow, null);
        g.drawString(" - Kubek papierowy",Okno.szerokosc/Pliki.zdjecia_pojemnikow.length*2+260, 1320 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*7 +Stan.wysokosc_odpadow/2);
        g.setFont(new Font("TimesRoman", Font.BOLD, 20));
        g.drawString(" * Odpady niestandardowe (pojemnik specjalny):",0,1340 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*8);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        
        g.drawImage(Pliki.zdjecia_odpadow[5],0, 1360 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*8  ,Okno.szerokosc/Pliki.zdjecia_pojemnikow.length ,Stan.wysokosc_odpadow, null);
        g.drawString(" - Pilot",Okno.szerokosc/Pliki.zdjecia_pojemnikow.length+30, 1360 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*8 +Stan.wysokosc_odpadow/2);
        g.drawImage(Pliki.zdjecia_odpadow[6], Okno.szerokosc/Pliki.zdjecia_pojemnikow.length+230, 1360 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*8  ,Okno.szerokosc/Pliki.zdjecia_pojemnikow.length ,Stan.wysokosc_odpadow, null);
        g.drawString(" - Żarówka",Okno.szerokosc/Pliki.zdjecia_pojemnikow.length*2+260, 1360 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*8 +Stan.wysokosc_odpadow/2);
        g.drawImage(Pliki.zdjecia_odpadow[7],0, 1380 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*9  ,Okno.szerokosc/Pliki.zdjecia_pojemnikow.length ,Stan.wysokosc_odpadow, null);
        g.drawString(" - Bateria",Okno.szerokosc/Pliki.zdjecia_pojemnikow.length+30, 1380 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*9 +Stan.wysokosc_odpadow/2);
        g.drawImage(Pliki.zdjecia_odpadow[8], Okno.szerokosc/Pliki.zdjecia_pojemnikow.length+230, 1380 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*9  ,Okno.szerokosc/Pliki.zdjecia_pojemnikow.length ,Stan.wysokosc_odpadow, null);
        g.drawString(" - Płyta CD/DVD/Blu-ray",Okno.szerokosc/Pliki.zdjecia_pojemnikow.length*2+260, 1380 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*9 +Stan.wysokosc_odpadow/2);
        g.setFont(new Font("TimesRoman", Font.BOLD, 20));
        g.drawString(" * Odpady, które należy zanieść do placówki medycznej:",0,1400 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*10);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        
        g.drawImage(Pliki.zdjecia_odpadow[9],0, 1420 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*10  ,Okno.szerokosc/Pliki.zdjecia_pojemnikow.length ,Stan.wysokosc_odpadow, null);
        g.drawString(" - Tabletki",Okno.szerokosc/Pliki.zdjecia_pojemnikow.length+30, 1420 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*10 +Stan.wysokosc_odpadow/2);
        g.drawImage(Pliki.zdjecia_odpadow[15], Okno.szerokosc/Pliki.zdjecia_pojemnikow.length+230, 1420 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*10  ,Okno.szerokosc/Pliki.zdjecia_pojemnikow.length ,Stan.wysokosc_odpadow, null);
        g.drawString(" - Syrop",Okno.szerokosc/Pliki.zdjecia_pojemnikow.length*2+260, 1420 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*10 +Stan.wysokosc_odpadow/2);
        
        g.drawImage(Pliki.zdjecia_odpadow[20],0, 1440 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*11  ,Okno.szerokosc/Pliki.zdjecia_pojemnikow.length ,Stan.wysokosc_odpadow, null);
        g.drawString(" - Strzykawka",Okno.szerokosc/Pliki.zdjecia_pojemnikow.length+30, 1440 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*11+Stan.wysokosc_odpadow/2);
        g.drawImage(Pliki.zdjecia_odpadow[22], Okno.szerokosc/Pliki.zdjecia_pojemnikow.length+230, 1440 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*11  ,Okno.szerokosc/Pliki.zdjecia_pojemnikow.length ,Stan.wysokosc_odpadow, null);
        g.drawString(" - Maść",Okno.szerokosc/Pliki.zdjecia_pojemnikow.length*2+260, 1440 + Stan.wysokosc_pojemnikow*6+Stan.wysokosc_odpadow*11 +Stan.wysokosc_odpadow/2);
        }
    
}
