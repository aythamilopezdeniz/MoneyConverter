package Main;

import Control.ExchangeMoneyControl;
import UserInterface.Console.ConsoleCurrencyDialog;
import UserInterface.Console.ConsoleMoneyDialog;
import UserInterface.Console.ConsoleMoneyViewer;
import UserInterface.CurrencyDialog;
import UserInterface.MainFrame;
import UserInterface.MoneyDialog;
import UserInterface.MoneyViewer;
import persistence.CurrencySetLoader;

public class Main {
    private static final String filename = "I:\\currency_list.txt";

    public static void main(String[] args) {
        //Console();
        Swing();
    }
    
    private static void Console(){
        MoneyDialog moneyDialog=new ConsoleMoneyDialog();
        CurrencyDialog currencyDialog=new ConsoleCurrencyDialog();
        MoneyViewer moneyViewer=new ConsoleMoneyViewer();
        CurrencySetLoader.getInstance().load(filename);
        ExchangeMoneyControl control=new ExchangeMoneyControl(moneyDialog, 
                currencyDialog, moneyViewer);
        control.execute();
    }
    
    private static void Swing(){
        MainFrame frame=new MainFrame();
    }
}