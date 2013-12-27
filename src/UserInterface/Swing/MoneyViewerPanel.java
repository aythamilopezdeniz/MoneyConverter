package UserInterface.Swing;

import UserInterface.MoneyViewer;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Money;

public class MoneyViewerPanel extends JPanel implements MoneyViewer {
    private JLabel resultado;
    private Money money;

    public MoneyViewerPanel() {
        this.setLayout(new FlowLayout());
        resultado=new JLabel("0");
    }

    @Override
    public void setMoney(Money money) {
        this.money=money;
    }
    
    @Override
    public void show(){
        this.add(createLabel());
    }

    private JLabel createLabel() {
        if(money!=null)
            resultado.setText(""+money);
        return resultado;
    }
}