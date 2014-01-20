package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import model.Currency;
import model.ExchangeRate;
import model.Number;
import oracle.jdbc.OracleDriver;

public class DBAExchangeRateLoader implements ExchangeRateLoader {
    private static DBAExchangeRateLoader instace;
    private Connection connection;

    private DBAExchangeRateLoader() {
        connection = null;
        try {
            connection = getConnection();
        } catch (SQLException ex) {
        }
    }

    public static DBAExchangeRateLoader getInstance() {
        if(instace==null) instace=new DBAExchangeRateLoader();
        return instace;
    }

    private Connection getConnection() throws SQLException {
        String userName = "system";
        String password = "orcl";
        String server = "localhost:101:orcl";
        String url = "jdbc:oracle:thin:@";
        DriverManager.registerDriver(new OracleDriver());
        return DriverManager.getConnection(url+server, userName, password);
    }

    @Override
    public ExchangeRate load(Date date, Currency from, Currency to) {
        try {
            return new ExchangeRate(date, from, to, new Number(getRate(date, from, to)));
        } catch (Exception ex) {
        }
        return null;
    }

    @Override
    public ExchangeRate load(Currency from, Currency to) {
        return load(new Date(), from, to);
    }

    private double getRate(Date date, Currency from, Currency to) {
        try {
            String query = "select cambio from historico_cambios " + "where divisa_desde='" + from.getCode()
                    + "' and divisa_a='" + to.getCode() + "'";
            ResultSet resultSet;
            resultSet=connection.createStatement().executeQuery(query);
            while(resultSet.next())
                return resultSet.getDouble(1);
        } catch (SQLException ex) {
        }
        return 0;
    }
}