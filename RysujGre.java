
package sortowanie_odpadow;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import static java.lang.Thread.sleep;
import javax.swing.JPanel;


public class RysujGre extends JPanel {
    

   Odpad pierwszy;
    private Pojemnik [] pojemniki;
  
    

    RysujGre() throws InterruptedException{
        super ();
        pierwszy = new Odpad(4, Pliki.zdjecia_odpadow);
        pojemniki = new Pojemnik [Pliki.zdjecia_pojemnikow.length];
        for (int i=0 ; i < Pliki.zdjecia_pojemnikow.length ; i++){
            pojemniki[i] = new Pojemnik(i, Pliki.zdjecia_pojemnikow);
            pojemniki[i].polozenie_y = 768-150;
            pojemniki[i].polozenie_x = 0 + i * (1024/6);    //(pojemniki[i].obrazek.getWidth(null)); 
        }
       
        
    }
    
    
    @Override
            public void paintComponent(Graphics gs) {
                Graphics2D g = (Graphics2D)gs;
                
                for (int i=0; i<Pliki.zdjecia_pojemnikow.length; i++){
                    g.drawImage(pojemniki[i].obrazek, pojemniki[i].polozenie_x, pojemniki[i].polozenie_y,1024/6 ,150 , null);
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

