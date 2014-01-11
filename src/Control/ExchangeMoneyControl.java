package Control;

import UserInterface.CurrencyDialog;
import UserInterface.DateDialog;
import UserInterface.MoneyDialog;
import UserInterface.MoneyViewer;
import java.util.Date;
import model.Currency;
import model.Money;
import model.MoneyExchanger;
import persistence.ExchangeRateLoader;

public class ExchangeMoneyControl {
    private final MoneyViewer moneyViewer;
    private final CurrencyDialog currencyDialog;
    private final MoneyDialog moneyDialog;
    private final DateDialog dateDialog;
    private final ExchangeRateLoader exchangeRateLoader;

    public ExchangeMoneyControl(MoneyDialog moneyDialog, CurrencyDialog currencyDialog, DateDialog dateDialog, 
            ExchangeRateLoader exchangeRateLoader, MoneyViewer moneyViewer) {
        this.moneyDialog=moneyDialog;
        this.currencyDialog=currencyDialog;
        this.dateDialog=dateDialog;
        this.exchangeRateLoader=exchangeRateLoader;
        this.moneyViewer=moneyViewer;
    }

    public void execute() {
        Date date=readDate();
        Money money=readMoney();
        moneyViewer.setMoney(MoneyExchanger.exchange(money, 
                exchangeRateLoader.load(date, money.getCurrency(), readCurrency())));
        moneyViewer.show();
    }

    private Money readMoney() {
        moneyDialog.show();
        return moneyDialog.getMoney();
    }

    private Currency readCurrency() {
        currencyDialog.show();
        return currencyDialog.getCurrency();
    }

    private Date readDate() {
        dateDialog.show();
        return dateDialog.getDate();
    }
}