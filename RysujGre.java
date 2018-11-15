
package sortowanie_odpadow;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.lang.Thread.sleep;
import java.util.Random;
import javax.swing.JPanel;


public class RysujGre extends JPanel {
    
    
        
    Odpad pierwszy;
    private Pojemnik [] pojemniki;
    private Odpad [][] odpady;
    

    RysujGre() {
        super ();

        StanPoczatkowy();
      
       addMouseListener(new MouseAdapter(){
            @Override
          public void mouseClicked(MouseEvent me){

          for(int i=0; i<pojemniki.length; i++){
           if(me.getY()>(Okno.wysokosc - Stan.wysokosc_pojemnikow - Stan.wysokosc_paska) && me.getY()< (Okno.wysokosc - Stan.wysokosc_paska)){
               if(me.getX()>pojemniki[i].polozenie_x && me.getX()<(pojemniki[i].polozenie_x+pojemniki[i].szerokosc)){
                   System.out.println("Kliknalem "+i);
                   Stan.klikniecia++;
                   System.out.println(Stan.klikniecia);
                     if(Stan.klikniecia ==1){
                       Stan.x1 = pojemniki[i].polozenie_x;
                       Stan.klikniety1 =i;
                       //System.out.println("zamieniam "+i);
                   }
                     else {
                       Stan.x2 = pojemniki[i].polozenie_x;
                       Stan.klikniety2 = i;
                       //System.out.println("z "+i);
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
          
               } 
       } );
        
    }
    
    
    @Override
            public void paintComponent(Graphics gs) {
                Graphics2D g = (Graphics2D)gs;
                
               g.setColor(Color.WHITE) ;
               g.fillRect(0, (Okno.wysokosc - Stan.wysokosc_paska) , Okno.szerokosc, Stan.wysokosc_paska);
                g.setColor(Color.BLACK) ;
               g.drawRect(0, (Okno.wysokosc - Stan.wysokosc_paska) , Okno.szerokosc - 1 , Stan.wysokosc_paska -1);
             //g.drawImage(pojemniki[0].obrazek, 1024-pojemniki[0].obrazek.getWidth(null), 768-pojemniki[0].obrazek.getHeight(null),pojemniki[0].obrazek.getWidth(null) , pojemniki[0].obrazek.getHeight(null), null);
             Stan.czas_do_kolejnego++;
             if(Stan.czas_do_kolejnego > Stan.predkosc ){
             Losuj(odpady);
             Stan.czas_do_kolejnego = 0;
             };
            for (int i =0; i<Pliki.zdjecia_pojemnikow.length; i++){
            for (int j=0; j<Stan.max_odpadow_rzad; j++){
                if(odpady[i][j] != null){
                g.drawImage(odpady[i][j].obrazek, odpady[i][j].x,odpady[i][j].aktualny_y,odpady[i][j].szerokosc,odpady[i][j].wysokosc, null);
                 odpady[i][j].Ruch();
                     if((odpady[i][j].aktualny_y+odpady[i][j].wysokosc) >= (Okno.wysokosc - Stan.wysokosc_pojemnikow + odpady[i][j].wysokosc*0.3)){
                      //  System.out.println("odpad: "+(odpady[i][j].aktualny_y+odpady[i][j].wysokosc)+" Pojemnik: "+(Okno.wysokosc - Stan.wysokosc_pojemnikow + odpady[i][j].wysokosc*0.3));
                      
                        if(odpady[i][j].rodzaj == pojemniki[odpady[i][j].rzad].rodzaj)
                            Stan.punkty++;
                        
                           
                        else 
                            Stan.ilosc_zyc--;

                        //System.out.println("punkty: "+Stan.punkty+" zycia: "+Stan.ilosc_zyc);
                         //System.out.println("Odpad: "+odpady[i][j].rodzaj+" pojemnik: "+pojemniki[odpady[i][j].rzad].rodzaj);
                         ZliczajTypy(odpady[i][j].rodzaj, '-');
                         odpady[i][j] = null;
                         Stan.jest_odpadow --;
                         //System.out.println("usunietp obiekto wspolrzednych: rzad"+i+" pozycja: "+j);
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
                         g.drawImage(Pliki.drzewka[1], Okno.szerokosc/2 + 200,Okno.wysokosc - Stan.wysokosc_paska +1,40,40, null);
                    }
                    else 
                         g.drawImage(Pliki.drzewka[0], Okno.szerokosc/2 + 200,Okno.wysokosc - Stan.wysokosc_paska +1,40,40, null);
                    
                    if(Stan.ilosc_zyc > 1){
                         g.drawImage(Pliki.drzewka[1], Okno.szerokosc/2 + 250,Okno.wysokosc - Stan.wysokosc_paska +1,40,40, null);
                    }
                    else 
                         g.drawImage(Pliki.drzewka[0], Okno.szerokosc/2 + 250,Okno.wysokosc - Stan.wysokosc_paska +1,40,40, null);
                    
                    if(Stan.ilosc_zyc > 2){
                         g.drawImage(Pliki.drzewka[1], Okno.szerokosc/2 + 300,Okno.wysokosc - Stan.wysokosc_paska +1,40,40, null);
                    }
                    else 
                         g.drawImage(Pliki.drzewka[0], Okno.szerokosc/2 + 300,Okno.wysokosc - Stan.wysokosc_paska +1,40,40, null);
                    
                    if (Stan.ilosc_zyc == 0){
                         g.setColor(Color.BLACK) ;
                        g.fillRect(0, 0 , Okno.szerokosc, Okno.wysokosc);
                        g.setColor(Color.RED) ;
                        g.setFont(new Font("Serif",Font.BOLD,50));
                        g.drawString("PRZEGRANKO :(",Okno.szerokosc/2,Okno.wysokosc/2);
                        Stan.graj = false;
                    } 
                    
                  //  Przyspieszenie(Stan.punkty);
                
            }
    
            
    private void Losuj(Odpad [][] odpady) {
        int ile_przejsc = 0;
        int zapelnione_typy = 0;
         int rzad;
         int jaki;
         boolean moze_powstac;
         boolean utworzono_odpad = false;
         Random losowanie = new Random();

         
         jaki = losowanie.nextInt(Pliki.zdjecia_odpadow.length);
         while(utworzono_odpad == false){
          
         rzad = losowanie.nextInt(Pliki.zdjecia_pojemnikow.length);
        // System.out.println("Wylosowano rzad "+rzad);
         for (int i =0; i<odpady[rzad].length; i++){
             moze_powstac = true;
             //System.out.println("JEstem teraz w rzedzie "+rzad+" komorce: "+i);
             if(odpady[rzad][i] == null){  //jezeli w tej komorce nic nie ma
                 //System.out.println("Wszedlem do if ");
                 for (int j =0; j<odpady[rzad].length; j++){
                    // System.out.println("JEstem teraz w forze w rzedzie "+rzad+" komorce: "+j);
                     if(odpady[rzad][j] != null){
                     if(odpady[rzad][j].aktualny_y <= 0 )
                       moze_powstac = false;
                     }
                 }
                 if (moze_powstac != false){
                     
                     
                         for (int k=0; k<Pliki.zdjecia_pojemnikow.length; k++){
                             if(IleTegoTypu(k) > 1)
                                 zapelnione_typy++;
                             if(zapelnione_typy <Pliki.zdjecia_pojemnikow.length){
                                 while (IleTegoTypu(jaki) > 1){
                         jaki = losowanie.nextInt(Pliki.zdjecia_odpadow.length);
                                 }
                             }
                                 
                         }
                         System.out.println("losowanieponowne");
                     
                     odpady[rzad][i] = new Odpad (jaki,Pliki.zdjecia_odpadow,Stan.wysokosc_odpadow, (rzad * (Okno.szerokosc/Pliki.zdjecia_pojemnikow.length)),rzad,i);
                     utworzono_odpad = true;
                     Stan.jest_odpadow ++;
                     ZliczajTypy(odpady[rzad][i].rodzaj, '+');
                    
                    // System.out.println("stworzono obiekt nr "+Stan.jest_odpadow+" o wspolrzednych: rzad"+rzad+" pozycja: "+i+" typu: "+odpady[rzad][i].rodzaj);
                     // System.out.println("jest: " +IleTegoTypu(jaki)+" odpadow typu "+odpady[rzad][i].rodzaj);
             }
             
         }
   
                     

    }     
         ile_przejsc ++;
         System.out.println(ile_przejsc);
         if ((Pliki.zdjecia_pojemnikow.length*Stan.max_odpadow_rzad)> ile_przejsc) //oznacza to ze doszlo do zapetlenia i nie da sie stworzyc nowego odpadu 
             utworzono_odpad = true;// w takim przypadku nalezy opuscic petle i poczekac az jakis odpad zostanie usuniety
        
    }
    }
    
    private void ZliczajTypy(Odpad.Rodzaj rodzaj, char operacja){
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
    
    private int IleTegoTypu(int jaki){
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
        }
        return ile;
    }
    
    private void Przyspieszenie(int punkty){
        if (punkty != 0){
        if(punkty%5 == 0){
            Stan.predkosc = Stan.predkosc - 20;
            Stan.mozna_przyspieszyc = false;
            //System.out.println("Przyspieszenie");
        }
        else Stan.mozna_przyspieszyc = true;
        
    }
    }
    
    private void StanPoczatkowy(){
        Stan.mozna_przyspieszyc = true;
        Stan.predkosc = 200;
        Stan.graj = true;
        Stan.wysokosc_paska = 50;
        Stan.jest_odpadow =0;
        Stan.ile_bio =0;
        Stan.ile_elektro =0;
        Stan.ile_leki =0;
        Stan.ile_metal =0;
        Stan.ile_papier = 0;
        Stan.ile_szklo =0;
        pierwszy = new Odpad (0,Pliki.zdjecia_odpadow,Stan.wysokosc_odpadow, (1 * (Okno.szerokosc/Pliki.zdjecia_pojemnikow.length)),1,2);
        Stan.czas_do_kolejnego = 201 ;
        Stan.ilosc_zyc =3;
        Stan.punkty =0;
        Stan.klikniecia = 0;
        Stan.bufor = new Pojemnik(0,Pliki.zdjecia_odpadow,150);
        Stan.wysokosc_odpadow = 150;
        Stan.wysokosc_pojemnikow = 150;
        //pierwszy = new Odpad(4, Pliki.zdjecia_odpadow,Stan.wysokosc_odpadow);
        pojemniki = new Pojemnik [Pliki.zdjecia_pojemnikow.length];
        Stan.max_odpadow_rzad = (Okno.wysokosc - Stan.wysokosc_pojemnikow)/Stan.wysokosc_odpadow;
        //System.out.println(Stan.max_odpadow_rzad);
        odpady = new Odpad [Pliki.zdjecia_pojemnikow.length][Stan.max_odpadow_rzad];
        for (int i =0; i<Pliki.zdjecia_pojemnikow.length; i++){
            for (int j=0; j<Stan.max_odpadow_rzad; j++){
                odpady[i][j] = null;
                
            }
                
        }
      //  odpady[4][3] = new Odpad (3,Pliki.zdjecia_odpadow,Stan.wysokosc_odpadow, (4 * (Okno.szerokosc/Pliki.zdjecia_pojemnikow.length)),4,3);
        // odpady[0][1] = new Odpad (1,Pliki.zdjecia_odpadow,Stan.wysokosc_odpadow, (0 * (Okno.szerokosc/Pliki.zdjecia_pojemnikow.length)),0,1);
        for (int i=0 ; i < Pliki.zdjecia_pojemnikow.length ; i++){
            pojemniki[i] = new Pojemnik(i, Pliki.zdjecia_pojemnikow,Stan.wysokosc_pojemnikow);
            pojemniki[i].polozenie_y = 768-150-Stan.wysokosc_paska;
            pojemniki[i].polozenie_x =  i * (1024/6);    //(pojemniki[i].obrazek.getWidth(null)); 
            
            
        }
    }
    
    

} 