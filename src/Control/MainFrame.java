package Control;

import UserInterface.CurrencyPanel;
import UserInterface.MoneyPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
//    private MoneyPanel moneyPanel;
//    private CurrencyPanel currencyPanel;
//    private JTextField leido;
    public MainFrame(){
        this.setTitle("Money Calculator");
        this.setBounds(550, 250, 350, 350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createComponents();
        this.setVisible(true);
        /*JFrame frame=new JFrame("Money Calculator");
        frame.setBounds(550, 250, 350, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createComponents();
        frame.setVisible(true);*/
    }

    private void createComponents() {
        this.add(createToolbar(), BorderLayout.SOUTH);
        this.add(createContent());
    }

    private JPanel createToolbar() {
        JPanel panel=new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panel.add(createCalculateButton());
        panel.add(createCancelButton());
        return panel;
    }

    private JPanel createContent() {
        JPanel panel=new JPanel(new FlowLayout(FlowLayout.LEFT));
//        moneyPanel=new MoneyPanel();
//        currencyPanel=new CurrencyPanel();
//        leido= new JTextField(7);
//        leido.setEditable(false);
//        panel.add(leido);
//        panel.add(moneyPanel);
//        panel.add(currencyPanel);
        panel.add(new MoneyPanel());
        panel.add(new CurrencyPanel());
        return panel;
    }

    private JButton createCalculateButton() {
        JButton calculate=new JButton("Calculate");
        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent accept) {
//                leido.setText(moneyPanel.getField());
                ExchangeMoneyControl control=new ExchangeMoneyControl();
                control.execute();
            }
        });
        return calculate;
    }

    private JButton createCancelButton() {
        JButton cancel=new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent cancel) {
                exit();
            }
        });
        return cancel;
    }

    private void exit() {
        dispose();
    }
}