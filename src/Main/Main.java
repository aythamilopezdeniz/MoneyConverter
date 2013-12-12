package Main;

//import Control.ExchangeMoneyControl;
import Control.MainFrame;
import persistence.CurrencySetLoader;

public class Main {
    private static final String filename = "G:\\Universidad\\Tercer Curso\\Primer Cuatrimestre\\Ingeniería del Software 2\\Prácticas\\moneyConverter\\currency_list.txt";

    public static void main(String[] args) {
        CurrencySetLoader.getInstance().load(filename);
        MainFrame frame=new MainFrame();
/*        ExchangeMoneyControl control=new ExchangeMoneyControl();
        control.execute();*/
    }
}