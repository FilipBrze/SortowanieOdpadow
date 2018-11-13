
package sortowanie_odpadow;

import java.awt.Image;


public class Odpad {
    
    public enum  Rodzaj{
    PLASTIK_METAL , SZKLO, PAPIER, BIODEGRADOWALNE, LEKI, ELEKTRONIKA
}; 
    
   int jaki ; //numer okresla jaki odpad sie pojawi
   Rodzaj rodzaj;
  public Image obrazek;
   public boolean wpadl = false; // false jezeli nie wpadl do pojemnika, true jezeli wpadl
   int dy = 1;
   int poczatkowy_x = 0;
   int poczatkowy_y = 0;
   int aktualny_y = 0;
        
   private Rodzaj Okresl_rodzaj (int jaki){
    
       switch (jaki){
           case 0: this.rodzaj = Rodzaj.PLASTIK_METAL; // butelka plastikowa
           break;
           case 1: this.rodzaj = Rodzaj.PLASTIK_METAL; // puszka
           break;
           case 2: this.rodzaj = Rodzaj.SZKLO; // butelka szklana
           break;
           case 3: this.rodzaj = Rodzaj.PAPIER; // gazety      
           break;
           case 4: this.rodzaj = Rodzaj.BIODEGRADOWALNE; //ogryzek
           break;
           case 5: this.rodzaj = Rodzaj.ELEKTRONIKA; // pilot
           break;
           case 6: this.rodzaj = Rodzaj.ELEKTRONIKA; // zarowka
           break;
           case 7: this.rodzaj = Rodzaj.ELEKTRONIKA; // bateria
           break;
           case 8: this.rodzaj = Rodzaj.ELEKTRONIKA;//plyta 
           break;
           case 9: this.rodzaj = Rodzaj.LEKI; // leki
           break;
           case 10: this.rodzaj = Rodzaj.PAPIER; //karton
           break;
           
          
       }
       return rodzaj;
};
    

    
    Odpad (int jaki, Image [] obrazki){
        this.jaki = jaki;
        this.rodzaj = Okresl_rodzaj(jaki);
        this.obrazek = obrazki[jaki];
    };
    
    public void Ruch ()
    {
       this.aktualny_y = aktualny_y + dy;  
       
    };
    
    
    
}
