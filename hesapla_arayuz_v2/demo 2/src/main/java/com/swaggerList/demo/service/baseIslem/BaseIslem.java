package com.swaggerList.demo.service.baseIslem;

import com.swaggerList.demo.service.baseIslem.intf.Islem;



public abstract class BaseIslem implements Islem {
    protected int number1;
    protected int number2;

    public BaseIslem(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }
}


//Tüm işlem sınıfları için ortak özellikleri ve davranışları tanımlar.
//Tüm işlemlerBaseIslem sınıfından türemektedir. Bu sınıf, her işlem türünün paylaşacağı ortak değişkenleri (firstNum ve secondNum) tanımlar.
//firstNum ve secondNum değişkenleri, BaseIslem ve türetilmiş sınıflardan erişilebilir
