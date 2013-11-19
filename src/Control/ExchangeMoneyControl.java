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


    public void execute() {
        Money money = readMoney();
        MoneyViewer viewer = new MoneyViewer(MoneyExchanger.exchange(money, 
                loadRate(money.getCurrency(), readCurrency())));
        viewer.show();
    }

    private ExchangeRate loadRate(Currency source, Currency target) {
        return new ExchangeRateLoader().load(source, target);
    }

    private Money readMoney() {
        MoneyDialog dialog = new MoneyDialog();
        dialog.execute();
        return dialog.getMoney();
    }

    private Currency readCurrency() {
        CurrencyDialog dialog = new CurrencyDialog();
        dialog.execute();
        return dialog.getCurrency();
    }
}
