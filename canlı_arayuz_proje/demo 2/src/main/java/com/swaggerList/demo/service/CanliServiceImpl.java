package com.swaggerList.demo.service;

import com.swaggerList.demo.canlilar.Canli;
import com.swaggerList.demo.service.intf.CanliService;
import org.springframework.stereotype.Service;

@Service
public class CanliServiceImpl implements CanliService {

    @Override
    public String konustur(Canli canli) {
        return canli.konustur();
    }
}
