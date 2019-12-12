package com.example.yeomanbg.config.datasource;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class DataSourceHandle {

    @Pointcut("@annotation(com.example.yeomanbg.config.datasource.DataSource)")
    public void pointcut(){

    }

    @Before("pointcut()")
    public void setDatasource(JoinPoint point) {
        Class clazz = point.getTarget().getClass();
        String methodName = point.getSignature().getName();
        Class[] classes = ((MethodSignature)point.getSignature()).getParameterTypes();

        try {
            Method method = clazz.getMethod(methodName, classes);
            if (method.isAnnotationPresent(DataSource.class)) {
                DataSource dataSource = method.getAnnotation(DataSource.class);
                DataSourceType type = dataSource.value();
                DataSourceContextHolder.setDatasource(type.getDbType());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @After("pointcut()")
    public void remove() {
        DataSourceContextHolder.clearDatasource();
    }

}
