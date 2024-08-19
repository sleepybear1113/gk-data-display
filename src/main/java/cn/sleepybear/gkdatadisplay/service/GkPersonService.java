package cn.sleepybear.gkdatadisplay.service;

import cn.sleepybear.gkdatadisplay.mapper.GkPersonMapper;
import cn.sleepybear.gkdatadisplay.model.GkPerson;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * There is description
 *
 * @author sleepybear
 * @date 2024/08/19 20:25
 */
@Service
public class GkPersonService extends ServiceImpl<GkPersonMapper, GkPerson> implements IService<GkPerson> {
}
