package com.handler;

import com.bean.Configuration;
import com.bean.ParamStateMent;
import com.config.BoundSql;
import com.utils.GenericTokenParser;
import com.utils.ParameterMapping;
import com.utils.ParameterMappingTokenHandler;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SimpleExcutor implements Excutor {

    
//    public <T> List<T> query(String statmentId, Configuration configuration, Map<String, ParamStateMent> paramStateMentMap, Object[] param) throws SQLException, NoSuchFieldException, IllegalAccessException, ClassNotFoundException, InstantiationException, IntrospectionException, InvocationTargetException {
//        Connection connection = configuration.getDataSource().getConnection();
//
//        ParamStateMent paramStateMent = paramStateMentMap.get(statmentId);
//        String sqlText = paramStateMent.getSqlText();
//        String paramType = paramStateMent.getParamType();
//        Class<?> classType = getClassType(paramType);
//        BoundSql boundSql=getBoundSql(sqlText);
//        PreparedStatement preparedStatement = connection.prepareStatement(boundSql.getSqlText());
//        List<ParameterMapping> lists = boundSql.getLists();
//        ResultSet resultSet=null;
//        if(null!=lists&&lists.size()>0){
//            for (int i = 0; i < lists.size(); i++) {
//                ParameterMapping parameterMapping =  lists.get(i);
//                String content = parameterMapping.getContent();
//                Field declaredField = classType.getDeclaredField(content);
//                declaredField.setAccessible(true);
//                Object o = declaredField.get(param[0]);
//                preparedStatement.setObject(i+1, o);
//            }
//            resultSet= preparedStatement.executeQuery();
//        }else{
//            boolean execute = preparedStatement.execute(boundSql.getSqlText());
//        }
//        String resultType = paramStateMent.getResultType();
//        Class<?> resultTypeClass =null;
//        ArrayList<Object> resultList = new ArrayList<>();
//        if(null!=resultType&&!"".equals(resultType)){
//             resultTypeClass = getClassType(resultType);
//            while (resultSet.next()){
//                Object o = resultTypeClass.newInstance();
//                ResultSetMetaData metaData = resultSet.getMetaData();
//                for (int i = 1; i <= metaData.getColumnCount(); i++) {
//                    String columnName = metaData.getColumnName(i);
//                    Object columnValue = resultSet.getObject(i);
//                    PropertyDescriptor propertyDescriptor=new PropertyDescriptor(columnName, resultTypeClass);
//                    Method writeMethod = propertyDescriptor.getWriteMethod();
//                    writeMethod.invoke(o,columnValue);
//                }
//                resultList.add(o);
//            }
//        }
//        return (List<T>) resultList;
//    }
//    public boolean insert(String statmentId, Configuration configuration, Map<String, ParamStateMent> paramStateMentMap, Object[] param) throws SQLException, NoSuchFieldException, IllegalAccessException, ClassNotFoundException, InstantiationException, IntrospectionException, InvocationTargetException {
//        Connection connection = configuration.getDataSource().getConnection();
//        ParamStateMent paramStateMent = paramStateMentMap.get(statmentId);
//        String sqlText = paramStateMent.getSqlText();
//        String paramType = paramStateMent.getParamType();
//        Class<?> classType = getClassType(paramType);
//        BoundSql boundSql=getBoundSql(sqlText);
//        PreparedStatement preparedStatement = connection.prepareStatement(boundSql.getSqlText());
//        List<ParameterMapping> lists = boundSql.getLists();
//        ResultSet resultSet=null;
//        boolean execute;
//        if(null!=lists&&lists.size()>0){
//            for (int i = 0; i < lists.size(); i++) {
//                ParameterMapping parameterMapping =  lists.get(i);
//                String content = parameterMapping.getContent();
//                Field declaredField = classType.getDeclaredField(content);
//                declaredField.setAccessible(true);
//                Object o = declaredField.get(param[0]);
//                preparedStatement.setObject(i+1, o);
//            }
//             execute = preparedStatement.execute();
//        }else{
//             execute= preparedStatement.execute();
//        }
//        String resultType = paramStateMent.getResultType();
//        Class<?> resultTypeClass =null;
//        ArrayList<Object> resultList = new ArrayList<>();
//        if(null!=resultType&&!"".equals(resultType)){
//            resultTypeClass = getClassType(resultType);
//            while (resultSet.next()){
//                Object o = resultTypeClass.newInstance();
//                ResultSetMetaData metaData = resultSet.getMetaData();
//                for (int i = 1; i <= metaData.getColumnCount(); i++) {
//                    String columnName = metaData.getColumnName(i);
//                    Object columnValue = resultSet.getObject(i);
//                    PropertyDescriptor propertyDescriptor=new PropertyDescriptor(columnName, resultTypeClass);
//                    Method writeMethod = propertyDescriptor.getWriteMethod();
//                    writeMethod.invoke(o,columnValue);
//                }
//                resultList.add(o);
//            }
//        }
//        return  execute;
//    }
//
//    public int update(String statmentId, Configuration configuration, Map<String, ParamStateMent> paramStateMentMap, Object[] param) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException, IntrospectionException, InvocationTargetException {
//        Connection connection = configuration.getDataSource().getConnection();
//        ParamStateMent paramStateMent = paramStateMentMap.get(statmentId);
//        String sqlText = paramStateMent.getSqlText();
//        String paramType = paramStateMent.getParamType();
//        BoundSql boundSql=getBoundSql(sqlText);
//        PreparedStatement preparedStatement = connection.prepareStatement(boundSql.getSqlText());
//        List<ParameterMapping> lists = boundSql.getLists();
//        ResultSet resultSet=null;
//        Class<?> classType = getClassType(paramType);
//        int successFlag;
//        if(null!=lists&&lists.size()>0){
//            for (int i = 0; i < lists.size(); i++) {
//                ParameterMapping parameterMapping =  lists.get(i);
//                String content = parameterMapping.getContent();
//                Field declaredField = classType.getDeclaredField(content);
//                declaredField.setAccessible(true);
//                Object o = declaredField.get(param[0]);
//                preparedStatement.setObject(i+1, o);
//            }
//            successFlag = preparedStatement.executeUpdate();
//        }else{
//            successFlag = preparedStatement.executeUpdate();
//        }
//        String resultType = paramStateMent.getResultType();
//        Class<?> resultTypeClass =null;
//        ArrayList<Object> resultList = new ArrayList<>();
//        if(null!=resultType&&!"".equals(resultType)){
//            resultTypeClass = getClassType(resultType);
//            while (resultSet.next()){
//                Object o = resultTypeClass.newInstance();
//                ResultSetMetaData metaData = resultSet.getMetaData();
//                for (int i = 1; i <= metaData.getColumnCount(); i++) {
//                    String columnName = metaData.getColumnName(i);
//                    Object columnValue = resultSet.getObject(i);
//                    PropertyDescriptor propertyDescriptor=new PropertyDescriptor(columnName, resultTypeClass);
//                    Method writeMethod = propertyDescriptor.getWriteMethod();
//                    writeMethod.invoke(o,columnValue);
//                }
//                resultList.add(o);
//            }
//        }
//        return  successFlag;
//    }

    public Object excute(String statmentId, Configuration configuration, Map<String, ParamStateMent> paramStateMentMap, Object[] param) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException, IntrospectionException, InvocationTargetException {
        Connection connection = configuration.getDataSource().getConnection();
        ParamStateMent paramStateMent = paramStateMentMap.get(statmentId);
        String sqlText = paramStateMent.getSqlText();
        String paramType = paramStateMent.getParamType();
        BoundSql boundSql=getBoundSql(sqlText);
        PreparedStatement preparedStatement = connection.prepareStatement(boundSql.getSqlText());
        List<ParameterMapping> lists = boundSql.getLists();
        ResultSet resultSet=null;
        Class<?> classType = getClassType(paramType);
        Object successFlag = null;
            for (int i = 0; i < lists.size(); i++) {
                ParameterMapping parameterMapping =  lists.get(i);
                String content = parameterMapping.getContent();
                Field declaredField = classType.getDeclaredField(content);
                declaredField.setAccessible(true);
                Object o = declaredField.get(param[0]);
                preparedStatement.setObject(i+1, o);
            }
                if(sqlText.contains("find")||sqlText.contains("select")||sqlText.contains("query")){
                    resultSet = preparedStatement.executeQuery();
                    String resultType = paramStateMent.getResultType();
                    Class<?> resultTypeClass =null;
                    ArrayList<Object> resultList = new ArrayList<>();
                    if(null!=resultType&&!"".equals(resultType)){
                        resultTypeClass = getClassType(resultType);
                        while (null!=resultSet&&resultSet.next()){
                            Object o = resultTypeClass.newInstance();
                            ResultSetMetaData metaData = resultSet.getMetaData();
                            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                                String columnName = metaData.getColumnName(i);
                                Object columnValue = resultSet.getObject(i);
                                PropertyDescriptor propertyDescriptor=new PropertyDescriptor(columnName, resultTypeClass);
                                Method writeMethod = propertyDescriptor.getWriteMethod();
                                writeMethod.invoke(o,columnValue);
                            }
                            resultList.add(o);
                        }
                    }
                }else if(sqlText.contains("insert")||sqlText.contains("create")){
                    successFlag = preparedStatement.execute();
                }else if(sqlText.contains("update")||sqlText.contains("delete")){
                    successFlag = preparedStatement.execute();
                }
        return  successFlag;
    }
    private Class<?> getClassType(String paramterType) throws ClassNotFoundException {
        if (null!=paramterType){
            Class<?> aClass = Class.forName(paramterType);
            return  aClass;
        }
        return  null;

    }
    private BoundSql getBoundSql(String sql) {
        ParameterMappingTokenHandler parameterMappingTokenHandler = new ParameterMappingTokenHandler();
        GenericTokenParser genericTokenParser = new GenericTokenParser("#{", "}", parameterMappingTokenHandler);
        String parse = genericTokenParser.parse(sql);
        List<ParameterMapping> parameterMappings = parameterMappingTokenHandler.getParameterMappings();
        BoundSql boundSql=new BoundSql(parse, parameterMappings);
        return  boundSql;

    }

}
