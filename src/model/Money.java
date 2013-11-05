package model;

public class Money {
    private final Number amount;
    private final Currency currency;

    public Money(Number amount, Currency curency) {
        this.amount=amount;
        this.currency=curency;
    }

    public Number getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }
}