package cn.sleepybear.gkdatadisplay.controller;

import cn.sleepybear.gkdatadisplay.config.GlobalConstants;
import cn.sleepybear.gkdatadisplay.config.MyConfig;
import cn.sleepybear.gkdatadisplay.dto.AppInfoDto;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * There is description
 *
 * @author sleepybear
 * @date 2024/08/22 01:28
 */
@RestController
@RequestMapping(value = GlobalConstants.PREFIX)
public class SystemController {
    @Resource
    private MyConfig myConfig;

    @RequestMapping("/system/getAppInfo")
    public AppInfoDto getAppInfo() {
        AppInfoDto appInfoDto = new AppInfoDto();
        appInfoDto.setVersion(myConfig.getVersion());
        appInfoDto.setSqlLimitSize(myConfig.getSqlLimitSizeInt());
        return appInfoDto;
    }
}
