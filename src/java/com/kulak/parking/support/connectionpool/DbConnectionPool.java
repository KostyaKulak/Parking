package com.kulak.parking.support.connectionpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Deque;
import java.util.LinkedList;


public class DbConnectionPool {


    private static DbConnectionPool instance;

    private Deque<Connection> connections;

    private DbConnectionPool() {
        this.connections = new LinkedList<>();
    }


    public synchronized Connection getConnection() {
        if (!connections.isEmpty()) {
            return connections.poll();
        }

        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost/cars?user=root&password=123456&useUnicode=true&characterEncoding=UTF-8&characterSetResults=utf8&connectionCollation=utf8_general_ci&useSSL=false");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }


    public void footConnection(Connection connection) {
        try {
            if (!connection.isClosed()) {
                connections.add(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DbConnectionPool getInstance() {
        if (instance == null) {
            synchronized (DbConnectionPool.class) {
                instance = new DbConnectionPool();
                return instance;
            }
        }
        return instance;
    }
}


