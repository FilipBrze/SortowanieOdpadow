
package sortowanie_odpadow;

import java.awt.Image;
import java.util.Random;


public class Odpad {
    
    public enum  Rodzaj{
    PLASTIK_METAL , SZKLO, PAPIER, BIODEGRADOWALNE, LEKI, ELEKTRONIKA
}; 
    
   int jaki ; //numer okresla jaki odpad sie pojawi
   Rodzaj rodzaj;
  public Image obrazek;
   public boolean wpadl = false; // false jezeli nie wpadl do pojemnika, true jezeli wpadl
   int dy;
   int x;
   int poczatkowy_y;
   int aktualny_y;
   int wysokosc;
   int szerokosc;
   int rzad;
   int pozycja;
   private Rodzaj okresl_rodzaj (int jaki){
    
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
           case 11: this.rodzaj = Rodzaj.PAPIER; //chusteczki
           break;
           case 12: this.rodzaj = Rodzaj.PAPIER; //kubek papierowy
           break;
           case 13: this.rodzaj = Rodzaj.PLASTIK_METAL; //papier po czekoladzie
           break;
           case 14: this.rodzaj = Rodzaj.SZKLO; //szklanka
           break;
           case 15: this.rodzaj = Rodzaj.LEKI; //syrop
           break;
           case 16: this.rodzaj = Rodzaj.BIODEGRADOWALNE; //worek po herbacie
           break;
           case 17: this.rodzaj = Rodzaj.BIODEGRADOWALNE; //skorupka jaja
           break;
           case 18: this.rodzaj = Rodzaj.SZKLO; //kieliszek
           break;
           case 19: this.rodzaj = Rodzaj.PLASTIK_METAL; //siatka plastikowa
           break;
           case 20: this.rodzaj = Rodzaj.LEKI; //strzykawka
           break;
           case 21: this.rodzaj = Rodzaj.BIODEGRADOWALNE; //skorka banana
           break;
           case 22: this.rodzaj = Rodzaj.LEKI; //masc
           break;
           case 23: this.rodzaj = Rodzaj.SZKLO; //sloik
           break;
           
          
       }
       return rodzaj;
};
    

    
    Odpad (int jaki, Image [] obrazki, int wysokosc, int x, int rzad, int pozycja){
        dy = 1;
        this.wysokosc = wysokosc;
        szerokosc = Okno.szerokosc/Pliki.zdjecia_pojemnikow.length;
        this.x =x ;
        poczatkowy_y = -wysokosc;
        aktualny_y = -wysokosc;
        this.jaki = jaki;
        this.rodzaj = okresl_rodzaj(jaki);
        this.obrazek = obrazki[jaki];
        this.rzad = rzad;
        this.pozycja = pozycja;
        
    };
    
    public void ruch ()
    {
       this.aktualny_y = aktualny_y + dy;  
    };
    
    
    
}
