package cn.sleepybear.gkdatadisplay.controller;

import cn.sleepybear.gkdatadisplay.config.GlobalConstants;
import cn.sleepybear.gkdatadisplay.dto.GkPersonDto;
import cn.sleepybear.gkdatadisplay.exception.FrontException;
import cn.sleepybear.gkdatadisplay.logic.QueryGkDataLogic;
import cn.sleepybear.gkdatadisplay.query.GkPersonQuery;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * There is description
 *
 * @author sleepybear
 * @date 2024/08/19 23:47
 */
@RestController
@RequestMapping(value = GlobalConstants.PREFIX)
public class QueryGkDataController {
    @Resource
    private QueryGkDataLogic queryGkDataLogic;

    @RequestMapping("/queryGkData")
    public List<GkPersonDto> queryGkData(@RequestBody GkPersonQuery gkPersonQuery) {
        if (gkPersonQuery == null) {
            throw new FrontException("参数不能为空");
        }
        return queryGkDataLogic.query(gkPersonQuery.toQueryWrapper());
    }
}
