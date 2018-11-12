
package sortowanie_odpadow;

import java.awt.Image;
import javax.swing.ImageIcon;



public class Pliki {
    
   public  static Image[] zdjecia_odpadow;
   public  static Image[] zdjecia_pojemnikow;
   public static Image [] drzewka;
   
   Pliki(){
   };
   
   public static void LadujObrazki(){
       
       zdjecia_odpadow = new Image[11];
       
       zdjecia_odpadow [0] = Laduj("Images/butelkaplastik.png");
       zdjecia_odpadow [1] = Laduj("Images/puszka.png");
       zdjecia_odpadow [2] = Laduj("Images/butelkaszklo.png");
       zdjecia_odpadow [3] = Laduj("Images/makulatura.png");
       zdjecia_odpadow [4] = Laduj("Images/ogryzek.png");
       zdjecia_odpadow [5] = Laduj("Images/pilot.png");
       zdjecia_odpadow [6] = Laduj("Images/zarowka.png");       
       zdjecia_odpadow [7] = Laduj("Images/bateria.png");
       zdjecia_odpadow [8] = Laduj("Images/CD.png");
       zdjecia_odpadow [9] = Laduj("Images/leki.png");
       zdjecia_odpadow [10] = Laduj("Images/karton.png");
       
       zdjecia_pojemnikow = new Image[6];
       
       zdjecia_pojemnikow [0] = Laduj("Images/plastikmetal.png");
       zdjecia_pojemnikow [1] = Laduj("Images/szklo.png");
       zdjecia_pojemnikow [2] = Laduj("Images/papier.png");
       zdjecia_pojemnikow [3] = Laduj("Images/biodegradowalne.png");
       zdjecia_pojemnikow [4] = Laduj("Images/elektronika.png");
       zdjecia_pojemnikow [5] = Laduj("Images/apteka.png");
       
       drzewka = new Image[2];
       
       drzewka [0] = Laduj("Images/drzewo_uschniete.png");
       drzewka [1] = Laduj("Images/drzewo_zdrowe.png");
   } ;
     
    /* public void Laduj_Pliki (Image[] zdjecia_odpadow){
     
       this.zdjecia_odpadow [0] = new ImageIcon ("Images/butelkaplastik.png").getImage();
       this.zdjecia_odpadow [1] = new ImageIcon ("Images/puszka.jpg").getImage();
       this.zdjecia_odpadow [2] = new ImageIcon ("Images/butelkaszklo.jpg").getImage();
       this.zdjecia_odpadow [3] = new ImageIcon ("Images/makulatura.jpg").getImage();
       this.zdjecia_odpadow [4] = new ImageIcon ("Images/ogryzek.jpg").getImage();
       this.zdjecia_odpadow [5] = new ImageIcon ("Images/pilot.jpg").getImage();
       this.zdjecia_odpadow [6] = new ImageIcon ("Images/zarowka.jpg").getImage();       
       this.zdjecia_odpadow [7] = new ImageIcon ("Images/bateria.jpg").getImage();
       this.zdjecia_odpadow [8] = new ImageIcon ("Images/CD.jpg").getImage();
       this.zdjecia_odpadow [9] = new ImageIcon ("Images/leki.jpg").getImage();
       this.zdjecia_odpadow [10] = new ImageIcon ("Images/karton.jpg").getImage();
     };  */
   
   public static Image Laduj(String nazwa_pliku) {
        return new ImageIcon(nazwa_pliku).getImage();
    }
   
}
