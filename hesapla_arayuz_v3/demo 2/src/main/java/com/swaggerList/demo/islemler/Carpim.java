package com.swaggerList.demo.islemler;
import com.swaggerList.demo.service.baseIslem.BaseIslem;

public class Carpim extends BaseIslem {

    public Carpim(int firstNum, int secondNum) {
        super(firstNum, secondNum);
    }

    public int calculate() {
        return firstNum * secondNum;
    }
}

// BaseIslem sınıfından türemiştir. calculate metodunu override ederek, çarpma işlemini yapar.
