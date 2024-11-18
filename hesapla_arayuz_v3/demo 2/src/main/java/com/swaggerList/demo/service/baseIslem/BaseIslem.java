package com.swaggerList.demo.service.baseIslem;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseIslem  {
    protected int firstNum;
    protected int secondNum;

    public BaseIslem(int firstNum, int secondNum) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
    }

    public int calculate(){
        return 0;
    }

}
//Tüm işlem sınıfları için ortak özellikleri ve davranışları tanımlar.
//Tüm işlemlerBaseIslem sınıfından türemektedir. Bu sınıf, her işlem türünün paylaşacağı ortak değişkenleri (firstNum ve secondNum) tanımlar.
//firstNum ve secondNum değişkenleri, BaseIslem ve türetilmiş sınıflardan erişilebilir
