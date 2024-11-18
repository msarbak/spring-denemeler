package com.swaggerList.demo.islemler;
import com.swaggerList.demo.service.baseIslem.BaseIslem;



public class Toplam extends BaseIslem {

    public Toplam(int number1, int number2) {
        super(number1, number2);
    }

    @Override
    public int calculate() {
        return number1 + number2;
    }
}

//iki sayının toplamını hesaplar.
// BaseIslem sınıfından türemiştir. calculate metodunu override ederek, toplama işlemini yapar.