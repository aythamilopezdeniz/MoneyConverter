package UserInterface;

import model.Currency;

public interface CurrencyDialog {
    
    public Currency getCurrency();
    public void setCurrency(Currency currency);
    public void show();
}