package com.bean;

public class ParamStateMent {
    private  String id;
    private String resultType;
    private String paramType;
    private String sqlText;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    public String getSqlText() {
        return sqlText;
    }

    public void setSqlText(String sqlText) {
        this.sqlText = sqlText;
    }

    @Override
    public String toString() {
        return "ParamStateMent{" +
                "id='" + id + '\'' +
                ", resultType='" + resultType + '\'' +
                ", paramType='" + paramType + '\'' +
                ", sqlText='" + sqlText + '\'' +
                '}';
    }
}
