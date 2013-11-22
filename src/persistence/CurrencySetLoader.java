package persistence;

import model.CurrencySet;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import model.Currency;

public class CurrencySetLoader {

    private static CurrencySetLoader instance;

    private CurrencySetLoader() {
    }

    public static CurrencySetLoader getInstance() {
        if (instance == null) {
            instance = new CurrencySetLoader();
        }
        return instance;
    }
    
    public void load(){
        CurrencySet.getInstance().add(new Currency("EUR", "Euros","E"));
    }

    public CurrencySet load(String filename) {
        CurrencySet set=CurrencySet.getInstance();
        BufferedReader reader = createBufferedReader(filename);
        while(true){
            String line=readLine(reader);
            if(line==null)break;
            if(!line.contains(","))continue;
            set.add(getCurrency(line));
        }
        return set;
    }

    private BufferedReader createBufferedReader(String filename) {
        try {
            BufferedReader reader=new BufferedReader(new FileReader(filename));
            return reader;
        } catch (FileNotFoundException ex) {
        }
        return null;
    }

    private Currency getCurrency(String line) {
        String[] amount=line.split(",");
        switch(amount.length){
            case 3:
                return new Currency(amount[1], amount[0], amount[2]);
            case 2:
                return new Currency(amount[1], amount[0]);
            default:
                return null;
        }
    }

    private String readLine(BufferedReader readLine) {
        if(readLine==null)return null;
        while(true){
            try {
                return readLine.readLine();
            } catch (IOException ex) {
            }
        }
    }
}