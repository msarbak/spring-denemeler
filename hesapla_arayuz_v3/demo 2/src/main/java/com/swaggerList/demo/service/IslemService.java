package com.swaggerList.demo.service;

import com.swaggerList.demo.service.baseIslem.BaseIslem;
import com.swaggerList.demo.service.baseIslem.intf.Islem;
import org.springframework.stereotype.Service;


@Service
public class IslemService implements Islem {

    /*public int islemYap(BaseIslem islem) {
        return islem.calculate();
    }*/

    @Override
    public int calculate(BaseIslem baseIslem) {
        return baseIslem.calculate();
    }
}

//İşlem nesnelerini işleyen bir servis sağlar.
//uygulamanın iş mantığını yürütmek için kullanılır.



