package com.config;

import com.bean.Configuration;
import com.bean.ParamStateMent;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XMLSQLConfig {
    private Configuration configuration;

    public XMLSQLConfig(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration parse(InputStream inputStream) throws DocumentException {
        SAXReader saxReader=new SAXReader();
        Document read = saxReader.read(inputStream);
        Element rootElement = read.getRootElement();
        String namespase = rootElement.attributeValue("namespase");

        Map<String, ParamStateMent> paramStateMentMap = new HashMap<>();

        List<Element> list = rootElement.selectNodes("//select");
        for (Element element : list) {
            ParamStateMent paramStateMent=new ParamStateMent();
            String id = element.attributeValue("id");
            String sqlText = element.getTextTrim();
            paramStateMent.setId(id);
            paramStateMent.setParamType(element.attributeValue("paramterType"));
            paramStateMent.setResultType(element.attributeValue("resultType"));
            paramStateMent.setSqlText(sqlText);
            paramStateMentMap.put(namespase + "." + id,paramStateMent);
        }
        List<Element> insertlist = rootElement.selectNodes("//insert");
        for (Element element : insertlist) {
            ParamStateMent paramStateMent=new ParamStateMent();
            String id = element.attributeValue("id");
            String sqlText = element.getTextTrim();
            paramStateMent.setId(id);
            paramStateMent.setParamType(element.attributeValue("paramterType"));
            paramStateMent.setResultType(element.attributeValue("resultType"));
            paramStateMent.setSqlText(sqlText);
            paramStateMentMap.put(namespase + "." + id,paramStateMent);
        }
        List<Element> updatelist = rootElement.selectNodes("//update");
        for (Element element : updatelist) {
            ParamStateMent paramStateMent=new ParamStateMent();
            String id = element.attributeValue("id");
            String sqlText = element.getTextTrim();
            paramStateMent.setId(id);
            paramStateMent.setParamType(element.attributeValue("paramterType"));
            paramStateMent.setResultType(element.attributeValue("resultType"));
            paramStateMent.setSqlText(sqlText);
            paramStateMentMap.put(namespase + "." + id,paramStateMent);
        }
        List<Element> deletelist = rootElement.selectNodes("//delete");
        for (Element element : deletelist) {
            ParamStateMent paramStateMent=new ParamStateMent();
            String id = element.attributeValue("id");
            String sqlText = element.getTextTrim();
            paramStateMent.setId(id);
            paramStateMent.setParamType(element.attributeValue("paramterType"));
            paramStateMent.setResultType(element.attributeValue("resultType"));
            paramStateMent.setSqlText(sqlText);
            paramStateMentMap.put(namespase + "." + id,paramStateMent);
        }
        configuration.setParamStateMent(paramStateMentMap);
        return  configuration;
    }
}
