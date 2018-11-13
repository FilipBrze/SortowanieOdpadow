
package sortowanie_odpadow;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.lang.Thread.sleep;
import javax.swing.JPanel;


public class RysujGre extends JPanel {
    
    

    Odpad pierwszy;
    private Pojemnik [] pojemniki;
  
    

    RysujGre() throws InterruptedException{
        super ();
        Stan.klikniecia = 0;
        Stan.bufor = new Pojemnik(0,Pliki.zdjecia_odpadow);
        pierwszy = new Odpad(4, Pliki.zdjecia_odpadow);
        pojemniki = new Pojemnik [Pliki.zdjecia_pojemnikow.length];
        for (int i=0 ; i < Pliki.zdjecia_pojemnikow.length ; i++){
            pojemniki[i] = new Pojemnik(i, Pliki.zdjecia_pojemnikow);
            pojemniki[i].polozenie_y = 768-150;
            pojemniki[i].polozenie_x = 0 + i * (1024/6);    //(pojemniki[i].obrazek.getWidth(null)); 
            
            
        }
      
       
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
                
                for (int i=0; i<Pliki.zdjecia_pojemnikow.length; i++){
                    g.drawImage(pojemniki[i].obrazek, pojemniki[i].polozenie_x, pojemniki[i].polozenie_y,pojemniki[i].szerokosc ,150 , null);
                } 
             //g.drawImage(pojemniki[0].obrazek, 1024-pojemniki[0].obrazek.getWidth(null), 768-pojemniki[0].obrazek.getHeight(null),pojemniki[0].obrazek.getWidth(null) , pojemniki[0].obrazek.getHeight(null), null);
                
                g.drawImage(pierwszy.obrazek, pierwszy.poczatkowy_x,pierwszy.aktualny_y,1024/6,150, null);
                pierwszy.Ruch();
            }
    
            
   /* private void RozpocznijGre() throws InterruptedException{
         
        for (int i =0; i<10; i++){
        pierwszy.Ruch();
        System.out.println(pierwszy.aktualny_y);
        repaint();
        sleep(500);
           
        }

    }      */  

}

