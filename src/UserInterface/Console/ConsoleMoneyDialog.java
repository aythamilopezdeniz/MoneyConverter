package UserInterface.Console;

import UserInterface.CurrencyDialog;
import UserInterface.MoneyDialog;
import java.io.BufferedReader;
import java.io.InputStreamReader;
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
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Number number=new Number(0);
        boolean state=false;
        while(!state){
            System.out.print("Introduzca cantidad de dinero: ");
            try{
                number=new Number(Double.parseDouble(reader.readLine()));
                state=true;
            }catch(Exception e){
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