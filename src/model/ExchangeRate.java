package model;

import java.util.Date;

public class ExchangeRate {
    private Currency fromCurrency;
    private Currency toCurrency;
    private Date date;
    private Number rate;

    public Currency getFromCurrency() {
        return fromCurrency;
    }

    public Currency getToCurrency() {
        return toCurrency;
    }

    public Date getDate() {
        return date;
    }

    public Number getRate() {
        return rate;
    }
}