package UserInterface.Swing;

import UserInterface.CurrencyDialog;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import model.Currency;
import model.CurrencySet;

public class CurrencyPanel extends JPanel implements CurrencyDialog{
    private Currency currency;
    private JComboBox comboCurrencies;

    public CurrencyPanel() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(createComboCurrency());
    }

    private JComboBox createComboCurrency() {
        comboCurrencies=new JComboBox();
        getInstance(comboCurrencies);
        comboCurrencies.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ie) {
                if(ie.getStateChange()!=ItemEvent.SELECTED) {
                    return;
                }
                currency=CurrencySet.getInstance().search((String) comboCurrencies.getSelectedItem())[0];
            }
        });
        return comboCurrencies;
    }

    @Override
    public Currency getCurrency() {
        return currency;
    }

    @Override
    public void setCurrency(Currency currency) {
    }

    private void getInstance(JComboBox comboCurrencies) {
        for (Currency currency : CurrencySet.getInstance()) {
            comboCurrencies.addItem(currency.getCode());
        }
    }
}