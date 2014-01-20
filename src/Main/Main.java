package Main;

import Command.Command;
import Command.ActionListenerCommand;
import Command.CalculateCommand;
import Command.RegisterCommand;
import Control.ExchangeMoneyControl;
import UserInterface.Console.ConsoleCurrencyDialog;
import UserInterface.Console.ConsoleDateDialog;
import UserInterface.Console.ConsoleMoneyDialog;
import UserInterface.Console.ConsoleMoneyViewer;
import UserInterface.CurrencyDialog;
import UserInterface.DateDialog;
import UserInterface.MainFrame;
import UserInterface.MoneyDialog;
import UserInterface.MoneyViewer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import persistence.CurrencySetLoader;
import persistence.DBAExchangeRateLoader;
import persistence.ExchangeRateLoader;

public class Main {

    private static final String filename = "I:\\currency_list.txt";

    public static void main(String[] args) {
        Console();
        Swing();
    }

    private static void Console() {
        MoneyDialog moneyDialog = new ConsoleMoneyDialog();
        CurrencyDialog currencyDialog = new ConsoleCurrencyDialog();
        DateDialog dateDialog = new ConsoleDateDialog();
        MoneyViewer moneyViewer = new ConsoleMoneyViewer();
        ExchangeRateLoader exchangeRateLoader=DBAExchangeRateLoader.getInstance();
        CurrencySetLoader.getInstance().load(filename);
        ExchangeMoneyControl control = new ExchangeMoneyControl(moneyDialog,
                currencyDialog, dateDialog, exchangeRateLoader, moneyViewer);
        control.execute();
    }

    private static void Swing() {
        CurrencySetLoader.getInstance().load(filename);
        final RegisterCommand commandRegister = new RegisterCommand();
        ActionListenerCommand actionListener = new ActionListenerCommand() {

            @Override
            public ActionListener getActionListener(final String action) {
                return new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        commandRegister.getActionMap(action).execute();
                    }
                };
            }
        };
        
        final MainFrame frame = new MainFrame(actionListener);
        
        commandRegister.setActionMap("calculate", new CalculateCommand(
                frame.getMoneyPanel(),
                frame.getCurrencyPanel(),
                frame.getDatePanel(),
                frame.getMoneyViewer()));

        commandRegister.setActionMap("exit", new Command() {

            @Override
            public void execute() {
                frame.dispose();
            }
        });
    }
}
