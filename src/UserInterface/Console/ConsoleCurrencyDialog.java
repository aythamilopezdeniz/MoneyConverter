package UserInterface.Console;

import UserInterface.CurrencyDialog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import model.Currency;
import model.CurrencySet;

public class ConsoleCurrencyDialog implements CurrencyDialog {

    private Currency currency;

    @Override
    public Currency getCurrency() {
        return currency;
    }

    @Override
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public void show() {
        while (currency == null) {
            currency = CurrencySet.getInstance().get(readCurrencyCode());
        }
    }

    private String readCurrencyCode() {
        try {
            System.out.print("Introduzca la divisa: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            return reader.readLine();
        } catch (IOException ex) {
            return "";
        }
    }
}
