package model;

import java.util.Date;

public class ExchangeRate {
    private final Currency fromCurrency;
    private final Currency toCurrency;
    private final Date date;
    private final Number rate;

    public ExchangeRate(Date date, Currency fromCurrency, Currency toCurrency, Number rate) {
        this.rate = rate;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.date = date;
    }

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