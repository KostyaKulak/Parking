package com.kulak.parking.support.service;

import com.kulak.parking.support.connectionpool.DbConnectionPool;

import java.util.ResourceBundle;

public class ResourceService {

    private static ResourceService instance;
    private static ResourceBundle bundle;

    private static final String SQL_FILE = "sql";

    public static final String SQL_GET_ALL_CARS = "SQL_GET_ALL_CARS";
    public static final String SQL_ADD_CAR = "SQL_ADD_CAR";

    private ResourceService() {
    }

    public static ResourceService getInstance() {
        if (instance == null) {
            synchronized (DbConnectionPool.class) {
                instance = new ResourceService();
                bundle = ResourceBundle.getBundle(SQL_FILE);
            }
        }
        return instance;
    }

    public String getProperty(String key) {
        return bundle.getString(key);
    }

}
