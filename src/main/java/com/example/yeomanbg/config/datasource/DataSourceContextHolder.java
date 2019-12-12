package com.example.yeomanbg.config.datasource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataSourceContextHolder {

    private final static ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static void setDatasource(String dbType) {
        log.info("切换到 [ {} ] 数据源",dbType);
        contextHolder.set(dbType);
    }

    public static String getDatasource() {
        return contextHolder.get();
    }

    public static void clearDatasource() {
        contextHolder.remove();
    }


}
