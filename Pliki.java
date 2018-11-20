
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
       
       zdjecia_odpadow = new Image[24];
       
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
       zdjecia_odpadow [11] = Laduj("Images/chusteczki.png");
       zdjecia_odpadow [12] = Laduj("Images/kubekpapierowy.png");
       zdjecia_odpadow [13] = Laduj("Images/czekolada.png");
       zdjecia_odpadow [14] = Laduj("Images/szklanka.png");
       zdjecia_odpadow [15] = Laduj("Images/syrop.png");
       zdjecia_odpadow [16] = Laduj("Images/herbata.png");
       zdjecia_odpadow [17] = Laduj("Images/jajko.png");
       zdjecia_odpadow [18] = Laduj("Images/kieliszek.png");
       zdjecia_odpadow [19] = Laduj("Images/siatka.png");
       zdjecia_odpadow [20] = Laduj("Images/strzykawka.png");
       zdjecia_odpadow [21] = Laduj("Images/banan.png");
       zdjecia_odpadow [22] = Laduj("Images/masc.png");
       zdjecia_odpadow [23] = Laduj("Images/sloik.png");
      
       
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
     

   
   public static Image Laduj(String nazwa_pliku) {
        return new ImageIcon(nazwa_pliku).getImage();
    }
   
}
