package moneyconverte;

public class ExchangeRate {
    private Currency fromCurrency;
    private Currency toCurrency;
    private date date;
    private Number rate;

    public Currency getFromCurrency() {
        return fromCurrency;
    }

    public Currency getToCurrency() {
        return toCurrency;
    }

    public date getDate() {
        return date;
    }

    public Number getRate() {
        return rate;
    }
}