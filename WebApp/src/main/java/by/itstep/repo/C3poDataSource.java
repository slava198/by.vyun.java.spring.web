package by.itstep.repo;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class C3poDataSource {

    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    private static final String JDBC_URL = "jdbc:mysql://localhost/todoList?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    private static ComboPooledDataSource cpds = new ComboPooledDataSource();

    static {
        try {
            cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
            cpds.setJdbcUrl(JDBC_URL);
            cpds.setUser(DB_USER);
            cpds.setPassword(DB_PASSWORD);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return cpds.getConnection();
    }

    private C3poDataSource(){}
}
