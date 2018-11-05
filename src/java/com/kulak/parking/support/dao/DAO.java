package com.kulak.parking.support.dao;

import com.kulak.parking.support.connectionpool.DbConnectionPool;
import com.kulak.parking.support.service.ResourceService;

public abstract class DAO {

    protected static DbConnectionPool poolInst;
    protected static ResourceService sql;

    protected DAO() {
        poolInst = DbConnectionPool.getInstance();
        sql = ResourceService.getInstance();
    }
}
