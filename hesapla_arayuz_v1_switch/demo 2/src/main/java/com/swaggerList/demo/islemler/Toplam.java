package com.swaggerList.demo.islemler;


import com.swaggerList.demo.service.intf.IslemService;

public class Toplam implements IslemService {
    private int sayi1;
    private int sayi2;

    public Toplam(int sayi1, int sayi2) {
        this.sayi1 = sayi1;
        this.sayi2 = sayi2;
    }

    @Override
    public int hesapla() {
        return sayi1 + sayi2;
    }

    public int getSayi1() {
        return sayi1;
    }

    public void setSayi1(int sayi1) {
        this.sayi1 = sayi1;
    }

    public int getSayi2() {
        return sayi2;
    }

    public void setSayi2(int sayi2) {
        this.sayi2 = sayi2;
    }
}


