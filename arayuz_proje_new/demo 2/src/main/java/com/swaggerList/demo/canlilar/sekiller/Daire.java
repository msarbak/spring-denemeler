package com.swaggerList.demo.canlilar.sekiller;

import com.swaggerList.demo.canlilar.Sekil;

public class Daire extends Sekil {
    private int yaricap;

    public Daire(int yaricap) {
        this.yaricap = yaricap;
    }

    @Override
    public int alanHesapla() {
        return (int) (Math.PI * yaricap * yaricap);
    }

    @Override
    public int cevreHesapla() {
        return (int) (2 * Math.PI * yaricap);
    }
}

