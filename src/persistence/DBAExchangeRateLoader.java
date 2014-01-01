package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import oracle.jdbc.OracleDriver;

public class DBAExchangeRateLoader {

    public static void main(String[] args) throws SQLException {
        String userName="system";
        String password="orcl";
        String server="localhost:101:orcl";
        DriverManager.registerDriver(new OracleDriver());
        Connection connection= DriverManager.getConnection(
                "jdbc:oracle:thin:@"+ server, userName, password);
        Statement statement=connection.createStatement();
        ResultSet set=statement.executeQuery("select * from CAMBIO_EUR_A");
        while(set.next()){
            printRegistrer(set);
        }
    }
    
    private static void printRegistrer(ResultSet set) throws SQLException{
        System.out.print(set.getString("DIVISA")+" ");
        System.out.println(set.getBigDecimal("CAMBIO"));
    }
}