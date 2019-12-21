package com.example.yeomanbg.controller;

import com.example.yeomanbg.response.BaseResponse;
import com.example.yeomanbg.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService service;

    @GetMapping("/{id}")
    public BaseResponse get(@PathVariable int id){
        return service.test(id);
    }

    @GetMapping("/area")
    public BaseResponse getArea() {
        return service.testSecond();
    }

}
