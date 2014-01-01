package UserInterface;

import UserInterface.Swing.CurrencyPanel;
import UserInterface.Swing.DatePanel;
import UserInterface.Swing.MoneyPanel;
import UserInterface.Swing.MoneyViewerPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
    
    public MainFrame(){
        this.setTitle("Money Calculator");
        //this.setBounds(550, 250, 350, 350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createComponents();
        this.setVisible(true);
        this.pack();
    }

    private void createComponents() {
        this.add(createPanel());
        this.add(createToolbar(), BorderLayout.SOUTH);
    }

    private JPanel createToolbar() {
        JPanel panel=new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panel.add(createCalculateButton());
        panel.add(createCancelButton());
        return panel;
    }

    private JPanel createPanel() {
        JPanel principalPanel=new JPanel(new BorderLayout());
        principalPanel.add(firstPanel(), BorderLayout.NORTH);
        principalPanel.add(SecondPanel(), BorderLayout.CENTER);
        return principalPanel;
    }

    private JPanel firstPanel() {
        JPanel panelMoneyExchange=new JPanel();
        panelMoneyExchange.add(new JLabel("to:"));
        panelMoneyExchange.add(createMoneyPanel());
        panelMoneyExchange.add(new JLabel("from:"));
        panelMoneyExchange.add(createCurrencyPanel());
        return panelMoneyExchange;
    }

    private JPanel SecondPanel() {
        JPanel panelDateAndViewer=new JPanel();
        panelDateAndViewer.add(new JLabel("Date:"));
        panelDateAndViewer.add(createDatePanel());
        panelDateAndViewer.add(new JLabel("Result:"));
        panelDateAndViewer.add(createMoneyViewerPanel());
        return panelDateAndViewer;
    }

    private JPanel createMoneyPanel() {
        MoneyPanel panel=new MoneyPanel();
        panel.show();
        return panel;
    }

    private JPanel createDatePanel() {
        DatePanel panel=new DatePanel();
        panel.show();
        return panel;
    }

    private JPanel createMoneyViewerPanel() {
        MoneyViewerPanel panel=new MoneyViewerPanel();
        panel.show();
        return panel;
    }

    private JPanel createCurrencyPanel() {
        CurrencyPanel panel=new CurrencyPanel();
        panel.show();
        return panel;
    }

    private JButton createCalculateButton() {
        JButton calculate=new JButton("Calculate");
        calculate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent accept) {
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