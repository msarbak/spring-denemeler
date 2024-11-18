package com.swaggerList.demo.canlilar.sekiller;

import com.swaggerList.demo.canlilar.Sekil;

public class Kare extends Sekil {
    private int kenar;

    public Kare(int kenar){
        this.kenar = kenar;
    }

    @Override
    public int alanHesapla() {
        return (kenar * kenar);
    }

    @Override
    public int cevreHesapla(){
        return (4 * kenar);
    }
}
