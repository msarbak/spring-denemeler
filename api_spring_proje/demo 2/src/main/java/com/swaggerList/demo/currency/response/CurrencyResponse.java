package com.swaggerList.demo.currency.response;

import com.swaggerList.demo.currency.Currency;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CurrencyResponse {
    private boolean success;
    private List<Currency> result;

}
