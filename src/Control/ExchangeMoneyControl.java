package Control;

import UserInterface.CurrencyDialog;
import UserInterface.MoneyDialog;
import UserInterface.MoneyViewer;
import model.Currency;
import model.ExchangeRate;
import model.Money;
import model.MoneyExchanger;
import persistence.ExchangeRateLoader;

public class ExchangeMoneyControl {
    private final MoneyViewer moneyViewer;
    private final CurrencyDialog currencyDialog;
    private final MoneyDialog moneyDialog;

    public ExchangeMoneyControl(MoneyDialog moneyDialog, CurrencyDialog currencyDialog, 
            MoneyViewer moneyViewer) {
        this.moneyDialog=moneyDialog;
        this.currencyDialog=currencyDialog;
        this.moneyViewer=moneyViewer;
    }

    public void execute() {
        Money money=readMoney();
        moneyViewer.setMoney(MoneyExchanger.exchange(money, 
                loadRate(money.getCurrency(), readCurrency())));
        moneyViewer.show();
    }

    private ExchangeRate loadRate(Currency source, Currency target) {
        return new ExchangeRateLoader().load(source, target);
    }

    private Money readMoney() {
        moneyDialog.show();
        return moneyDialog.getMoney();
    }

    private Currency readCurrency() {
        currencyDialog.show();
        return currencyDialog.getCurrency();
    }
}