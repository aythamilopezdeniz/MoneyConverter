package model;

public class MoneyExchanger {
    public static Money exchange(Money money, ExchangeRate rate){
        return new Money(money.getAmount().multiply(rate.getRate()),rate.getToCurrency());
    }
}