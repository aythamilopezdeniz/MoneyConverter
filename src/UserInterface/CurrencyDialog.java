package UserInterface;

import java.util.Scanner;
import model.Currency;
import model.CurrencySet;

public class CurrencyDialog {
    private Currency currency;
    
    public void execute(){
        Scanner in=new Scanner(System.in);
        System.out.println("Inserte una divisa: ");
        String code = in.next();
        currency = CurrencySet.getInstance().get(code);
    }

    public Currency getCurrency() {
        return currency;
    }

    
}