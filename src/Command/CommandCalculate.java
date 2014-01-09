package Command;

import UserInterface.CurrencyDialog;
import UserInterface.MoneyDialog;
import UserInterface.MoneyViewer;
import UserInterface.Swing.CurrencyPanel;
import UserInterface.Swing.DatePanel;
import UserInterface.Swing.MoneyPanel;
import UserInterface.Swing.MoneyViewerPanel;
import model.Currency;
import model.ExchangeRate;
import model.Money;
import model.MoneyExchanger;
import persistence.ExchangeRateLoader;

public class CommandCalculate extends Command {
    private final MoneyViewer moneyViewer;
    private final MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;
    private final DatePanel dateDialog;

    public CommandCalculate(MoneyPanel moneyPanel, CurrencyPanel currencyPanel, DatePanel datePanel,
            MoneyViewerPanel moneyViewer) {
        this.moneyDialog = moneyPanel;
        this.currencyDialog = currencyPanel;
        this.dateDialog = datePanel;
        this.moneyViewer = moneyViewer;
    }

    @Override
    public void execute() {
        Money money=moneyDialog.getMoney();
        moneyViewer.setMoney(MoneyExchanger.exchange(money,
                loadRate(money.getCurrency(), currencyDialog.getCurrency())));
        moneyViewer.show();
    }

    private ExchangeRate loadRate(Currency source, Currency target) {
        return new ExchangeRateLoader().load(source, target);
    }
}