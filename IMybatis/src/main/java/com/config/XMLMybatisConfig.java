package com.config;

import com.bean.Configuration;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class XMLMybatisConfig {
    private Configuration configuration= new Configuration();

    public Configuration parse(InputStream inputStream) throws DocumentException, PropertyVetoException {
        SAXReader saxReader=new SAXReader();
        Document read = saxReader.read(inputStream);
        Element rootElement = read.getRootElement();
        List<Element> list = rootElement.selectNodes("//property");
        Properties properties =new Properties();
        for (Element element : list) {
            String name = element.attributeValue("name");
            String value = element.attributeValue("value");
            properties.setProperty(name,value);
        }
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass(properties.getProperty("driverClass"));
        comboPooledDataSource.setJdbcUrl(properties.getProperty("jdbcUrl"));
        comboPooledDataSource.setUser(properties.getProperty("username"));
        comboPooledDataSource.setPassword(properties.getProperty("password"));

        configuration.setDataSource(comboPooledDataSource);
        List<Element> mybatislist = rootElement.selectNodes("//mapper");
        for (Element element : mybatislist) {
            String path = element.attributeValue("resource");
            InputStream inputStreamFromXmlByPath = Resources.getInputStreamFromXmlByPath(path);
            XMLSQLConfig xmlSQLConfig=new XMLSQLConfig(configuration);
            configuration = xmlSQLConfig.parse(inputStreamFromXmlByPath);
        }
        return  configuration;
    }
}
