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
    public int toplamYap(@RequestParam int firstNum, @RequestParam int secondNum) {
        Toplam toplam = new Toplam(firstNum, secondNum);
        return islemService.calculate(toplam);
    }

    @PostMapping("/fark")
    public int farkYap(@RequestParam int firstNum, @RequestParam int secondNum) {
        Fark fark = new Fark(firstNum, secondNum);
        return islemService.calculate(fark);
    }

    @PostMapping("/carpim")
    public int carpimYap(@RequestParam int firstNum, @RequestParam int secondNum) {
        Carpim carpim = new Carpim(firstNum, secondNum);
        return islemService.calculate(carpim);
    }
}

//HTTP isteklerini alır ve ilgili işlemi yapar.
// Web API üzerinden matematiksel işlemleri gerçekleştirmek için kullanılacak RESTful endpoint'leri sağlar.