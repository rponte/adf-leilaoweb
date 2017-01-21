package br.com.triadworks.leilaoweb.dao;

import java.sql.*;

public class ConnectionFactory {

    private static final String USERNAME = "leilao_web";
    private static final String PASSWORD = "123";
    private static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:XE";

    public Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            conn.setAutoCommit(false);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        }
    }
}
