
package sortowanie_odpadow;

import java.awt.Image;
import javax.swing.ImageIcon;



public class Pliki {
    
   public  static Image[] zdjecia_odpadow;
   public  static Image[] zdjecia_pojemnikow;
   public static Image [] drzewka;
   
   Pliki(){
   };
   
   public static void ladujObrazki(){
       
       zdjecia_odpadow = new Image[24];
       
       zdjecia_odpadow [0] = laduj("Images/butelkaplastik.png");
       zdjecia_odpadow [1] = laduj("Images/puszka.png");
       zdjecia_odpadow [2] = laduj("Images/butelkaszklo.png");
       zdjecia_odpadow [3] = laduj("Images/makulatura.png");
       zdjecia_odpadow [4] = laduj("Images/ogryzek.png");
       zdjecia_odpadow [5] = laduj("Images/pilot.png");
       zdjecia_odpadow [6] = laduj("Images/zarowka.png");       
       zdjecia_odpadow [7] = laduj("Images/bateria.png");
       zdjecia_odpadow [8] = laduj("Images/CD.png");
       zdjecia_odpadow [9] = laduj("Images/leki.png");
       zdjecia_odpadow [10] = laduj("Images/karton.png");
       zdjecia_odpadow [11] = laduj("Images/chusteczki.png");
       zdjecia_odpadow [12] = laduj("Images/kubekpapierowy.png");
       zdjecia_odpadow [13] = laduj("Images/czekolada.png");
       zdjecia_odpadow [14] = laduj("Images/szklanka.png");
       zdjecia_odpadow [15] = laduj("Images/syrop.png");
       zdjecia_odpadow [16] = laduj("Images/herbata.png");
       zdjecia_odpadow [17] = laduj("Images/jajko.png");
       zdjecia_odpadow [18] = laduj("Images/kieliszek.png");
       zdjecia_odpadow [19] = laduj("Images/siatka.png");
       zdjecia_odpadow [20] = laduj("Images/strzykawka.png");
       zdjecia_odpadow [21] = laduj("Images/banan.png");
       zdjecia_odpadow [22] = laduj("Images/masc.png");
       zdjecia_odpadow [23] = laduj("Images/sloik.png");
      
       
       zdjecia_pojemnikow = new Image[6];
       
       zdjecia_pojemnikow [0] = laduj("Images/plastikmetal.png");
       zdjecia_pojemnikow [1] = laduj("Images/szklo.png");
       zdjecia_pojemnikow [2] = laduj("Images/papier.png");
       zdjecia_pojemnikow [3] = laduj("Images/biodegradowalne.png");
       zdjecia_pojemnikow [4] = laduj("Images/elektronika.png");
       zdjecia_pojemnikow [5] = laduj("Images/apteka.png");
       
       drzewka = new Image[2];
       
       drzewka [0] = laduj("Images/drzewo_uschniete.png");
       drzewka [1] = laduj("Images/drzewo_zdrowe.png");
   } ;
     

   
   public static Image laduj(String nazwa_pliku) {
        return new ImageIcon(nazwa_pliku).getImage();
    }
   
}
