package persistence;

import java.util.Date;
import model.Currency;
import model.ExchangeRate;
import model.Number;

public class ExchangeRateLoader {
    public ExchangeRate load(Date date, Currency from, Currency to){
        return new ExchangeRate(date, from, to, new Number(10,13));
    }
    
    public ExchangeRate load(Currency from, Currency to){
        return load(new Date(), from, to);
    }
}