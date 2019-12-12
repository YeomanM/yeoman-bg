package com.example.yeomanbg.config.datasource;

public enum DataSourceType {

    PRIMARY("first"),
    SECOND("second")
    ;

    private String dbType;
    DataSourceType(String name) {
        this.dbType = name;
    }

    public String getDbType() {
        return this.dbType;
    }

    public static DataSourceType instance(String dbType) {
        switch (dbType.toLowerCase()) {
            case "first" : return PRIMARY;
            case "second" : return SECOND;
            default:
                throw new RuntimeException("Not exists datasource type!");
        }
    }

}
