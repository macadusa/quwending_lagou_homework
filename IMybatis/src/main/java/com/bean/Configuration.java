package com.bean;

import javax.sql.DataSource;
import java.util.Map;

public class Configuration {
    private DataSource dataSource;
    private Map<String ,ParamStateMent> paramStateMent;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Map<String, ParamStateMent> getParamStateMent() {
        return paramStateMent;
    }

    public void setParamStateMent(Map<String, ParamStateMent> paramStateMent) {
        this.paramStateMent = paramStateMent;
    }
}
