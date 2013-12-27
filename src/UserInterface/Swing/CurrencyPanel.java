package UserInterface.Swing;

import UserInterface.CurrencyDialog;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import model.Currency;

public class CurrencyPanel extends JPanel implements CurrencyDialog{
    private static final String[] currencies=new String[]{"EUR", "USD", "CAD", "GBP"};

    public CurrencyPanel() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(createComboCurrency());
    }

    private JComboBox createComboCurrency() {
        JComboBox comboCurrencies=new JComboBox(currencies);
        return comboCurrencies;
    }

    @Override
    public Currency getCurrency() {
        return null;
    }

    @Override
    public void setCurrency(Currency currency) {
    }
}