package com.swaggerList.demo.service;

import com.swaggerList.demo.service.intf.IslemService;
import org.springframework.stereotype.Service;

@Service
public class IslemServiceImpl {

    public int islemYap(IslemService islem) {
        return islem.hesapla();
    }
}
