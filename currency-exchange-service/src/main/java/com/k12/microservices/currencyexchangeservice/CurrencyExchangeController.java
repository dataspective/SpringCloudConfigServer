package com.k12.microservices.currencyexchangeservice;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private Exchange exVal;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to){
        // conversion rates as of 6/11/2018, for testing purposes though numbers can be arbitrary
        final BigDecimal DOLLAR_TO_RUPEE = BigDecimal.valueOf(67.47);
        final BigDecimal DOLLAR_TO_EURO = BigDecimal.valueOf(0.85);
        final BigDecimal DOLLAR_TO_RUBLE = BigDecimal.valueOf(62.79);
        final BigDecimal DOLLAR_TO_YEN = BigDecimal.valueOf(110.45);
        ExchangeValue exchangeValue = new ExchangeValue();

        if(to.equals("INR")) { // American to Indian currency
            exchangeValue = new ExchangeValue(exVal.getId(), from, to, DOLLAR_TO_RUPEE);
        }
        if(to.equals("EUR")) { // American to European currency
            exchangeValue = new ExchangeValue(exVal.getId(), from, to, DOLLAR_TO_EURO);
        }
        if(to.equals("RUB")) { // American to Russian currency
            exchangeValue = new ExchangeValue(exVal.getId(), from, to, DOLLAR_TO_RUBLE);
        }
        if(to.equals("JPY")) { // American to Japanese currency
            exchangeValue = new ExchangeValue(exVal.getId(), from, to, DOLLAR_TO_YEN);
        }

        // TODO: input validation for non-supported cases, may not be needed for testing purposes

        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        return exchangeValue;
    }
}