package Control;

import UserInterface.MoneyDialog;
import persistence.CurrencySetLoader;

public class MoneyExchangeRate {
    private static final String filename="G:\\Universidad\\Tercer Curso\\Primer Cuatrimestre\\Ingeniería del Software 2\\Prácticas";
    
    public void execute(){
        CurrencySetLoader.getInstance().load(filename);
        MoneyDialog money=new MoneyDialog();
        money.execute();
    }
}