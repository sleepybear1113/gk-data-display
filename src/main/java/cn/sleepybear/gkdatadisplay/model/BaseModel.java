package cn.sleepybear.gkdatadisplay.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * There is description
 *
 * @author sleepybear
 * @date 2024/08/19 19:22
 */
@Data
public class BaseModel {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Long createTime;
    private Long modifyTime;

    public void fillAllTime() {
        long currentTimeMillis = System.currentTimeMillis();
        this.createTime = currentTimeMillis;
        this.modifyTime = currentTimeMillis;
    }

    public void fillUpdateTime() {
        this.modifyTime = System.currentTimeMillis();
    }
}
