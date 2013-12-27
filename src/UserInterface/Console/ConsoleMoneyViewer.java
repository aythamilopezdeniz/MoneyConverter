package UserInterface.Console;

import UserInterface.MoneyViewer;
import model.Money;

public class ConsoleMoneyViewer implements MoneyViewer{
    private Money money;

    public ConsoleMoneyViewer(Money money) {
        this.money=money;
    }

    public ConsoleMoneyViewer() {
    }

    @Override
    public void show(){
        System.out.println("Cantidad final "+(double)(money.getAmount().getNumerator()/
                money.getAmount().getDenominator())
                +" "+money.getCurrency().getSymbol());
    }

    @Override
    public void setMoney(Money money) {
        this.money=money;
    }
}