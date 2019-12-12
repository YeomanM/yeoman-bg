package com.example.yeomanbg.service;

import com.example.yeomanbg.response.BaseResponse;
import org.springframework.stereotype.Service;


public interface TestService {

    BaseResponse test(int id);

    BaseResponse testSecond();

}
