package com.swaggerList.demo.islemler;
import com.swaggerList.demo.service.baseIslem.BaseIslem;

public class Toplam extends BaseIslem {

    public Toplam(int firstNum, int secondNum) {
        super(firstNum, secondNum);
    }


    public int calculate() {
        return firstNum + secondNum;
    }
}

//iki sayının toplamını hesaplar.
// BaseIslem sınıfından türemiştir. calculate metodunu override ederek, toplama işlemini yapar.