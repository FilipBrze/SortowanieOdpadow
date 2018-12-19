
package sortowanie_odpadow;

import java.awt.Image;


public class Pojemnik {
    int jaki;
    Odpad.Rodzaj rodzaj;
    public Image obrazek;
    int polozenie_x;
    int polozenie_y ;
    boolean klikniety;
    int szerokosc;
    int wysokosc;
    
    
    Pojemnik(int jaki, Image [] obrazki, int wysokosc){
        klikniety = false;
        this.rodzaj = okresl_rodzaj (jaki);
        this.obrazek = obrazki [jaki];
        szerokosc = Okno.szerokosc/Pliki.zdjecia_pojemnikow.length; 
        this.wysokosc = wysokosc;
    }
    
    private Odpad.Rodzaj okresl_rodzaj (int jaki){
    
       switch (jaki){
           case 0: this.rodzaj = Odpad.Rodzaj.PLASTIK_METAL; // butelka plastikowa
           break;
           case 1: this.rodzaj = Odpad.Rodzaj.SZKLO; // puszka
           break;
           case 2: this.rodzaj = Odpad.Rodzaj.PAPIER; // butelka szklana
           break;
           case 3: this.rodzaj = Odpad.Rodzaj.BIODEGRADOWALNE; // gazety      
           break;
           case 4: this.rodzaj = Odpad.Rodzaj.ELEKTRONIKA; //ogryzek
           break;
           case 5: this.rodzaj = Odpad.Rodzaj.LEKI; // pilot
           break;
            }
       return rodzaj;
};
    
    public void ustawKlikniecie(boolean klikniety){
        this.klikniety = klikniety;

    };
    
    
}
