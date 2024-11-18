package com.swaggerList.demo.controller;

import com.swaggerList.demo.currency.Currency;
import com.swaggerList.demo.service.CurrencyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller //HTML http://localhost:8080
public class CurrencyController {

    @Autowired
    private CurrencyServiceImpl currencyService;

    @GetMapping("/")
    public String showForm() {
        return "currencyForm"; // Kullanıcıya formu gösterir
    }


    @PostMapping("/currency")
    public String getCurrency(@RequestParam String currencyName, Model model) {
        Currency currency = currencyService.getCurrencyByName(currencyName);
        if (currency != null) {
            model.addAttribute("message", String.format("Döviz Kodu: %s, Alış: %s, Satış: %s",
                    currency.getName(), currency.getBuying(), currency.getSelling()));
        } else {
            model.addAttribute("message", "Döviz bulunamadı.");
        }
        return "currencyForm"; // Sonucu aynı sayfada gösterir
    }
}


/*@RestController //POSTMAN http://localhost:8080/currency?currencyName=sterlin
public class CurrencyController {

    @Autowired
    private CurrencyServiceImpl currencyServiceImpl;

    @GetMapping("/currency")
    public String getCurrency(@RequestParam String currencyName) {
        Currency currency = currencyServiceImpl.getCurrencyByName(currencyName);
        if (currency != null) {
            return String.format("Döviz Kodu: %s, Alış Fiyatı: %s, Satış Fiyatı: %s",
                    currency.getName(), currency.getBuying(), currency.getSelling());
        } else {
            return "İlgili döviz bulunamadı.";
        }
    }
}
*/




