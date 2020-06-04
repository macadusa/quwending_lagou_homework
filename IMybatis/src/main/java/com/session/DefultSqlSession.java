package com.session;

import com.bean.Configuration;
import com.handler.SimpleExcutor;

import java.beans.IntrospectionException;
import java.lang.reflect.*;
import java.sql.SQLException;
import java.util.List;

public class DefultSqlSession implements SqlSession {
     private Configuration configuration;

    public DefultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    public <T> List<T> selectOne(String statmentId, Object... param) throws IllegalAccessException, ClassNotFoundException, IntrospectionException, InstantiationException, SQLException, InvocationTargetException, NoSuchFieldException {
        SimpleExcutor simpleExcutor=new SimpleExcutor();
//        List<T>  list =simpleExcutor.query(statmentId,configuration,configuration.getParamStateMent(),param);
//        return list;
        return null;
    }

    @Override
    public <T> T getMapper(Class<T> tClass) {
        Object o = Proxy.newProxyInstance(DefultSqlSession.class.getClassLoader(), new Class[]{tClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //statmentId 由nameSpace 和select id组成
                //name相当于mapper.xml中的<select id='findAll'> 那个findAll
                String id = method.getName();
                String nameSpace = method.getDeclaringClass().getName();
                SimpleExcutor simpleExcutor=new SimpleExcutor();
                Type genericReturnType = method.getGenericReturnType();
                System.out.println("method"+method.toString());
                String methods = method.toString();
                Object result = simpleExcutor.excute(nameSpace + "." + id, configuration, configuration.getParamStateMent(), args);
//                if(methods.contains("find")||methods.contains("select")||methods.contains("query")){
//                    List<Object>  list=simpleExcutor.query(nameSpace+"."+id,configuration,configuration.getParamStateMent(),args);
//                    return list;
//                }else if(methods.contains("insert")||methods.contains("create")){
//                    boolean insertFlag = simpleExcutor.insert(nameSpace + "." + id, configuration, configuration.getParamStateMent(), args);
//                    return insertFlag;
//                }else if(methods.contains("update")){
//                    boolean updateFlag =  simpleExcutor.update(nameSpace + "." + id, configuration, configuration.getParamStateMent(), args);
//                }
//                if (genericReturnType instanceof  ParameterizedType){
//                }
                return result;
            }
        });
        return (T) o;
    }


}
