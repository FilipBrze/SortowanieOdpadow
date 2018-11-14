
package sortowanie_odpadow;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.lang.Thread.sleep;
import java.util.Random;
import javax.swing.JPanel;
import static sortowanie_odpadow.Stan.odpady;
import static sortowanie_odpadow.Stan.pojemniki;


public class RysujGre extends JPanel {
    
    

    Odpad pierwszy;
    

    

    RysujGre() throws InterruptedException{
        super ();

        StanPoczatkowy();
       
       addMouseListener(new MouseAdapter(){
            @Override
          public void mouseClicked(MouseEvent me){

          for(int i=0; i<pojemniki.length; i++){
           if(me.getY()>(768-150)){
               if(me.getX()>pojemniki[i].polozenie_x && me.getX()<(pojemniki[i].polozenie_x+pojemniki[i].szerokosc)){
                   //System.out.println("Kliknalem "+i);
                   Stan.klikniecia++;
                   //System.out.println(Stan.klikniecia);
                     if(Stan.klikniecia ==1){
                       Stan.x1 = Stan.pojemniki[i].polozenie_x;
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



             
            for (int i =0; i<Pliki.zdjecia_pojemnikow.length; i++){
            for (int j=0; j<Stan.max_odpadow_rzad; j++){
                if(odpady[i][j] != null){
                g.drawImage(odpady[i][j].obrazek, odpady[i][j].x,odpady[i][j].aktualny_y,odpady[i][j].szerokosc,odpady[i][j].wysokosc, null);
                 odpady[i][j].Ruch();
                   
                     
                 
                }
            }
                
        }       
             for (int i=0; i<Pliki.zdjecia_pojemnikow.length; i++){
                    g.drawImage(Stan.pojemniki[i].obrazek, Stan.pojemniki[i].polozenie_x, Stan.pojemniki[i].polozenie_y,Stan.pojemniki[i].szerokosc ,Stan.pojemniki[i].wysokosc , null);
                } 
               /* g.drawImage(pierwszy.obrazek, pierwszy.x,pierwszy.aktualny_y,pierwszy.szerokosc,pierwszy.wysokosc, null);
               System.out.println("odpad: "+(pierwszy.aktualny_y+pierwszy.wysokosc)+" Pojemnik: "+(Okno.wysokosc - Stan.wysokosc_pojemnikow + pierwszy.wysokosc*0.3));
               pierwszy.Ruch(); */
            }
    
            

    
    private void StanPoczatkowy(){
        pierwszy = new Odpad (0,Pliki.zdjecia_odpadow,Stan.wysokosc_odpadow, (1 * (Okno.szerokosc/Pliki.zdjecia_pojemnikow.length)),1,2);
        Stan.czas_do_kolejnego = 0 ;
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
        Stan.odpady = new Odpad[Pliki.zdjecia_pojemnikow.length][Stan.max_odpadow_rzad];
        for (int i =0; i<Pliki.zdjecia_pojemnikow.length; i++){
            for (int j=0; j<Stan.max_odpadow_rzad; j++){
                Stan.odpady[i][j] = null;
            }
        }
        
        
        for (int i=0 ; i < Pliki.zdjecia_pojemnikow.length ; i++){
            pojemniki[i] = new Pojemnik(i, Pliki.zdjecia_pojemnikow,Stan.wysokosc_pojemnikow);
            pojemniki[i].polozenie_y = 768-150;
            pojemniki[i].polozenie_x =  i * (1024/6);    //(pojemniki[i].obrazek.getWidth(null)); 
            
            
        }
    }

    }     



