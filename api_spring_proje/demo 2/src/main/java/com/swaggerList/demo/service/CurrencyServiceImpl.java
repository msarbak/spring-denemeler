package com.swaggerList.demo.service;

import com.swaggerList.demo.currency.Currency;
import com.swaggerList.demo.currency.response.CurrencyResponse;
import com.swaggerList.demo.service.intf.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    private static final String API_URL = "https://api.collectapi.com/economy/allCurrency";
    //private static final String API_URL = "https://api.collectapi.com/economy/currencyToAll?int=10&base=USD";
    private static final String API_KEY = "apikey 3I75SuaoTTlqLxhFEWxAAQ:56FLzc5uor7LN5F8VBxEy1";

    @Override
    public Currency getCurrencyByName(String currencyName) {
        Mono<CurrencyResponse> response = webClientBuilder.build() //asenkron veri transeferi ve tek veri taşıması için mono kullanıyoruz
                .get()
                .uri(API_URL)
                .header("authorization", "apikey " + API_KEY)
                .retrieve()
                .bodyToMono(CurrencyResponse.class);

        return Objects.requireNonNull(response.block())
                .getResult()
                .stream()
                .filter(currency -> currency.getName().toLowerCase().contains(currencyName.toLowerCase()))
                .findFirst()
                .orElse(null);
    }

}
