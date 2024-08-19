package cn.sleepybear.gkdatadisplay.logic;

import cn.sleepybear.gkdatadisplay.model.GkPersonOld;
import cn.sleepybear.gkdatadisplay.service.GkPersonOldService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * There is description
 *
 * @author sleepybear
 * @date 2024/08/19 20:29
 */
@Component
public class ReBuildDbLogic {

    @Resource
    private GkPersonOldService gkPersonOldService;

    public void reBuildDb() {
        List<Integer> ids = new ArrayList<>();
        // 1-1000
        for (int i = 100000; i <= 100000 + 1000; i++) {
            ids.add(i);
        }
        List<GkPersonOld> gkPersonOldList = gkPersonOldService.listByIds(ids);
        System.out.println();
    }
}
