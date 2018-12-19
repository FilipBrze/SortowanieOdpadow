
package sortowanie_odpadow;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;



public class Pliki {
    
   public  static Image[] zdjecia_odpadow;
   public  static Image[] zdjecia_pojemnikow;
   public static Image [] drzewka;
   public static Image zakoncz;
   public static File correct;
   public static File wrong;
   
   Pliki(){
   };
   
   public static void ladujObrazki(){
       
       zdjecia_odpadow = new Image[24];
       
       zdjecia_odpadow [0] = laduj("res/Images/butelkaplastik.png");
       zdjecia_odpadow [1] = laduj("res/Images/puszka.png");
       zdjecia_odpadow [2] = laduj("res/Images/butelkaszklo.png");
       zdjecia_odpadow [3] = laduj("res/Images/makulatura.png");
       zdjecia_odpadow [4] = laduj("res/Images/ogryzek.png");
       zdjecia_odpadow [5] = laduj("res/Images/pilot.png");
       zdjecia_odpadow [6] = laduj("res/Images/zarowka.png");       
       zdjecia_odpadow [7] = laduj("res/Images/bateria.png");
       zdjecia_odpadow [8] = laduj("res/Images/CD.png");
       zdjecia_odpadow [9] = laduj("res/Images/leki.png");
       zdjecia_odpadow [10] = laduj("res/Images/karton.png");
       zdjecia_odpadow [11] = laduj("res/Images/chusteczki.png");
       zdjecia_odpadow [12] = laduj("res/Images/kubekpapierowy.png");
       zdjecia_odpadow [13] = laduj("res/Images/czekolada.png");
       zdjecia_odpadow [14] = laduj("res/Images/szklanka.png");
       zdjecia_odpadow [15] = laduj("res/Images/syrop.png");
       zdjecia_odpadow [16] = laduj("res/Images/herbata.png");
       zdjecia_odpadow [17] = laduj("res/Images/jajko.png");
       zdjecia_odpadow [18] = laduj("res/Images/kieliszek.png");
       zdjecia_odpadow [19] = laduj("res/Images/siatka.png");
       zdjecia_odpadow [20] = laduj("res/Images/strzykawka.png");
       zdjecia_odpadow [21] = laduj("res/Images/banan.png");
       zdjecia_odpadow [22] = laduj("res/Images/masc.png");
       zdjecia_odpadow [23] = laduj("res/Images/sloik.png");
      
       
       zdjecia_pojemnikow = new Image[6];
       
       zdjecia_pojemnikow [0] = laduj("res/Images/plastikmetal.png");
       zdjecia_pojemnikow [1] = laduj("res/Images/szklo.png");
       zdjecia_pojemnikow [2] = laduj("res/Images/papier.png");
       zdjecia_pojemnikow [3] = laduj("res/Images/biodegradowalne.png");
       zdjecia_pojemnikow [4] = laduj("res/Images/elektronika.png");
       zdjecia_pojemnikow [5] = laduj("res/Images/apteka.png");
       
       drzewka = new Image[2];
       
       drzewka [0] = laduj("res/Images/drzewo_uschniete.png");
       drzewka [1] = laduj("res/Images/drzewo_zdrowe.png");
       
       zakoncz = laduj("res/Images/X.png");
       
       correct = new File("res/Sounds/correct.wav");
       wrong = new File("res/Sounds/wrong.wav");
   } ;
     

   
   public static Image laduj(String nazwa_pliku) {
        return new ImageIcon(nazwa_pliku).getImage();
    }
   
}
