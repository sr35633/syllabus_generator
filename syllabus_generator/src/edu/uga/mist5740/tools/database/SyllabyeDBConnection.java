package edu.uga.mist5740.tools.database;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class SyllabyeDBConnection {
    private static Connection connection;

    private SyllabyeDBConnection() {
    }

    public static Connection getConnection() throws NamingException, SQLException {
        if (connection != null) {
            return connection;
        }
        Context context = null;
        DataSource datasource = null;
        // Get the context and create a connection
        context = new InitialContext();
        datasource = (DataSource) context.lookup("java:/comp/env/jdbc/syllabus_generator");
        connection = datasource.getConnection();
        return connection;
    }
}
