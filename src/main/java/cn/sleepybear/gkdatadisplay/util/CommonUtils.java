package cn.sleepybear.gkdatadisplay.util;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * There is description
 *
 * @author sleepybear
 * @date 2024/08/19 22:01
 */
public class CommonUtils {
    public static <T, V> T copyBean(V source, Class<T> target) {
        if (source == null) {
            return null;
        }

        try {
            T targetInstance = target.getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(source, targetInstance);
            return targetInstance;
        } catch (Exception ignored) {
            return null;
        }
    }

    public static <T, V> List<T> copyBean(List<V> sources, Class<T> target) {
        if (sources == null || sources.isEmpty()) {
            return null;
        }

        List<T> targetList = new ArrayList<>(sources.size());
        try {
            for (V source : sources) {
                targetList.add(copyBean(source, target));
            }
            return targetList;
        } catch (Exception e) {
            return null;
        }
    }
}
