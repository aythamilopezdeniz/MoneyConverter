package UserInterface;

import UserInterface.Swing.CurrencyPanel;
import UserInterface.Swing.MoneyPanel;
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
        this.setBounds(550, 250, 350, 350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createComponents();
        this.setVisible(true);
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
        panelMoneyExchange.add(new JLabel());
        panelMoneyExchange.add(createMoneyPanel());
        panelMoneyExchange.add(new JLabel());
        panelMoneyExchange.add(createCurrencyPanel());
        return panelMoneyExchange;
    }

    private JPanel SecondPanel() {
        JPanel panelDateAndViewer=new JPanel();
        panelDateAndViewer.add(createDatePanel());
        panelDateAndViewer.add(createMoneyViewerPanel());
        return panelDateAndViewer;
    }

    private JPanel createMoneyPanel() {
        MoneyPanel panel=new MoneyPanel();
        return panel;
    }

    private JPanel createDatePanel() {
        JPanel panel=new JPanel();
        return panel;
    }

    private JPanel createMoneyViewerPanel() {
        JPanel panel=new JPanel();
        return panel;
    }

    private JPanel createCurrencyPanel() {
        CurrencyPanel panel=new CurrencyPanel();
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