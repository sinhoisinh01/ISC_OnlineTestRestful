package isc.intake2.online_test.configurations;

import org.hibernate.dialect.MySQLDialect;

public class CustomMySQLDialect extends MySQLDialect {
    @Override
    public String getTableTypeString() {
        return " DEFAULT CHARSET=utf8 collate utf8_general_ci";
    }
   
    
}