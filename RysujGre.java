
package sortowanie_odpadow;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JPanel;


public class RysujGre extends JPanel {
    
    
        
 
    public static Pojemnik [] pojemniki;
    public static Odpad [][] odpady;
    

    RysujGre() {
        super ();

        stanPoczatkowy();

      
       addMouseListener(new MouseAdapter(){
            @Override
          public void mousePressed(MouseEvent me){

          for(int i=0; i<pojemniki.length; i++){
           if(me.getY()>(Okno.wysokosc - Stan.wysokosc_pojemnikow - Stan.wysokosc_paska) && me.getY()< (Okno.wysokosc - Stan.wysokosc_paska)){
               if(me.getX()>pojemniki[i].polozenie_x && me.getX()<(pojemniki[i].polozenie_x+pojemniki[i].szerokosc)){
                   Stan.klikniecia++;
                     if(Stan.klikniecia ==1){
                       Stan.x1 = pojemniki[i].polozenie_x;
                       Stan.klikniety1 =i;
                   }
                     else {
                       Stan.x2 = pojemniki[i].polozenie_x;
                       Stan.klikniety2 = i;
                       pojemniki[Stan.klikniety1].polozenie_x = Stan.x2;
                       pojemniki[Stan.klikniety2].polozenie_x = Stan.x1;
                       
                       Stan.bufor = pojemniki[Stan.klikniety1];
                       pojemniki[Stan.klikniety1] = pojemniki[Stan.klikniety2];
                       pojemniki[Stan.klikniety2] = Stan.bufor;
                       
                       Stan.klikniecia =0; // wyzerowanie stanu klikniec
                   }
               }

           }
               
       }
                         if(me.getX()>(Okno.szerokosc - Stan.wysokosc_paska) && me.getX()<Okno.szerokosc){
                   if(me.getY()>Okno.wysokosc - Stan.wysokosc_paska  && me.getY()< Okno.wysokosc ){
                       Okno.karty.show(Okno.okna,"MENU"); 
                   }
               }
          
               } 
       } );
        
    }
    
    
    @Override
            public void paintComponent(Graphics gs) {
                Graphics2D g = (Graphics2D)gs;
               Color a = new Color(76, 187, 228);
               GradientPaint kolor_tla = new GradientPaint(Okno.szerokosc, Okno.wysokosc, a, 0,0, Color.LIGHT_GRAY);
               g.setPaint(kolor_tla);
               g.fillRect(0, 0,Okno.szerokosc, Okno.wysokosc);
               Color b = new Color(167,188,140);
               GradientPaint kolor_paska = new GradientPaint(0, (Okno.wysokosc - Stan.wysokosc_paska), b,Okno.szerokosc, Stan.wysokosc_paska, Color.LIGHT_GRAY);
               g.setPaint(kolor_paska);
               g.fillRect(0, (Okno.wysokosc - Stan.wysokosc_paska) , Okno.szerokosc, Stan.wysokosc_paska);
               g.setColor(Color.BLACK) ;
               g.drawRect(0, (Okno.wysokosc - Stan.wysokosc_paska) , Okno.szerokosc - 1 , Stan.wysokosc_paska -1);
               g.drawImage(Pliki.zakoncz, Okno.szerokosc - Stan.wysokosc_paska-1,Okno.wysokosc - Stan.wysokosc_paska+1 ,Stan.wysokosc_paska,Stan.wysokosc_paska-2, null);
               g.drawRect(Okno.szerokosc - Stan.wysokosc_paska-1,Okno.wysokosc - Stan.wysokosc_paska+1 ,Stan.wysokosc_paska,Stan.wysokosc_paska-2);
               Stan.czas_do_kolejnego++;

            
             if(Stan.czas_do_kolejnego > Stan.czestotliwosc ){
             losuj(odpady);
             Stan.czas_do_kolejnego = 0;
             }
             
            for (int i =0; i<Pliki.zdjecia_pojemnikow.length; i++){
            for (int j=0; j<Stan.max_odpadow_rzad; j++){
                if(odpady[i][j] != null){
                g.drawImage(odpady[i][j].obrazek, odpady[i][j].x,odpady[i][j].aktualny_y,odpady[i][j].szerokosc,odpady[i][j].wysokosc, null);
                 odpady[i][j].ruch();
                     if((odpady[i][j].aktualny_y+odpady[i][j].wysokosc) >= (Okno.wysokosc - Stan.wysokosc_pojemnikow + odpady[i][j].wysokosc*0.3)){
                        if(odpady[i][j].rodzaj == pojemniki[odpady[i][j].rzad].rodzaj){
                            Stan.punkty++;
                            dzwiek(Pliki.correct);
                        }
                        else {
                            Stan.ilosc_zyc--;
                            dzwiek(Pliki.wrong);
                        }
                         zliczajTypy(odpady[i][j].rodzaj, '-');
                         odpady[i][j] = null;
                         Stan.jest_odpadow --;
                     }
                }
            }      
        }       
             for (int i=0; i<Pliki.zdjecia_pojemnikow.length; i++){
                    g.drawImage(pojemniki[i].obrazek, pojemniki[i].polozenie_x, pojemniki[i].polozenie_y,pojemniki[i].szerokosc ,pojemniki[i].wysokosc , null);
                } 
                
                g.setFont(new Font("Serif",Font.PLAIN,20));
              	g.drawString("Punkty: "+Integer.toString(Stan.punkty), 20, Okno.wysokosc - ((Stan.wysokosc_paska-10)/2) );
                g.drawString("Życie: ", Okno.szerokosc/2 + 100, Okno.wysokosc - ((Stan.wysokosc_paska-10)/2) );

                    if(Stan.ilosc_zyc > 0){
                         g.drawImage(Pliki.drzewka[1], Okno.szerokosc/2 + 200,Okno.wysokosc - Stan.wysokosc_paska +5,40,40, null);
                    }
                    else 
                         g.drawImage(Pliki.drzewka[0], Okno.szerokosc/2 + 200,Okno.wysokosc - Stan.wysokosc_paska +5,40,40, null);
                    
                    if(Stan.ilosc_zyc > 1){
                         g.drawImage(Pliki.drzewka[1], Okno.szerokosc/2 + 250,Okno.wysokosc - Stan.wysokosc_paska +5,40,40, null);
                    }
                    else 
                         g.drawImage(Pliki.drzewka[0], Okno.szerokosc/2 + 250,Okno.wysokosc - Stan.wysokosc_paska +5,40,40, null);
                    
                    if(Stan.ilosc_zyc > 2){
                         g.drawImage(Pliki.drzewka[1], Okno.szerokosc/2 + 300,Okno.wysokosc - Stan.wysokosc_paska +5,40,40, null);
                    }
                    else 
                         g.drawImage(Pliki.drzewka[0], Okno.szerokosc/2 + 300,Okno.wysokosc - Stan.wysokosc_paska +5,40,40, null);
                    
                          if (Stan.ilosc_zyc == 0){
                    try {
                        Przegrana.wywolajRanking();
                    } catch (IOException ex) {
                        Logger.getLogger(RysujGre.class.getName()).log(Level.SEVERE, null, ex);
                    }
                       
                       Okno.karty.show(Okno.okna,"PRZE");
                    } 
                    
                    
                        przyspieszenie();
                
                   
            }
    
            
    private void losuj(Odpad [][] odpady) {
        int ile_przejsc = 0;
        int zapelnione_typy = 0;
         int rzad;
         int jaki;
         boolean moze_powstac;
         boolean utworzono_odpad = false;
         Random losowanie = new Random();

         jaki = losowanie.nextInt(Pliki.zdjecia_odpadow.length); //losujemy odpad
         while(utworzono_odpad == false){
          
         rzad = losowanie.nextInt(Pliki.zdjecia_pojemnikow.length); //losujemy rzad
         while (Stan.ostatni_wylosowany == rzad){
         rzad = losowanie.nextInt(Pliki.zdjecia_pojemnikow.length);
         }
         for (int i =0; i<odpady[rzad].length; i++){
             moze_powstac = true;
             if(odpady[rzad][i] == null){  //jezeli w tej komorce nic nie ma
                 for (int j =0; j<odpady[rzad].length; j++){
                     if(odpady[rzad][j] != null){
                     if(odpady[rzad][j].aktualny_y <= 150) //sprawdzamy jego pozycje zeby rysunki na siebie nie nachodzily
                       moze_powstac = false;
                     }
                 }
                 if (moze_powstac != false){                                         
                         for (int l=0; l<Pliki.zdjecia_pojemnikow.length; l++){
                             if(ileTegoTypu(l) > 1)
                                 zapelnione_typy++; // maksymalnie 2 takie same obiekty jednoczesnie
                          }                         // w celu wiekszej roznorodnosci
                             if(zapelnione_typy <Pliki.zdjecia_pojemnikow.length){ 
                                 while (ileTegoTypu(jaki) > 1){
                         jaki = losowanie.nextInt(Pliki.zdjecia_odpadow.length);
                                 }
                             }
                     odpady[rzad][i] = new Odpad (jaki,Pliki.zdjecia_odpadow,Stan.wysokosc_odpadow, (rzad * (Okno.szerokosc/Pliki.zdjecia_pojemnikow.length)),rzad,i);
                     utworzono_odpad = true;
                     Stan.jest_odpadow ++;
                     zliczajTypy(odpady[rzad][i].rodzaj, '+');
                     Stan.ostatni_wylosowany = rzad;
             }            
         }                   
    }     
         ile_przejsc ++;
        if ((Pliki.zdjecia_pojemnikow.length*Stan.max_odpadow_rzad)< ile_przejsc) //oznacza to ze w zadnym rzedzie nie da sie juz stworzyc nowego odpadu 
        utworzono_odpad = true;// w takim przypadku nalezy opuscic petle i poczekac az jakis odpad zostanie usuniety
        
    }
    }
    
    private void zliczajTypy(Odpad.Rodzaj rodzaj, char operacja){
        switch(rodzaj){
            case PLASTIK_METAL: {
                if(operacja == '+')
                    Stan.ile_metal++;
                else if(operacja == '-')
                    Stan.ile_metal--;
            }
            break;
            
            case SZKLO: {
                if(operacja == '+')
                    Stan.ile_szklo++;
                else if(operacja == '-') 
                    Stan.ile_szklo--;
            }
            break;
            
            case PAPIER: {
                if(operacja == '+')
                    Stan.ile_papier++;
                else if(operacja == '-')
                    Stan.ile_papier--;
            }
            break;
            
            case BIODEGRADOWALNE: {
                if(operacja == '+')
                    Stan.ile_bio++;
                else if(operacja == '-') 
                    Stan.ile_bio--;
            }
            break;
            
            case LEKI: {
                if(operacja == '+')
                    Stan.ile_leki++;
                else if(operacja == '-')
                    Stan.ile_leki--;
            }
            break;
            
            case ELEKTRONIKA: {
                if(operacja == '+')
                    Stan.ile_elektro++;
                else if(operacja == '-') 
                    Stan.ile_elektro--;
            }
            break;
                
               
        }
    }
    
    private int ileTegoTypu(int jaki){
        int ile =0;
        switch(jaki){
            case 0: ile = Stan.ile_metal; 
           break;
           case 1: ile = Stan.ile_metal; 
           break;
           case 2: ile = Stan.ile_szklo; 
           break;
           case 3: ile = Stan.ile_papier;   
           break;
           case 4: ile = Stan.ile_bio;
           break;
           case 5: ile = Stan.ile_elektro;
           break;
           case 6: ile = Stan.ile_elektro;
           break;
           case 7: ile = Stan.ile_elektro;
           break;
           case 8: ile = Stan.ile_elektro;
           break;
           case 9: ile = Stan.ile_leki;
           break;
           case 10: ile = Stan.ile_papier;   
           break;
           case 11: ile = Stan.ile_papier;   
           break;
           case 12: ile = Stan.ile_papier;   
           break;
           case 13: ile = Stan.ile_metal;   
           break;
           case 14: ile = Stan.ile_szklo;   
           break;
           case 15: ile = Stan.ile_leki;   
           break;
           case 16: ile = Stan.ile_bio;   
           break;
           case 17: ile = Stan.ile_bio;   
           break;
           case 18: ile = Stan.ile_szklo;   
           break;
           case 19: ile = Stan.ile_metal;   
           break;
           case 20: ile = Stan.ile_leki;   
           break;
           case 21: ile = Stan.ile_bio;   
           break;
           case 22: ile = Stan.ile_leki;   
           break;
           case 23: ile = Stan.ile_szklo;   
           break;
        }
        return ile;
    }
    
    private void przyspieszenie(){
        if (Stan.punkty != 0){
            
            if(Stan.punkty%5 == 0){
                if (Stan.mozna_przyspieszyc == true){
                    if(Stan.czestotliwosc >= Stan.czestotliwosc_graniczna+10)
                        Stan.czestotliwosc = Stan.czestotliwosc - 10;
                
                    if(Stan.uspij > 10){
                         Stan.uspij = Stan.uspij - 2;
                    }
                 Stan.mozna_przyspieszyc = false;

        }
            }
        else Stan.mozna_przyspieszyc = true;
        
    }
    }
    
    public static void stanPoczatkowy(){
        Stan.top10 = false;
        Stan.menu = false;
        Stan.czestotliwosc_graniczna = 100;
        Stan.ostatni_wylosowany = 0;
        Stan.uspij = 17;
        Stan.mozna_przyspieszyc = true;
        Stan.czestotliwosc = 170;
        Stan.wysokosc_paska = 50;
        Stan.jest_odpadow =0;
        Stan.ile_bio =0;
        Stan.ile_elektro =0;
        Stan.ile_leki =0;
        Stan.ile_metal =0;
        Stan.ile_papier = 0;
        Stan.ile_szklo =0;
        Stan.czas_do_kolejnego = 201 ;
        Stan.ilosc_zyc =3;
        Stan.punkty =0;
        Stan.klikniecia = 0;
        Stan.bufor = new Pojemnik(0,Pliki.zdjecia_odpadow,150);
        Stan.wysokosc_odpadow = 150;
        Stan.wysokosc_pojemnikow = 150;
        pojemniki = new Pojemnik [Pliki.zdjecia_pojemnikow.length];
        Stan.max_odpadow_rzad = (Okno.wysokosc - Stan.wysokosc_pojemnikow)/Stan.wysokosc_odpadow;
        //System.out.println(Stan.max_odpadow_rzad);
        odpady = new Odpad [Pliki.zdjecia_pojemnikow.length][Stan.max_odpadow_rzad];
        for (int i =0; i<Pliki.zdjecia_pojemnikow.length; i++){
            for (int j=0; j<Stan.max_odpadow_rzad; j++){
                odpady[i][j] = null;
                
            }
                
        }

        for (int i=0 ; i < Pliki.zdjecia_pojemnikow.length ; i++){
            pojemniki[i] = new Pojemnik(i, Pliki.zdjecia_pojemnikow,Stan.wysokosc_pojemnikow);
            pojemniki[i].polozenie_y = 768-150-Stan.wysokosc_paska;
            pojemniki[i].polozenie_x =  i * (1024/6);    
            
            
        }
    }
    
     public static synchronized void dzwiek(final File f) {
        new Thread(new Runnable() {
          public void run() {
            try {
              Clip clip = AudioSystem.getClip();
              AudioInputStream inputStream = AudioSystem.getAudioInputStream(f);
              clip.open(inputStream);
              clip.start(); 
            } catch (Exception e) {
              System.err.println(e.getMessage());
            }
          }
        }).start();
    }

} 