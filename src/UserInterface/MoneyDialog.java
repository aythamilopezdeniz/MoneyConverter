package UserInterface;

import java.util.Scanner;

public class MoneyDialog {
    private Number money;
    private Number fromCurrecy;
    
    public void execute(){
        Scanner in=new Scanner(System.in);
        System.out.println("Inserte una cantidad: ");
        money = in.nextInt();
        System.out.println("Inserte la divisa: ");
    }

    public Number getMoney() {
        return money;
    }

    public Number getFromCurrecy() {
        return fromCurrecy;
    }
    
    
}