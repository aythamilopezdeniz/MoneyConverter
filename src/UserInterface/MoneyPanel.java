package UserInterface;

import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MoneyPanel extends JPanel {
    private JTextField field;

    public MoneyPanel() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(createTextField());
        this.add(new CurrencyPanel());
    }

    public MoneyPanel(JTextField field) {
        this.field=field;
    }

    private JTextField createTextField() {
        field=new JTextField(10);
        return field;
    }

    public String getField() {
        return field.getText();
    }
}
