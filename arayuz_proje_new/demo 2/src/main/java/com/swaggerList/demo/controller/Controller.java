package com.swaggerList.demo.controller;

import com.swaggerList.demo.canlilar.sekiller.Daire;
import com.swaggerList.demo.canlilar.sekiller.Kare;
import com.swaggerList.demo.canlilar.sekiller.Ucgen;
import com.swaggerList.demo.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private ServiceImpl service;

    @PostMapping("/kare/alan")
    public int kareAlanHesapla() {
        Kare kare = new Kare(5);
        return service.alanHesapla(kare);
    }
    @PostMapping("/kare/cevre")
    public int kareCevreHesapla() {
        Kare kare = new Kare(5);
        return service.cevreHesapla(kare);
    }
    @PostMapping("/ucgen/alan")
    public int ucgenAlanHesapla() {
        Ucgen ucgen = new Ucgen(3,4,5,8);
        return service.alanHesapla(ucgen);
    }
    @PostMapping("/ucgen/cevre")
    public int ucgenCevreHesapla() {
        Ucgen ucgen = new Ucgen(3,4,5,9);
        return service.cevreHesapla(ucgen);
    }
    @PostMapping("/daire/alan")
    public int daireAlanHesapla(){
        Daire daire = new Daire(9);
        return service.alanHesapla(daire);
    }
    @PostMapping("/daire/cevren")
    public int daireCevreHesapla(){
        Daire daire = new Daire(9);
        return service.cevreHesapla(daire);
    }
}
