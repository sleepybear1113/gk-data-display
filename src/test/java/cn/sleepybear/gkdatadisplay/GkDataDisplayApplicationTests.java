package cn.sleepybear.gkdatadisplay;

import cn.sleepybear.gkdatadisplay.dto.GkPersonDto;
import cn.sleepybear.gkdatadisplay.logic.QueryGkDataLogic;
import cn.sleepybear.gkdatadisplay.query.GkPersonQuery;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class GkDataDisplayApplicationTests {

    @Resource
    private QueryGkDataLogic queryGkDataLogic;

    @Test
    void contextLoads() {
    }

    @Test
    void testReBuildDb() {
        GkPersonQuery gkPersonQuery = new GkPersonQuery();

        gkPersonQuery.setYear(List.of("2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024"));
        List<GkPersonDto> list = queryGkDataLogic.query(gkPersonQuery.toQueryWrapper());
        System.out.println();
    }
}
