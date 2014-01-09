package Main;

import Command.Command;
import Command.CommandActionListener;
import Command.CommandCalculate;
import Command.CommandRegister;
import Control.ExchangeMoneyControl;
import UserInterface.Console.ConsoleCurrencyDialog;
import UserInterface.Console.ConsoleMoneyDialog;
import UserInterface.Console.ConsoleMoneyViewer;
import UserInterface.CurrencyDialog;
import UserInterface.MainFrame;
import UserInterface.MoneyDialog;
import UserInterface.MoneyViewer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import persistence.CurrencySetLoader;

public class Main {

    private static final String filename = "I:\\currency_list.txt";

    public static void main(String[] args) {
        //Console();
        Swing();
    }

    private static void Console() {
        MoneyDialog moneyDialog = new ConsoleMoneyDialog();
        CurrencyDialog currencyDialog = new ConsoleCurrencyDialog();
        MoneyViewer moneyViewer = new ConsoleMoneyViewer();
        CurrencySetLoader.getInstance().load(filename);
        ExchangeMoneyControl control = new ExchangeMoneyControl(moneyDialog,
                currencyDialog, moneyViewer);
        control.execute();
    }

    private static void Swing() {
        CurrencySetLoader.getInstance().load(filename);
        final CommandRegister commandRegister = new CommandRegister();
        CommandActionListener actionListener = new CommandActionListener() {

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
        
        commandRegister.setActionMap("calculate", new CommandCalculate(
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
