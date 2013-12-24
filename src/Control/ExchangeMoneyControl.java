package Control;

import UserInterface.ConsoleCurrencyDialog;
import UserInterface.ConsoleMoneyDialog;
import UserInterface.CurrencyDialog;
import UserInterface.MoneyDialog;
import UserInterface.MoneyViewer;
import model.Currency;
import model.ExchangeRate;
import model.Money;
import model.MoneyExchanger;
import persistence.ExchangeRateLoader;

public class ExchangeMoneyControl {


    public void execute() {
        Money money=readMoney();
        Currency currency=readCurrency();
        MoneyViewer viewer = new MoneyViewer(MoneyExchanger.exchange(money, 
                loadRate(money.getCurrency(), currency)));
        viewer.show();
    }

    private ExchangeRate loadRate(Currency source, Currency target) {
        return new ExchangeRateLoader().load(source, target);
    }

    private Money readMoney() {
        MoneyDialog dialog = new ConsoleMoneyDialog();
        dialog.show();
        return dialog.getMoney();
    }

    private Currency readCurrency() {
        CurrencyDialog dialog = new ConsoleCurrencyDialog();
        dialog.show();
        return dialog.getCurrency();
    }
}