package UserInterface.Console;

import UserInterface.CurrencyDialog;
import UserInterface.MoneyDialog;
import java.util.Scanner;
import model.Currency;
import model.Money;
import model.Number;

public class ConsoleMoneyDialog implements MoneyDialog{
    private Money money;

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
        Scanner in=new Scanner(System.in);
        Number number=new Number(0);
        while(true){
            System.out.println("Introduzca cantidad de dinero: ");
            try{
                number=new Number(in.nextDouble());
                break;
            }catch(Exception e){
                break;
            }
        }
        return number;
    }

    private Currency readCurrency() {
        CurrencyDialog dialog = new ConsoleCurrencyDialog();
        dialog.show();
        return dialog.getCurrency();
    }
}