package UserInterface;

import java.util.Scanner;
import model.Currency;
import model.Money;
import model.Number;

public class MoneyDialog {
    private Money money;
    
    public void execute(){
        Scanner in=new Scanner(System.in);
        System.out.println("Inserte una cantidad: ");
        Double amount = in.nextDouble();
        money = new Money(new Number(amount), readCurrency());
    }

    public Money getMoney() {
        return money;
    }

    private Currency readCurrency() {
        CurrencyDialog dialog =new CurrencyDialog();
        dialog .execute();        
        return dialog.getCurrency();
    }
    
}