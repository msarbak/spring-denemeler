package com.swaggerList.demo.canlilar.sekiller;

import com.swaggerList.demo.canlilar.Sekil;

public class Ucgen extends Sekil {
   private int kenarA,kenarB,kenarC, yukseklik;

   public Ucgen(int kenarA, int kenarB, int kenarC, int yukseklik) {
       this.kenarA = kenarA;
       this.kenarB = kenarB;
       this.kenarC = kenarC;
       this.yukseklik = yukseklik;
   }

   @Override
    public int alanHesapla(){
       return (kenarA * yukseklik) / 2;
   }

   @Override
    public int cevreHesapla(){
       return (kenarA + kenarB + kenarC);
   }
}
