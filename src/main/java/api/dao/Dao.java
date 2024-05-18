package api.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

public class Dao {
    private Connection conn;
    private String url;
    private String username;
    private String password;

    public Dao(final String _url, final String _username, final String _password) {
        url = _url;
        username = _username;
        password = _password;
    }

    public void initialize() throws SQLException {
        conn = DriverManager.getConnection(url, username, password);
    }

    public void close() throws SQLException {
        conn.close();
    }

    public DSLContext getDSLContext() {
        return DSL.using(conn, SQLDialect.POSTGRES);
    }
}