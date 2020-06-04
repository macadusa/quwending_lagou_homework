package com.config;

import com.utils.ParameterMapping;

import java.util.ArrayList;
import java.util.List;

public class BoundSql {
    private  String sqlText;
    private List<ParameterMapping> lists=new ArrayList<>();

    public BoundSql(String sqlText, List<ParameterMapping> lists) {
        this.sqlText = sqlText;
        this.lists = lists;
    }

    public String getSqlText() {
        return sqlText;
    }

    public void setSqlText(String sqlText) {
        this.sqlText = sqlText;
    }

    public List<ParameterMapping> getLists() {
        return lists;
    }

    public void setLists(List<ParameterMapping> lists) {
        this.lists = lists;
    }
}
