package UserInterface;

import java.util.Scanner;
import model.Currency;
import model.Money;
import model.Number;

public class ConsoleMoneyDialog implements MoneyDialog{
    private Money money;
    //private MoneyPanel moneyConsole;

    @Override
    public Money getMoney() {
        return money;
    }

    @Override
    public void setMoney(Money money) {
        this.money = money;
    }

    @Override
    public void show() {
        this.money = new Money(readAmount(), readCurrency());
    }

    private Number readAmount() {
        //moneyConsole=new MoneyPanel();
        //return new Number(Double.parseDouble(moneyConsole.getField()));
        Scanner in=new Scanner(System.in);
        System.out.println("Introduzca cantidad de dinero: ");
        return new Number(in.nextDouble());
    }

    private Currency readCurrency() {
        CurrencyDialog dialog = new ConsoleCurrencyDialog();
        dialog.show();
        return dialog.getCurrency();
    }
}