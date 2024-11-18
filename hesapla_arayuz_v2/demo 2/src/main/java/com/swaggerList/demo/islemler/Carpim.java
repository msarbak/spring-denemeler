package com.swaggerList.demo.islemler;
import com.swaggerList.demo.service.baseIslem.BaseIslem;



public class Carpim extends BaseIslem {

    public Carpim(int number1, int number2) {
        super(number1, number2);
    }

    @Override
    public int calculate() {
        return number1 * number2;
    }
}


// BaseIslem sınıfından türemiştir. calculate metodunu override ederek, çarpma işlemini yapar.
