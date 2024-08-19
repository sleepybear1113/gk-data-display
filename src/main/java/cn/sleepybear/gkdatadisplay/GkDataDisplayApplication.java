package cn.sleepybear.gkdatadisplay;

import cn.sleepybear.gkdatadisplay.util.SpringContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class GkDataDisplayApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(GkDataDisplayApplication.class, args);
        SpringContextUtil.setApplicationContext(context);
    }

}
