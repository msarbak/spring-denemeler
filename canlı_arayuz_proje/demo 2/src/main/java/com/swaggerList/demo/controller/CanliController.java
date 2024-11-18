package com.swaggerList.demo.controller;

import com.swaggerList.demo.canlilar.Canli;
import com.swaggerList.demo.canlilar.hayvanlar.Balik;
import com.swaggerList.demo.canlilar.hayvanlar.Kedi;
import com.swaggerList.demo.service.intf.CanliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CanliController {

    @Autowired
    private CanliService canliService;

    @PostMapping("/kedi")
    public String kediKonustur() {
        Canli kedi = new Kedi();
        return canliService.konustur(kedi);
    }

    @PostMapping("/balik")
    public String balikKonustur() {
        Canli balik = new Balik();
        return canliService.konustur(balik);
    }
}
