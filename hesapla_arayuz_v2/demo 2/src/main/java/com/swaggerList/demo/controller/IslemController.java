package com.swaggerList.demo.controller;

import com.swaggerList.demo.islemler.Carpim;
import com.swaggerList.demo.islemler.Fark;
import com.swaggerList.demo.islemler.Toplam;
import com.swaggerList.demo.service.IslemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/islem")
public class IslemController {

    @Autowired
    private IslemService islemService;

    @PostMapping("/toplam")
    public int toplamYap(@RequestParam int number1, @RequestParam int number2) {
        Toplam toplam = new Toplam(number1, number2);
        return islemService.islemYap(toplam);
    }

    @PostMapping("/fark")
    public int farkYap(@RequestParam int number1, @RequestParam int number2) {
        Fark fark = new Fark(number1, number2);
        return islemService.islemYap(fark);
    }

    @PostMapping("/carpim")
    public int carpimYap(@RequestParam int number1, @RequestParam int number2) {
        Carpim carpim = new Carpim(number1, number2);
        return islemService.islemYap(carpim);
    }
}


//HTTP isteklerini alır ve ilgili işlemi yapar.
// Web API üzerinden matematiksel işlemleri gerçekleştirmek için kullanılacak RESTful endpoint'leri sağlar.