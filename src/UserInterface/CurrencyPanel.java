package UserInterface;

import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class CurrencyPanel extends JPanel{
    private static final String[] currencies=new String[]{"EUR", "USD", "CAD", "GBP"};

    public CurrencyPanel() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(createComboCurrency());
    }

    private JComboBox createComboCurrency() {
        JComboBox comboCurrencies=new JComboBox(currencies);
        return comboCurrencies;
    }
}