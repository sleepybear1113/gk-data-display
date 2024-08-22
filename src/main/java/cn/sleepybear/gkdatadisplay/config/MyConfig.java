package cn.sleepybear.gkdatadisplay.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author sleepybear
 */
@Configuration
@Data
public class MyConfig {
    @Value("${my-config.version}")
    private String version;
    @Value("${my-config.sql-limit-size}")
    private String sqlLimitSize;

    public int getSqlLimitSizeInt() {
        try {
            return Integer.parseInt(sqlLimitSize);
        } catch (Exception e) {
            return 100;
        }
    }
}