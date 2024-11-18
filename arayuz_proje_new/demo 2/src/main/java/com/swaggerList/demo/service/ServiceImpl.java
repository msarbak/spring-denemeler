package com.swaggerList.demo.service;

import com.swaggerList.demo.canlilar.Sekil;
import com.swaggerList.demo.service.intf.Service;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

    @Override
    public int alanHesapla(Sekil sekil) {
        return sekil.alanHesapla();
    }

    @Override
    public int cevreHesapla(Sekil sekil) {
        return sekil.cevreHesapla();
    }
}
