package com.session;

import com.bean.Configuration;
import com.config.XMLMybatisConfig;
import org.dom4j.DocumentException;

import java.beans.PropertyVetoException;
import java.io.InputStream;

public class DefultSqlSessionFactoryBuilder {


    public SqlSessionFactory build(InputStream inputStream) throws PropertyVetoException, DocumentException {
        XMLMybatisConfig XMLMybatisConfig =new XMLMybatisConfig();
        Configuration configuration=XMLMybatisConfig.parse(inputStream);
        DefultSqlSessionFactory defultSqlSessionFactory = new DefultSqlSessionFactory(configuration);
        return  defultSqlSessionFactory;
    }
}
