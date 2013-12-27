package UserInterface.Swing;

import UserInterface.CurrencyDialog;
import UserInterface.MoneyDialog;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Money;
import model.Number;

public class MoneyPanel extends JPanel implements MoneyDialog{
    private JTextField amount;
    private CurrencyDialog currencyDialog;
    private Money money;

    public MoneyPanel() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(createTextField());
        this.add(new CurrencyPanel());
    }

    public MoneyPanel(JTextField amount) {
        this.amount=amount;
    }

    private JTextField createTextField() {
        amount=new JTextField(10);
        return amount;
    }

    public String getField() {
        return amount.getText();
    }

    @Override
    public Money getMoney() {
        return money;
    }

    @Override
    public void setMoney(Money money) {
        this.money=new Money(new Number(Double.parseDouble(getField())), currencyDialog.getCurrency());
    }
}
