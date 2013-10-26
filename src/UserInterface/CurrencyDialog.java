package UserInterface;

import java.util.Scanner;

public class CurrencyDialog {
    private String currency;
    
    public void execute(){
        Scanner in=new Scanner(System.in);
        System.out.println("Inserte una cantidad: ");
        currency=in.next();
    }
    public String getSymbol() {
        return currency;
    }
}