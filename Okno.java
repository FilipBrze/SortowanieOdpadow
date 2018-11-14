
package sortowanie_odpadow ;

import java.awt.GridLayout;
import static java.lang.Thread.sleep;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Okno extends JFrame {
    
    public static int wysokosc  ;
    public static int szerokosc;
    int x_srodka;
    int y_srodka;

    
    Okno(int szerokosc, int wysokosc, int x_srodka, int y_srodka) throws InterruptedException{
        super ();
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
        this.x_srodka = x_srodka;
        this.y_srodka = y_srodka;
        setSize(szerokosc, wysokosc);
        setLocation(x_srodka,y_srodka);
       setResizable(false); 
        setUndecorated(true); 
         initGUI();
        setVisible(true); 
        
       animationLoop();
        
        
    }
    
   
    
    public void initGUI() throws InterruptedException {
      
       // JPanel obrazPanel = new RysujGre();
        Pliki.LadujObrazki();     
        add(new RysujGre());
    }
    
    private void animationLoop() {

        
        while (true) {
            
                    try {
            Thread.sleep(5);
          } catch (InterruptedException ex) {System.out.println("Wyjątek: "+ex);      }
             
          losuj(Stan.odpady);
      System.out.println("HALO");
            for (int i =0; i<Pliki.zdjecia_pojemnikow.length; i++){
                for (int j=0; j<Stan.max_odpadow_rzad; j++){
                    if(Stan.odpady[i][j] != null){
                        if((Stan.odpady[i][j].aktualny_y+Stan.odpady[i][j].wysokosc) >= (Okno.wysokosc - Stan.wysokosc_pojemnikow + Stan.odpady[i][j].wysokosc*0.3)){
                            if(Stan.odpady[i][j].rodzaj == Stan.pojemniki[Stan.odpady[i][j].rzad].rodzaj)
                             Stan.punkty++;
                            else 
                            Stan.ilosc_zyc--;
                         Stan.odpady[i][j] = null;
                     }
                    }   
                }
            } 
        
          repaint();
        
          
        }
    }
    
    
        
        public void losuj(Odpad [][] odpady) {
                   
         int rzad;
         int jaki;
         boolean moze_powstac = true;
         int utworzono_odpad = 0;
         Random losowanie = new Random();
         
         jaki = losowanie.nextInt(Pliki.zdjecia_odpadow.length);
        
         while(utworzono_odpad == 0){
        
    
         rzad = losowanie.nextInt(Pliki.zdjecia_pojemnikow.length);
         for (int i =0; i<Stan.max_odpadow_rzad; i++){
             if (odpady[rzad][i] != null){
                
                 if(odpady[rzad][i].aktualny_y <= 0){
                 moze_powstac = true;
                 
             }
                 else
                     moze_powstac = false;
                  
             }
         }
         
         for (int i =0; i<Stan.max_odpadow_rzad; i++){
             if (odpady[rzad][i] == null){
              
                 if (moze_powstac == true){
                     odpady[rzad][i] = new Odpad(jaki,Pliki.zdjecia_odpadow,Stan.wysokosc_odpadow, (rzad * (Okno.szerokosc/Pliki.zdjecia_pojemnikow.length)),rzad,i);
                     utworzono_odpad = 1;
                     //System.out.println("Utworzono element: "+licz);
                 }
             }
         }
    }      
        
    }
    
    
}
