package com.example.yeomanbg.component;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class KaptchaConfig {


    @Bean
    public DefaultKaptcha defaultKaptcha() {
        Properties properties = new Properties();

        DefaultKaptcha kaptcha = new DefaultKaptcha();
        properties.put("kaptcha.border","yes");
        properties.put("kaptcha.border.color","black");
        properties.put("kaptcha.image.width","120");
        properties.put("kaptcha.image.height","36");
        properties.put("kaptcha.textproducer.font.size","28");
        properties.put("kaptcha.session.key","code");
        properties.put("kaptcha.textproducer.char.length","4");
        properties.put("kaptcha.textproducer.font.names","宋体,楷体,微软雅黑");
        properties.put("kaptcha.obscurificator.impl","com.google.code.kaptcha.impl.FishEyeGimpy");
        Config config = new Config(properties);
        kaptcha.setConfig(config);

        return kaptcha;
    }

}
