package com.example.yeomanbg.service.impl;

import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;

@Service
public class CommonServiceImpl {

    @Autowired
    private Producer producer;

    public BufferedImage createVerifyCode() {

        String str = producer.createText();
        BufferedImage bi = producer.createImage(str);

        return null;
    }

}
