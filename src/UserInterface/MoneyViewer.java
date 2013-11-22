package UserInterface;

import model.Money;

public class MoneyViewer {
    private Money money;

    public MoneyViewer(Money money) {
        this.money=money;
    }

    public void show(){
        System.out.println("Cantidad final "+(double)(money.getAmount().getNumerator()/money.getAmount().getDenominator())
                +" "+money.getCurrency().getSymbol());
    }
}
