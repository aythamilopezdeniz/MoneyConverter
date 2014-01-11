package UserInterface.Console;

import UserInterface.DateDialog;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConsoleDateDialog implements DateDialog {

    private Date date;

    @Override
    public void show() {
        this.date = readDate();
    }

    @Override
    public Date getDate() {
        return date;
    }

    private Date readDate() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean correct = false;
        Date newDate = new Date();
        while (!correct) {
            try {
                System.out.print("Introduzca la fecha para realizar cambio (dd,mm,aaaa): ");
                DateFormat dateFormat = new SimpleDateFormat("dd,MM,yyyy");
                String string=reader.readLine();
                newDate = dateFormat.parse(string);
                correct = true;
            } catch (Exception e) {
                System.out.println("Fecha incorrecta");
            }
        }
        return newDate;
    }
}
