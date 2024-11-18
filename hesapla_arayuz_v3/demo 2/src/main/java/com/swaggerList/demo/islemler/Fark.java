package com.swaggerList.demo.islemler;
import com.swaggerList.demo.service.baseIslem.BaseIslem;

public class Fark extends BaseIslem {

    public Fark(int firstNum, int secondNum) {
        super(firstNum, secondNum);
    }


    public int calculate() {
        return firstNum - secondNum;
    }
}

//iki sayının farkını hesaplar.
// BaseIslem sınıfından türemiştir. calculate metodunu override ederek, çıkarma işlemini yapar.

