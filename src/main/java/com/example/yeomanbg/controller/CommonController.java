package com.example.yeomanbg.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RequestMapping("/common")
@RestController
public class CommonController {

    @Autowired
    private Producer producer;

    @GetMapping("/code")
    public void createVerifyCode(HttpServletResponse response, HttpServletRequest request) throws IOException {
        String str = producer.createText();
        BufferedImage bi = producer.createImage(str);
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, str);

        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        // Set standard HTTP/1.0 no-cache header.
        response.setHeader("Pragma", "no-cache");
        // return a jpeg
        response.setContentType("image/jpeg");

        ImageIO.write(bi, "jpg", response.getOutputStream());


    }


}
