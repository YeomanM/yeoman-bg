package com.example.yeomanbg.service.impl;

import com.example.yeomanbg.config.datasource.DataSource;
import com.example.yeomanbg.config.datasource.DataSourceType;
import com.example.yeomanbg.dao.TestDAO;
import com.example.yeomanbg.response.BaseResponse;
import com.example.yeomanbg.response.ResponseUtils;
import com.example.yeomanbg.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDAO testDAO;

    @Override
    public BaseResponse test(int id) {
        return ResponseUtils.success(testDAO.test(id));
    }

    @DataSource(value = DataSourceType.SECOND)
    @Override
    public BaseResponse testSecond() {
        return ResponseUtils.success(testDAO.testSecond());
    }
}
