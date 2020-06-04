package com.session;

import com.bean.Configuration;

public class DefultSqlSessionFactory implements  SqlSessionFactory{
    private Configuration configuration;

    public DefultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    public SqlSession openSqlSession() {
        return new DefultSqlSession(configuration);
    }
}
