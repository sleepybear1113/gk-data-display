package cn.sleepybear.gkdatadisplay.logic;

import cn.sleepybear.gkdatadisplay.config.MyConfig;
import cn.sleepybear.gkdatadisplay.dto.GkPersonDto;
import cn.sleepybear.gkdatadisplay.model.GkPerson;
import cn.sleepybear.gkdatadisplay.service.GkPersonService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * There is description
 *
 * @author sleepybear
 * @date 2024/08/19 21:48
 */
@Component
public class QueryGkDataLogic {

    @Resource
    private MyConfig myConfig;
    @Resource
    private GkPersonService gkPersonService;

    public List<GkPersonDto> query(LambdaQueryWrapper<GkPerson> queryWrapper) {
        queryWrapper.last("limit " + myConfig.getSqlLimitSizeInt());
        List<GkPerson> list = gkPersonService.list(queryWrapper);
        return GkPersonDto.convert(list);
    }
}
