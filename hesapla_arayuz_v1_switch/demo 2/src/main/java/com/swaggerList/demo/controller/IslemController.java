package com.swaggerList.demo.controller;

import com.swaggerList.demo.islemler.Carpim;
import com.swaggerList.demo.islemler.Fark;
import com.swaggerList.demo.islemler.Toplam;
import com.swaggerList.demo.service.intf.IslemService;
import com.swaggerList.demo.service.IslemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/v1")
public class IslemController {

    @Autowired
    private IslemServiceImpl islemService;

    @GetMapping("/form")
    public String showForm() {
        return "islem-form";
    }

    @PostMapping("/islem")
    public String islemYap(
            @RequestParam("sayi1") int sayi1,
            @RequestParam("sayi2") int sayi2,
            @RequestParam("islemTipi") String islemTipi,
            Model model) {

        IslemService islem = null;
//IPTAL
        switch (islemTipi) {
            case "toplam":
                islem = new Toplam(sayi1, sayi2);
                break;
            case "carpim":
                islem = new Carpim(sayi1, sayi2);
                break;
            case "fark":
                islem = new Fark(sayi1, sayi2);
                break;
            default:
                throw new IllegalArgumentException("Geçersiz işlem tipi: " + islemTipi);
        }

        int sonuc = islemService.islemYap(islem);
        model.addAttribute("sonuc", sonuc);
        return "islem-sonuc";
    }
}
